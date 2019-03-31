import java.io.IOException;

public class Edition {

    public Edition() {
    }

    public void ProcessEdit(String str){
        if(str == ""){
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
//        if (str.charAt(0) == 'e') {
//            try {
//                if (str.substring(1).equals("")){
//                    String[] command = {"code","NewFile"};
//                    Process process = Runtime.getRuntime().exec(command);
//                    process.waitFor();
//                }else {
//                    Process process = Runtime.getRuntime().exec("code "+str.substring(1));
//                    process.waitFor();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }else if (str.substring(0,3).equals("edit")) {
//            try {
//                if (str.substring(4).equals("")){
//                    Process process = Runtime.getRuntime().exec("code NewFile");
//                    process.waitFor();
//                }else {
//                    Process process = Runtime.getRuntime().exec("code "+str.substring(4));
//                    process.waitFor();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }
}
