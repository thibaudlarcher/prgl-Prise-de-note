import java.util.Scanner;

/**
 * Permet de faire un affichage lors de l'ouverture de l'application sans ligne de commande
 */
public class InterpreteurConsole implements Command{

    private static InterpreteurConsole ourInstance = new InterpreteurConsole();

    public static InterpreteurConsole getInstance() {
        return ourInstance;
    }

    private InterpreteurConsole() {
        System.out.println("                    _                _                    _");
        System.out.println("         _ __  _ __(_)___  ___    __| | ___   _ __   ___ | |_ ___");
        System.out.println("        | '_ \\| '__| / __|/ _ \\  / _` |/ _ \\ | '_ \\ / _ \\| __/ _ \\");
        System.out.println("        | |_) | |  | \\__ \\  __/ | (_| |  __/ | | | | (_) | ||  __/");
        System.out.println("        | .__/|_|  |_|___/\\___|  \\__,_|\\___| |_| |_|\\___/ \\__\\___|");
        System.out.println("        |_|");
        if(OSRecognizer.isWindows()){
            System.out.println("Bienvenue sur l'application de prise de note !");
            System.out.println("Vous avez plusieurs possibilité de choix :");
        } else {
            System.out.println("\033[1;31m" + "Bienvenue sur l'application de prise de note !");
            System.out.println("\033[0;32m" + "Vous avez plusieurs possibilité de choix :");
        }
        System.out.println("0) Quiter (saisir exit ou ex)");
        System.out.println("1) Créer ou modifier une note (saisir edit ou e)");
        System.out.println("2) Lister les notes existantes (saisir list ou ls)");
        System.out.println("3) Supprimer une note (saisir delete ou d)");
        System.out.println("4) Voir la note (saisir view ou v)");
        System.out.println("5) Rechercher une note (saisir search ou s)");
        System.out.println("6) Changer dossier de sauvegarde (saisir path ou p)");
        System.out.println("7) Ouvrir le fichier de propriété (saisir properties ou pr)");
    }

    /**
     * Permet de récupérer la ligne de commande
     * @param str La ligne de commande
     */
    @SuppressWarnings("InfiniteLoopStatement")
    @Override
    public void command(String str) {
        Scanner sc = new Scanner(System.in);
        String st = sc.nextLine();
        while (true) {
            InterpreteurGlobal.execute(st.split(" "));
            st = sc.nextLine();
        }
    }
}
