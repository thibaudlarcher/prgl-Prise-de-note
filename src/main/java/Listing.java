import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Listing implements Command {
    private String paths;

    public Listing(String paths){
        this.paths = paths;
    }

    private void affichageList(Process process,String str) throws IOException {
        StringBuilder output = new StringBuilder();
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            output.append("|    "+line + "\n");
        }
        System.out.println("\033[0;34m"+"target/");
        System.out.println(output+"\033[0m");
    }

    @Override
    public void command(String str) {
        if (str.equals("")) {
            String[] command = {"ls","*.adoc","target"};
            Process process = null;
            try {
                process = Runtime.getRuntime().exec(command);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                affichageList(process,"target");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            String[] command = {"ls","*.adoc", str};
            Process process = null;
            try {
                process = Runtime.getRuntime().exec(command);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                affichageList(process,str);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean isEqual(String str) {
        if(str.equals("ls") || str.equals("list"))
            return true;
        return false;
    }
}

