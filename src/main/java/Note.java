import java.time.LocalDate;

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
}
