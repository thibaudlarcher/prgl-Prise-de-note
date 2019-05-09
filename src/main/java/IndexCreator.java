import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Classe pour créer l'index.
 */
public class IndexCreator {
    private ArrayList<Note> ListNote;

    /**
     * Constructeur de la classe.
     */
    public IndexCreator() {
        ListNote = new ArrayList<>();
    }

    /**
     * Méthode pour créer l'index si le fichier n'existe pas.
     */
    public static void createIndexFile() {
        File f = new File(PropertiesRead.getPaths() + "index.adoc");

        if (!(f.exists())) {
            try {
                FileWriter fw = new FileWriter(f, true);
                fw.write("= Liste des notes\n");
                fw.write("\n");
                fw.write("==== Tri des notes par ordre alphabétique :\n");
                fw.write("[square]");
                fw.write("\n");
                fw.write("==== Tri des notes par contexte :\n");
                fw.write("[square]");
                fw.write("\n");
                fw.write("==== Tri des notes par projet :\n");
                fw.write("[square]");
                fw.write("\n");
                fw.write("==== Tri des notes par mois de création :\n");
                fw.write("[square]");
                fw.write("\n");
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Méthode pour lire le fichier de l'index et récuperer son contenu (les notes) que l'on met dans une liste.
     */
    private void readIndex() {
        this.ListNote = new ArrayList<>();
        File f = new File(PropertiesRead.getPaths() + "index.adoc");
        if (f.exists()) {
            BufferedReader br;
            try {
                br = new BufferedReader(new InputStreamReader(new FileInputStream(PropertiesRead.getPaths() + "index.adoc"), StandardCharsets.UTF_8));
                String line = br.readLine();
                while (line != null) {
                    boolean exist = false;
                    if (line.startsWith("*")) {
                        String titre = line.substring(2);
                        if (ListNote.isEmpty()) {
                            ListNote.add(new Note.NoteBuilder(titre).setContext(findContext(titre)).setProject(findProject(titre)).setDate(findDate(titre)).build());
                        } else {
                            for (Note note : ListNote) {
                                if (note.getTitre().equalsIgnoreCase(titre)) {
                                    exist = true;
                                }
                            }
                            if (!exist) {
                                ListNote.add(new Note.NoteBuilder(titre).setContext(findContext(titre)).setProject(findProject(titre)).setDate(findDate(titre)).build());
                            }
                        }
                    }
                    line = br.readLine();
                }
                br.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Méthode pour ajouter une note dans l'index.
     * @param note la nouvelle note à ajouter.
     */
    public void addNote(Note note) {
        File f = new File(PropertiesRead.getPaths() + "index.adoc");

        if (f.exists()) {
            readIndex();
            ListNote.add(note);
            writeIndex();
        }
    }

    /**
     * Méthode pour supprimer une note de l'index.
     * @param note la note à supprimer.
     */
    public void deleteNote(Note note) {
        File f = new File(PropertiesRead.getPaths() + "index.adoc");
        if (f.exists()) {
            for (int i = 0; i < ListNote.size(); i++) {
                if (ListNote.get(i).getTitre().equalsIgnoreCase(note.getTitre())) {
                    ListNote.remove(ListNote.get(i));
                }
            }
        }
        writeIndex();
    }

    /**
     * Méthode pour récuperer le contexte d'une note de l'index.
     * @param titre le nom de la note.
     * @return le contexte de la note.
     */
    private String findContext(String titre) {
        File f = new File(PropertiesRead.getPaths() + titre + ".adoc");
        String context = "context";
        if (f.exists()) {
            BufferedReader br;
            try {
                br = new BufferedReader(new InputStreamReader(new FileInputStream(f), StandardCharsets.UTF_8));
                String line = br.readLine();
                while (line != null) {
                    if (line.startsWith(":context:") && line.length() > 9) {
                        context = line.substring(10);
                    }
                    line = br.readLine();
                }
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return context;
    }

    /**
     * Méthode pour récuperer le projet d'une note de l'index.
     * @param titre le nom de la note.
     * @return le projet de la note.
     */
    private String findProject(String titre) {
        File f = new File(PropertiesRead.getPaths() + titre + ".adoc");
        String project = "project";
        if (f.exists()) {
            BufferedReader br;
            try {
                br = new BufferedReader(new InputStreamReader(new FileInputStream(f), StandardCharsets.UTF_8));
                String line = br.readLine();
                while (line != null) {
                    if (line.startsWith(":project:") && line.length() > 9) {
                        project = line.substring(10);
                    }
                    line = br.readLine();
                }
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return project;
    }

    /**
     * Méthode pour recupere la date de creation d'une note de l'index.
     * @param titre le nom de la note.
     * @return la date de création de la note.
     */
    private int findDate(String titre) {
        File f = new File(PropertiesRead.getPaths() + titre + ".adoc");
        int date = 1;
        if (f.exists()) {
            BufferedReader br;
            String line = null;
            String[] month;
            try {
                br = new BufferedReader(new InputStreamReader(new FileInputStream(f), StandardCharsets.UTF_8));
                for (int i = 0; i < 3; i++) {
                    if (i == 2) {
                        line = br.readLine();
                    }
                    br.readLine();
                }
                month = line.split("/");
                date = Integer.parseInt(month[1]);
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return date;
    }

    /**
     * Méthode pour mettre à jour le tri des notes de l'index.
     */
    public void updateIndex() {
        File f = new File(PropertiesRead.getPaths() + "index.adoc");
        if (f.exists()) {
            readIndex();
            writeIndex();
        }
    }

    /**
     * Méthode pour écrire les notes dans l'index de manière triée.
     */
    private void writeIndex() {
        File f = new File(PropertiesRead.getPaths() + "index.adoc");

        if (f.exists()) {
            try {
                FileWriter fw = new FileWriter(f, false);
                fw.write("= Liste des notes\n");
                fw.write("\n");
                fw.write("==== Tri des notes par ordre alphabétique :\n");
                fw.write("[square]");
                fw.write("\n");
                ListNote.sort(Note.TitreComparator);
                for (int i = 0; i < ListNote.size(); i++) {
                    fw.write("* " + ListNote.get(i).getTitre());
                    fw.write("\n");
                }
                fw.write("\n");
                fw.write("==== Tri des notes par contexte :\n");

                ListNote.sort(Note.ContextComparator);
                for (int i = 0; i < ListNote.size(); i++) {
                    if (i > 0) {
                        if (!(ListNote.get(i).getContext().equals(ListNote.get(i - 1).getContext()))) {
                            fw.write("\n");
                            fw.write("===== " + ListNote.get(i).getContext());
                            fw.write("\n");
                            fw.write("[square]");
                            fw.write("\n");
                        }
                    } else {
                        fw.write("===== " + ListNote.get(i).getContext());
                        fw.write("\n");
                        fw.write("[square]");
                        fw.write("\n");
                    }
                    fw.write("* " + ListNote.get(i).getTitre());
                    fw.write("\n");
                }
                fw.write("\n");
                fw.write("==== Tri des notes par projet :\n");

                ListNote.sort(Note.ProjectComparator);
                for (int i = 0; i < ListNote.size(); i++) {
                    if (i > 0) {
                        if (!(ListNote.get(i).getProject().equals(ListNote.get(i - 1).getProject()))){
                            fw.write("\n");
                            fw.write("===== " + ListNote.get(i).getProject());
                            fw.write("\n");
                            fw.write("[square]");
                            fw.write("\n");
                        }
                    } else {
                        fw.write("===== " + ListNote.get(i).getProject());
                        fw.write("\n");
                        fw.write("[square]");
                        fw.write("\n");
                    }
                    fw.write("* " + ListNote.get(i).getTitre());
                    fw.write("\n");
                }
                fw.write("\n");
                fw.write("==== Tri des notes par mois de création :\n");

                ListNote.sort(Note.DateComparator);
                for (int i = 0; i < ListNote.size(); i++) {
                    if (i > 0){
                        if (ListNote.get(i).getDate() != ListNote.get(i - 1).getDate()) {
                            fw.write("\n");
                            fw.write("===== " + ListNote.get(i).getDate());
                            fw.write("\n");
                            fw.write("[square]");
                            fw.write("\n");
                        }
                    } else {
                        fw.write("===== " + ListNote.get(i).getDate());
                        fw.write("\n");
                        fw.write("[square]");
                        fw.write("\n");
                    }
                    fw.write("* " + ListNote.get(i).getTitre());
                    fw.write("\n");
                }
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
