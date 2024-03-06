package student_management_system;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;
import java.awt.event.*;

public class update_Student_info extends JFrame implements ActionListener {
    
    Choice scroll;
    JLabel Sname,Sfname,Srollno,Sdob,SXth,SXII,SAadhar; 
    JLabel rollNo;
    JTextField Saddress,Sphone,Semail,Scourse,Sbranch;
    JButton submit,cancel;
   
    update_Student_info(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel heading =new JLabel("Update Student Details: ");
        heading.setFont(new Font("Times New Roman",Font.ITALIC,45));
        heading.setBounds(10,20,600,55);
        add(heading);
        
        JLabel search_roll=new JLabel("Select Roll No. ");
        search_roll.setBounds(60,100,120,17);
        search_roll.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(search_roll);
        
        scroll=new Choice();
        scroll.setBounds(200, 100, 180, 16);
        add(scroll);
        
        try{
           conn c=new conn();
           ResultSet rs=c.s.executeQuery("SELECT * FROM new_Student");
           while(rs.next()){
            scroll.add(rs.getString("roll_no"));
           }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel name=new JLabel("Name");
        name.setBounds(40,150,100,18);
        name.setFont(new Font("Tahoma",Font.BOLD,18));
        add(name);
        
        Sname=new JLabel();
        Sname.setBounds(200,150,150,18);
        Sname.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(Sname);
        
        JLabel fname=new JLabel("Father's Name");
        fname.setBounds(380,150,150,18);
        fname.setFont(new Font("Tahoma",Font.BOLD,18));
        add(fname);
        
        Sfname=new JLabel();
        Sfname.setBounds(550,150,150,18);
        Sfname.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(Sfname);
        
        rollNo=new JLabel("Roll No.");
        rollNo.setBounds(40,200,100,18);
        rollNo.setFont(new Font("Tahoma",Font.BOLD,18));
        add(rollNo);
        
        Srollno=new JLabel();
        Srollno.setBounds(200,200,150,18);
        Srollno.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(Srollno);
        
        JLabel Dob=new JLabel("Date Of Birth");
        Dob.setBounds(380,200,150,18);
        Dob.setFont(new Font("Tahoma",Font.BOLD,18));
        add(Dob);
        
        Sdob=new JLabel();
        Sdob.setBounds(550,200,150,18);
        Sdob.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(Sdob);
        
        
        
        JLabel address=new JLabel("Address");
        address.setBounds(40,250,100,18);
        address.setFont(new Font("Tahoma",Font.BOLD,18));
        add(address);
        
        Saddress=new JTextField();
        Saddress.setBounds(200,250 ,150 ,30 );
        Saddress.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(Saddress);
        
        
        JLabel Phone=new JLabel("Phone");
        Phone.setBounds(380,250,150,18);
        Phone.setFont(new Font("Tahoma",Font.BOLD,18));
        add(Phone);
        
        Sphone=new JTextField();
        Sphone.setBounds(550,250 ,150 ,30);
        Sphone.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(Sphone);
        
       
        
        
        JLabel Email=new JLabel("Email");
        Email.setBounds(40,300,100,18);
        Email.setFont(new Font("Tahoma",Font.BOLD,18));
        add(Email);
        
        Semail=new JTextField();
        Semail.setBounds(200,300 ,150 ,30 );
        Semail.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(Semail);
        
        
        
        JLabel Xth=new JLabel("Class Xth(%)");
        Xth.setBounds(380,300,150,18);
        Xth.setFont(new Font("Tahoma",Font.BOLD,18));
        add(Xth);
        
        SXth=new JLabel();
        SXth.setBounds(550,300,150,18);
        SXth.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(SXth);
        
        JLabel XII=new JLabel("Class XII(%)");
        XII.setBounds(40,350,130,18);
        XII.setFont(new Font("Tahoma",Font.BOLD,18));
        add(XII);
        
        SXII=new JLabel();
        SXII.setBounds(200,350,150,18);
        SXII.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(SXII);
        
        JLabel Aadhar=new JLabel("Aadhar No.");
        Aadhar.setBounds(380,350,150,18);
        Aadhar.setFont(new Font("Tahoma",Font.BOLD,18));
        add(Aadhar);
        
        SAadhar=new JLabel();
        SAadhar.setBounds(550,350,200,18);
        SAadhar.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(SAadhar);
        
        JLabel course=new JLabel("Course");
        course.setBounds(40,400,100,18);
        course.setFont(new Font("Tahoma",Font.BOLD,18));
        add(course);
        
        Scourse=new JTextField();
        Scourse.setBounds(200,400 ,150 ,30 );
        Scourse.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(Scourse);
        
        
        JLabel branch=new JLabel("Branch");
        branch.setBounds(380,400,150,18);
        branch.setFont(new Font("Tahoma",Font.BOLD,18));
        add(branch);
        
        Sbranch=new JTextField();
        Sbranch.setBounds(550,400 ,150 ,30 );
        Sbranch.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(Sbranch);
        
        submit=new JButton("Update");
        submit.setBounds(150,470,150,25);
        submit.setFont(new Font("Tahoma",Font.BOLD,17));
        submit.setBackground(Color.BLACK);
        submit.addActionListener(this);
        submit.setForeground(Color.WHITE);
        add(submit);

        
        cancel=new JButton("Cancel");
        cancel.setBounds(450,470,150,25);
        cancel.setFont(new Font("Tahoma",Font.BOLD,17));
        cancel.setBackground(Color.BLACK);
        cancel.addActionListener(this);
        cancel.setForeground(Color.WHITE);
        add(cancel);
        
        
        try{
            conn c=new conn();
            String Query="SELECT * FROM new_Student WHERE roll_no='"+scroll.getSelectedItem()+"'";
            ResultSet rs=c.s.executeQuery(Query);
            while(rs.next()){
                Sname.setText(rs.getString("Stu_name"));
                Sfname.setText(rs.getString("father_name"));
                Srollno.setText(rs.getString("roll_no"));
                Sdob.setText(rs.getString("date_of_birth"));
                SXth.setText(rs.getString("class10"));
                SXII.setText(rs.getString("class12"));
                SAadhar.setText(rs.getString("addhar"));
                
                Saddress.setText(rs.getString("address"));
                Sphone.setText(rs.getString("phone"));
                Semail.setText(rs.getString("Email"));
                Scourse.setText(rs.getString("course"));
                Sbranch.setText(rs.getString("branch"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        scroll.addItemListener(new ItemListener(){
                 public void itemStateChanged(ItemEvent ie){ 
                      try{
                   conn c=new conn();
                   String Query="SELECT * FROM new_Student WHERE roll_no='"+scroll.getSelectedItem()+"'";
                    ResultSet rs=c.s.executeQuery(Query);
                    while(rs.next()){
                Sname.setText(rs.getString("Stu_name"));
                Sfname.setText(rs.getString("father_name"));
                Srollno.setText(rs.getString("roll_no"));
                Sdob.setText(rs.getString("date_of_birth"));
                SXth.setText(rs.getString("class10"));
                SXII.setText(rs.getString("class12"));
                SAadhar.setText(rs.getString("addhar"));
                
                Saddress.setText(rs.getString("address"));
                Sphone.setText(rs.getString("phone"));
                Semail.setText(rs.getString("Email"));
                Scourse.setText(rs.getString("course"));
                Sbranch.setText(rs.getString("branch"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
                     
                 }
        });
        
        
        setLocation(450,100);
        setSize(750,600);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String Eroll_no=Srollno.getText();
        String Uaddress=Saddress.getText();
        String Uphone=Sphone.getText();
        String Uemail=Semail.getText();
        String Ucourse=Scourse.getText();
        String Ubranch=Sbranch.getText();
        if(ae.getSource()==submit){ 
            try{
                conn con =new conn();
                String query = "UPDATE new_Student SET address = '" + Uaddress + "', phone = '" + Uphone + "', Email = '" + Uemail + "', course = '" + Ucourse + "', branch = '" + Ubranch + "' WHERE roll_no = '" + Eroll_no + "'";
                con.s.executeUpdate(query);  
                JOptionPane.showMessageDialog(null, "Data is Updated successfully");
//                System.out.println("Executing SQL Query: " + query);
                 setVisible(false);
            }catch(Exception e){
              e.printStackTrace();
            }
        }else if(ae.getSource()==cancel){
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new update_Student_info();
    }
}
