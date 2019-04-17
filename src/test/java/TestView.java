import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;
public class TestView {
    @BeforeClass
    public static void TestViewBefore(){
        PropertiesCreator.createPropertiesFile();
        PropertiesRead.readPropertiesFile();
        IndexCreator.createIndexFile();
        InterpreteurGlobal.execute("e NewFile".split(" "));
    }

    @Test
    public void TestView(){
        String e = "view NewFile";
        InterpreteurGlobal.execute(e.split(" "));
    }

    @AfterClass
    public static void TestDeleteAfter(){
        InterpreteurGlobal.execute("delete NewFile".split(" "));
        InterpreteurGlobal.execute("delete index".split(" "));
        File f = new File(PropertiesRead.getPaths());
        f.delete();
        File f2 = new File("notes.properties");
        f2.delete();
    }
}
