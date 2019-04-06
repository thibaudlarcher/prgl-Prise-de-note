import java.io.*;
import java.util.ArrayList;

public class PropertiesRead {

    private String paths;
    private String application;

    public PropertiesRead() {
        readPropertiesFile();
    }

    public void readPropertiesFile() {
        File f = new File("notes.properties");
        if ((f.exists())) {
            BufferedReader br;
            String motLu;

            try{
                br = new BufferedReader(new InputStreamReader(new FileInputStream("notes.properties"),"UTF-8"));
                for(int i = 0;i<2;i++){
                    if(i == 0)
                        this.application = br.readLine();
                    if(i == 1)
                        this.paths = br.readLine();
                }
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String getPaths() {
        return paths;
    }

    public String getApplication() {
        return application;
    }
}
