package student_management_system;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class Student_Leave extends JFrame implements ActionListener{
    
    Choice scroll;
    JDateChooser datee;
    JRadioButton Hday,Fday;
    JButton submit,cancel;
    ButtonGroup grp;
    
    Student_Leave(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading=new JLabel("Apply For Leave (Student)");
        heading.setBounds(90,30,300,25);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        add(heading);
        
        JLabel roll_search=new JLabel("Search By Roll Number : ");
        roll_search.setBounds(40, 100, 180, 20);
        roll_search.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(roll_search);
        
        scroll=new Choice();
        scroll.setBounds(240, 100, 150, 20);
        add(scroll);
        
        try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("SELECT * FROM new_Student");
            while(rs.next()){
                scroll.add(rs.getString("roll_no"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        
        JLabel date=new JLabel("Select Date ");
        date.setBounds(40,150,150,20);
        date.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(date);
             
        datee=new JDateChooser();
        datee.setBounds(240, 150, 150, 20);
        datee.setBackground(Color.WHITE);
        datee.setForeground(Color.BLACK);
        add(datee);
        
        
        JLabel day=new JLabel("Timing of Leave");
        day.setBounds(40, 200, 200, 20);
        day.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(day);
        
        Hday =new JRadioButton("Half Day");
        Hday.setBounds(240, 200, 90, 20);
        Hday.setFont(new Font("Tahoma",Font.PLAIN,14));
        Hday.setBackground(Color.WHITE);
        add(Hday);
        
        Fday =new JRadioButton("Full Day");
        Fday.setBounds(330, 200, 100, 20);
        Fday.setFont(new Font("Tahoma",Font.PLAIN,14));
        Fday.setBackground(Color.WHITE);
        add(Fday);

        
        grp=new ButtonGroup();
        grp.add(Hday);
        grp.add(Fday);
        
        submit= new JButton("Submit");
        submit.setBounds(60,270,120,25);
        submit.addActionListener(this);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Tahoma",Font.BOLD,17));
        add(submit);
        
        cancel= new JButton("Cancel");
        cancel.setBounds(230,270,120,25);
        cancel.addActionListener(this);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Tahoma",Font.BOLD,17));
        add(cancel);
        
        setLocation(600,100);
        setSize(450,400);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String roll_no=scroll.getSelectedItem();
            String date=((JTextField)datee.getDateEditor().getUiComponent()).getText();
            String duration = null;
            if(Hday.isSelected()){
                duration="Half Day";
            }
            else if(Fday.isSelected()){
                duration="Full Day";
            }

            try{
               conn c=new conn();
               String query="INSERT INTO stu_leave VALUES('"+roll_no+"','"+date+"','"+duration+"')";
               c.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null,"Data Successfully Inserted");
               setVisible(false);
            }
            catch(Exception e){
                 e.printStackTrace();
            }
        }
        else if(ae.getSource()==cancel){
            setVisible(false);
            new Project();
        }
    }
    
    public static void main(String[]args){
        new Student_Leave();
    }
}
