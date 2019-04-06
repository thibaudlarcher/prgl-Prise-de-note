import java.io.File;
import java.util.Objects;

public class Listing implements Command {
    private static String paths;

    public Listing(){
        if(paths == null){
            paths =  PropertiesRead.getPaths();
        }
    }

    @Override
    public void command(String str) {
        StringBuilder output = new StringBuilder();

        System.out.println("\033[0;34m");
        output.append(paths);
        output.append(" :\n");
        File f = new File(paths);
        for(File f2 : Objects.requireNonNull(f.listFiles())){
            output.append("|    ");
            output.append(f2.getName(), 0, f2.getName().length()-5);
            output.append("\n");
        }
        System.out.println(output);
        System.out.println("\033[0m");
    }
}

