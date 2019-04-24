import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Search implements Command {

    private static String paths;

    /**
     * builder du listing
     */
    public Search(){
        if(paths == null){
            paths =  PropertiesRead.getPaths();
        }
    }

    /**
     * Permet de récupérer le chemin physique du dossier note
     * @return le chemin du dossier note
     */
    public static String getPaths() {
        return paths;
    }

    private void affichageSearch(Process process) throws IOException {
        StringBuilder output = new StringBuilder();
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(process.getInputStream()));
        String line;
        line = reader.readLine();
        while ((line = reader.readLine()) != null) {
            output.append("|    ");
            output.append(line);
            output.append("\n");
        }
        System.out.println("\033[0;34m");
        System.out.println(output+"\033[0m");
    }

    @Override
    public void command(String str) {
        String[] command = {"find",paths," | xargs grep",str};
        Process process;
        try {
            process = Runtime.getRuntime().exec(command);
            affichageSearch(process);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
