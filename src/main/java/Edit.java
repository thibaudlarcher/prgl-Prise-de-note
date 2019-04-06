public class Edit {

    public static void main(String[] args){
        PropertiesCreator.createPropertiesFile();
        PropertiesRead.readPropertiesFile();
        if(args.length == 0){
//            InterpreteurFenetre.getInstance().command("");
            InterpreteurConsole.getInstance().command("");
        }else{
            InterpreteurGlobal.execute(args);
        }
    }
}