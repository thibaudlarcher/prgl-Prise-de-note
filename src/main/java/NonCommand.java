public class NonCommand implements Command {


    public NonCommand() {
    }

    @Override
    public void command(String str) {
        System.out.println("Commande " + str +  " incorrecte.");
    }
}
