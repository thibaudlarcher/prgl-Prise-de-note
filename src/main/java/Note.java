import java.time.LocalDate;
import java.util.Comparator;

/**
 * Classe de la création des notes.
 */
public class Note {
    private String titre;
    private String context;
    private String project;
    private int dateMonth;
    private int dateYear;

    /**
     * Pattern Builder de la noteBuilder.
     */
    public static class NoteBuilder {
        private String titre;
        private String context = "none";
        private String project = "none";
        private int dateMonth = LocalDate.now().getMonthValue();
        private int dateYear = LocalDate.now().getYear();

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
         * Permet de définir la dateMonth de création de la note.
         * @param dateMonth la dateMonth de création.
         * @return le builder.
         */
        public NoteBuilder setDateMonth(int dateMonth) {
            this.dateMonth = dateMonth;
            return this;
        }

        /**
         * Permet de définir la dateMonth de création de la note.
         * @param dateYear la dateMonth de création.
         * @return le builder.
         */
        public NoteBuilder setDateYear(int dateYear) {
            this.dateYear = dateYear;
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
        this.dateMonth = builder.dateMonth;
        this.dateYear = builder.dateYear;
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

    public int getDateMonth() {
        return this.dateMonth;
    }

    public int getDateYear() {
        return this.dateYear;
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
     * Méthode pour comparer deux notes selon leur dateMonth de création.
     */
    public static Comparator<Note> DateComparator = new Comparator<Note>() {
        @Override
        public int compare(Note o1, Note o2) {
            if (o1.getDateYear() == o2.getDateYear()){
                return o1.getDateMonth() - o2.getDateMonth();
            } else {
                return o1.getDateYear() - o2.getDateYear();
            }
        }
    };
}
