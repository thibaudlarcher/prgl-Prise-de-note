import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class listing {
    public listing(){}

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

    public void list(String str){

        if (str.substring(0,2).equals("ls")) {
            try {
                if (str.substring(2).equals("")) {
                    String[] command = {"ls", "target"};
                    Process process = Runtime.getRuntime().exec(command);
                    affichageList(process,"target");
                    process.waitFor();
                }else{
                    String[] command = {"ls", str.substring(2)};
                    Process process = Runtime.getRuntime().exec(command);
                   affichageList(process,str.substring(2));
                    process.waitFor();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else if (str.substring(0,4).equals("list")){
            try {
                if (str.substring(4).equals("")) {
                    String[] command = {"ls", "target"};
                    Process process = Runtime.getRuntime().exec(command);
                    affichageList(process,"target");
                    process.waitFor();
                }else{
                    String[] command = {"ls", str.substring(4)};
                    Process process = Runtime.getRuntime().exec(command);
                    affichageList(process,str.substring(4));
                    process.waitFor();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
