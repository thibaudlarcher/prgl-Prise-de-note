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
    JFileChooser chooser;
    String choosertitle;
    public pathsChooser(){
    }
    public void actionPerformed(ActionEvent e) {

    }
    public Dimension getPreferredSize(){
        return new Dimension(200, 200);
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
    }

    public String getPaths() {
        return paths;
    }
}
