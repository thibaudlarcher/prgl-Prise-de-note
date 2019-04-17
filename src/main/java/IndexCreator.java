import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class IndexCreator {
    private ArrayList<Note> ListNote;

    public IndexCreator() {
        ListNote = new ArrayList<>();
    }

    public static void createIndexFile() {
        File f = new File("index.adoc");

        if (!(f.exists())) {
            try {
                FileWriter fw = new FileWriter(f, true);
                fw.write("= Liste des notes\n");
                fw.write("\n");
                fw.write("Tri des notes par ordre alphabétique :\n");
                fw.write("[square]");
                fw.write("\n");
                fw.write("Tri des notes par contexte :\n");
                fw.write("[square]");
                fw.write("\n");
                fw.write("Tri des notes par projet :\n");
                fw.write("[square]");
                fw.write("\n");
                fw.write("Tri des notes par date de création :\n");
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
        File f = new File("index.adoc");

        if (f.exists()) {
            BufferedReader br;
            try {
                br = new BufferedReader(new InputStreamReader(new FileInputStream("index.adoc"),"UTF-8"));
                String line = br.readLine();
                while (line != null) {
                    if (line.startsWith("*")) {
                        String titre = line.substring(2);
                        if (ListNote.isEmpty()) {
                            ListNote.add(new Note.NoteBuilder(titre).build());
                        } else {
                            for (int i = 0; i < ListNote.size(); i++) {
                                if (ListNote.get(i).getTitre().equalsIgnoreCase(titre)) {
                                    ListNote.add(new Note.NoteBuilder(titre).build());
                                }
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
        File f = new File("index.adoc");

        if (f.exists()) {
            readIndex();
            ListNote.add(note);
            writeIndex();
        }
    }

    public void deleteNote(Note note) {
        File f = new File("index.adoc");
        if (f.exists()) {
            for (int i = 0; i < ListNote.size(); i++) {
                if (ListNote.get(i).getTitre().equalsIgnoreCase(note.getTitre())) {
                    ListNote.remove(ListNote.get(i));
                }
            }
        }
        writeIndex();
    }

    private void writeIndex() {
        File f = new File("index.adoc");

        if (f.exists()) {
            try {
                FileWriter fw = new FileWriter(f, false);
                fw.write("= Liste des notes\n");
                fw.write("\n");
                fw.write("Tri des notes par ordre alphabétique :\n");
                fw.write("[square]");
                fw.write("\n");
                Collections.sort(ListNote, Note.TitreComparator);
                for (Note note : ListNote) {
                    fw.write("* " + note.getTitre());
                    fw.write("\n");
                }
//                fw.write("\n");
//                fw.write("Tri des notes par contexte :\n");
//                fw.write("[square]");
//                fw.write("\n");
//                Collections.sort(ListNote, Note.ContextComparator);
//                for (Note note : ListNote) {
//                    fw.write("* " + note.getTitre());
//                    fw.write("\n");
//                }
//                fw.write("\n");
//                fw.write("Tri des notes par projet :\n");
//                fw.write("[square]");
//                fw.write("\n");
//                Collections.sort(ListNote, Note.ProjectComparator);
//                for (Note note : ListNote) {
//                    fw.write("* " + note.getTitre());
//                    fw.write("\n");
//                }
//                fw.write("\n");
//                fw.write("Tri des notes par date de création :\n");
//                fw.write("[square]");
//                fw.write("\n");
//                Collections.sort(ListNote, Note.DateComparator);
//                for (Note note : ListNote) {
//                    fw.write("* " + note.getTitre());
//                    fw.write("\n");
//                }
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
