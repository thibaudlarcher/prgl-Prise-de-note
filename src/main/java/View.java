import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Classe pour la visualisation d'une note.
 */
public class View implements Command {
    private static String paths;

    /**
     * Constructeur de la classe.
     */
    public View(){
        if(paths == null) {
            paths =  PropertiesRead.getPaths();
        }
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Override
    public void command(String str) {
        if (str.length() >= 5 && str.substring(str.length() - 5).equals(".adoc")) {
            String file = paths + str;
            if (file.equalsIgnoreCase(paths + "index.adoc")) {
                index.updateIndex();
            }
            file.replaceAll(" ", "%20");
            File f = new File(file);
            try {
                Desktop.getDesktop().browse(f.toURI());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            String file = paths + str + ".adoc";
            if (file.equalsIgnoreCase(paths + "index.adoc")) {
                index.updateIndex();
            }
            file.replaceAll(" ", "%20");
            File f = new File(file);
            try {
                Desktop.getDesktop().browse(f.toURI());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
