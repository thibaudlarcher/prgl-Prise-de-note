import java.io.IOException;

public class Delete implements Command {
    private static String path;

    public Delete() {
        if(path == null){
            path =  PropertiesRead.getPaths();
        }
    }

    @Override
    public void command(String str) {
        Note note = new Note.NoteBuilder(str).build();
        index.deleteNote(note);

        if (str.length() >= 5 && str.substring(str.length() - 5).equals(".adoc")) {
            String[] command = {"rm", path + str};
            try {
                Runtime.getRuntime().exec(command);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            String[] command = {"rm", path+ str + ".adoc"};
            try {
                Runtime.getRuntime().exec(command);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
