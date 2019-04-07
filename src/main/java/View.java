import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

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
            try {
                Desktop.getDesktop().browse(new URI("file:///" + file));
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        } else {
            String file = paths + str + ".adoc";
            try {
                Desktop.getDesktop().browse(new URI("file:///" + file));
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }
}
