import java.awt.*;
import java.io.File;
import java.io.IOException;

public class View implements Command {
    private static String paths;

    public View(){
        if(paths == null) {
            paths =  PropertiesRead.getPaths();
        }
    }

    @Override
    public void command(String str) {
        if (str.length() >= 5 && str.substring(str.length() - 5).equals(".adoc")) {
            String file = paths + str;
            file.replaceAll(" ", "%20");
            File f = new File(file);
            try {
                Desktop.getDesktop().browse(f.toURI());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            String file = paths + str + ".adoc";
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
