public class Edit {

    public static void main(String[] args){


        new PropertiesCreator().createPropertiesFile();
        PropertiesRead properties = new PropertiesRead();
        if(args.length == 0){
            new InterpreteurConsole(properties.getPaths()).command("");

        }else{
            Command C ;
            C = new Edition(properties.getPaths());
            if(C.isEqual(args[0])) {
                if (args.length == 1) {
                    C.command("");
                } else {
                    C.command(args[1]);
                }

            }else{ C = new Listing(properties.getPaths());
                if (C.isEqual(args[0])){
                    if(args.length == 1) {
                     C.command("");
                    } else {
                        C.command(args[1]);
                    }

            }else{ C = new InterpreteurFenetre(properties.getPaths());
                if(C.isEqual(args[0])) {
                    ((InterpreteurFenetre) C).Afficher();
                }else { C = new InterpreteurConsole(properties.getPaths());
                    if (C.isEqual(args[0])) {
                            C.command(args[0]);
                        }
                    }
                }
            }
        }
    }
}