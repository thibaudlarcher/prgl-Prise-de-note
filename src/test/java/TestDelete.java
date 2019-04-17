import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.File;

public class TestDelete {

    @BeforeClass
    public static void TestDeleteBefore(){
        PropertiesCreator.createPropertiesFile();
        PropertiesRead.readPropertiesFile();
        IndexCreator.createIndexFile();
        InterpreteurGlobal.execute("e TestDeletion1".split(" "));
        InterpreteurGlobal.execute("e TestDeletion2".split(" "));
    }

    @Test
    public void TestDeleteFichier(){
        String e = "delete TestDeletion1";
        InterpreteurGlobal.execute(e.split(" "));
        Delete del = new Delete();
        File f = new File(del.getPath()+"TestDeletion1.adoc");
        assertFalse(f.exists());
    }

    @Test
    public void TestDelFichier(){
        String e = "d TestDeletion2";
        InterpreteurGlobal.execute(e.split(" "));
        Delete del = new Delete();
        File f = new File(del.getPath()+"TestDeletion2.adoc");
        assertFalse(f.exists());
    }

    @AfterClass
    public static void TestDeleteAfter(){
        InterpreteurGlobal.execute("delete TestDeletion1".split(" "));
        InterpreteurGlobal.execute("delete TestDeletion2".split(" "));
        InterpreteurGlobal.execute("delete index".split(" "));
        File f = new File(PropertiesRead.getPaths());
        f.delete();
        File f2 = new File("notes.properties");
        f2.delete();
    }
}
