import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Classe pour la création du fichier de propriété.
 */
public class PropertiesCreator {
    private PropertiesCreator() {
    }

    /**
     * Méthode pour créer le dossier où les notes seront enregistrer.
     */
    @SuppressWarnings("ResultOfMethodCallIgnored")
    private static void createDir(){
        File f = new File("notes.properties");

        BufferedReader br;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(f), StandardCharsets.UTF_8));
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

    /**
     * Méthode pour créer le fichier des propriétés.
     */
    public static void createPropertiesFile(){
        File f = new File("notes.properties");
        if(!(f.exists())) {
            try {
                FileWriter fw = new FileWriter(f, true);
                if (OSRecognizer.isWindows()) {
                    fw.write("notepad\n");
                } else if (OSRecognizer.isMac()) {
                    fw.write("code\n");
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

    /**
     * Méthode pour mettre à jour le fichier des propriétés.
     * @param paths le chemin où ce trouve le fichier.
     */
    public static void updatePropertiesFile(String paths) {
        File f = new File("notes.properties");
        if ((f.exists())) {
            try {
                String programme;
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
                programme = br.readLine();
                br.close();
                FileWriter fw = new FileWriter(f, false);
                fw.write(programme+"\n");
                fw.write(paths);
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
}
