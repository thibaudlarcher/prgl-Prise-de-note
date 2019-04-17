import org.junit.Test;
import static org.junit.Assert.*;

public class TestView {
    @Test
    public void TestView(){
        PropertiesCreator.createPropertiesFile();
        PropertiesRead.readPropertiesFile();
        IndexCreator.createIndexFile();
        String e = "view NewFile";
        InterpreteurGlobal.execute(e.split(" "));
    }
}
