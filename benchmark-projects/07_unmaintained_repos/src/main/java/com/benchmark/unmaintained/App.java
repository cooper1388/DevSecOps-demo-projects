package com.benchmark.unmaintained;

import au.com.bytecode.opencsv.CSVReader;
import com.thoughtworks.paranamer.BytecodeReadingParanamer;
import com.thoughtworks.paranamer.Paranamer;
import net.jcip.annotations.ThreadSafe;
import org.apache.oro.text.regex.MalformedPatternException;
import org.apache.oro.text.regex.Pattern;
import org.apache.oro.text.regex.PatternCompiler;
import org.apache.oro.text.regex.PatternMatcher;
import org.apache.oro.text.regex.Perl5Compiler;
import org.apache.oro.text.regex.Perl5Matcher;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Aplicacion demo que usa librerias abandonadas o poco mantenidas.
 * Ninguna de estas librerias tiene CVEs conocidos, pero todas representan
 * un riesgo de supply chain por falta de mantenimiento activo.
 *
 * Codigo disenado para pasar SAST: uso convencional de cada API.
 */
@ThreadSafe
public class App {

    private final PatternCompiler compiler;
    private final PatternMatcher matcher;
    private final Paranamer paranamer;

    public App() {
        this.compiler = new Perl5Compiler();
        this.matcher = new Perl5Matcher();
        this.paranamer = new BytecodeReadingParanamer();
    }

    /**
     * Usa Apache ORO (abandonado 2003) para matching de patrones regex.
     */
    @Nonnull
    public boolean matchesPattern(@Nonnull String input, @Nonnull String regex) {
        try {
            Pattern pattern = compiler.compile(regex);
            return matcher.matches(input, pattern);
        } catch (MalformedPatternException e) {
            throw new IllegalArgumentException("Regex invalido: " + regex, e);
        }
    }

    /**
     * Usa OpenCSV legacy (abandonado 2011) para parsear lineas CSV.
     */
    @Nonnull
    public List<String[]> parseCsv(@Nonnull String csvContent) {
        List<String[]> rows = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new StringReader(csvContent))) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                rows.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error parseando CSV", e);
        }
        return rows;
    }

    /**
     * Usa Paranamer (ultimo release 2017) para obtener nombres de parametros.
     */
    @Nullable
    public String[] getParameterNames(Method method) {
        return paranamer.lookupParameterNames(method, false);
    }

    public static void main(String[] args) {
        App app = new App();

        // Demo Apache ORO
        boolean matches = app.matchesPattern("user@example.com", "\\w+@\\w+\\.\\w+");
        System.out.println("Email valido: " + matches);

        // Demo OpenCSV legacy
        String csv = "nombre,edad,ciudad\nJuan,30,Madrid\nAna,25,Barcelona";
        List<String[]> rows = app.parseCsv(csv);
        System.out.println("Filas CSV: " + rows.size());

        // Demo Paranamer
        try {
            Method method = App.class.getMethod("matchesPattern", String.class, String.class);
            String[] paramNames = app.getParameterNames(method);
            if (paramNames != null) {
                System.out.println("Parametros: " + String.join(", ", paramNames));
            }
        } catch (NoSuchMethodException e) {
            System.err.println("Metodo no encontrado");
        }
    }
}
