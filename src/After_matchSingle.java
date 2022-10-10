import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class After_matchSingle implements ActionListener {
    public static TicTacToeSingle ticTacToeSingle;
    JFrame frame = new JFrame();
    JButton replay = new JButton();
    JButton main_menu  = new JButton();
    JButton exit = new JButton();

    After_matchSingle() {
        ImageIcon logo = new ImageIcon("game_logo.png");
        frame.setIconImage(logo.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.setTitle("Tic-Tac-Toe");
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new GridLayout(3,1,10,10));
        frame.setLocationRelativeTo(null);

        replay.setText("Replay");
        replay.setFocusable(false);
        replay.setForeground(new Color(0,101,200));
        replay.setBackground(new Color(255,101,0));
        replay.setFont(new Font("Times New Roman",Font.BOLD,30));
        replay.addActionListener(this);

        main_menu.setText("Main Menu");
        main_menu.setFocusable(false);
        main_menu.setForeground(new Color(0,101,200));
        main_menu.setBackground(new Color(255,101,0));
        main_menu.setFont(new Font("Times New Roman",Font.BOLD,30));
        main_menu.addActionListener(this);

        exit.setText("Exit");
        exit.setFocusable(false);
        exit.setForeground(new Color(0,101,200));
        exit.setBackground(new Color(255,101,0));
        exit.setFont(new Font("Times New Roman",Font.BOLD,30));
        exit.addActionListener(this);

        frame.add(replay);
        frame.add(main_menu);
        frame.add(exit);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == replay) {
            if(OpenWindow.ticTacToeSingle != null)OpenWindow.ticTacToeSingle.frame.dispose();
            if(After_matchSingle.ticTacToeSingle != null)After_matchSingle.ticTacToeSingle.frame.dispose();
            ticTacToeSingle = new TicTacToeSingle();
            frame.dispose();
        }
        if(e.getSource() == main_menu) {
            if(OpenWindow.ticTacToeSingle != null)OpenWindow.ticTacToeSingle.frame.dispose();
            if(After_matchSingle.ticTacToeSingle != null)After_matchSingle.ticTacToeSingle.frame.dispose();
            new OpenWindow();
            frame.dispose();
        }
        if(e.getSource() == exit) {
            int selected = JOptionPane.showConfirmDialog(null,"Are You Sure You Want To Exit","Conformation",JOptionPane.YES_NO_OPTION);
            if(selected == 0) {
                frame.dispose();
                System.exit(0);
            }
        }
    }
}
