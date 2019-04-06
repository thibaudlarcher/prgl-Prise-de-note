import static java.lang.System.exit;

public class InterpreteurGlobal {
    private InterpreteurGlobal() { }

    public static void execute(String[] args){
        Command C = null;
        String command = "";
        if(args.length != 1){
            command = args[1];
        }
        for(int i = 2;i < args.length;i++) {
            command = command +" "+ args[i];
        }
        if(args[0].equals("exit")){
            exit(0);
        }else if(args[0].equals("e") || args[0].equals("edit")){
            C = new Edition();
        }else if(args[0].equals("ls") || args[0].equals("list")){
            C = new Listing();
        }else if(args[0].equals("d") || args[0].equals("delete")){
            C = new Delete();
        }else if(args[0].equals("f") || args[0].equals("fenetre")){
            C = new InterpreteurFenetre();
        }else if(args[0].equals("c") || args[0].equals("console")){
            C = new InterpreteurConsole();
        }else{
            C = new NonCommand();
        }
        C.command(command);
    }
}
