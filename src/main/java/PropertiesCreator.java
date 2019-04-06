import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PropertiesCreator {
    private PropertiesCreator() {

    }

    public static void createPropertiesFile(){
        File f = new File("notes.properties");
        if(!(f.exists())) {
            try {
                FileWriter fw = new FileWriter(f, true);
                if (OSRecognizer.isWindows()) {
                    System.out.println("test");
                    fw.write("notepad\n");
                } else if (OSRecognizer.isMac()) {
                    fw.write("/Applications/TextEdit.app/Contents/MacOS/TextEdit\n");
                } else {
                    fw.write("notepad\n");
                }
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
