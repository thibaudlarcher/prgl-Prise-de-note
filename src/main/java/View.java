import java.io.IOException;

public class View implements Command {
    private String path;

    public View(String path){
        this.path = path;
    }

    @Override
    public void command(String str) {
        if (str.length() >= 5 && str.substring(str.length() - 5).equals(".adoc")) {
            String[] command = {"open", str};
            try {
                Runtime.getRuntime().exec(command);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            String[] command = {"open", str + ".adoc"};
            try {
                Runtime.getRuntime().exec(command);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean isEqual(String str) {
        if (str.equals("View") || str.equals("v")) {
            return true;
        }
        return false;
    }
}
