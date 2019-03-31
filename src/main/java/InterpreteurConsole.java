import java.util.Scanner;

public class InterpreteurConsole {
    public InterpreteurConsole() {
        System.out.println("                    _                _                    _");
        System.out.println("         _ __  _ __(_)___  ___    __| | ___   _ __   ___ | |_ ___");
        System.out.println("        | '_ \\| '__| / __|/ _ \\  / _` |/ _ \\ | '_ \\ / _ \\| __/ _ \\");
        System.out.println("        | |_) | |  | \\__ \\  __/ | (_| |  __/ | | | | (_) | ||  __/");
        System.out.println("        | .__/|_|  |_|___/\\___|  \\__,_|\\___| |_| |_|\\___/ \\__\\___|");
        System.out.println("        |_|");
        System.out.println("\033[1;31m" + "Bienvenue sur l'application de prise de note !");
        System.out.println("\033[0;32m" + "Vous avez plusieurs possibilité de choix :");
        System.out.println("1) Créer ou modifier une note (saisir edit ou e)");
        System.out.println("2) Lister les notes existantes (saisire list ou ls)");
        System.out.println("3) Supprimer une note (saisir delet ou d)");
        System.out.println("4) Voir la note (saisir view ou v)");
        System.out.println("5) Rechercher une note (saisir search ou s)");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        while(str != "exit"){
            TakeAction("str");
            str = sc.nextLine();
        }
    }

    private void TakeAction(String commande){
        System.out.println("TakeAction");
        if(commande.length() >= 3 && commande.substring(0,4).equals("edit")){
            System.out.println("EDIT");
            if(commande.length() == 4 || commande.length() == 5)
            {
                new Edition().ProcessEdit("");
            }else{
                new Edition().ProcessEdit(commande.substring(5));
            }
        }else if(commande.length() >= 1 && commande.substring(0,1).equals("e")){
            if(commande.length() == 1 || commande.length() == 2)
            {
                new Edition().ProcessEdit("");
            }else{
                new Edition().ProcessEdit(commande.substring(2));
            }
        }
    }
}
