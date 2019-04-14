public class NonCommand implements Command {

    /**
     * Builder de l'erreur de la mauvaise commande
     */
    public NonCommand() {
    }

    /**
     * Permet de renvoyer l'erreur
     * @param str la commande
     */
    @Override
    public void command(String str) {
        System.out.println("Commande " + str +  " incorrecte.");
    }
}
