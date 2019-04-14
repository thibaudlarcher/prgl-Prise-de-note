import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

public class TestListing {
    @Test
    public void TestListingls(){
        PropertiesCreator.createPropertiesFile();
        PropertiesRead.readPropertiesFile();
        IndexCreator.createIndexFile();
        String e = "ls";
        InterpreteurGlobal com = new InterpreteurGlobal();
        com.execute(e.split(" "));
        Listing lis = new Listing();
        String temp;
        temp = PropertiesRead.getPaths();
        assertEquals(lis.getPaths(),temp);
    }
    @Test
    public void TestListinglist(){
        PropertiesCreator.createPropertiesFile();
        PropertiesRead.readPropertiesFile();
        IndexCreator.createIndexFile();
        String e = "list";
        InterpreteurGlobal com = new InterpreteurGlobal();
        com.execute(e.split(" "));
        Listing lis = new Listing();
        String temp;
        temp = PropertiesRead.getPaths();
        assertEquals(lis.getPaths(),temp);
    }
}
