import javax.annotation.processing.Generated;
import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class PasswordGenerator2 {
    public static Random random = new Random();
    public static JCheckBox[] condition  = {new JCheckBox("Has Uppercase Letters"),new JCheckBox("Has Numbers"),new JCheckBox("Has symbols"),new JCheckBox("Has Other character")};
    public static void main(String[] args) {
        JFrame frame = new JFrame("Password Generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());
        frame.setBounds(10, 10, 500, 500);
        JPanel panel = new JPanel();
        for(JCheckBox chk:condition){
            panel.add(chk);
        }
        JSpinner lettercount = new JSpinner(new SpinnerNumberModel(8, 0, 500, 1));
        JLabel letterCountLabel = new JLabel("how many latters : ");

        panel.add(letterCountLabel);
        panel.add(lettercount);
        JTextField password = new JTextField(20);
        panel.add(password);
        JButton gen= new JButton("Geneartor");
        gen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                StringBuilder generated = new StringBuilder();
                int count = (int)lettercount.getValue();
                for(int i=0; i<count;i++){
                    int rand ;
                    if(condition[0].isSelected()){
                        if(random.nextBoolean()){
                            rand =  65+random.nextInt(25);
                            generated.append((char)rand);
                        continue;
                        }
                    }
                    if(condition[1].isSelected()){
                        if(random.nextBoolean()){
                            rand =  48+random.nextInt(10);
                            generated.append((char)rand);
                        continue;
                        }
                    }
                    if(condition[2].isSelected()){
                        if(random.nextBoolean()){
                            rand =  33+random.nextInt(14);
                            generated.append((char)rand);
                        continue;
                        }
                    }
                    if(condition[3].isSelected()){
                        if(random.nextBoolean()){
                            rand =  random.nextInt(Character.MIN_VALUE);
                            generated.append((char)rand);
                        continue;
                        }
                    }
                    rand = 97+random.nextInt(25);
                    generated.append((char)rand);
                }
                password.setText(generated.toString());
            }
        });
        JButton copy= new JButton("Copy");
        copy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(password.getText()), null);
            }
        });
        panel.add(gen);
        panel.add(copy);
        for(Component c:panel.getComponents()){
            c.setFont(new Font("Arial", Font.PLAIN, 20));
        }
        frame.add(panel);
        frame.setVisible(true);
    }
    
}