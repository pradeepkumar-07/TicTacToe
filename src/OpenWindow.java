import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OpenWindow implements ActionListener {
    public static TicTacToe ticTacToe;
    public static TicTacToeSingle ticTacToeSingle;
    JFrame window = new JFrame();
    JLabel text_field = new JLabel();
    JPanel title_panel = new JPanel();
    JPanel body_panel = new JPanel();
    JButton single_player = new JButton();
    JButton multi_player = new JButton();
    JButton exit = new JButton();

    OpenWindow() {
        ImageIcon logo = new ImageIcon("game_logo.png");
        window.setIconImage(logo.getImage());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(500,500);
        window.getContentPane().setBackground(new Color(255,255,255));
        window.setTitle("Tic-Tac-Toe");
        window.setLocationRelativeTo(null);

        text_field.setBackground(new Color(25,25,25));
        text_field.setForeground(new Color(25,255,0));
        text_field.setFont(new Font("Times New Roman",Font.BOLD,70));
        text_field.setHorizontalAlignment(JLabel.CENTER);
        text_field.setText("Tic-Tac-Toe");
        text_field.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,500,100);

        body_panel.setLayout(new GridLayout(3,1,10,10));
        body_panel.setBackground(new Color(30,0,0));


        title_panel.add(text_field);
        single_player.addActionListener(this);
        multi_player.addActionListener(this);
        exit.addActionListener(this);

        single_player.setText("Single Player");
        single_player.setForeground(Color.BLACK);
        single_player.setBackground(new Color(200,200,200));
        single_player.setFont(new Font("Times New Roman",Font.ITALIC,30));
        single_player.setFocusable(false);
        multi_player.setText("Multi Player");
        multi_player.setForeground(Color.BLACK);
        multi_player.setBackground(new Color(200,200,200));
        multi_player.setFont(new Font("Times New Roman",Font.ITALIC,30));
        multi_player.setFocusable(false);
        exit.setText("Exit");
        exit.setForeground(new Color(255,0,0));
        exit.setBackground(new Color(200,200,200));
        exit.setFont(new Font("Times New Roman",Font.ITALIC,30));
        exit.setFocusable(false);

        window.add(title_panel,BorderLayout.NORTH);
        window.add(body_panel);
        body_panel.add(single_player);
        body_panel.add(multi_player);
        body_panel.add(exit);

        window.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            if(e.getSource() == single_player) {
                ticTacToeSingle = new TicTacToeSingle();
                window.dispose();
            }
            if(e.getSource() == multi_player) {
                ticTacToe = new TicTacToe();
                window.dispose();
            }
            if(e.getSource() == exit) {
                int selected = JOptionPane.showConfirmDialog(null,"Are You Sure You Want To Exit","Conformation",JOptionPane.YES_NO_OPTION);
                if(selected == 0) {
                    System.exit(0);
                }
            }
    }
}
