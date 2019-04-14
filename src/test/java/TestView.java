import org.junit.jupiter.api.Test;

public class TestView {
    @Test
    public void TestView(){
        PropertiesCreator.createPropertiesFile();
        PropertiesRead.readPropertiesFile();
        IndexCreator.createIndexFile();
        String e = "view NewFile";
        InterpreteurGlobal com = new InterpreteurGlobal();
        com.execute(e.split(" "));
    }
}
