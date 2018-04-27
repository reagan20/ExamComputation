package examsystem;

/**
 *
 * @author Reagan
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;
public class Update_Records extends JFrame{
    
        
private JLabel admission = new JLabel("Admission Number:");

private JTextField txtadmission = new JTextField(8);
private JTextField mathcat = new JTextField();
private JTextField mathexam = new JTextField();
private JLabel mathtotal = new JLabel();
private JLabel mathgrade = new JLabel();
private JLabel mathcomment = new JLabel();
private JTextField engcat = new JTextField();
private JTextField engexam = new JTextField();
private JLabel engtotal = new JLabel();
private JLabel enggrade = new JLabel();
private JLabel engcomment = new JLabel();
private JTextField kiscat = new JTextField();
private JTextField kisexam = new JTextField();
private JLabel kistotal = new JLabel();
private JLabel kisgrade = new JLabel();
private JLabel kiscomment = new JLabel();
private JTextField geogcat = new JTextField();
private JTextField geogexam = new JTextField();
private JLabel geogtotal = new JLabel();
private JLabel geoggrade = new JLabel();
private JLabel geogcomment = new JLabel();
private JTextField biocat = new JTextField();
private JTextField bioexam = new JTextField();
private JLabel biototal = new JLabel();
private JLabel biograde = new JLabel();
private JLabel biocomment = new JLabel();
private JTextField chemcat = new JTextField();
private JTextField chemexam = new JTextField();
private JLabel chemtotal = new JLabel();
private JLabel chemgrade = new JLabel();
private JLabel chemcomment = new JLabel();
private JTextField phyccat = new JTextField();
private JTextField phycexam = new JTextField();
private JLabel phyctotal = new JLabel();
private JLabel phycgrade = new JLabel();
private JLabel phyccomment = new JLabel();



private JButton btnSearch = new JButton("Search...");
private JButton btnExit = new JButton("Exit");
private JButton btnUpdate = new JButton("Update");




Update_Records() {
    JPanel adm = new JPanel(new FlowLayout(3));
           btnSearch.setFont(new Font("San Serif", Font.ITALIC,12));
           adm.setBorder(new TitledBorder("Enter student's admission number"));
           adm.add(admission);
           adm.add(txtadmission);
           adm.add(btnSearch);
    
    JPanel entry = new JPanel(new GridLayout(0, 6, 2, 2));
           entry.setBorder(new TitledBorder("Enter scores for a student: CATS and Main Exam marks"));
           entry.add(new JLabel("SUBJECT"));
           entry.add(new JLabel("CAT"));
           entry.add(new JLabel("EXAM"));
           entry.add(new JLabel("TOTAL"));
           entry.add(new JLabel("GRADE"));
           entry.add(new JLabel("COMMENT"));
           
           entry.add(new JLabel("Mathematics:"));
           entry.add(mathcat);
           entry.add(mathexam);
           entry.add(mathtotal);
           entry.add(mathgrade);
           entry.add(mathcomment);
           entry.add(new JLabel("English:"));
           entry.add(engcat);
           entry.add(engexam);
           entry.add(engtotal);
           entry.add(enggrade);
           entry.add(engcomment);
           entry.add(new JLabel("Kiswahili:"));
           entry.add(kiscat);
           entry.add(kisexam);
           entry.add(kistotal);
           entry.add(kisgrade);
           entry.add(kiscomment);
           entry.add(new JLabel("Geography:"));
           entry.add(geogcat);
           entry.add(geogexam);
           entry.add(geogtotal);
           entry.add(geoggrade);
           entry.add(geogcomment);
           entry.add(new JLabel("Biology:"));
           entry.add(biocat);
           entry.add(bioexam);
           entry.add(biototal);
           entry.add(biograde);
           entry.add(biocomment);
           entry.add(new JLabel("Chemistry:"));
           entry.add(chemcat);
           entry.add(chemexam);
           entry.add(chemtotal);
           entry.add(chemgrade);
           entry.add(chemcomment);
           entry.add(new JLabel("Physics:"));
           entry.add(phyccat);
           entry.add(phycexam);
           entry.add(phyctotal);
           entry.add(phycgrade);
           entry.add(phyccomment);
       
    JPanel computation = new JPanel(new FlowLayout(FlowLayout.CENTER));
           computation.setBorder(new TitledBorder("Computation Section"));
           btnExit.setBackground(Color.RED);
           computation.add(btnUpdate);
           computation.add(btnExit);
      
           add(adm, BorderLayout.NORTH);
           add(entry, BorderLayout.CENTER);
           add(computation, BorderLayout.SOUTH);
       
    btnSearch.addActionListener(new ButtonListener());
    btnExit.addActionListener(new ButtonListener());
    btnUpdate.addActionListener(new ButtonListener()); 
    
        
     pack();      
    //setSize(500, 600);
    setTitle("Exam Sytstem");
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
}
public class ButtonListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
        
        Double adm_number = Double.parseDouble(txtadmission.getText());
       if(e.getSource() == btnSearch)
       {
           try{
               Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam_system", "root", "");
               String fetching = "select * from marks_records where admin = '"+adm_number+"' ";
               Statement stmt = conn.createStatement();
                         
               ResultSet rst = stmt.executeQuery(fetching);
                         
               int rowCount = 0;
                while(rst.next()){
                    mathcat.setText(String.format("%.2f", rst.getDouble("mcat")));
                    mathexam.setText(String.format("%.2f", rst.getDouble("mexam")));
                    mathtotal.setText(String.format("%.2f", rst.getDouble("mtotal")));
                    mathgrade.setText(rst.getString("mgrade"));
                    mathcomment.setText(rst.getString("mcomment"));
                    engcat.setText(String.format("%.2f", rst.getDouble("ecat")));
                    engexam.setText(String.format("%.2f", rst.getDouble("eexam")));
                    engtotal.setText(String.format("%.2f", rst.getDouble("etotal")));
                    enggrade.setText(rst.getString("egrade"));
                    engcomment.setText(rst.getString("ecomment"));
                    kiscat.setText(String.format("%.2f", rst.getDouble("kcat")));
                    kisexam.setText(String.format("%.2f", rst.getDouble("kexam")));
                    kistotal.setText(String.format("%.2f", rst.getDouble("ktotal")));
                    kisgrade.setText(rst.getString("kgrade"));
                    kiscomment.setText(rst.getString("kcomment"));
                    geogcat.setText(String.format("%.2f", rst.getDouble("gcat")));
                    geogexam.setText(String.format("%.2f", rst.getDouble("gexam")));
                    geogtotal.setText(String.format("%.2f", rst.getDouble("gtotal")));
                    geoggrade.setText(rst.getString("ggrade"));
                    geogcomment.setText(rst.getString("gcomment"));
                    biocat.setText(String.format("%.2f", rst.getDouble("bcat")));
                    bioexam.setText(String.format("%.2f", rst.getDouble("bexam")));
                    biototal.setText(String.format("%.2f", rst.getDouble("btotal")));
                    biograde.setText(rst.getString("bgrade"));
                    biocomment.setText(rst.getString("bcomment"));
                    chemcat.setText(String.format("%.2f", rst.getDouble("chcat")));
                    chemexam.setText(String.format("%.2f", rst.getDouble("chexam")));
                    chemtotal.setText(String.format("%.2f", rst.getDouble("chtotal")));
                    chemgrade.setText(rst.getString("chgrade"));
                    chemcomment.setText(rst.getString("chcomment"));
                    phyccat.setText(String.format("%.2f", rst.getDouble("phcat")));
                    phycexam.setText(String.format("%.2f", rst.getDouble("phexam")));
                    phyctotal.setText(String.format("%.2f", rst.getDouble("phtotal")));
                    phycgrade.setText(rst.getString("phgrade"));
                    phyccomment.setText(rst.getString("phcomment"));
                  
                  ++rowCount;
                }
                System.out.println("Rows: "+rowCount);
               
           }catch(Exception ex){
               JOptionPane.showMessageDialog(null,"MySQL ERROR!!!","ERROR",JOptionPane.ERROR);
           }
       }
    }
}

public static void main(String args []){
    new Update_Records();
}
    
}
