import java.io.*;

/**
 * Classe pour l'ouverture du fichier des propriétés.
 */
public class PropertiesOpener implements Command {
    private static String programme;
    public PropertiesOpener() {
    }

    @Override
    public void command(String str) {
        if(programme == null){
            File f = new File("notes.properties");
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
                programme = br.readLine();
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            String[] command = {programme,"notes.properties"};
            Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
