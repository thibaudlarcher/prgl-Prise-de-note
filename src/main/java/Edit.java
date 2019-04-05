public class Edit {

    public static void main(String[] args){
        new PropertiesCreator().createPropertiesFile();
        if(args.length == 0){
//            InterpreteurFenetre inter = new InterpreteurFenetre();
//            inter.Afficher();
            new InterpreteurConsole("/target").command("");

        }else{
            Command C ;
            C = new Edition("/target");
            if(C.isEqual(args[0])) {
                if (args.length == 1) {
                    C.command("");
                } else {
                    C.command(args[1]);
                }

            }else{ C = new Listing("/target");
                if (C.isEqual(args[0])){
                    if(args.length == 1) {
                     C.command("");
                    } else {
                        C.command(args[1]);
                    }

            }else{ C = new InterpreteurFenetre("/target");
                if(C.isEqual(args[0])) {
                    ((InterpreteurFenetre) C).Afficher();
                }else { C = new InterpreteurConsole("/target");
                    if (C.isEqual(args[0])) {
                            C.command(args[0]);
                        }
                    }
                }
            }
        }
    }
}