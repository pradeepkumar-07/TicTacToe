import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.Random;

public class TicTacToe implements ActionListener {

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel text_field = new JLabel();
    JLabel xScore = new JLabel();
    static int x = 0;
    JLabel oScore = new JLabel();
    static int o = 0;
    JButton[] buttons = new JButton[9];
    boolean player1_turn;
    TicTacToe() {
        ImageIcon logo = new ImageIcon("game_logo.png");
        frame.setIconImage(logo.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.setTitle("Tic-Tac-Toe");
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);

        text_field.setBackground(new Color(25,25,25));
        text_field.setForeground(new Color(25,255,0));
        text_field.setFont(new Font("Roboto",Font.BOLD,50));
        text_field.setHorizontalAlignment(JLabel.CENTER);
        text_field.setText("Tic-Tac-Toe");
        text_field.setOpaque(true);

        xScore.setBackground(new Color(25,25,25));
        xScore.setForeground(new Color(25,255,0));
        xScore.setFont(new Font("Roboto",Font.BOLD,30));
        xScore.setHorizontalAlignment(JLabel.TRAILING);
        xScore.setText("X-Score = " + x);
        xScore.setOpaque(true);

        oScore.setBackground(new Color(25,25,25));
        oScore.setForeground(new Color(25,255,0));
        oScore.setFont(new Font("Roboto",Font.BOLD,30));
        oScore.setHorizontalAlignment(JLabel.TRAILING);
        oScore.setText("O-Score = " + o);
        oScore.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,500,100);

        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(new Color(150,150,150));

        for(int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("Roboto",Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        title_panel.add(text_field,BorderLayout.CENTER);
        title_panel.add(xScore,BorderLayout.EAST);
        title_panel.add(oScore,BorderLayout.WEST);
        frame.add(title_panel,BorderLayout.NORTH);
        frame.add(button_panel);

        frame.setVisible(true);
        firstTurn();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < 9; i++) {
            if(e.getSource() == buttons[i]) {
                if(player1_turn) {
                    if(Objects.equals(buttons[i].getText(), "")) {
                        buttons[i].setForeground(new Color(255,0,0));
                        buttons[i].setText("X");
                        player1_turn = false;
                        text_field.setText("O's turn");
                        check();
                    }
                }
                else {
                    if(Objects.equals(buttons[i].getText(), "")) {
                        buttons[i].setForeground(new Color(0,0,255));
                        buttons[i].setText("O");
                        player1_turn = true;
                        text_field.setText("X's turn");
                        check();
                    }
                }
            }
        }
    }
    public void firstTurn() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(random.nextInt(2) == 0) {
            player1_turn = true;
            text_field.setText("X's turn");
        }
        else {
            player1_turn = false;
            text_field.setText("O's turn");
        }
    }
    public void check() {
        if((Objects.equals(buttons[0].getText(), buttons[1].getText())) && (Objects.equals(buttons[0].getText(), buttons[2].getText()))) {
            if(Objects.equals(buttons[0].getText(), "X")) {
                xWins(0,1,2);
            }
            if(Objects.equals(buttons[0].getText(), "O")) {
                oWins(0,1,2);
            }
        }
        if((Objects.equals(buttons[3].getText(), buttons[4].getText())) && (Objects.equals(buttons[3].getText(), buttons[5].getText()))) {
            if(Objects.equals(buttons[3].getText(), "X")) {
                xWins(3,4,5);
            }
            if(Objects.equals(buttons[3].getText(), "O")) {
                oWins(3,4,5);
            }
        }
        if((Objects.equals(buttons[6].getText(), buttons[7].getText())) && (Objects.equals(buttons[6].getText(), buttons[8].getText()))) {
            if(Objects.equals(buttons[6].getText(), "X")) {
                xWins(6,7,8);
            }
            if(Objects.equals(buttons[6].getText(), "O")) {
                oWins(6,7,8);
            }
        }
        if((Objects.equals(buttons[0].getText(), buttons[3].getText())) && (Objects.equals(buttons[0].getText(), buttons[6].getText()))) {
            if(Objects.equals(buttons[6].getText(), "X")) {
                xWins(0,3,6);
            }
            if(Objects.equals(buttons[6].getText(), "O")) {
                oWins(0,3,6);
            }
        }
        if((Objects.equals(buttons[1].getText(), buttons[4].getText())) && (Objects.equals(buttons[1].getText(), buttons[7].getText()))) {
            if(Objects.equals(buttons[7].getText(), "X")) {
                xWins(1,4,7);
            }
            if(Objects.equals(buttons[7].getText(), "O")) {
                oWins(1,4,7);
            }
        }
        if((Objects.equals(buttons[2].getText(), buttons[5].getText())) && (Objects.equals(buttons[2].getText(), buttons[8].getText()))) {
            if(Objects.equals(buttons[8].getText(), "X")) {
                xWins(2,5,8);
            }
            if(Objects.equals(buttons[8].getText(), "O")) {
                oWins(2,5,8);
            }
        }
        if((Objects.equals(buttons[0].getText(), buttons[4].getText())) && (Objects.equals(buttons[0].getText(), buttons[8].getText()))) {
            if(Objects.equals(buttons[8].getText(), "X")) {
                xWins(0,4,8);
            }
            if(Objects.equals(buttons[8].getText(), "O")) {
                oWins(0,4,8);
            }
        }
        if((Objects.equals(buttons[2].getText(), buttons[4].getText())) && (Objects.equals(buttons[2].getText(), buttons[6].getText()))) {
            if(Objects.equals(buttons[2].getText(), "X")) {
                xWins(2,4,6);
            }
            if(Objects.equals(buttons[2].getText(), "O")) {
                oWins(2,4,6);
            }
        }
        else tieCheck();
    }
    public void xWins(int a,int b,int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        text_field.setText("X WON");
        xScore.setText("X-Score = " + ++x);
        new After_match();
    }
    public void oWins(int a,int b,int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        text_field.setText("O WON");
        oScore.setText("O-Score = " + ++o);
        new After_match();
    }
    public void tieCheck() {
        int empty = 0;
        for(int i = 0; i < 9; i++) {
            if(Objects.equals(buttons[i].getText(), ""))empty++;
        }
        if(empty == 0) {
            text_field.setText("Tie");
            new After_match();
        }
    }
}
