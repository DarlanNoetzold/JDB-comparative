package tech.noetzold.JDB_witch_JNI;

public interface DatabaseInterface {
    void create(String id, String data);
    String read(String id);
    void update(String id, String data);
    void delete(String id);
}