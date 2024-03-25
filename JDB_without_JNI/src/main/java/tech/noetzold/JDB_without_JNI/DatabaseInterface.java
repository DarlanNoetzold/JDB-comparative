package tech.noetzold.JDB_without_JNI;

public interface DatabaseInterface {
    void create(String id, Document document);
    Document read(String id);
    void update(String id, Document document);
    void delete(String id);
}