import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class Search implements Command {

    private static String paths;

    /**
     * builder de la classe
     */
    public Search(){
        if(paths == null){
            paths =  PropertiesRead.getPaths();
        }
    }

    /**
     * Permet de récupérer le chemin physique du dossier note
     * @return le chemin du dossier note
     */
    public static String getPaths() {
        return paths;
    }

    /**
     * Methode de recherche dans toutes la notes
     * @param str mots a chercher.
     */
    private void rechercheGlobal(String str){
        String[] regexs = str.split(" ");
        StringBuilder output = new StringBuilder();

        System.out.println("\033[0;34m");
        output.append("Résultat Recherche mot clef : ");
        output.append(str);
        output.append(" :\n");
        File f = new File(paths);
        for(File f2 : Objects.requireNonNull(f.listFiles())){
            BufferedReader br;
            try{
                boolean boolcontient = true;
                for(String regex : regexs) {
                    br = new BufferedReader(new InputStreamReader(new FileInputStream(f2), StandardCharsets.UTF_8));
                    String line = br.readLine();
                    boolean boolcontientregex = false;
                    while(!boolcontientregex && (line != null)){
                        boolcontientregex = line.matches(".*" + regex + "+.*");
                        line = br.readLine() ;
                    }
                    boolcontient = boolcontientregex;
                    if(!boolcontient) {
                        break;
                    }
                    br.close();
                }
                if(boolcontient){
                    output.append("|");
                    output.append(f2.getName(), 0, f2.getName().length()-5);
                    output.append("\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(output);
        System.out.println("\033[0m");
    }

    /**
     * Methode de recherche dans le titre
     * @param str mots a chercher.
     */
    private void rechercheTitre(String str){
        String[] regexs = str.split(" ");
        StringBuilder output = new StringBuilder();

        System.out.println("\033[0;34m");
        output.append("Résultat Recherche Titre : ");
        output.append(str);
        output.append(" :\n");
        File f = new File(paths);
        for(File f2 : Objects.requireNonNull(f.listFiles())){
            BufferedReader br;
            try{
                br = new BufferedReader(new InputStreamReader(new FileInputStream(f2), StandardCharsets.UTF_8));
                String line = br.readLine();
                boolean boolcontient = false;
                for(String regex : regexs) {
                    boolcontient =  boolcontient | line.matches(".*" + regex + "+.*");
                }
                if(boolcontient){
                    output.append("|");
                    output.append(f2.getName(), 0, f2.getName().length()-5);
                    output.append("\n");
                }
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(output);
        System.out.println("\033[0m");
    }

    /**
     * Methode de recherche dans le contexte
     * @param str mots a chercher.
     */
    private void rechercheContext(String str){
        String[] regexs = str.split(" ");
        StringBuilder output = new StringBuilder();

        System.out.println("\033[0;34m");
        output.append("Résultat Recherche Context : ");
        output.append(str);
        output.append(" :\n");
        File f = new File(paths);
        for(File f2 : Objects.requireNonNull(f.listFiles())){
            BufferedReader br;
            try{
                br = new BufferedReader(new InputStreamReader(new FileInputStream(f2), StandardCharsets.UTF_8));
                br.readLine();
                br.readLine();
                br.readLine();
                String line = br.readLine();
                boolean boolcontient = false;
                for(String regex : regexs) {
                    boolcontient =  boolcontient | line.matches(".*" + regex + "+.*");
                }
                if(boolcontient){
                    output.append("|");
                    output.append(f2.getName(), 0, f2.getName().length()-5);
                    output.append("\n");
                }
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(output);
        System.out.println("\033[0m");
    }

    /**
     * Methode de recherche dans le projet
     * @param str mots a chercher.
     */
    private void rechercheProjet(String str){
        String[] regexs = str.split(" ");
        StringBuilder output = new StringBuilder();

        System.out.println("\033[0;34m");
        output.append("Résultat Recherche Projet : ");
        output.append(str);
        output.append(" :\n");
        File f = new File(paths);
        for(File f2 : Objects.requireNonNull(f.listFiles())){
            BufferedReader br;
            try{
                br = new BufferedReader(new InputStreamReader(new FileInputStream(f2), StandardCharsets.UTF_8));
                br.readLine();
                br.readLine();
                br.readLine();
                br.readLine();
                String line = br.readLine();
                boolean boolcontient = false;
                for(String regex : regexs) {
                    boolcontient =  boolcontient | line.matches(".*" + regex + "+.*");
                }
                if(boolcontient){
                    output.append("|");
                    output.append(f2.getName(), 0, f2.getName().length()-5);
                    output.append("\n");
                }
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(output);
        System.out.println("\033[0m");
    }

    /**
     * permet le recherche dans les fichier
     * @param str contient les mots a chercher et peut contenir le type de recherche a faire.
     */
    @Override
    public void command(String str) {
        String[] separation = str.split(" ");
        StringBuilder sb = new StringBuilder();
        if(separation.length != 1){
            sb.append(separation[1]);
        }
        for(int i = 2;i < separation.length;i++) {
            sb.append(" ");
            sb.append(separation[i]);
        }
        String regex = sb.toString();

        switch (separation[0]) {
            case "c":
            case "context":
            case "Context":
                rechercheContext(regex);
                break;
            case "t":
            case "titre":
            case "Titre":
                rechercheTitre(regex);
                break;
            case "p":
            case "projet":
            case "Projet":
                rechercheProjet(regex);
                break;
            default:
                rechercheGlobal(str);
                break;
        }
    }
}
