import java.time.LocalDate;
import java.util.Comparator;

/**
 * Classe de la création des notes.
 */
public class Note {
    private String titre;
    private String context;
    private String project;
    private int date;

    /**
     * Pattern Builder de la noteBuilder.
     */
    public static class NoteBuilder {
        private String titre;
        private String context = "context";
        private String project = "project";
        private int date = LocalDate.now().getMonthValue();

        /**
         * Constructeur du NoteBuilder.
         * @param titre la titre de la note.
         */
        public NoteBuilder(String titre) {
            this.titre = titre;
        }

        /**
         * Permet de définir le contexte de la Note.
         * @param context le contexte
         * @return le Builder
         */
        public NoteBuilder setContext(String context) {
            this.context = context;
            return this;
        }

        /**
         * Permet de définir le projet de la note.
         * @param project le projet.
         * @return le builder.
         */
        public NoteBuilder setProject(String project) {
            this.project = project;
            return this;
        }

        /**
         * Permet de définir la date de création de la note.
         * @param date la date de création.
         * @return le builder.
         */
        public NoteBuilder setDate(int date) {
            this.date = date;
            return this;
        }

        /**
         * Méthode pour créer une nouvelle note.
         * @return la nouvelle note.
         */
        public Note build() {
            return new Note(this);
        }
    }

    /**
     * Constructeur de la classe Note.
     * @param builder le noteBuilder
     */
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

    private int getDate() {
        return this.date;
    }

    /**
     * Méthode pour comparer deux notes selon leur titre.
     */
    public static Comparator<Note> TitreComparator = new Comparator<Note>() {

        @Override
        public int compare(Note o1, Note o2) {
            return o1.getTitre().toUpperCase().compareTo(o2.getTitre().toUpperCase());
        }
    };

    /**
     * Méthode pour comparer deux notes selon leur contexte.
     */
    public static Comparator<Note> ContextComparator = new Comparator<Note>() {
        @Override
        public int compare(Note o1, Note o2) {
            return o1.getContext().toUpperCase().compareTo(o2.getContext().toUpperCase());
        }
    };

    /**
     * Méthode pour comparer deux notes selon leur projet.
     */
    public static Comparator<Note> ProjectComparator = new Comparator<Note>() {
        @Override
        public int compare(Note o1, Note o2) {
            return o1.getProject().toUpperCase().compareTo(o2.getProject().toUpperCase());
        }
    };

    /**
     * Méthode pour comparer deux notes selon leur date de création.
     */
    public static Comparator<Note> DateComparator = new Comparator<Note>() {
        @Override
        public int compare(Note o1, Note o2) {
            return o1.getDate() - o2.getDate();
        }
    };
}
