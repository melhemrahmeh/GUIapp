import javax.swing.*;

public class MyFrame extends JFrame {
    public MyFrame() {
        setBounds(100, 100, 800, 500);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        setContentPane(panel);

        JLabel label = new JLabel();
        label.setText("Enter the location of the Lab: ");
        label.setBounds(12, 10, 300, 30);
        panel.add(label);

        JTextField field = new JTextField();
        field.setBounds(12, 45, 300, 25);
        panel.add(field);

        JButton btn = new JButton();
        btn.setText("Check");
        btn.setBounds(12, 80, 300, 20);

        JTextArea j = new JTextArea(5,5);
        btn.addActionListener(e -> {
            String location = field.getText().trim();
            j.setBounds(3,100 , 800,500);
            j.setText("The technicians working at "+field.getText() +" are:\n\n "+ DB.getTechnicians(location) +"\n \n and the Lab info ("+field.getText() +") are:\n\n"+ DB.getLabInfo(location));
        });
        panel.add(btn);
        panel.add(j);
    }
}