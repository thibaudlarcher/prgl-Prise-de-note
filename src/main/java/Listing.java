import java.io.BufferedReader;
import java.io.File;
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
        StringBuilder output = new StringBuilder();

        System.out.println("\033[0;34m");
        output.append(paths);
        output.append(" :\n");
        File f = new File(paths);
        for(File f2 : f.listFiles()){
            output.append("|    ");
            output.append(f2.getName());
            output.append("\n");
        }
        System.out.println(output);
        System.out.println("\033[0m");
    }
}

