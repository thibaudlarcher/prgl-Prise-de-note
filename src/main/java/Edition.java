import java.io.*;
import java.time.LocalDate;

public class Edition implements Command{
    private static String programme = null;
    private static String paths;

    /**
     * Permet de récupérer le programme et le path propre a chaque ordinateur
     */
    public Edition(){
        if(paths == null){
            paths = PropertiesRead.getPaths();
        }
        if(programme == null){
            programme = PropertiesRead.getApplication();
        }
    }

    /**
     * Permet de remplir le fichier .adoc avec la base du asciidoctor
     * @param str Le nom du fichier
     */
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
                Note note = new Note.NoteBuilder(str2).build();
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
        index.updateIndex();
    }

    /**
     * Permet de récupérer le chemin physique du dossier note
     * @return le chemin du dossier note
     */
    public String getPath(){
        return paths;
    }

    /**
     * Permet la création de fichier, elle va permet de créer un nouveau fichier sans nom ou avec un nom
     * @param str la commande de la création de fichier par "e" ou "edit" suivi ou non du nom de fichier
     */
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
