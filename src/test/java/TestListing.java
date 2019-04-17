import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class TestListing {
    @BeforeClass
    public static void TestListBefore(){
        PropertiesCreator.createPropertiesFile();
        PropertiesRead.readPropertiesFile();
        IndexCreator.createIndexFile();
    }

    @Test
    public void TestListingls(){
        String e = "ls";
        InterpreteurGlobal.execute(e.split(" "));
        Listing lis = new Listing();
        String temp;
        temp = PropertiesRead.getPaths();
        assertEquals(lis.getPaths(),temp);
    }
    @Test
    public void TestListinglist(){
        String e = "list";
        InterpreteurGlobal.execute(e.split(" "));
        Listing lis = new Listing();
        String temp;
        temp = PropertiesRead.getPaths();
        assertEquals(lis.getPaths(),temp);
    }

    @AfterClass
    public static void TestListAfter(){
        InterpreteurGlobal.execute("delete index".split(" "));
        File f = new File(PropertiesRead.getPaths());
        f.delete();
        File f2 = new File("notes.properties");
        f2.delete();
    }
}
