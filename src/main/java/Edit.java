import java.awt.*;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.exit;

public class Edit {

    public static void main(String[] args){

        if(args.length == 0){
//            InterpreteurFenetre inter = new InterpreteurFenetre();
//            inter.Afficher();
            new InterpreteurConsole();
        }else{
            if(args[0].equals("e") || args[0].equals("edit")) {
                new Edition().ProcessEdit(args[1]);
            }else if(args[0].equals("f") || args[0].equals("Fenetre")) {
                InterpreteurFenetre inter = new InterpreteurFenetre();
                inter.Afficher();
            }else if(args[0].equals("f") || args[0].equals("fenestre")) {
                new InterpreteurConsole();
            }
        }
    }
}