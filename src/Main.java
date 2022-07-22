import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frm = new JFrame("Moving Square");
                frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frm.add(new Panel());
                frm.pack();
                frm.setVisible(true);
            }
        });
    }
}