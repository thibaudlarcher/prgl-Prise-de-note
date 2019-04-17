import java.io.*;
import java.time.LocalDate;

public class Edition implements Command{
    private static String programme = null;
    private static String paths;
    public Edition(){
        if(paths == null){
            paths = PropertiesRead.getPaths();
        }
        if(programme == null){
            programme = PropertiesRead.getApplication();
        }
    }

    private void creationFile(String str){
        String str2;
        if(str.equals("")){
            str2 = "NewFile";
        }else{
            str2 = str;
        }
        File f = new File(paths+str2+".adoc");
        if(!(f.exists())) {
            try {
                Note note = new Note.NoteBuilder(str2).setDate(LocalDate.now().getMonthValue()).build();
                index.addNote(note);

                FileWriter fw = new FileWriter(f, true);
                fw.write("= "+str2 + "\n");
                fw.write(System.getProperty("user.name") + "\n");
                fw.write(LocalDate.now().getDayOfMonth() +
                        "/"+ LocalDate.now().getMonthValue() +
                        "/"+LocalDate.now().getYear() + "\n");
                fw.write(":context:" + "\n");
                fw.write(":project:" + "\n");
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void command(String str){

        creationFile(str);

        if(str.equals("")){
            try {
                String p = paths + "NewFile.adoc";
                String[] command = {programme,p };
                Runtime.getRuntime().exec(command);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            try {
                String p = paths + str + ".adoc";
                String[] command = {programme,p};
                Runtime.getRuntime().exec(command);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
