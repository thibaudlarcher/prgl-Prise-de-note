import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class IndexCreator {
    private ArrayList<Note> ListNote;

    public IndexCreator() {
        ListNote = new ArrayList<>();
    }

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

    public void readIndex() {
        this.ListNote = new ArrayList<>();
        File f = new File(PropertiesRead.getPaths() + "index.adoc");
        if (f.exists()) {
            BufferedReader br;
            try {
                br = new BufferedReader(new InputStreamReader(new FileInputStream(PropertiesRead.getPaths() + "index.adoc"),"UTF-8"));
                String line = br.readLine();
                while (line != null) {
                    boolean exist = false;
                    if (line.startsWith("*")) {
                        String titre = line.substring(2);
                        if (ListNote.isEmpty()) {
                            ListNote.add(new Note.NoteBuilder(titre).setContext(findContext(titre)).setProject(findProject(titre)).setDate(findDate(titre)).build());
                        } else {
                            for (int i = 0; i < ListNote.size(); i++) {
                                if (ListNote.get(i).getTitre().equalsIgnoreCase(titre)) {
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

    public void addNote(Note note) {
        File f = new File(PropertiesRead.getPaths() + "index.adoc");

        if (f.exists()) {
            readIndex();
            ListNote.add(note);
            writeIndex();
        }
    }

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

    public String findContext(String titre) {
        File f = new File(PropertiesRead.getPaths() + titre + ".adoc");
        String context = "context";
        if (f.exists()) {
            BufferedReader br;
            try {
                br = new BufferedReader(new InputStreamReader(new FileInputStream(f),"UTF-8"));
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

    public String findProject(String titre) {
        File f = new File(PropertiesRead.getPaths() + titre + ".adoc");
        String project = "project";
        if (f.exists()) {
            BufferedReader br;
            try {
                br = new BufferedReader(new InputStreamReader(new FileInputStream(f),"UTF-8"));
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

    public int findDate(String titre) {
        File f = new File(PropertiesRead.getPaths() + titre + ".adoc");
        int date = 1;
        if (f.exists()) {
            BufferedReader br;
            String line = null;
            String[] month;
            try {
                br = new BufferedReader(new InputStreamReader(new FileInputStream(f),"UTF-8"));
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

    public void updateIndex() {
        File f = new File(PropertiesRead.getPaths() + "index.adoc");
        if (f.exists()) {
            readIndex();
            writeIndex();
        }
    }

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
                Collections.sort(ListNote, Note.TitreComparator);
                for (Note note : ListNote) {
                    fw.write("* " + note.getTitre());
                    fw.write("\n");
                }
                fw.write("\n");
                fw.write("==== Tri des notes par contexte :\n");
                fw.write("[square]");
                fw.write("\n");
                Collections.sort(ListNote, Note.ContextComparator);
                for (Note note : ListNote) {
                    fw.write("* " + note.getTitre());
                    fw.write("\n");
                }
                fw.write("\n");
                fw.write("==== Tri des notes par projet :\n");
                fw.write("[square]");
                fw.write("\n");
                Collections.sort(ListNote, Note.ProjectComparator);
                for (Note note : ListNote) {
                    fw.write("* " + note.getTitre());
                    fw.write("\n");
                }
                fw.write("\n");
                fw.write("==== Tri des notes par mois de création :\n");
                fw.write("[square]");
                fw.write("\n");
                Collections.sort(ListNote, Note.DateComparator);
                for (Note note : ListNote) {
                    fw.write("* " + note.getTitre());
                    fw.write("\n");
                }
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
