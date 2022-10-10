import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class TicTacToeSingle implements ActionListener {

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel text_field = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1_turn;
    JLabel playerScore = new JLabel();
    static int player = 0;
    JLabel cpuScore = new JLabel();
    static int cpu = 0;
    TicTacToeSingle() {
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

        playerScore.setBackground(new Color(25,25,25));
        playerScore.setForeground(new Color(25,255,0));
        playerScore.setFont(new Font("Roboto",Font.BOLD,30));
        playerScore.setHorizontalAlignment(JLabel.TRAILING);
        playerScore.setText("Your-Score = " + player);
        playerScore.setOpaque(true);

        cpuScore.setBackground(new Color(25,25,25));
        cpuScore.setForeground(new Color(25,255,0));
        cpuScore.setFont(new Font("Roboto",Font.BOLD,30));
        cpuScore.setHorizontalAlignment(JLabel.TRAILING);
        cpuScore.setText("Cpu-Score = " + cpu);
        cpuScore.setOpaque(true);
        
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
        title_panel.add(playerScore,BorderLayout.EAST);
        title_panel.add(cpuScore,BorderLayout.WEST);

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
                        if(check()) {
                            player1_turn = false;
                            continue;
                        }
                        else tieCheck();
                        ArrayList<Integer> remaining = new ArrayList<>();
                        for(int j = 0; j < 9; j++) {
                            if(Objects.equals(buttons[j].getText(), "")) {
                                remaining.add(j);
                            }
                        }
                        int n = remaining.size();
                        int random_number = random.nextInt(n);
                            if(Objects.equals(buttons[remaining.get(random_number)].getText(), "")) {
                                buttons[remaining.get(random_number)].setForeground(new Color(0,0,255));
                                buttons[remaining.get(random_number)].setText("O");
                                text_field.setText("Your Turn");
                                if(check()) {
                                    player1_turn = false;
                                    continue;
                                }
                                else tieCheck();
                                break;
                            }

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
        int selected = JOptionPane.showConfirmDialog(null,"Will You Start the Game First ?","Computer",JOptionPane.YES_NO_OPTION);
        player1_turn = true;
        if (selected != 0) {
            while (true) {
                int random_number = random.nextInt(9);
                if (Objects.equals(buttons[random_number].getText(), "")) {
                    buttons[random_number].setForeground(new Color(0, 0, 255));
                    buttons[random_number].setText("O");
                    check();
                    text_field.setText("Your Turn");
                    break;
                }
            }
        }
    }
    public boolean check() {
        if((Objects.equals(buttons[0].getText(), buttons[1].getText())) && (Objects.equals(buttons[0].getText(), buttons[2].getText()))) {
            if(Objects.equals(buttons[0].getText(), "X")) {
                xWins(0,1,2);
                return true;
            }
            if(Objects.equals(buttons[0].getText(), "O")) {
                oWins(0,1,2);
                return true;
            }
        }
        if((Objects.equals(buttons[3].getText(), buttons[4].getText())) && (Objects.equals(buttons[3].getText(), buttons[5].getText()))) {
            if(Objects.equals(buttons[3].getText(), "X")) {
                xWins(3,4,5);
                return true;
            }
            if(Objects.equals(buttons[3].getText(), "O")) {
                oWins(3,4,5);
                return true;
            }
        }
        if((Objects.equals(buttons[6].getText(), buttons[7].getText())) && (Objects.equals(buttons[6].getText(), buttons[8].getText()))) {
            if(Objects.equals(buttons[6].getText(), "X")) {
                xWins(6,7,8);
                return true;
            }
            if(Objects.equals(buttons[6].getText(), "O")) {
                oWins(6,7,8);
                return true;
            }
        }
        if((Objects.equals(buttons[0].getText(), buttons[3].getText())) && (Objects.equals(buttons[0].getText(), buttons[6].getText()))) {
            if(Objects.equals(buttons[6].getText(), "X")) {
                xWins(0,3,6);
                return true;
            }
            if(Objects.equals(buttons[6].getText(), "O")) {
                oWins(0,3,6);
                return true;
            }
        }
        if((Objects.equals(buttons[1].getText(), buttons[4].getText())) && (Objects.equals(buttons[1].getText(), buttons[7].getText()))) {
            if(Objects.equals(buttons[7].getText(), "X")) {
                xWins(1,4,7);
                return true;
            }
            if(Objects.equals(buttons[7].getText(), "O")) {
                oWins(1,4,7);
                return true;
            }
        }
        if((Objects.equals(buttons[2].getText(), buttons[5].getText())) && (Objects.equals(buttons[2].getText(), buttons[8].getText()))) {
            if(Objects.equals(buttons[8].getText(), "X")) {
                xWins(2,5,8);
                return true;
            }
            if(Objects.equals(buttons[8].getText(), "O")) {
                oWins(2,5,8);
                return true;
            }
        }
        if((Objects.equals(buttons[0].getText(), buttons[4].getText())) && (Objects.equals(buttons[0].getText(), buttons[8].getText()))) {
            if(Objects.equals(buttons[8].getText(), "X")) {
                xWins(0,4,8);
                return true;
            }
            if(Objects.equals(buttons[8].getText(), "O")) {
                oWins(0,4,8);
                return true;
            }
        }
        if((Objects.equals(buttons[2].getText(), buttons[4].getText())) && (Objects.equals(buttons[2].getText(), buttons[6].getText()))) {
            if(Objects.equals(buttons[2].getText(), "X")) {
                xWins(2,4,6);
                return true;
            }
            if(Objects.equals(buttons[2].getText(), "O")) {
                oWins(2,4,6);
                return true;
            }

        }
        return false;
    }
    public void xWins(int a,int b,int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        text_field.setText("YOU WON");
        playerScore.setText("Your Score = " + ++player);

        new After_matchSingle();
    }
    public void oWins(int a,int b,int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        text_field.setText("CPU WON");
        cpuScore.setText("Cpu Score = " + ++cpu);
        new After_matchSingle();

    }
    public void tieCheck() {
        int empty = 0;
        for(int i = 0; i < 9; i++) {
            if(Objects.equals(buttons[i].getText(), ""))empty++;
        }
        if(empty == 0) {
            text_field.setText("Tie");
            new After_matchSingle();
        }
    }
}
