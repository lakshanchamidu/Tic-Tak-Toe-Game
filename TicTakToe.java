import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTakToe implements ActionListener {

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_Panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player_1;

    TicTakToe(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textfield.setBackground(Color.black);
        textfield.setForeground(Color.white);
        textfield.setFont(new Font("MV Boil",Font.BOLD,75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("TIC Tak Toe");
        textfield.setOpaque(true);

        title_Panel.setLayout(new BorderLayout());
        title_Panel.setBounds(0, 0, 700, 100);

        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(Color.black);
        button_panel.setForeground(Color.black);

        for (int i=0; i<9;i++){
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boil",Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
            buttons[i].setBackground(Color.black);
        }

        title_Panel.add(textfield);
        frame.add(title_Panel,BorderLayout.NORTH);
        frame.add(button_panel);

        firsturn();

    }

    public void actionPerformed(ActionEvent e) {

        for (int i=0;i<9;i++){
            if (e.getSource()==buttons[i]){
                if (player_1 ){
                    if (buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(255, 0, 0));
                        buttons[i].setText("X");
                        player_1 = false;
                        textfield.setText("O Turn");
                        check();
                    }
                }
                else {
                    if (buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(0, 0, 255));
                        buttons[i].setText("O");
                        player_1 = true;
                        textfield.setText("X Turn");
                        check();
                    }
                }
            }
        }
    }

    public void firsturn(){

        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        if (random.nextInt(2) == 0){
            player_1 = true;
            textfield.setText("X Turn");

        } else {
            player_1 =false;
            textfield.setText("O Turn");
        }
    }

    public void check(){

        if((buttons[0].getText() == "X")&&
                (buttons[1].getText() == "X")&&
                (buttons[2].getText() == "X")){
            xWins(0,1,2);
        }
        if((buttons[3].getText() == "X")&&
                (buttons[4].getText() == "X")&&
                (buttons[5].getText() == "X")){
            xWins(3,4,5);
        }
        if((buttons[6].getText() == "X")&&
                (buttons[7].getText() == "X")&&
                (buttons[8].getText() == "X")){
            xWins(6,7,8);
        }
        if((buttons[0].getText() == "X")&&
                (buttons[3].getText() == "X")&&
                (buttons[6].getText() == "X")){
            xWins(0,3,6);
        }
        if((buttons[1].getText() == "X")&&
                (buttons[4].getText() == "X")&&
                (buttons[7].getText() == "X")){
            xWins(1,4,7);
        }
        if((buttons[2].getText() == "X")&&
                (buttons[5].getText() == "X")&&
                (buttons[8].getText() == "X")){
            xWins(2,5,8);
        }
        if((buttons[0].getText() == "X")&&
                (buttons[4].getText() == "X")&&
                (buttons[8].getText() == "X")){
            xWins(0,4,8);
        }
        if((buttons[2].getText() == "X")&&
                (buttons[4].getText() == "X")&&
                (buttons[6].getText() == "X")){
            xWins(2,4,6);
        }



        if((buttons[0].getText() == "O")&&
                (buttons[1].getText() == "O")&&
                (buttons[2].getText() == "O")){
            oWins(0,1,2);
        }
        if((buttons[3].getText() == "O")&&
                (buttons[4].getText() == "O")&&
                (buttons[5].getText() == "O")){
            oWins(3,4,5);
        }
        if((buttons[6].getText() == "O")&&
                (buttons[7].getText() == "O")&&
                (buttons[8].getText() == "O")){
            oWins(6,7,8);
        }
        if((buttons[0].getText() == "O")&&
                (buttons[3].getText() == "O")&&
                (buttons[6].getText() == "O")){
            oWins(0,3,6);
        }
        if((buttons[1].getText() == "O")&&
                (buttons[4].getText() == "O")&&
                (buttons[7].getText() == "O")){
            oWins(1,4,7);
        }
        if((buttons[2].getText() == "O")&&
                (buttons[5].getText() == "O")&&
                (buttons[8].getText() == "O")){
            oWins(2,5,8);
        }
        if((buttons[0].getText() == "O")&&
                (buttons[4].getText() == "O")&&
                (buttons[8].getText() == "O")){
            oWins(0,4,8);
        }
        if((buttons[2].getText() == "O")&&
                (buttons[4].getText() == "O")&&
                (buttons[6].getText() == "O")){
            oWins(2,4,6);
        }

    }

    public void xWins(int a, int b, int c){

        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i =0; i< 9;i++){
            buttons[i].setEnabled(false);
        }
        textfield.setText("X Wins");

    }

    public void oWins(int a, int b, int c){

        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i =0; i< 9;i++){
            buttons[i].setEnabled(false);
        }
        textfield.setText("0 Wins");

    }
}
