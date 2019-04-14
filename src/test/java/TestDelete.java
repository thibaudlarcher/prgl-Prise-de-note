import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.Assert.*;

public class TestDelete {
    @Test
    public void TestDeleteFichier(){
        PropertiesCreator.createPropertiesFile();
        PropertiesRead.readPropertiesFile();
        IndexCreator.createIndexFile();
        String e = "delete bonjour";
        InterpreteurGlobal com = new InterpreteurGlobal();
        com.execute(e.split(" "));
        Delete del = new Delete();
        File f = new File(del.getPath()+"bonjour.adoc");
        assertFalse(f.exists());
    }
    @Test
    public void TestDelFichier(){
        PropertiesCreator.createPropertiesFile();
        PropertiesRead.readPropertiesFile();
        IndexCreator.createIndexFile();
        String e = "d bonjour";
        InterpreteurGlobal com = new InterpreteurGlobal();
        com.execute(e.split(" "));
        Delete del = new Delete();
        File f = new File(del.getPath()+"bonjour.adoc");
        assertFalse(f.exists());
    }
}
