import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Listing implements Command {
    private static String paths;

    /**
     * builder du listing
     */
    public Listing(){
        if(paths == null){
            paths =  PropertiesRead.getPaths();
        }
    }

    /**
     * Permet de récuprer les différents fichier et dossier contenue dans le path
     * @param process le processus du listing linux
     * @throws IOException
     */
    private void affichageList(Process process) throws IOException {
        StringBuilder output = new StringBuilder();
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            output.append("|    ");
            output.append(line);
            output.append("\n");
        }
        System.out.println("\033[0;34m");
        System.out.println(output+"\033[0m");
    }

    /**
     * Permet de récupérer le chemin physique du dossier note
     * @return le chemin du dossier note
     */
    public static String getPaths() {
        return paths;
    }

    /**
     * Permet d'interpréter la commande du listing, il va automatiquement renvoyer ce qu'il y a comme note dans le dossier prédéfini
     * @param str la commande du listing
     */
    @Override
    public void command(String str) {
        String[] command = {"ls","*.adoc",paths};
        Process process;
        try {
            process = Runtime.getRuntime().exec(command);
            affichageList(process);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

