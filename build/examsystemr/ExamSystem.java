
package examsystem;

/**
 *
 * @author Reagan
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
//import java.util.*;
import javax.swing.border.TitledBorder;

public class ExamSystem extends JFrame{
    
private JLabel admission = new JLabel("Admission Number:");

private JTextField txtadmission = new JTextField(8);
private JTextField mathcat = new JTextField();
private JTextField mathexam = new JTextField();
private JTextField mathtotal = new JTextField();
private JTextField mathgrade = new JTextField();
private JTextField mathcomment = new JTextField();
private JTextField engcat = new JTextField();
private JTextField engexam = new JTextField();
private JTextField engtotal = new JTextField();
private JTextField enggrade = new JTextField();
private JTextField engcomment = new JTextField();
private JTextField kiscat = new JTextField();
private JTextField kisexam = new JTextField();
private JTextField kistotal = new JTextField();
private JTextField kisgrade = new JTextField();
private JTextField kiscomment = new JTextField();
private JTextField geogcat = new JTextField();
private JTextField geogexam = new JTextField();
private JTextField geogtotal = new JTextField();
private JTextField geoggrade = new JTextField();
private JTextField geogcomment = new JTextField();
private JTextField biocat = new JTextField();
private JTextField bioexam = new JTextField();
private JTextField biototal = new JTextField();
private JTextField biograde = new JTextField();
private JTextField biocomment = new JTextField();
private JTextField chemcat = new JTextField();
private JTextField chemexam = new JTextField();
private JTextField chemtotal = new JTextField();
private JTextField chemgrade = new JTextField();
private JTextField chemcomment = new JTextField();
private JTextField phyccat = new JTextField();
private JTextField phycexam = new JTextField();
private JTextField phyctotal = new JTextField();
private JTextField phycgrade = new JTextField();
private JTextField phyccomment = new JTextField();



private JButton btnCompute = new JButton("Compute");
private JButton btnSubmit = new JButton("Submit");
private JButton btnClear = new JButton("Clear");
private JButton btnExit = new JButton("Exit");
private JButton btnUpdate = new JButton("Update");




ExamSystem() {
    JPanel adm = new JPanel(new FlowLayout(3));
           adm.setBorder(new TitledBorder("Enter student's admission number"));
           adm.add(admission);
           adm.add(txtadmission);
    
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
       
    JPanel computation = new JPanel(new GridLayout(0, 5, 5, 0));
           computation.setBorder(new TitledBorder("Computation Section"));
           btnExit.setBackground(Color.RED);
           btnClear.setBackground(Color.MAGENTA);
           btnCompute.setBackground(Color.CYAN);
           btnSubmit.setBackground(Color.LIGHT_GRAY);
           computation.add(btnCompute);
           computation.add(btnSubmit);
           computation.add(btnUpdate);
           computation.add(btnClear);
           computation.add(btnExit);
      
           add(adm, BorderLayout.NORTH);
           add(entry, BorderLayout.CENTER);
           add(computation, BorderLayout.SOUTH);
       
    btnCompute.addActionListener(new ButtonListener());
    btnSubmit.addActionListener(new ButtonListener());
    btnClear.addActionListener(new ButtonListener());
    btnExit.addActionListener(new ButtonListener());
    btnUpdate.addActionListener(new ButtonListener());
    
        
     pack();      
    //setSize(500, 600);
    setTitle("Exam Sytstem");
    setLocationRelativeTo(null);
    //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    
}

public class ButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent e){
        double Mcat=0,Mexam=0, Ecat=0,Eexam=0, Kcat=0,Kexam=0, Gcat=0,Gexam=0, Bcat=0,Bexam=0, Chcat=0,Chexam=0, Phcat=0,Phexam=0;
        double admis = 0, Mtotal = 0, Etotal = 0, Ktotal = 0, Btotal = 0, Gtotal = 0, Phtotal = 0, Chtotal = 0;
    
   // Creating an 'if else statement'  to direct the click of the buttons.
   

  if(e.getSource() == btnCompute) //if compute button is pressed, the below code is executed.
  {
        
        //registration number input
        if(txtadmission.getText().trim().isEmpty()){ JOptionPane.showMessageDialog(null, "Admission Number missing!!","", JOptionPane.ERROR_MESSAGE);txtadmission.setBackground(Color.cyan);}
        else {admis = Double.parseDouble(txtadmission.getText());  txtadmission.setBackground(Color.LIGHT_GRAY);}
        
        //mathematics section
        if(mathcat.getText().trim().isEmpty()){ JOptionPane.showMessageDialog(null, "Input Mathematics Cat","", JOptionPane.ERROR_MESSAGE); mathcat.setBackground(Color.ORANGE);}
        else { Mcat = Double.parseDouble(mathcat.getText()); mathcat.setBackground(Color.LIGHT_GRAY);}
        if(mathexam.getText().trim().isEmpty()){ JOptionPane.showMessageDialog(null, "Input Mathematics Exam","", JOptionPane.ERROR_MESSAGE); mathexam.setBackground(Color.ORANGE);}
        else { Mexam = Double.parseDouble(mathexam.getText()); mathexam.setBackground(Color.LIGHT_GRAY);}
       
        //english section
       if(engcat.getText().trim().isEmpty()){ JOptionPane.showMessageDialog(null, "Input English Cat","", JOptionPane.ERROR_MESSAGE); engcat.setBackground(Color.ORANGE);}
        else { Ecat = Double.parseDouble(engcat.getText()); engcat.setBackground(Color.LIGHT_GRAY);}
        if(engexam.getText().trim().isEmpty()){ JOptionPane.showMessageDialog(null, "Input English Exam","", JOptionPane.ERROR_MESSAGE); engexam.setBackground(Color.ORANGE);}
        else { Eexam = Double.parseDouble(engexam.getText()); engexam.setBackground(Color.LIGHT_GRAY);}
        
        //kiswahili section
        if(kiscat.getText().trim().isEmpty()){ JOptionPane.showMessageDialog(null, "Input Kiswahili Cat","", JOptionPane.ERROR_MESSAGE); kiscat.setBackground(Color.ORANGE);}
        else { Kcat = Double.parseDouble(kiscat.getText()); kiscat.setBackground(Color.LIGHT_GRAY);}
        if(kisexam.getText().trim().isEmpty()){ JOptionPane.showMessageDialog(null, "Input Kiswahili exam","", JOptionPane.ERROR_MESSAGE); kisexam.setBackground(Color.ORANGE);}
        else { Kexam = Double.parseDouble(kisexam.getText()); kisexam.setBackground(Color.LIGHT_GRAY);}
        
        //geography section
        if(geogcat.getText().trim().isEmpty()){ JOptionPane.showMessageDialog(null, "Input Geography Cat","", JOptionPane.ERROR_MESSAGE); geogcat.setBackground(Color.ORANGE);}
        else { Gcat = Double.parseDouble(geogcat.getText()); geogcat.setBackground(Color.LIGHT_GRAY);}
        if(geogexam.getText().trim().isEmpty()){ JOptionPane.showMessageDialog(null, "Input Geography Exam","", JOptionPane.ERROR_MESSAGE); geogexam.setBackground(Color.ORANGE);}
        else { Gexam = Double.parseDouble(geogexam.getText()); geogexam.setBackground(Color.LIGHT_GRAY);}
        
        //biology section
        if(biocat.getText().trim().isEmpty()){ JOptionPane.showMessageDialog(null, "Input Bilogy Cat","", JOptionPane.ERROR_MESSAGE); biocat.setBackground(Color.ORANGE);}
        else { Bcat = Double.parseDouble(biocat.getText()); biocat.setBackground(Color.LIGHT_GRAY);}
        if(bioexam.getText().trim().isEmpty()){ JOptionPane.showMessageDialog(null, "Input Biology Exam","", JOptionPane.ERROR_MESSAGE); bioexam.setBackground(Color.ORANGE);}
        else { Bexam = Double.parseDouble(bioexam.getText()); bioexam.setBackground(Color.LIGHT_GRAY);}
        
        //chemistry section
        if(chemcat.getText().trim().isEmpty()){ JOptionPane.showMessageDialog(null, "Input Chemistry Cat","", JOptionPane.ERROR_MESSAGE); chemcat.setBackground(Color.ORANGE);}
        else { Chcat = Double.parseDouble(chemcat.getText()); chemcat.setBackground(Color.LIGHT_GRAY);}
        if(chemexam.getText().trim().isEmpty()){ JOptionPane.showMessageDialog(null, "Input Chemistry Exam","", JOptionPane.ERROR_MESSAGE); chemexam.setBackground(Color.ORANGE);}
        else { Chexam = Double.parseDouble(chemexam.getText()); chemexam.setBackground(Color.LIGHT_GRAY);}
        
        //physics section
        if(phyccat.getText().trim().isEmpty()){ JOptionPane.showMessageDialog(null, "Input Physics Cat","", JOptionPane.ERROR_MESSAGE); phyccat.setBackground(Color.ORANGE);}
        else { Phcat = Double.parseDouble(phyccat.getText()); phyccat.setBackground(Color.LIGHT_GRAY);}
        if(phycexam.getText().trim().isEmpty()){ JOptionPane.showMessageDialog(null, "Input Physics Exam","", JOptionPane.ERROR_MESSAGE); phycexam.setBackground(Color.ORANGE);}
        else { Phexam = Double.parseDouble(phycexam.getText()); phycexam.setBackground(Color.LIGHT_GRAY);}       
        
        //Mathematics validation
        if(Mcat >= 0 && Mcat <= 40) {
            if(Mexam >= 0 && Mexam <= 60) 
            {
                Mtotal = Mcat + Mexam; 
                Calculations cal = new Calculations(Mtotal);
                mathtotal.setText(String.format("%.2f", Mtotal));
                mathgrade.setText( cal.getGrade());
                mathcomment.setText(cal.getComment());
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Wrong Mathematics EXAM Value","ERROR", JOptionPane.ERROR_MESSAGE);
                mathexam.setBackground(Color.RED);
                mathtotal.setText("");mathgrade.setText("");mathcomment.setText("");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Wrong Mathematics CAT Value","ERROR", JOptionPane.ERROR_MESSAGE);
            mathcat.setBackground(Color.RED);
            mathtotal.setText("");mathgrade.setText("");mathcomment.setText("");
        }
        
        //English validation
       if(Ecat >= 0 && Ecat <= 40) {
            if(Eexam >= 0 && Eexam <= 60)
            {
                Etotal = Ecat + Eexam;
                Calculations cal = new Calculations(Etotal);
                engtotal.setText(String.format("%.2f", Etotal));
                enggrade.setText(cal.getGrade());
                engcomment.setText(cal.getComment());
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Wrong English EXAM Value","ERROR", JOptionPane.ERROR_MESSAGE);
                engexam.setBackground(Color.RED);
                engtotal.setText("");enggrade.setText("");engcomment.setText("");
            }
        }
        else
       {
           JOptionPane.showMessageDialog(null, "Wrong English CAT Value","ERROR", JOptionPane.ERROR_MESSAGE);
           engcat.setBackground(Color.RED);
           engtotal.setText("");enggrade.setText("");engcomment.setText("");
       }
        
        //Kiswahili validation
        if(Kcat >= 0 && Kcat <= 40) {
            if(Kexam >= 0 && Kexam <= 60)
            {
                Ktotal = Kcat + Kexam;
                Calculations cal = new Calculations(Ktotal);
                kistotal.setText(String.format("%.2f", Ktotal));
                kisgrade.setText(cal.getGrade());
                kiscomment.setText( cal.getComment());
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Wrong Kiswahili EXAM Value","ERROR", JOptionPane.ERROR_MESSAGE);
                kisexam.setBackground(Color.RED);
                kistotal.setText("");kisgrade.setText("");kiscomment.setText("");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Wrong Kiswahili CAT Value","ERROR", JOptionPane.ERROR_MESSAGE);
            kiscat.setBackground(Color.RED);
            kistotal.setText("");kisgrade.setText("");kiscomment.setText("");
        }
        //Geography validation
        if(Gcat >= 0 && Gcat <= 40) {
            if(Gexam >= 0 && Gexam <= 60)
            {
                Gtotal = Gcat + Gexam;
                Calculations cal = new Calculations(Gtotal);
                geogtotal.setText(String.format("%.2f", Gtotal));
                geoggrade.setText(cal.getGrade());
                geogcomment.setText(cal.getComment());
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Wrong Geography EXAM Value","ERROR", JOptionPane.ERROR_MESSAGE);
                geogexam.setBackground(Color.RED);
                geogtotal.setText("");geoggrade.setText("");geogcomment.setText("");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Wrong Geography CAT Value","ERROR", JOptionPane.ERROR_MESSAGE);
            geogcat.setBackground(Color.RED);
            geogtotal.setText("");geoggrade.setText("");geogcomment.setText("");
        }
        
        //Biology validation
        if(Bcat >= 0 && Bcat <= 40) {
            if(Bexam >= 0 && Bexam <= 60)
            {
                Btotal = Bcat + Bexam;
                Calculations cal = new Calculations(Btotal);
                biototal.setText(String.format("%.2f", Btotal));
                biograde.setText(cal.getGrade());
                biocomment.setText(cal.getComment());
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Wrong Biology EXAM Value","ERROR", JOptionPane.ERROR_MESSAGE);
                bioexam.setBackground(Color.RED);
                biototal.setText("");biograde.setText("");biocomment.setText("");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Wrong Biology CAT Value","ERROR", JOptionPane.ERROR_MESSAGE);
            biocat.setBackground(Color.RED);
            biototal.setText("");biograde.setText("");biocomment.setText("");
        }
        
        //Chemistry validation
        if(Chcat >= 0 && Chcat <= 40) {
            if(Chexam >= 0 && Chexam <= 60)
            {
                Chtotal = Chcat + Chexam;
                Calculations cal = new Calculations(Chtotal);
                chemtotal.setText(String.format("%.2f", Chtotal));
                chemgrade.setText(cal.getGrade());
                chemcomment.setText(cal.getComment());
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Wrong Chemistry EXAM Value","ERROR", JOptionPane.ERROR_MESSAGE);
                chemexam.setBackground(Color.RED);
                chemtotal.setText("");chemgrade.setText("");chemcomment.setText("");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Wrong Chemistry CAT Value","ERROR", JOptionPane.ERROR_MESSAGE);
            chemcat.setBackground(Color.RED);
            chemtotal.setText("");chemgrade.setText("");chemcomment.setText("");
        }
        
        //Physics validation
        if(Phcat >= 0 && Phcat <= 40) {
            if(Phexam >= 0 && Phexam <= 60)
            {
                Phtotal = Phcat + Phexam;
                Calculations cal = new Calculations(Phtotal);
                phyctotal.setText(String.format("%.2f", Phtotal));
                phycgrade.setText(cal.getGrade());
                phyccomment.setText(cal.getComment());
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Wrong Physics EXAM Value","ERROR", JOptionPane.ERROR_MESSAGE);
                phycexam.setBackground(Color.RED);
                phyctotal.setText("");phycgrade.setText("");phyccomment.setText("");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Wrong Physics CAT Value","ERROR", JOptionPane.ERROR_MESSAGE);
            phyccat.setBackground(Color.RED);
            phyctotal.setText("");phycgrade.setText("");phyccomment.setText("");
        }       
       
  }// ends btnCompute
  
    if(e.getSource() == btnSubmit)
  {
        try{
      Connection conn  = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam_system", "root", "");
      String querying = "insert into marks_records(admin, mcat, mexam, mtotal, mgrade, mcomment,ecat,eexam,etotal,egrade,ecomment,kcat,kexam,ktotal,kgrade,kcomment,gcat,gexam,gtotal,ggrade,gcomment,bcat,bexam,btotal,bgrade,bcomment,chcat,chexam,chtotal,chgrade,chcomment,phcat,phexam,phtotal,phgrade,phcomment) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      PreparedStatement stmt = conn.prepareStatement(querying);
                        stmt.setDouble(1, Double.parseDouble(txtadmission.getText()));
                        stmt.setDouble(2, Double.parseDouble(mathcat.getText()));
                        stmt.setDouble(3, Double.parseDouble(mathexam.getText()));
                        stmt.setDouble(4, Double.parseDouble(mathtotal.getText()));
                        stmt.setString(5, mathgrade.getText());
                        stmt.setString(6, mathcomment.getText());
                        stmt.setDouble(7, Double.parseDouble(engcat.getText()));
                        stmt.setDouble(8, Double.parseDouble(engexam.getText()));
                        stmt.setDouble(9, Double.parseDouble(engtotal.getText()));
                        stmt.setString(10, enggrade.getText());
                        stmt.setString(11, engcomment.getText());
                        stmt.setDouble(12, Double.parseDouble(kiscat.getText()));
                        stmt.setDouble(13, Double.parseDouble(kisexam.getText()));
                        stmt.setDouble(14, Double.parseDouble(kistotal.getText()));
                        stmt.setString(15, kisgrade.getText());
                        stmt.setString(16, kiscomment.getText());
                        stmt.setDouble(17, Double.parseDouble(geogcat.getText()));
                        stmt.setDouble(18, Double.parseDouble(geogexam.getText()));
                        stmt.setDouble(19, Double.parseDouble(geogtotal.getText()));
                        stmt.setString(20, geoggrade.getText());
                        stmt.setString(21, geogcomment.getText());
                        stmt.setDouble(22, Double.parseDouble(biocat.getText()));
                        stmt.setDouble(23, Double.parseDouble(bioexam.getText()));
                        stmt.setDouble(24, Double.parseDouble(biototal.getText()));
                        stmt.setString(25, biograde.getText());
                        stmt.setString(26, biocomment.getText());
                        stmt.setDouble(27, Double.parseDouble(chemcat.getText()));
                        stmt.setDouble(28, Double.parseDouble(chemexam.getText()));
                        stmt.setDouble(29, Double.parseDouble(chemtotal.getText()));
                        stmt.setString(30, chemgrade.getText());
                        stmt.setString(31, chemcomment.getText());
                        stmt.setDouble(32, Double.parseDouble(phyccat.getText()));
                        stmt.setDouble(33, Double.parseDouble(phycexam.getText()));
                        stmt.setDouble(34, Double.parseDouble(phyctotal.getText()));
                        stmt.setString(35, phycgrade.getText());
                        stmt.setString(36, phyccomment.getText());      
                        
                        stmt.execute();
                        
                       JOptionPane.showMessageDialog(null,"Data successfully inserted.","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
                   conn.close();
                        
  }
  catch(Exception ex){
      JOptionPane.showMessageDialog(null, "There is a MySQL error!!!","ERROR",JOptionPane.ERROR_MESSAGE);
  }
      
  }//End of SUBMIT button.
  
  if (e.getSource() == btnClear)
      
  {
      mathcat.setText("");      mathcat.setBackground(Color.WHITE);
      mathexam.setText("");     mathexam.setBackground(Color.WHITE);
      mathtotal.setText("");
      mathgrade.setText("");
      mathcomment.setText("");
      engcat.setText("");       engcat.setBackground(Color.WHITE);
      engexam.setText("");      engexam.setBackground(Color.WHITE);
      engtotal.setText("");
      enggrade.setText("");
      engcomment.setText("");
      kiscat.setText("");       kiscat.setBackground(Color.WHITE);
      kisexam.setText("");      kisexam.setBackground(Color.WHITE);
      kistotal.setText("");
      kisgrade.setText("");
      kiscomment.setText("");
      geogcat.setText("");      geogcat.setBackground(Color.WHITE);
      geogexam.setText("");     geogexam.setBackground(Color.WHITE);
      geogtotal.setText("");
      geoggrade.setText("");
      geogcomment.setText("");
      biocat.setText("");       biocat.setBackground(Color.WHITE);
      bioexam.setText("");      bioexam.setBackground(Color.WHITE);
      biototal.setText("");
      biograde.setText("");
      biocomment.setText("");
      chemcat.setText("");      chemcat.setBackground(Color.WHITE);
      chemexam.setText("");     chemexam.setBackground(Color.WHITE);
      chemtotal.setText("");
      chemgrade.setText("");
      chemcomment.setText("");
      phyccat.setText("");      phyccat.setBackground(Color.WHITE);
      phycexam.setText("");     phycexam.setBackground(Color.WHITE);
      phyctotal.setText("");
      phycgrade.setText("");
      phyccomment.setText("");
  }
  else if(e.getSource() == btnExit)
  {
      JOptionPane.showMessageDialog(null,"BYE","",JOptionPane.INFORMATION_MESSAGE);
      new Login();
      //System.exit(0);
      setVisible(false);
      
  }
  else if(e.getSource() == btnUpdate){
      int x = JOptionPane.showConfirmDialog(null,"Do you really wanna update the records...?","UPDATE...",JOptionPane.YES_NO_OPTION);
      if(x == JOptionPane.YES_OPTION){
         new Update_Records();
         dispose();
         setVisible(false); 
          
      }
      
  }
        
 }
}

   
   /* public static void main(String[] args) {
       
        new ExamSystem();
    }*/
    
}
