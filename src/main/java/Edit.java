import static java.lang.System.exit;

public class Edit {

    public static void main(String[] args){
        PropertiesCreator.createPropertiesFile();
        PropertiesRead.readPropertiesFile();
        IndexCreator.createIndexFile();
        if(args.length == 0){
//            new InterpreteurFenetre().command("");
            new InterpreteurConsole().command("");

        }else{
            InterpreteurGlobal.execute(args);
        }
    }
}