import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Listing implements Command {
    private static String paths;

    public Listing(){
        if(paths == null){
            paths =  PropertiesRead.getPaths();
        }
    }

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

