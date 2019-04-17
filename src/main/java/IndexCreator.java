import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

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
                fw.write("[square]");
                fw.write("\n");
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void addNote(Note note) {
        File f = new File(PropertiesRead.getPaths() + "index.adoc");

        if (f.exists()) {
            try {
                FileWriter fw = new FileWriter(f, true);
                fw.write("* " + note.getTitre());
                fw.write("\n");
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteNote(Note note) {
        File f = new File(PropertiesRead.getPaths() + "index.adoc");

        if (f.exists()) {
            BufferedReader br;
            try {
                br = new BufferedReader(new InputStreamReader(new FileInputStream(PropertiesRead.getPaths() + "index.adoc"),"UTF-8"));

                for (int i = 0; i < 3; i++) {
                    br.readLine();
                }
                String line = br.readLine();
                while (line != null) {
                    String titre = line.substring(2);
                    if (!(titre.equals(note.getTitre()))) {
                        ListNote.add(new Note.NoteBuilder(titre).build());
                    }
                    line = br.readLine();
                }
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        writeIndex();
    }

    private void writeIndex() {
        File f = new File(PropertiesRead.getPaths() + "index.adoc");

        if (f.exists()) {
            try {
                FileWriter fw = new FileWriter(f, false);
                fw.write("= Liste des notes\n");
                fw.write("\n");
                fw.write("[square]");
                fw.write("\n");
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
