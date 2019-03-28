import java.awt.*;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.exit;

public class Edit {

    public Edit(){}

    public static void main(String[] args){
        System.out.println("                    _                _                    _");
        System.out.println("         _ __  _ __(_)___  ___    __| | ___   _ __   ___ | |_ ___");
        System.out.println("        | '_ \\| '__| / __|/ _ \\  / _` |/ _ \\ | '_ \\ / _ \\| __/ _ \\");
        System.out.println("        | |_) | |  | \\__ \\  __/ | (_| |  __/ | | | | (_) | ||  __/");
        System.out.println("        | .__/|_|  |_|___/\\___|  \\__,_|\\___| |_| |_|\\___/ \\__\\___|");
        System.out.println("        |_|");
        Scanner sc = new Scanner(System.in);
        System.out.println("\033[1;31m" + "Bienvenue sur l'application de prise de note !");
        System.out.println("\033[0;32m"+"Vous avez plusieurs possibilité de choix :");
        System.out.println("1) Créer ou modifier une note (saisir edit ou e)");
        System.out.println("2) Lister les notes existantes (saisire list ou ls)");
        System.out.println("3) Supprimer une note (saisir delet ou d)");
        System.out.println("4) Voir la note (saisir view ou v)");
        System.out.println("5) Rechercher une note (saisir search ou s)");
        System.out.println("\033[4;30m"+"Action :");
        String str = sc.nextLine();
        str = str.replaceAll("\\s+","");
        System.out.println("\033[0m"+"Vous avez saisi  : " + str);

        Edition edit = new Edition();
        edit.ProcessEdit(str);
    }
}