import org.junit.Test;
import static org.junit.Assert.*;
import java.io.File;

public class TestDelete {
    @Test
    public void TestDeleteFichier(){
        PropertiesCreator.createPropertiesFile();
        PropertiesRead.readPropertiesFile();
        IndexCreator.createIndexFile();
        String e = "delete bonjour";
        InterpreteurGlobal.execute(e.split(" "));
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
        InterpreteurGlobal.execute(e.split(" "));
        Delete del = new Delete();
        File f = new File(del.getPath()+"bonjour.adoc");
        assertFalse(f.exists());
    }
}
