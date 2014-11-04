import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class File extends Frame
{
    Button bt = new Button("Open File");
    Button clear = new Button("Clear");
    TextArea ta = new TextArea("", 0, 10);
    FileDialog fc;

    public File()
    {
        Frame f = new Frame();

        f.setLayout(new FlowLayout());
        f.setSize(500, 500);
        f.setTitle("Browse File");
        f.setVisible(true);
        f.add(bt);
        f.add(ta);
        f.add(clear);

        fc = new FileDialog(f, "Select File");
        bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fileContents = "";
                String line;

                fc.setVisible(true);
                String filename = fc.getFile();
                String filedir = fc.getDirectory();

                try {
                    System.out.println(filedir+filename);
                    BufferedReader br = new BufferedReader(new FileReader(filedir + filename));
                    while ((line = br.readLine()) != null) {
                        ta.append(line);
                        ta.append("\n");
                    }

                } catch (Exception exc) {
                    System.out.println(exc);
                }
            }
        });

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ta.setText("");
            }
        });

        f.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we){
                System.exit(0);
            }
        });
    }

    public static void main(String[] args)
    {
        new File();
    }
}
