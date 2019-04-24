
public class Edit {
    /**
     * Fonction main qui permet d'interpréter les commandes des utilisateurs.
     * Si on passe en arg les commandes ou on passe sous forme graphique.
     * @param args Commande passé en argument en ligne de code.
     */
    public static void main(String[] args){
        PropertiesCreator.createPropertiesFile();
        PropertiesRead.readPropertiesFile();
        IndexCreator.createIndexFile();
        if(args.length == 0){
//            InterpreteurFenetre.getInstance().command("");
            InterpreteurConsole.getInstance().command("");
        }else{
            InterpreteurGlobal.execute(args);
        }
    }
}