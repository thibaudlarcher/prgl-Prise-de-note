import java.io.IOException;

public class Edition {

    public Edition() {
    }

    public void ProcessEdit(String str){
        if(str.equals("")){
            String[] command = {"C:\\Program Files (x86)\\Notepad++\\notepad++","NewFile.adoc"};
            try {
                Runtime.getRuntime().exec(command);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            String[] command = {"C:\\Program Files (x86)\\Notepad++\\notepad++",str + ".adoc"};
            try {
                Runtime.getRuntime().exec(command);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
