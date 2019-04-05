import java.io.*;

public class Edition {
    static String programme = null;
    public Edition() {
    }

    private void creationFile(String str){
        String str2;
        if(str.equals("")){
            str2 = "NewFile";
        }else{
            str2 = str;
        }
        File f = new File(str2+".adoc");
        if(!(f.exists())) {
            try {
                FileWriter fw = new FileWriter(f, true);
                fw.write("= "+str2);
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void ProcessEdit(String str){
        if(programme == null){
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

        creationFile(str);

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
