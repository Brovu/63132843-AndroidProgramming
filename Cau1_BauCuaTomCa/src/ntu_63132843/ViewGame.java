package ntu_63132843;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ViewGame extends JFrame {

	private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldShrimp;
    private JTextField textFieldCrab;
    private JTextField textFieldFish;
    private JTextField textFieldGourd;
    private JTextField textFieldRooster;
    private JTextField textFieldDeer;
    private int myMoney = 10000; // Số tiền của bạn

    public ViewGame() {
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 400);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE); // Màu nền trắng
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        Font titleFont = new Font("Arial", Font.BOLD, 16); // Font chữ cho tiêu đề

        JLabel lblTitle = new JLabel("Mời bạn đặt cược (Số tiền hiện tại: " + myMoney + ")");
        lblTitle.setForeground(new Color(255, 0, 0));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setFont(titleFont); // Sử dụng font mới
        lblTitle.setBounds(10, 11, 414, 20);
        contentPane.add(lblTitle);
        
        JLabel lblShrimp = new JLabel("Tôm:");
        lblShrimp.setForeground(Color.BLUE);
        lblShrimp.setFont(titleFont);
        lblShrimp.setBounds(46, 72, 55, 14);
        contentPane.add(lblShrimp);

        textFieldShrimp = new JTextField();
        textFieldShrimp.setName("Tôm"); // Thiết lập tên cho trường nhập liệu Tôm
        textFieldShrimp.setBounds(111, 71, 243, 20);
        contentPane.add(textFieldShrimp);
        textFieldShrimp.setColumns(10);

        JLabel lblCrab = new JLabel("Cua:");
        lblCrab.setForeground(Color.BLUE); // Màu chữ xanh
        lblCrab.setFont(titleFont); // Sử dụng font mới
        lblCrab.setBounds(46, 97, 55, 20);
        contentPane.add(lblCrab);

        textFieldCrab = new JTextField();
        textFieldCrab.setName("Cua"); 
        textFieldCrab.setBounds(111, 99, 243, 20);
        contentPane.add(textFieldCrab);
        textFieldCrab.setColumns(10);

        JLabel lblFish = new JLabel("Cá:");
        lblFish.setForeground(Color.BLUE); // Màu chữ xanh
        lblFish.setFont(titleFont); // Sử dụng font mới
        lblFish.setBounds(46, 128, 55, 20);
        contentPane.add(lblFish);

        textFieldFish = new JTextField();
        textFieldFish.setName("Cá"); 
        textFieldFish.setBounds(111, 130, 243, 20);
        contentPane.add(textFieldFish);
        textFieldFish.setColumns(10);

        JLabel lblGourd = new JLabel("Bầu:");
        lblGourd.setForeground(Color.BLUE); // Màu chữ xanh
        lblGourd.setFont(titleFont); // Sử dụng font mới
        lblGourd.setBounds(46, 159, 55, 20);
        contentPane.add(lblGourd);

        textFieldGourd = new JTextField();
        textFieldGourd.setName("Bầu"); 
        textFieldGourd.setBounds(111, 161, 243, 20);
        contentPane.add(textFieldGourd);
        textFieldGourd.setColumns(10);

        JLabel lblRooster = new JLabel("Gà:");
        lblRooster.setForeground(Color.BLUE); // Màu chữ xanh
        lblRooster.setFont(titleFont); // Sử dụng font mới
        lblRooster.setBounds(46, 190, 55, 20);
        contentPane.add(lblRooster);

        textFieldRooster = new JTextField();
        textFieldRooster.setName("Gà"); 
        textFieldRooster.setBounds(111, 192, 243, 20);
        contentPane.add(textFieldRooster);
        textFieldRooster.setColumns(10);

        JLabel lblDeer = new JLabel("Nai:");
        lblDeer.setForeground(Color.BLUE); // Màu chữ xanh
        lblDeer.setFont(titleFont); // Sử dụng font mới
        lblDeer.setBounds(46, 221, 55, 20);
        contentPane.add(lblDeer);

        textFieldDeer = new JTextField();
        textFieldDeer.setName("Nai"); 
        textFieldDeer.setBounds(111, 223, 243, 20);
        contentPane.add(textFieldDeer);
        textFieldDeer.setColumns(10);

        JButton btnBet = new JButton("Cược");
        btnBet.setBackground(Color.GREEN); // Màu nút xanh
        btnBet.setForeground(Color.WHITE); // Màu chữ trắng
        btnBet.setFont(new Font("Arial", Font.BOLD, 25)); // Sử dụng font mới
      
        btnBet.setBounds(155, 282, 134, 50);
        contentPane.add(btnBet);
    }
    
    private void rollDice() {
        Map<String, Integer> diceResult = new HashMap<>();
        diceResult.put("Tôm", 0);
        diceResult.put("Cua", 0);
        diceResult.put("Cá", 0);
        diceResult.put("Bầu", 0);
        diceResult.put("Gà", 0);
        diceResult.put("Nai", 0);

        int totalRolls = 0;
        Random rand = new Random();
        int totalWin = 0;
        int totalLose = 0; // Biến để theo dõi tổng số tiền bị mất

        int shrimpBet = Integer.parseInt(textFieldShrimp.getText());
        int crabBet = Integer.parseInt(textFieldCrab.getText());
        int fishBet = Integer.parseInt(textFieldFish.getText());
        int gourdBet = Integer.parseInt(textFieldGourd.getText());
        int roosterBet = Integer.parseInt(textFieldRooster.getText());
        int deerBet = Integer.parseInt(textFieldDeer.getText());
        
        int totalBet = shrimpBet + crabBet + fishBet + gourdBet + roosterBet + deerBet;

        if (totalBet > myMoney) {
            JOptionPane.showMessageDialog(null, "Số tiền cược vượt quá số tiền hiện có!");
            return;
        }

        for (int i = 0; i < 3; i++) {
            int roll = rand.nextInt(6) + 1;
            switch (roll) {
            case 1:
                diceResult.put("Tôm", diceResult.get("Tôm") + 1);
                break;
            case 2:
                diceResult.put("Cua", diceResult.get("Cua") + 1);
                break;
            case 3:
                diceResult.put("Cá", diceResult.get("Cá") + 1);
                break;
            case 4:
                diceResult.put("Bầu", diceResult.get("Bầu") + 1);
                break;
            case 5:
                diceResult.put("Gà", diceResult.get("Gà") + 1);
                break;
            case 6:
                diceResult.put("Nai", diceResult.get("Nai") + 1);
                break;
        }
            totalRolls++;
        }

    }
}