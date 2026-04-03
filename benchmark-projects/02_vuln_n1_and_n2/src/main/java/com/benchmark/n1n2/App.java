package com.benchmark.n1n2;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Aplicacion demo que usa XStream para serializacion XML
 * y simula un contexto donde Struts2 maneja acciones web.
 *
 * Codigo disenado para pasar SAST: no hay deserializacion de input
 * externo directo. La vulnerabilidad reside en las versiones de las librerias
 * tanto a nivel directo (N1) como transitivo (N2).
 */
public class App {

    private final XStream xstream;

    public App() {
        this.xstream = new XStream(new DomDriver());
        this.xstream.allowTypes(new Class[]{EventRecord.class, EventBatch.class});
    }

    public String serializeEvents(List<EventRecord> events) {
        EventBatch batch = new EventBatch();
        batch.setEvents(events);
        return xstream.toXML(batch);
    }

    public EventBatch deserializeEvents(String xml) {
        return (EventBatch) xstream.fromXML(xml);
    }

    public static void main(String[] args) {
        App app = new App();

        List<EventRecord> events = new ArrayList<>();
        events.add(new EventRecord("LOGIN", "user123", System.currentTimeMillis()));
        events.add(new EventRecord("PAGE_VIEW", "user123", System.currentTimeMillis()));

        String xml = app.serializeEvents(events);
        System.out.println("Eventos serializados:");
        System.out.println(xml);

        EventBatch restored = app.deserializeEvents(xml);
        System.out.println("Eventos restaurados: " + restored.getEvents().size());
    }

    public static class EventRecord implements Serializable {
        private String type;
        private String userId;
        private long timestamp;

        public EventRecord(String type, String userId, long timestamp) {
            this.type = type;
            this.userId = userId;
            this.timestamp = timestamp;
        }

        public String getType() { return type; }
        public String getUserId() { return userId; }
        public long getTimestamp() { return timestamp; }
    }

    public static class EventBatch implements Serializable {
        private List<EventRecord> events = new ArrayList<>();

        public List<EventRecord> getEvents() { return events; }
        public void setEvents(List<EventRecord> events) { this.events = events; }
    }
}
