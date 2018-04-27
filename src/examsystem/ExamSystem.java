
package examsystem;

/**
 *
 * @author Litoh
 */
import javax.swing.*;
import java.awt.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ExamSystem extends JFrame{
    //cat
    private JTextField mathcat=new JTextField();
    private JTextField engcat=new JTextField();
    private JTextField kiscat=new JTextField();
    private JTextField geogcat=new JTextField();
    private JTextField biocat=new JTextField();
    private JTextField chemcat=new JTextField();
    private JTextField phycat=new JTextField();
    
    //exam
    private JTextField mathex=new JTextField();
    private JTextField engex=new JTextField();
    private JTextField kisex=new JTextField();
    private JTextField geogex=new JTextField();
    private JTextField bioex=new JTextField();
    private JTextField chemex=new JTextField();
    private JTextField phyex=new JTextField();
    
    //total lables
     private JLabel mathtotal=new JLabel();
     private JLabel engtotal=new JLabel();
     private JLabel kistotal=new JLabel();
     private JLabel geogtotal=new JLabel();
     private JLabel biototal=new JLabel();
     private JLabel chemtotal=new JLabel();
     private JLabel phytotal=new JLabel();
     
     //grade lables
     private JLabel mathgrade=new JLabel();
     private JLabel enggrade=new JLabel();
     private JLabel kisgrade=new JLabel();
     private JLabel geoggrade=new JLabel();
     private JLabel biograde=new JLabel();
     private JLabel chemgrade=new JLabel();
     private JLabel phygrade=new JLabel();
     
     //comments lables
      private JLabel mathcomment=new JLabel();
     private JLabel engcomment=new JLabel();
     private JLabel kiscomment=new JLabel();
     private JLabel geogcomment=new JLabel();
     private JLabel biocomment=new JLabel();
     private JLabel chemcomment=new JLabel();
     private JLabel phycomment=new JLabel();
     
     private static JButton compute;
    public ExamSystem(){
         
       
        JPanel p1=new JPanel(new GridLayout(8,6,5,5));
        
        
        
        add(p1, BorderLayout.CENTER);
         TitledBorder centerBorder = BorderFactory.createTitledBorder("Enter Scores For a Student: CATs and Main Exam");
          centerBorder.setTitleJustification(TitledBorder.CENTER);
          p1.setBorder(centerBorder);
        p1.setBackground(Color.decode("#C0C0C0"));
        p1.add(new JLabel("")); 
        p1.add(new JLabel("CAT"));
        p1.add(new JLabel("EXAM"));
        p1.add(new JLabel("TOTAL"));
        p1.add(new JLabel("GRADE"));
        p1.add(new JLabel("COMMENTS"));
        
        p1.add(new JLabel("Mathematics"));
        p1.add(mathcat);
        p1.add(mathex);
        p1.add(mathtotal);
        p1.add(mathgrade);
        p1.add(mathcomment);
        
        p1.add(new JLabel("English"));
        p1.add(engcat);
        p1.add(engex);
        p1.add(engtotal);
        p1.add(enggrade);
        p1.add(engcomment);
        
        p1.add(new JLabel("Kiswahili"));
        p1.add(kiscat);
        p1.add(kisex);
        p1.add(kistotal);
        p1.add(kisgrade);
        p1.add(kiscomment);
        
        p1.add(new JLabel("Geography"));
        p1.add(geogcat);
        p1.add(geogex);
        p1.add(geogtotal);
        p1.add(geoggrade);
        p1.add(geogcomment);
        
        p1.add(new JLabel("Biology"));
        p1.add(biocat);
        p1.add(bioex);
        p1.add(biototal);
        p1.add(biograde);
        p1.add(biocomment);
        
        p1.add(new JLabel("Chemistry"));
        p1.add(chemcat);
        p1.add(chemex);
        p1.add(chemtotal);
        p1.add(chemgrade);
        p1.add(chemcomment);
        
        p1.add(new JLabel("Physics"));
        p1.add(phycat);
        p1.add(phyex);
        p1.add(phytotal);
        p1.add(phygrade);
        p1.add(phycomment);
    
    //p1.setBorder(new TitledBorder("Enter Scores For a Student: CATs and Main Exam"));
    
    compute=new JButton("Compute");
    compute.setBackground(Color.BLUE);
    compute.addActionListener(new ActionListener(){                             
        //@Override
        public void actionPerformed(ActionEvent e){
            
            if(!((mathcat.getText().isEmpty())&& mathex.getText().isEmpty())){
                int mcat=Integer.parseInt(mathcat.getText());
                int mexam=Integer.parseInt(mathex.getText());
                if(mcat<0 || mcat>40){
                    JOptionPane.showMessageDialog(null, "wrong input for maths CAT please check out!","error",JOptionPane.ERROR_MESSAGE);
                }
                else if(mexam<0 || mexam>60){
                   JOptionPane.showMessageDialog(null, "wrong input for maths EXAM please check out!","error",JOptionPane.ERROR_MESSAGE); 
                }
                //else if(mexam<0 || mexam>60 && mcat<0 || mcat>40){
                   //JOptionPane.showMessageDialog(null, "wrong input for EXAM and CAT please check out!","error",JOptionPane.ERROR_MESSAGE); 
                //}
                else{
                    int total=mcat+mexam;
                    mathtotal.setText(Integer.toString(total));
                    
                     String Grades=Grades(total);
                     mathgrade.setText(Grades);
                     
                     String Comments=Comments(total);
                     mathcomment.setText(Comments);
                }
       
        
            }
            //else{
              //JOptionPane.showMessageDialog(null, "kindly provide the required fields","notice",JOptionPane.ERROR_MESSAGE);   
            //}
            
            if(!((engcat.getText().isEmpty())&& engex.getText().isEmpty())){
                int ecat=Integer.parseInt(engcat.getText());
                int engexam=Integer.parseInt(engex.getText());
                if(ecat<0 || ecat>40){
                    JOptionPane.showMessageDialog(null, "wrong input for English CAT please check out!","error",JOptionPane.ERROR_MESSAGE); 
                }
                else if(engexam<0 || engexam>60){
                   JOptionPane.showMessageDialog(null, "wrong input for English EXAM please check out!","error",JOptionPane.ERROR_MESSAGE); 
                }
                else{
                    int total=ecat+engexam;
                    engtotal.setText(Integer.toString(total));
                    
                    String Grades=Grades(total);
                     enggrade.setText(Grades);
                     
                     String Comments=Comments(total);
                     engcomment.setText(Comments);
                }
        
            }  
          
            
          if(!((kiscat.getText().isEmpty())&& kisex.getText().isEmpty())){
                int kcat=Integer.parseInt(kiscat.getText());
                int kexam=Integer.parseInt(kisex.getText());
                if(kcat<0 || kcat>40){
                    JOptionPane.showMessageDialog(null, "wrong input for Kiswahili CAT please check out!","error",JOptionPane.ERROR_MESSAGE); 
                }
                else if(kexam<0 || kexam>60){
                   JOptionPane.showMessageDialog(null, "wrong input for Kiswahili EXAM please check out!","error",JOptionPane.ERROR_MESSAGE);
                }
                else{
                    int total=kcat+kexam;
                    kistotal.setText(Integer.toString(total));
                    
                    String Grades=Grades(total);
                     kisgrade.setText(Grades);
                     
                     String Comments=Comments(total);
                     kiscomment.setText(Comments);
                }
        
            } 
          
          if(!((geogcat.getText().isEmpty())&& geogex.getText().isEmpty())){
                int gcat=Integer.parseInt(geogcat.getText());
                int gexam=Integer.parseInt(geogex.getText());
                if(gcat<0 || gcat>40){
                    JOptionPane.showMessageDialog(null, "wrong input for Geography CAT please check out!","error",JOptionPane.ERROR_MESSAGE); 
                }
                else if(gexam<0 || gexam>60){
                   JOptionPane.showMessageDialog(null, "wrong input for Geography EXAM please check out!","error",JOptionPane.ERROR_MESSAGE); 
                }
                else{
                    int total=gcat+gexam;
                    geogtotal.setText(Integer.toString(total));
                    
                    String Grades=Grades(total);
                     geoggrade.setText(Grades);
                     
                     String Comments=Comments(total);
                     geogcomment.setText(Comments);
                }
        
            } 
          
          if(!((biocat.getText().isEmpty())&& bioex.getText().isEmpty())){
                int bcat=Integer.parseInt(biocat.getText());
                int bexam=Integer.parseInt(bioex.getText());
                if(bcat<0 || bcat>40){
                    JOptionPane.showMessageDialog(null, "wrong input for Biology CAT please check out!","error",JOptionPane.ERROR_MESSAGE); 
                }
                else if(bexam<0 || bexam>60){
                   JOptionPane.showMessageDialog(null, "wrong input for Biology EXAM please check out!","error",JOptionPane.ERROR_MESSAGE);
                }
                else{
                    int total=bcat+bexam;
                    biototal.setText(Integer.toString(total));
                    
                    String Grades=Grades(total);
                     biograde.setText(Grades);
                     
                     String Comments=Comments(total);
                     biocomment.setText(Comments);
                }
        
            }
          
          if(!((chemcat.getText().isEmpty())&& chemex.getText().isEmpty())){
                int chcat=Integer.parseInt(chemcat.getText());
                int chexam=Integer.parseInt(chemex.getText());
                if(chcat<0 || chcat>40){
                    JOptionPane.showMessageDialog(null, "wrong input for Chemistry CAT please check out!","error",JOptionPane.ERROR_MESSAGE);
                }
                else if(chexam<0 || chexam>60){
                   JOptionPane.showMessageDialog(null, "wrong input for Chemistry EXAM please check out!","error",JOptionPane.ERROR_MESSAGE); 
                }
                else{
                    int total=chcat+chexam;
                    chemtotal.setText(Integer.toString(total));
                    
                    String Grades=Grades(total);
                     chemgrade.setText(Grades);
                     
                     String Comments=Comments(total);
                     chemcomment.setText(Comments);
                }
        
            } 
          
          if(!((phycat.getText().isEmpty())&& phyex.getText().isEmpty())){
                int pcat=Integer.parseInt(phycat.getText());
                int pexam=Integer.parseInt(phyex.getText());
                if(pcat<0 || pcat>40){
                    JOptionPane.showMessageDialog(null, "wrong input for Physics CAT please check out!","error",JOptionPane.ERROR_MESSAGE); 
                }
                else if(pexam<0 || pexam>60){
                   JOptionPane.showMessageDialog(null, "wrong input for Physics EXAM please check out!","error",JOptionPane.ERROR_MESSAGE);
                }
                else{
                    int total=pcat+pexam;
                    phytotal.setText(Integer.toString(total));
                    
                    String Grades=Grades(total);
                     phygrade.setText(Grades);
                     
                     String Comments=Comments(total);
                     phycomment.setText(Comments);
                }
        
            } 
            
        }
    });
    
    JButton clear=new JButton("Clear");
    clear.setBackground(Color.ORANGE);
    clear.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            mathcat.setText(null);
            mathex.setText(null);
            mathtotal.setText(null);
            mathgrade.setText(null);
            mathcomment.setText(null);
            
            engcat.setText(null);
            engex.setText(null);
            engtotal.setText(null);
            enggrade.setText(null);
            engcomment.setText(null);
            
            kiscat.setText(null);
            kisex.setText(null);
            kistotal.setText(null);
            kisgrade.setText(null);
            kiscomment.setText(null);
            
            geogcat.setText(null);
            geogex.setText(null);
            geogtotal.setText(null);
            geoggrade.setText(null);
            geogcomment.setText(null);
            
            biocat.setText(null);
            bioex.setText(null);
            biototal.setText(null);
            biograde.setText(null);
            biocomment.setText(null);
            
            chemcat.setText(null);
            chemex.setText(null);
            chemtotal.setText(null);
            chemgrade.setText(null);
            chemcomment.setText(null);
            
            phycat.setText(null);
            phyex.setText(null);
            phytotal.setText(null);
            phygrade.setText(null);
            phycomment.setText(null);
            
        }
    });
    JButton exit=new JButton("Exit");
    exit.setBackground(Color.RED);
    exit.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            JOptionPane.showMessageDialog(null, "Do you want to quit..?","QUIT", JOptionPane.CLOSED_OPTION);
            System.exit(0);
            
        }
    });
    
    
     JPanel p2=new JPanel(new FlowLayout());
     p2.setBackground(Color.GRAY);
    p2.add(compute);
    p2.add(clear);
    p2.add(exit);
     p2.setBorder(new TitledBorder("Computation Section"));   
    add(p2,BorderLayout.SOUTH);
    
 
    
    
    }

    private String Grades(int total){
     if(total>=80){return "A";} 
     else if(total>=75 && total<80){return "A-";}
     else if(total>=70 && total<75){return "B+";}
     else if(total>=65 && total<70){return "B";}
     else if(total>=60 && total<65){return "B-";}
     else if(total>=55 && total<60){return "C+";}
     else if(total>=50 && total<55){return "C";}
     else if(total>=45 && total<50){return "C-";}
     else if(total>=40 && total<45){return "D+";}
     else if(total>=35 && total<40){return "D";}
     else if(total>=34 && total<35){return "D-";}
      else{return "E";}
    }
   
    private String Comments(int total){
        if(total>=80){return"Excellent";}
        else if(total>70 && total<80){return "V.Good";}
        else if(total>=60 && total<70){return "Good";}
        else if(total>=50 && total<60){return "Fair";}
        else if(total>40 && total<50){return "Poor";}
        else{return"Very poor";}
        
   }
    public static void main(String[] args) {
        ExamSystem app = new ExamSystem();
        app.setSize(700, 400);
        app.setTitle("Exam System");
        //app.setTitleJustification(TitledBorder.CENTER);
        app.setLocationRelativeTo(null);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
     
    }
    
}
