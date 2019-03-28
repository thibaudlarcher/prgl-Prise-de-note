import java.io.IOException;

public class Edition {

    public Edition() {
    }

    public void ProcessEdit(String str){

        if (str.charAt(0) == 'e') {
            try {
                if (str.substring(1).equals("")){
                    Process process = Runtime.getRuntime().exec("code NewFile");
                    process.waitFor();
                }else {
                    Process process = Runtime.getRuntime().exec("code "+str.substring(1));
                    process.waitFor();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else if (str.substring(3).equals("edit")) {
            try {
                if (str.substring(4).equals("")){
                    Process process = Runtime.getRuntime().exec("code NewFile");
                    process.waitFor();
                }else {
                    Process process = Runtime.getRuntime().exec("code "+str.substring(4));
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
