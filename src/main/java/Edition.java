import java.io.IOException;

public class Edition {

    public Edition() {
    }

    public void ProcessEdit(String str){
        if(str == ""){
            String[] command = {"code","NewFile.adoc"};
            try {
                Runtime.getRuntime().exec(command);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            String[] command = {"code",str + ".adoc"};
            try {
                Runtime.getRuntime().exec(command);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
