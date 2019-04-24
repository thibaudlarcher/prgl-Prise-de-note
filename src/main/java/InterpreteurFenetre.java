import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.lang.System.exit;

/**
 * Class permettant d'ouvrire l'application dans une autre fenêtre
 */
public class InterpreteurFenetre implements Command{

    private JFrame interpreteur;

    /**
     * Constructeur de la Fenêtre
     */
    public InterpreteurFenetre() {
        this.interpreteur = new JFrame("Interpréteur Notes");
        this.interpreteur.setSize(700,400);
        this.interpreteur.setLayout(null);
        this.interpreteur.setResizable(false);
        this.interpreteur.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.interpreteur.setLocationRelativeTo(null);
        this.interpreteur.setBackground(Color.black);
    }

    /**
     * Pour écrire une ligne dans la nouvelle fenêtre
     * @param s Les caractères
     * @param C La couleur
     * @param x La position en x
     * @param y La position en y
     * @return le type Jtextpane
     */
    private JTextPane jtxtpane(String s,Color C,int x,int y){
        JTextPane textPane = new JTextPane();
        textPane.setEditable(false);
        textPane.setBounds(x,y,700,22);
        textPane.setBackground(Color.black);
        Font f = new Font("Consolas",Font.BOLD,16);
        textPane.setForeground(C);
        textPane.setFont(f);
        textPane.setText(s);
        return textPane;
    }

    /**
     * Permet de former tout la nouvelle fenêtre
     * @return Un Jpanel
     */
    private JPanel setHelpText(){
        JPanel helpTxtPanel = new JPanel();
        helpTxtPanel.setLocation(0,0);
//        helpTxtPanel.setBorder(BorderFactory.createLineBorder(Color.white,2));
        helpTxtPanel.setBounds(0,0,700,400);
        helpTxtPanel.setBackground(Color.black);
        helpTxtPanel.setLayout(null);
        helpTxtPanel.add(jtxtpane("                    _                _                    _",Color.white,0,0));
        helpTxtPanel.add(jtxtpane("         _ __  _ __(_)___  ___    __| | ___   _ __   ___ | |_ ___",Color.white,0,22));
        helpTxtPanel.add(jtxtpane("        | '_ \\| '__| / __|/ _ \\  / _` |/ _ \\ | '_ \\ / _ \\| __/ _ \\",Color.white,0,44));
        helpTxtPanel.add(jtxtpane("        | |_) | |  | \\__ \\  __/ | (_| |  __/ | | | | (_) | ||  __/",Color.white,0,66));
        helpTxtPanel.add(jtxtpane("        | .__/|_|  |_|___/\\___|  \\__,_|\\___| |_| |_|\\___/ \\__\\___|",Color.white,0,88));
        helpTxtPanel.add(jtxtpane("        |_|",Color.white,0,110));
        helpTxtPanel.add(jtxtpane("Bienvenue sur l'application de prise de note !",new Color(230,0,0),0,132));
        helpTxtPanel.add(jtxtpane("Vous avez plusieurs possibilités de choix :",new Color(0,153,0),0,154));
        helpTxtPanel.add(jtxtpane("1) Créer ou modifier une note (saisir edit ou e)",new Color(0,153,0),0,176));
        helpTxtPanel.add(jtxtpane("2) Lister les notes existantes (saisir list ou ls)",new Color(0,153,0),0,198));
        helpTxtPanel.add(jtxtpane("3) Supprimer une note (saisir delete ou d)",new Color(0,153,0),0,220));
        helpTxtPanel.add(jtxtpane("4) Voir la note (saisir view ou v)",new Color(0,153,0),0,242));
        helpTxtPanel.add(jtxtpane("5) Rechercher une note (saisir search ou s)",new Color(0,153,0),0,264));
        helpTxtPanel.add(jtxtpane("6) Changer dossier de sauvegarde (saisir path ou p)",new Color(0,153,0),0,264));
        return helpTxtPanel ;
    }

    /**
     * Permet de prendre en entré les lignes de commande passé par l'Utilisateur
     * @param listenerPanel
     */
    private void setListener(JPanel listenerPanel){
        JTextPane textPane = new JTextPane();
        textPane.setEditable(false);
        textPane.setBounds(0,320,20,20);
        textPane.setBackground(Color.black);
        Font f = new Font("Consolas",Font.BOLD,16);
        textPane.setForeground(Color.white);
        textPane.setFont(f);
        textPane.setText(">");

        listenerPanel.add(textPane);

        final JTextField jTextField = new JTextField();
        jTextField.setBounds(20,320,600,20);
        jTextField.setBackground(Color.black);
        jTextField.setForeground(Color.white);
        jTextField.setFont(f);
        jTextField.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    String commande = jTextField.getText();
                    InterpreteurGlobal.execute(commande.split(" "));
                    jTextField.setText("");
                }
            }
        });

        listenerPanel.add(jTextField);

        this.interpreteur.setContentPane(listenerPanel);

    }

    /**
     * Affiche la fenêtre Jpanel
     */
    private void Afficher(){
        JPanel J = this.setHelpText();
        this.setListener(J);
        this.interpreteur.setVisible(true);

    }

    @Override
    public void command(String str) {
        this.Afficher();
    }
}
