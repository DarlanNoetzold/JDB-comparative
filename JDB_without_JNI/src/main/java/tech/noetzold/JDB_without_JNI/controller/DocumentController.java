package tech.noetzold.JDB_without_JNI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.noetzold.JDB_without_JNI.Document;
import tech.noetzold.JDB_without_JNI.InMemoryNoSqlDb;

import java.util.Map;

@RestController
@RequestMapping("/api/documents")
public class DocumentController {

    private final InMemoryNoSqlDb database;

    @Autowired
    public DocumentController(InMemoryNoSqlDb database) {
        this.database = database;
    }

    @PostMapping
    public String createDocument(@RequestBody Map<String, Object> data) {
        String id = generateId();
        Document document = new Document(id, data);
        database.create(id, document);
        return "Document created with ID: " + id;
    }

    @GetMapping("/{id}")
    public Document getDocument(@PathVariable String id) {
        return database.read(id);
    }

    @PutMapping("/{id}")
    public String updateDocument(@PathVariable String id, @RequestBody Map<String, Object> data) {
        Document document = new Document(id, data);
        database.update(id, document);
        return "Document updated with ID: " + id;
    }

    @DeleteMapping("/{id}")
    public String deleteDocument(@PathVariable String id) {
        database.delete(id);
        return "Document deleted with ID: " + id;
    }

    private String generateId() {
        return java.util.UUID.randomUUID().toString();
    }
}

