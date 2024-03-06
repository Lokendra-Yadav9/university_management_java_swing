package student_management_system;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class Student_fee extends JFrame implements ActionListener{
    
    Choice scroll;
    JComboBox<String> course,branch,semester;
    JLabel Sname,Sfname,totalAmount;
    JButton update,pay,back;
    
    Student_fee(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        JLabel heading =new JLabel("Fee Submission Form");
        heading.setBounds(10, 0, 450, 40);
        heading.setFont(new Font("tahoma",Font.BOLD,35));
        add(heading);
        
        JLabel select =new JLabel("Select Roll No.");
        select.setBounds(10, 100, 130, 25);
        select.setFont(new Font("tahoma",Font.PLAIN,18));
        add(select);
        
        scroll =new Choice();
        scroll.setBounds(170, 100, 150, 20);
        scroll.setFont(new Font("tahoma",Font.PLAIN,15));
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
        
       
        
        ImageIcon imgg=new ImageIcon(ClassLoader.getSystemResource("img/fee.jpg"));
        Image igg=imgg.getImage().getScaledInstance(320, 310, Image.SCALE_SMOOTH);
        ImageIcon img=new ImageIcon(igg);
        JLabel image=new JLabel(img);
        image.setBounds(360, 80, 320,310);
        add(image);
        
        JLabel name =new JLabel("Name");
        name.setBounds(10, 150, 150, 25);
        name.setFont(new Font("tahoma",Font.BOLD,18));
        add(name);
        
        Sname =new JLabel();
        Sname.setBounds(170, 150, 200, 25);
        Sname.setFont(new Font("tahoma",Font.PLAIN,16));
        add(Sname);
        
        JLabel fname =new JLabel("Father's Name");
        fname.setBounds(10, 200, 150, 25);
        fname.setFont(new Font("tahoma",Font.BOLD,18));
        add(fname);
        
        Sfname =new JLabel();
        Sfname.setBounds(170, 200, 200, 25);
        Sfname.setFont(new Font("tahoma",Font.PLAIN,16));
        add(Sfname);
        
        JLabel Course=new JLabel("Course");
        Course.setBounds(10, 250, 150, 25);
        Course.setFont(new Font("tahoma",Font.BOLD,18));
        add(Course);
        
        String []courses={"","B.tech","BA","BSc","BCom","Mbbs","BBA","MA","MSc","MCom","BCA"};
        course=new JComboBox<>(courses);
        course.setBounds(170, 250, 150, 20);
        course.setBackground(Color.WHITE);
        course.setFont(new Font("tahoma",Font.PLAIN,15));
        add(course);
        
        JLabel Branch=new JLabel("Branch");
        Branch.setBounds(10, 300, 150, 25);
        Branch.setFont(new Font("tahoma",Font.BOLD,18));
        add(Branch);
        
        String []branchs={"","Computer Science and Engineering",
    "Electronics and Communication Engineering",
    "Mechanical Engineering",
    "Civil Engineering",
    "Electrical Engineering",
    "Chemical Engineering",
    "Aerospace Engineering",
    "Information Technology",
      "English",
    "History",
    "Psychology",
    "Sociology",
    "Political Science",
    "Economics",
    "Anthropology",
    "Philosophy",  
    "Physics",
    "Chemistry",
    "Mathematics",
    "Biology",
    "Environmental Science",
    "Geology",
    "Computer Science",
    "Statistics",  
     "Accounting",
    "Finance",
    "Marketing",
    "Business Management",
    "Economics",
    "Entrepreneurship",
    "International Business",
    "General Medicine",
    "Surgery",
    "Pediatrics",
    "Obstetrics and Gynecology",
    "Radiology",
    "Orthopedics",
    "Dermatology",
    "Finance",
    "Marketing",
    "Human Resources",
    "Operations Management",
    "International Business",
    "Entrepreneurship",
    "Business Analytics",
    "English",
    "History",
    "Sociology",
    "Political Science",
    "Economics",
    "Psychology",
    "Linguistics",
     "Physics",
    "Chemistry",
    "Mathematics",
    "Biology",
    "Computer Science",
    "Environmental Science",
    "Geology",
     "Accounting",
    "Finance",
    "Marketing",
    "Business Management",
    "Economics",
    "International Business",
    "Software Development",
    "Web Development",
    "Database Management",
    "Networking",
    "Artificial Intelligence",
    "Mobile App Development",
        };
        branch=new JComboBox<>(branchs);
        branch.setBounds(170, 300, 150, 20);
        branch.setBackground(Color.WHITE);
        branch.setFont(new Font("tahoma",Font.PLAIN,15));
        add(branch);
        
        JLabel Semester=new JLabel("Semester");
        Semester.setBounds(10,350, 150, 25);
        Semester.setFont(new Font("tahoma",Font.BOLD,18));
        add(Semester);
        
        String[] semesters={"","1st semester","2nd semester","3rd semester","4th semester","5th semester","6th semester","7th semester","8th semester",};
        semester=new JComboBox<>(semesters);
        semester.setBounds(170, 350, 150, 20);
        semester.setBackground(Color.WHITE);
        semester.setFont(new Font("tahoma",Font.PLAIN,15));
        add(semester);
        
        JLabel total=new JLabel("Tatal Payable Amount -");
        total.setBounds(10,410, 350, 25);
        total.setFont(new Font("tahoma",Font.BOLD,18));
        add(total);
          
         totalAmount=new JLabel();
        totalAmount.setBounds(250,410, 350, 25);
        totalAmount.setFont(new Font("tahoma",Font.BOLD,18));
        add(totalAmount);
        
        update=new JButton("Update");
        update.setBounds(100,460, 100, 25);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        update.setFont(new Font("tahoma",Font.BOLD,14));
        add(update);
        
        pay=new JButton("Pay");
        pay.setBounds(250,460, 100, 25);
        pay.setBackground(Color.BLACK);
        pay.setForeground(Color.WHITE);
        pay.addActionListener(this);
        pay.setFont(new Font("tahoma",Font.BOLD,14));
        add(pay);
        
        back=new JButton("Back");
        back.setBounds(400,460, 100, 25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setFont(new Font("tahoma",Font.BOLD,14));
        add(back);
        
         try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("SELECT * FROM new_Student WHERE roll_no='"+scroll.getSelectedItem()+"'");
            while(rs.next()){
                Sname.setText(rs.getString("Stu_name"));
                Sfname.setText(rs.getString("father_name"));
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
            }
        }catch(Exception e){
            e.printStackTrace();
        }
                     
                 }
        });
        
        setLocation(500,100);
        setSize(700,550);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==update){
            String course_name=course.getSelectedItem().toString();
            String barnch_name=branch.getSelectedItem().toString();
            String Semester_name=semester.getSelectedItem().toString();
            
            if(Semester_name.equals("1st semester")){
                Semester_name="semester1";
            }
            else if(Semester_name.equals("2nd semester")){
               Semester_name="semester2"; 
            }
            else if(Semester_name.equals("3rd semester")){
               Semester_name="semester3"; 
            }else if(Semester_name.equals("4th semester")){
               Semester_name="semester4"; 
            }else if(Semester_name.equals("5th semester")){
               Semester_name="semester5"; 
            }
            else if(Semester_name.equals("6th semester")){
               Semester_name="semester6"; 
            }
            else if(Semester_name.equals("7th semester")){
               Semester_name="semester7"; 
            }
            else if(Semester_name.equals("8th semester")){
               Semester_name="semester8"; 
            }
            
            try{
                conn c=new conn();
                ResultSet rs=c.s.executeQuery("SELECT* FROM fee_details WHERE course='"+course_name+"'");
                while(rs.next()){
                    totalAmount.setText(rs.getString(Semester_name));
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==pay){
            String roll_no=scroll.getSelectedItem();
            String course_name=course.getSelectedItem().toString();
            String barnch_name=branch.getSelectedItem().toString();
            String Semester_name=semester.getSelectedItem().toString();
            String total_Amount=totalAmount.getText();
            try{
                conn c=new conn();
                String query="insert into fee_pay values ('"+roll_no+"','"+course_name+"','"+barnch_name+"','"+Semester_name+"','"+total_Amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Fee Submitted Successfully");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==back){
            setVisible(false);
        }
    }
    
    public static void main(String[]args){
        new Student_fee();
    }
}
