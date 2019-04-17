import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class TestEdit {

    @BeforeClass
    public static void TestEditBefore(){
        PropertiesCreator.createPropertiesFile();
        PropertiesRead.readPropertiesFile();
        IndexCreator.createIndexFile();
    }

    @Test
    public void TestEditionNewFichier(){
        String e = "e";
        InterpreteurGlobal.execute(e.split(" "));
        Edition edt = new Edition();
        File f = new File(edt.getPath()+"NewFile.adoc");
        assertTrue(f.exists());
    }

    @Test
    public void TestEditionFichier(){
        String e = "e Bonjour";
        InterpreteurGlobal.execute(e.split(" "));
        Edition edt = new Edition();
        File f = new File(edt.getPath()+"Bonjour.adoc");
        assertTrue(f.exists());
    }

    @AfterClass
    public static void TestEditAfter(){
        InterpreteurGlobal.execute("delete Bonjour".split(" "));
        InterpreteurGlobal.execute("delete Newfile".split(" "));
        InterpreteurGlobal.execute("delete index".split(" "));
        File f = new File(PropertiesRead.getPaths());
        f.delete();
        File f2 = new File("notes.properties");
        f2.delete();
    }

}
