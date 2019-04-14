import java.io.IOException;

public class Delete implements Command {
    private static String path;

    /**
     * Builder de la class Delete
     */
    public Delete() {
        if(path == null){
            path =  PropertiesRead.getPaths();
        }
    }

    /**
     * Permet de récupérer le chemin physique du dossier note
     * @return le chemin du dossier note
     */
    public static String getPath() {
        return path;
    }

    /**
     * Commande du delete qui permet de supprimer le fichier que l'on souhaite
     * @param str la commande composé du "d" ou "delete" suivit du fichier
     */
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
