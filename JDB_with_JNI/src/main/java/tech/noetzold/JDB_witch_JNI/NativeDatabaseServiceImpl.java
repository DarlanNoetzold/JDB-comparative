package tech.noetzold.JDB_witch_JNI;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.nio.charset.StandardCharsets;
import org.springframework.stereotype.Service;

@Service
public class NativeDatabaseServiceImpl implements DatabaseInterface {

    @Override
    public void createDocument(Document document) {
    }

    @Override
    public Document getDocument(String id) {
        return null;
    }

    @Override
    public void updateDocument(String id, Document document) {
    }

    @Override
    public void deleteDocument(String id) {
    }
}
