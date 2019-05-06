import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.File;

public class TestNote {

    @BeforeClass
    public static void TestNoteBefore(){
        PropertiesCreator.createPropertiesFile();
        PropertiesRead.readPropertiesFile();
        IndexCreator.createIndexFile();
    }

    @Test
    public void testNote(){
        Note note = new Note.NoteBuilder("test").setContext("coucou").setProject("toto").build();
        assertEquals(note.getTitre(), "test");
        assertEquals(note.getContext(), "coucou");
        assertEquals(note.getProject(), "toto");
    }
}
