import java.io.IOException;

public class View implements Command {
    private static String paths;

    public View(){
        if(paths == null){
            paths =  PropertiesRead.getPaths();
        }
    }

    @Override
    public void command(String str) {
        if (str.length() >= 5 && str.substring(str.length() - 5).equals(".adoc")) {
            String[] command = {"open",paths + str};
            try {
                Runtime.getRuntime().exec(command);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            String[] command = {"open",paths + str + ".adoc"};
            try {
                Runtime.getRuntime().exec(command);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
