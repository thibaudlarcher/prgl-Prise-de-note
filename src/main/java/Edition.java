import java.io.*;

public class Edition {
    static String programme = null;
    public Edition() {
    }

    public void ProcessEdit(String str){
        if(programme == null){
            System.out.println("test");
            File f = new File("notes.properties");
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
                programme = br.readLine();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        if(str.equals("")){
            try {
                String[] command = {programme,"NewFile.adoc"};
                Runtime.getRuntime().exec(command);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            try {
                String[] command = {programme,str + ".adoc"};
                Runtime.getRuntime().exec(command);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
