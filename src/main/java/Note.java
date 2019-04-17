import java.time.LocalDate;
import java.util.Comparator;

public class Note {
    private String titre;
    private String context;
    private String project;
    private int date;

    public static class NoteBuilder {
        private String titre;
        private String context = "context";
        private String project = "project";
        private int date = LocalDate.now().getMonthValue();

        public NoteBuilder(String titre) {
            this.titre = titre;
        }

        public NoteBuilder setContext(String context) {
            this.context = context;
            return this;
        }

        public NoteBuilder setProject(String project) {
            this.project = project;
            return this;
        }

        public NoteBuilder setDate(int date) {
            this.date = date;
            return this;
        }

        public Note build() {
            return new Note(this);
        }
    }

    private Note(NoteBuilder builder) {
        this.titre = builder.titre;
        this.context = builder.context;
        this.project = builder.project;
        this.date = builder.date;
    }

    public String getTitre() {
        return this.titre;
    }

    public String getContext() {
        return this.context;
    }

    public String getProject() {
        return this.project;
    }

    public int getDate() {
        return this.date;
    }

    public static Comparator<Note> TitreComparator = new Comparator<Note>() {

        @Override
        public int compare(Note o1, Note o2) {
            return o1.getTitre().toUpperCase().compareTo(o2.getTitre().toUpperCase());
        }
    };

    public static Comparator<Note> ContextComparator = new Comparator<Note>() {
        @Override
        public int compare(Note o1, Note o2) {
            return o1.getContext().toUpperCase().compareTo(o2.getContext().toUpperCase());
        }
    };

    public static Comparator<Note> ProjectComparator = new Comparator<Note>() {
        @Override
        public int compare(Note o1, Note o2) {
            return o1.getProject().toUpperCase().compareTo(o2.getProject().toUpperCase());
        }
    };

    public static Comparator<Note> DateComparator = new Comparator<Note>() {
        @Override
        public int compare(Note o1, Note o2) {
            return o1.getDate() - o2.getDate();
        }
    };
}
