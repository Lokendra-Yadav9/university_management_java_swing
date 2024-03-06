package student_management_system;
import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.util.*;

public class Add_student extends JFrame implements ActionListener{
    JLabel title,Sname,Fname,RollNo,roll_no,Date_of_birth,Address,Phone,Email_id,Class,Class_12,Addhar,Course,Branch;
    JTextField s_name,f_name,u_Address,u_Phone,u_email,u_class,u_class_12,u_addhar;
    JButton submit,cancel;
    JDateChooser dc;
    JComboBox<String> course_sel,Branch_sel;
    
    Random ran=new Random();
    long first4=Math.abs((ran.nextLong() % 9000L)+1000L);
    
    Add_student(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
         title=new JLabel("Student Addmission Form");
        title.setBounds(200, 30, 250, 25);
        title.setFont(new Font("Raleway",Font.PLAIN,20));
        add(title);
       
         Sname=new JLabel("Name");
        Sname.setBounds(70,100,80,20);
        Sname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(Sname);
        
         s_name=new JTextField();
        s_name.setBounds(150, 100, 130, 25);
        add(s_name);   
        
         Fname=new JLabel("Father Name");
        Fname.setBounds(330,100,150,20);
        Fname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(Fname);
        
         f_name=new JTextField();
        f_name.setBounds(450, 100, 130, 25);
        add(f_name); 
        
         RollNo=new JLabel("Roll No");
        RollNo.setBounds(70,150,80,20);
        RollNo.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(RollNo);
        
        roll_no=new JLabel("1533"+first4);
        roll_no.setBounds(150, 150, 130, 25);
        roll_no.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(roll_no); 
        
        
        
         Date_of_birth=new JLabel("Date Of Birth");
        Date_of_birth.setBounds(330,150,150,20);
        Date_of_birth.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(Date_of_birth);
        
         dc=new JDateChooser();
        dc.setBounds(450,150,150,25);
        dc.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(dc);
        
        
         Address=new JLabel("Address");
        Address.setBounds(70,200,80,20);
        Address.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(Address);
        
         u_Address=new JTextField();
        u_Address.setBounds(150, 200, 130, 25);
        add(u_Address); 
        
         Phone=new JLabel("Phone");
        Phone.setBounds(330,200,150,20);
        Phone.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(Phone);
        
         u_Phone=new JTextField();
        u_Phone.setBounds(450, 200, 130, 25);
        add(u_Phone);
        
         Email_id=new JLabel("Email Id");
        Email_id.setBounds(70,250,80,20);
        Email_id.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(Email_id);
        
         u_email=new JTextField();
        u_email.setBounds(150, 250, 130, 25);
        add(u_email);
        
         Class=new JLabel("Class X(%)");
        Class.setBounds(330,250,150,20);
        Class.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(Class);
        
         u_class=new JTextField();
        u_class.setBounds(450, 250, 130, 25);
        add(u_class);
        
         Class_12=new JLabel("Class XII(%)");
        Class_12.setBounds(55,300,120,20);
        Class_12.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(Class_12);
        
         u_class_12=new JTextField();
        u_class_12.setBounds(150, 300, 130, 25);
        add(u_class_12);
        
         Addhar=new JLabel("Addhar No.");
        Addhar.setBounds(330,300,150,20);
        Addhar.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(Addhar);
        
         u_addhar=new JTextField();
        u_addhar.setBounds(450, 300, 130, 25);
        add(u_addhar);
        
        
         Course=new JLabel("Course");
        Course.setBounds(70,350,120,20);
        Course.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(Course);
        
        String []course={"","B.tech","BA","BSc","BCom","Mbbs","BBA","MA","MSc","MCom","BCA"};
        course_sel=new JComboBox<>(course);
        course_sel.setBounds(150, 350, 130, 25);
        course_sel.setSelectedIndex(0);
        course_sel.setBackground(Color.WHITE);
        course_sel.setFont(new Font("Tahona",Font.BOLD,12));
        add(course_sel);
        
        Branch=new JLabel("Branch");
        Branch.setBounds(330,350,150,20);
        Branch.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(Branch);
        
        String []branch={"","Computer Science","IT","E & C","E & I","Machenical Engg","Civil Engg"};
        Branch_sel=new JComboBox<>(branch);
        Branch_sel.setBounds(450, 350, 130, 25);
        Branch_sel.setSelectedIndex(0);
        Branch_sel.setBackground(Color.WHITE);
        Branch_sel.setFont(new Font("Tahona",Font.BOLD,12));
        add(Branch_sel);
        
        submit=new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Tahona",Font.BOLD,18));
        submit.addActionListener(this);
        submit.setBounds(120,450,130,30);
        add(submit);
        
         cancel=new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Tahona",Font.BOLD,18));
        cancel.addActionListener(this);
        cancel.setBounds(390,450,130,30);
        add(cancel);
          
        
        setLocation(450,150);
        setSize(650,600);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== submit){
            String name=s_name.getText();
            String Fname=f_name.getText();
            String rollNo=roll_no.getText();
            String dob=((JTextField)dc.getDateEditor().getUiComponent()).getText();
            String address=u_Address.getText();
            String phone =u_Phone.getText();
            String email=u_email.getText();
            String class10=u_class.getText();
            String class12=u_class_12.getText();
            String addhar=u_addhar.getText();
            String course=(String)course_sel.getSelectedItem();
            String branch=(String) Branch_sel.getSelectedItem();
            
            try{
                conn con=new conn();
                String query="INSERT INTO new_Student VALUES('"+name+"','"+Fname+"','"+rollNo+"','"+dob+"','"+address+"','"+phone+"','"+email+"','"+class10+"','"+class12+"','"+addhar+"','"+course+"','"+branch+"')";
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Student Details Is Inserted Successfully");
                setVisible(false);
            }catch(Exception e){
               e.printStackTrace();  
            }
        }
        else{
            setVisible(false);
        }
    }
    
    public static void main(String[]args){
        new Add_student();
    }

}
