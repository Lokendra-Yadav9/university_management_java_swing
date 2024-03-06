package student_management_system;
import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.util.*;

public class Add_Faculty extends JFrame implements ActionListener{
    JLabel title,Sname,Fname,Emplyee_id,emp_no,Date_of_birth,Address,Phone,Email_id,Class,Class_12,Addhar,Qualify,department;
    JTextField s_name,f_name,u_Address,u_Phone,u_email,u_class,u_class_12,u_addhar;
    JButton submit,cancel;
    JDateChooser dc;
    JComboBox<String> Quali_opt,depart_opt;
    
    Random ran=new Random();
    long first4=Math.abs((ran.nextLong() % 9000L)+1000L);
    
    Add_Faculty(){
        
//        getContentPane().setBackground(Color.);
        setLayout(null);
        
         title=new JLabel("Join Faculty Form");
        title.setBounds(210, 30, 250, 25);
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
        
        Emplyee_id=new JLabel("Employee Id");
        Emplyee_id.setBounds(55,150,120,20);
        Emplyee_id.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(Emplyee_id);
        
        emp_no=new JLabel("1533"+first4);
        emp_no.setBounds(160, 150, 130, 25);
        emp_no.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(emp_no); 
        
        
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
        
        
        Qualify=new JLabel("Qualification");
        Qualify.setBounds(55,350,120,20);
        Qualify.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(Qualify);
        
        String []course={"","B.tech","BA","BSc","BCom","Mbbs","BBA","MA","MSc","MCom","BCA"};
        Quali_opt=new JComboBox<>(course);
        Quali_opt.setBounds(150, 350, 130, 25);
        Quali_opt.setSelectedIndex(0);
        Quali_opt.setFont(new Font("Tahona",Font.BOLD,12));
        add(Quali_opt);
        
        department=new JLabel("Department");
        department.setBounds(330,350,150,20);
        department.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(department);
        
        String []branch={"","Computer Science","IT","E & C","E & I","Machenical Engg","Civil Engg"};
        depart_opt=new JComboBox<>(branch);
        depart_opt.setSelectedIndex(0);
        depart_opt.setBounds(450, 350, 130, 25);
        depart_opt.setFont(new Font("Tahona",Font.BOLD,12));
        add(depart_opt);
        
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
            String employee_no=emp_no.getText();
            String dob=((JTextField)dc.getDateEditor().getUiComponent()).getText();
            String address=u_Address.getText();
            String phone =u_Phone.getText();
            String email=u_email.getText();
            String class10=u_class.getText();
            String class12=u_class_12.getText();
            String addhar=u_addhar.getText();
            String Qulification=(String)Quali_opt.getSelectedItem();
            String dapartment=(String) depart_opt.getSelectedItem();
            
            try{
                conn con=new conn();
                String query="INSERT INTO new_teacher VALUES('"+name+"','"+Fname+"','"+employee_no+"','"+dob+"','"+address+"','"+phone+"','"+email+"','"+class10+"','"+class12+"','"+addhar+"','"+Qulification+"','"+dapartment+"')";
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Faculty Details Is Inserted Successfully");
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
        new Add_Faculty();
    }

}

