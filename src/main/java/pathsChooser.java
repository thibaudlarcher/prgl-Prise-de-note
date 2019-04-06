import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import static java.lang.System.exit;

public class pathsChooser extends JPanel implements ActionListener,Command {

    private String paths;
    private JFileChooser chooser;
    private String choosertitle;
    public pathsChooser(){
    }
    public void actionPerformed(ActionEvent e) {

    }
    public Dimension getPreferredSize(){
        return new Dimension(200, 200);
    }

    public void closeWindow(){
        JFrame J = new JFrame();
        J.setSize(300,200);
        J.setLayout(null);
        J.setResizable(false);
        J.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        J.setLocationRelativeTo(null);

        JPanel JP = new JPanel();
        JP.setLocation(0,0);
        JP.setBounds(0,0,300,200);
        JP.setLayout(null);

        JTextPane textPane = new JTextPane();
        textPane.setEditable(false);
        textPane.setBounds(0,0,300,100);
        Font f = new Font("Consolas",Font.BOLD,16);
        textPane.setForeground(Color.black);
        textPane.setFont(f);
        textPane.setText("L'application doit être fermé pour appliquer les modifications.");
        JP.add(textPane);

        JButton JB = new JButton("OK");
        JB.setBounds(100,120,100,25);
        JB.addActionListener(e -> exit(0));
        JP.add(JB);

        J.add(JP);
        J.setVisible(true);
    }

    @Override
    public void command(String str) {
            JFrame frame = new JFrame("");
            chooser = new JFileChooser();
            chooser.setCurrentDirectory(new java.io.File("."));
            chooser.setDialogTitle(choosertitle);
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            chooser.setAcceptAllFileFilterUsed(false);
            frame.setVisible(true);
            //
            if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                this.paths = String.valueOf(chooser.getSelectedFile());
                PropertiesCreator.updatePropertiesFile(paths);
            } else {
                System.out.println("Pas de dossier choisit ");
            }
            frame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    exit(0);
                }
            });
            frame.getContentPane().add(this, "Center");
            frame.setSize(this.getPreferredSize());
            frame.setVisible(false);
            this.closeWindow();
    }
}
