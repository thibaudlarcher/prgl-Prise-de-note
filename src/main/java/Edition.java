import java.io.IOException;

public class Edition {

    public Edition() {
    }

    public void ProcessEdit(String str){
        if(str.equals("")){
            try {
                if(OSRecognizer.isWindows()) {
                    String[] command = {"notepad","NewFile.adoc"};
                    Runtime.getRuntime().exec(command);
                }else if(OSRecognizer.isMac()) {
                    String[] command = {"code","NewFile.adoc"};
                    Runtime.getRuntime().exec(command);
                }else {
                    String[] command = {"code","NewFile.adoc"};
                    Runtime.getRuntime().exec(command);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            try {
                if(OSRecognizer.isWindows()) {
                    String[] command = {"notepad",str + ".adoc"};
                    Runtime.getRuntime().exec(command);
                }else if(OSRecognizer.isMac()) {
                    String[] command = {"code",str + ".adoc"};
                    Runtime.getRuntime().exec(command);
                }else {
                    String[] command = {"code",str + ".adoc"};
                    Runtime.getRuntime().exec(command);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
