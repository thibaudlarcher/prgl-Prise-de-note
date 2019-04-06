import java.io.*;

public class Edition implements Command{
    static String programme = null;
    private String paths;
    public Edition(String paths) {
        this.paths = paths;
    }

    private void creationFile(String str){
        String str2;
        if(str.equals("")){
            str2 = "NewFile";
        }else{
            str2 = str;
        }
        File f = new File(paths+str2+".adoc");
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

    @Override
    public void command(String str){
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
                System.out.println(paths);
                String p = paths + "NewFile.adoc";
                String[] command = {programme,p };
                Runtime.getRuntime().exec(command);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            try {
                String p = paths + str + ".adoc";
                String[] command = {programme,p};
                Runtime.getRuntime().exec(command);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean isEqual(String str) {
        if(str.equals("e") || str.equals("edit")){
            return true;
        }
        return false;
    }
}
