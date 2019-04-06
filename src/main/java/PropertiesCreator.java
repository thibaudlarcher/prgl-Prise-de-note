import java.io.*;

public class PropertiesCreator {
    private PropertiesCreator() {
    }

    private static void createDir(){
        File f = new File("notes.properties");

        BufferedReader br;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(f),"UTF-8"));
            br.readLine();
            String path = br.readLine();
            File f2 = new File(path);
            if(!(f2.exists())){
                f2.mkdirs();
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createPropertiesFile(){
        File f = new File("notes.properties");
        if(!(f.exists())) {
            try {
                FileWriter fw = new FileWriter(f, true);
                if (OSRecognizer.isWindows()) {
                    fw.write("notepad\n");
                } else if (OSRecognizer.isMac()) {
                    fw.write("/Applications/TextEdit.app/Contents/MacOS/TextEdit\n");
                } else {
                    fw.write("notepad\n");
                }
                fw.write(System.getProperty("user.dir"));
                if (OSRecognizer.isWindows()) {
                    fw.write("\\notes\\\n");
                } else if (OSRecognizer.isMac()) {
                    fw.write("/notes/\n");
                } else {
                    fw.write("/notes/\n");
                }
                fw.write("\n");
                fw.write("\n");
                fw.write("\n");
                fw.write("Tout changement sera répercuté après un redémarage de l'Application.");
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        createDir();
    }
    public static void updatePropertiesFile(String paths) {
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
                fw.write(paths);
                if (OSRecognizer.isWindows()) {
                    fw.write("\\notes\\\n");
                } else if (OSRecognizer.isMac()) {
                    fw.write("/notes/\n");
                } else {
                    fw.write("/notes/\n");
                }
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        createDir();
    }
}
