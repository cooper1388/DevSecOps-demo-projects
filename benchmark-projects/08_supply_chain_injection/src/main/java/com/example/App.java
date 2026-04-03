package com.example;

import com.thoughtworks.xstream.XStream;
import io.netty.bootstrap.ServerBootstrap;
import org.apache.commons.io.FileUtils;
import java.io.File;

/**
 * VULNERABLE: Supply Chain Injection vectors
 * 1. XStream 1.4.17 — 15+ CVEs de deserializacion remota (CVE-2021-39139 a 39153)
 *    Permite instanciar clases arbitrarias via XML malicioso
 * 2. Netty 4.1.42 — HTTP request smuggling (CVE-2019-20444)
 *    Permite bypass de proxies y WAFs
 * 3. Commons IO 2.6 — path traversal en nombres de archivo
 *    Permite leer/escribir archivos fuera del directorio esperado
 */
public class App {
    public static void main(String[] args) throws Exception {
        // VULNERABLE: XStream deserializa XML no confiable
        XStream xstream = new XStream();
        // SIN security framework configurado — permite cualquier clase
        String untrustedXml = args.length > 0 ? args[0] : "<string>safe</string>";
        Object result = xstream.fromXML(untrustedXml);

        // VULNERABLE: path traversal — el usuario controla el nombre del archivo
        String filename = args.length > 1 ? args[1] : "data.txt";
        File file = new File("/uploads/" + filename);  // ../../etc/passwd
        String content = FileUtils.readFileToString(file, "UTF-8");

        System.out.println("Parsed: " + result + ", File: " + content);
    }
}
