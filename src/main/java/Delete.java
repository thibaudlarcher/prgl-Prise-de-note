import java.io.IOException;

public class Delete implements Command {
    private String path;

    public Delete(String path) {
        this.path = path;
    }

    @Override
    public void command(String str) {
        if (str.length() >= 5 && str.substring(str.length() - 5).equals(".adoc")) {
            String[] command = {"rm", str};
            try {
                Runtime.getRuntime().exec(command);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            String[] command = {"rm", str + ".adoc"};
            try {
                Runtime.getRuntime().exec(command);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean isEqual (String str){
        return str.equals("delete") || str.equals("d");
    }
}
