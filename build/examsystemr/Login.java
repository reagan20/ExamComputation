/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examsystem;

/**
 *
 * @author Reagan
 */
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;

public class Login extends JFrame{
    
private ImageIcon image = new ImageIcon();
private JLabel login = new JLabel("LOGIN");
private JLabel username = new JLabel("Username");
private JTextField txtUsername = new JTextField(15);
private JLabel password = new JLabel("Password");
private JPasswordField Jpassword = new JPasswordField(15);
private JCheckBox cBox = new JCheckBox();
private JLabel remember = new JLabel("Remember Me?");
private JButton btnLogin = new JButton("Login");
private JLabel error = new JLabel("");
private JLabel correct = new JLabel("");

Login(){
    
    //pack();
    setSize(500,400);
    setTitle("Exam System");
    setVisible(true);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);
   // setMinimumSize(getMinimumSize());
   
    
    login.setFont(new Font("San Serif", Font.BOLD, 20));
    login.setForeground(Color.BLUE);
    error.setFont(new Font("San Serif", Font.ITALIC,10));
    error.setForeground(Color.red);
    correct.setFont(new Font("San Serif", Font.ITALIC, 11));
    correct.setForeground(Color.GREEN);
    remember.setFont(new Font("San Serif", Font.ITALIC,15));
    
  /*  JPanel big = new JPanel();
           big.setSize(500,400);
           add(big);
   
    JLabel background = new JLabel(new ImageIcon(getClass().getResource("computer2.jpg")));
            big.add(background);
    */
    JPanel log = new JPanel(new FlowLayout(FlowLayout.CENTER));
           log.add(login);
    JPanel pError = new JPanel(new FlowLayout(FlowLayout.CENTER));
           pError.add(error);
           pError.add(correct);
    JPanel rem = new JPanel(new FlowLayout(FlowLayout.CENTER));
           rem.setBackground(Color.LIGHT_GRAY);
           rem.add(cBox);
           rem.add(remember);
    JPanel btn = new JPanel(new FlowLayout(FlowLayout.CENTER));
           btn.setBackground(Color.LIGHT_GRAY);
           btn.add(btnLogin);
           
    JPanel panel = new JPanel(new GridLayout(0, 1 ));
    Dimension expectedDimension = new Dimension(210, 230);
            panel.setPreferredSize(expectedDimension);
            panel.setMaximumSize(expectedDimension);
            panel.setMinimumSize(expectedDimension);
            panel.setBorder(new LineBorder(Color.GRAY,2, true));
            panel.setBackground(Color.LIGHT_GRAY);
            panel.add(log);
            panel.add(pError);
            panel.add(username);
            panel.add(txtUsername);
            panel.add(password);
            panel.add(Jpassword);
            panel.add(rem);
            panel.add(btn);
            
       Box bx = new Box(BoxLayout.Y_AXIS);
            bx.add(Box.createVerticalGlue());
            bx.add(panel);
            bx.add(Box.createVerticalGlue());       
       add(bx);
 btnLogin.addActionListener(new loginClick());
 
}
public class loginClick implements ActionListener {
    public void actionPerformed(ActionEvent e){
        
        String name = txtUsername.getText();
        String passw = Jpassword.getText();
        String nam = null, pass = null;
        
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam_system", "root", "");
            String query = "select user_name, user_password from login";
            Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query);
             
             int rowCount = 0;
             while(rs.next()) {   // Move the cursor to the next row
             nam = rs.getString("user_name");
             pass = rs.getString("user_password");
            //System.out.println(nam + ", " + pass);
            ++rowCount;
             }
            
             if(rowCount == 1){
                 if(name.equals(name) && passw.equals(pass)){
                    error.setText("");
                    correct.setText("Loading...");
                   JOptionPane.showMessageDialog(null,"Successfully logged in.","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
                   correct.setText("");
                   txtUsername.setText("");
                   Jpassword.setText("");
                   new ExamSystem();
                   setVisible(false);
                 }
                 else{
                     correct.setText("");
                     error.setText("Wrong username or password");
                 }
             }
             else{
                 correct.setText("");
                 error.setText("");
                 JOptionPane.showMessageDialog(null,"A problem encountered!!","ERROR",JOptionPane.ERROR_MESSAGE);
             }
                              
             
                    conn.close();
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null,"MySQL Error Encountered","ERROR",JOptionPane.ERROR_MESSAGE);
        }

        
    }
}

  /* public static void main(String args []){
       new Login();
   }
    */
}

