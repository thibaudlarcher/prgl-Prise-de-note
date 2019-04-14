import static java.lang.System.exit;

/**
 * Permet d'interpréter les lignes de commandes
 */
public class InterpreteurGlobal {
    public static Command C;
    protected InterpreteurGlobal() { }

    /**
     * Permet d'éxécuter les fonctions suivant la ligne de commande solicité
     * @param args ligne de commande
     */
    public static void execute(String[] args){
        //Command C;
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
            case "pr":
            case "property":
            case "properties":
                C = new PropertiesOpener();
                break;
            case "p":
            case "path":
                C = new pathsChooser();
                break;
            case "v":
            case "view":
                C = new View();
                break;
            default:
                C = new NonCommand();
                command = args[0] + " " + command;
                break;
        }
        C.command(command);
    }

    public Command getCommand(){
        return C;
    }
}
