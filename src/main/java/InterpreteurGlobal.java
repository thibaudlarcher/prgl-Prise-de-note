import static java.lang.System.exit;

public class InterpreteurGlobal {
    private InterpreteurGlobal() { }

    public static void execute(String[] args){
        Command C;
        StringBuilder sb = new StringBuilder();
        if(args.length != 1){
            sb.append(args[1]);
        }
        for(int i = 2;i < args.length;i++) {
            sb.append(" ");
            sb.append(args[i]);
        }
        String command = sb.toString();

        switch (args[0]) {
            case "exit":
                exit(0);
            case "e":
            case "edit":
                C = new Edition();
                break;
            case "ls":
            case "list":
                C = new Listing();
                break;
            case "d":
            case "delete":
                C = new Delete();
                break;
            case "f":
            case "fenetre":
                C = new InterpreteurFenetre();
                break;
            case "c":
            case "console":
                C = new InterpreteurConsole();
                break;
            default:
                C = new NonCommand();
                break;
        }
        C.command(command);
    }
}
