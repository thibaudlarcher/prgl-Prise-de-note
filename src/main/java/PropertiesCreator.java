import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PropertiesCreator {
    public PropertiesCreator() {
    }

    public void createPropertiesFile() {
        File f = new File("notes.properties");
        if (!(f.exists())) {
            try {
                FileWriter fw = new FileWriter(f, true);
                if (OSRecognizer.isWindows()) {
                    fw.write("notepad\n");
                } else if (OSRecognizer.isMac()) {
                    System.out.println(System.getProperty("user.dir"));
                    fw.write("/Applications/TextEdit.app/Contents/MacOS/TextEdit\n");
                } else {
                    fw.write("notepad\n");
                }
                fw.write(System.getProperty("user.dir") + "/\n");
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void updatePropertiesFile(String paths) {
        File f = new File("notes.properties");
        if ((f.exists())) {
            try {
                FileWriter fw = new FileWriter(f, false);
                if (OSRecognizer.isWindows()) {
                    fw.write("notepad\n");
                } else if (OSRecognizer.isMac()) {
                    fw.write("/Applications/TextEdit.app/Contents/MacOS/TextEdit\n");
                } else {
                    fw.write("notepad\n");
                }
                fw.write(paths + "/\n");
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}