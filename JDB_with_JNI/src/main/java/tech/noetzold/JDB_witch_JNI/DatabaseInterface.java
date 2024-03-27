package tech.noetzold.JDB_witch_JNI;

public interface DatabaseInterface {
    void createDocument(Document document);
    Document getDocument(String id);
    void updateDocument(String id, Document document);
    void deleteDocument(String id);
}