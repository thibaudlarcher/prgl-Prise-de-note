import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class TestEdit {
    @Test
    public void TestEditionNewFichier(){
        PropertiesCreator.createPropertiesFile();
        PropertiesRead.readPropertiesFile();
        IndexCreator.createIndexFile();
        String e = "e";
        InterpreteurGlobal.execute(e.split(" "));
        Edition edt = new Edition();
        File f = new File(edt.getPath()+"NewFile.adoc");
        assertTrue(f.exists());
    }
    @Test
    public void TestEditionFichier(){
        PropertiesCreator.createPropertiesFile();
        PropertiesRead.readPropertiesFile();
        IndexCreator.createIndexFile();
        String e = "e Bonjour";
        InterpreteurGlobal.execute(e.split(" "));
        Edition edt = new Edition();
        File f = new File(edt.getPath()+"Bonjour.adoc");
        assertTrue(f.exists());
    }
}
