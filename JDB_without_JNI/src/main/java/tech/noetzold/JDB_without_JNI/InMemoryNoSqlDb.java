package tech.noetzold.JDB_without_JNI;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class InMemoryNoSqlDb implements DatabaseInterface {
    private final Map<String, Document> store = new HashMap<>();
    private final String dbDirectory = "dbFiles";

    public InMemoryNoSqlDb() {
        File directory = new File(dbDirectory);
        if (!directory.exists()) {
            directory.mkdir();
        }
    }

    @Override
    public void create(String id, Document document) {
        store.put(id, document);
        saveToFile(id, document);
    }

    @Override
    public Document read(String id) {
        return store.getOrDefault(id, readFromFile(id));
    }

    @Override
    public void update(String id, Document document) {
        store.put(id, document);
        saveToFile(id, document);
    }

    @Override
    public void delete(String id) {
        store.remove(id);
        new File(dbDirectory + "/" + id + ".txt").delete();
    }

    private void saveToFile(String id, Document document) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(dbDirectory + "/" + id + ".txt"))) {
            out.writeObject(document);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Document readFromFile(String id) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(dbDirectory + "/" + id + ".txt"))) {
            return (Document) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }
}
