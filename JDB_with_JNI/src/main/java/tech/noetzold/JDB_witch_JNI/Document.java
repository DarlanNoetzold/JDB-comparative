package tech.noetzold.JDB_witch_JNI;

import java.util.Map;

public class Document {
    private String id;
    private Map<String, Object> data;

    public Document(String id, Map<String, Object> data) {
        this.id = id;
        this.data = data;
    }

    public Document() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
