import java.util.Scanner;

import static java.lang.System.exit;

public class InterpreteurConsole implements Command{
    private String paths;
    public InterpreteurConsole(String paths) {
        this.paths = paths;
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
        System.out.println("3) Supprimer une note (saisir Delete ou d)");
        System.out.println("4) Voir la note (saisir view ou v)");
        System.out.println("5) Rechercher une note (saisir search ou s)");
    }

    @Override
    public void command(String str) {
        Scanner sc = new Scanner(System.in);
        String st = sc.nextLine();
        while (true) {
            if (st.length() >= 3 && st.substring(0, 4).equals("exit")) {
                exit(0);
            } else if (st.length() >= 4 && st.substring(0, 4).equals("edit")) {
                if (st.length() == 4 || st.length() == 5) {
                    new Edition(paths).command("");
                } else {
                    new Edition(paths).command(st.substring(5));
                }
            } else if (st.length() >= 1 && st.substring(0, 1).equals("e")) {
                if (st.length() == 1 || st.length() == 2) {
                    new Edition(paths).command("");
                } else {
                    new Edition(paths).command(st.substring(2));
                }
            } else if (st.length() >= 2 && st.substring(0, 2).equals("ls")) {
                if (st.length() == 2 || st.length() == 3) {
                    new Listing(paths).command("");
                } else {
                    new Listing(paths).command(st.substring(3));
                }
            } else if (st.length() >= 4 && st.substring(0, 4).equals("list")) {
                if (st.length() == 4 || st.length() == 5) {
                    new Listing(paths).command("");
                } else {
                    new Listing(paths).command(st.substring(5));
                }
            } else if (st.length() >= 6 && st.substring(0, 6).equals("Delete")) {
                if (st.length() >= 7) {
                    new Delete(paths).command(st.substring(7));
                }
            } else if (st.length() >= 1 && st.substring(0, 1).equals("d")) {
                if (st.length() >= 2) {
                    new Delete(paths).command(st.substring(2));
                }
            }
            st = sc.nextLine();

        }
    }

    @Override
    public boolean isEqual(String str) {
        if(str.equals("c") || str.equals("console"))
            return true;
        return false;
    }
}
