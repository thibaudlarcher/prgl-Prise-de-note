import java.io.*;
import java.nio.charset.StandardCharsets;

public class PropertiesRead {

    private static String paths;
    private static String application;

    private PropertiesRead() {
        readPropertiesFile();
    }

    public static void readPropertiesFile() {
        File f = new File("notes.properties");
        if ((f.exists())) {
            BufferedReader br;
            try{
                br = new BufferedReader(new InputStreamReader(new FileInputStream("notes.properties"), StandardCharsets.UTF_8));
                for(int i = 0;i<2;i++){
                    if(i == 0)
                        application = br.readLine();
                    if (i == 1)
                        paths = br.readLine();
                }
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getPaths() {
        return paths;
    }

    public static String getApplication() {
        return application;
    }

}
