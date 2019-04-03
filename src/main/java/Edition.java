import java.io.IOException;

public class Edition implements Command{
    private String paths;
    public Edition(String paths) {
        this.paths = paths;
    }

    @Override
    public void command(String str) {
        if(str.equals("")){
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

    @Override
    public boolean isEqual(String str) {
        if(str.equals("e") || str.equals("edit")){
            return true;
        }
        return false;
    }
}
