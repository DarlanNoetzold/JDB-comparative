package tech.noetzold.JDB_witch_JNI;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.nio.charset.StandardCharsets;
import org.springframework.stereotype.Service;

@Service
public class NativeDatabaseServiceImpl implements DatabaseInterface {

    static {
        System.loadLibrary("nomeDaSuaBiblioteca"); // Carrega a biblioteca nativa
    }

    public native void create(String id, String data);
    public native String read(String id);
    public native void update(String id, String data);
    public native void delete(String id);
}
