import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Listing implements Command {
    private String paths;

    public Listing(){
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
        System.out.println("\033[0;34m"+"target/");
        System.out.println(output+"\033[0m");
    }

    @Override
    public void command(String str) {
        if (str.equals("")) {
            String[] command = {"ls","*.adoc","target"};
            Process process;
            try {
                process = Runtime.getRuntime().exec(command);
                affichageList(process);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            String[] command = {"ls","*.adoc", str};
            Process process;
            try {
                process = Runtime.getRuntime().exec(command);
                affichageList(process);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

