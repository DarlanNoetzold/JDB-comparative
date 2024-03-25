package tech.noetzold.JDB_without_JNI;

import java.util.HashMap;
import java.util.Map;

public class Document {
    private String id;
    private Map<String, Object> data;

    public Document(String id, Map<String, Object> data) {
        this.id = id;
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public Map<String, Object> getData() {
        return new HashMap<>(data);
    }
}