package student_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Project extends JFrame implements ActionListener{
    
    JMenuItem new_Student,new_faculty, FacultyInfo,StudentInfo,Facultyleave,Studentleave,F_leave_Details,Stu_leave_Details,Exam_result,enter_marks,U_fac_info,U_stu_info,
            fee_structure ,Fee_form,Notepad,Calculator,ex,ab ;
    
    Project(){
        setLocation(0,0);
        setSize(1540,850);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ImageIcon imgc=new ImageIcon(ClassLoader.getSystemResource("img/third.jpg"));
        Image ig=imgc.getImage().getScaledInstance(1540, 850, Image.SCALE_DEFAULT);
        ImageIcon igc=new ImageIcon(ig);
        JLabel image =new JLabel(igc);
        add(image);
        
        JMenuBar mb=new JMenuBar();
        
        JMenu newInformation = new JMenu("New Information");
        newInformation.setForeground(Color.BLUE);
        newInformation.addActionListener(this);
        mb.add(newInformation);
        
        new_Student=new JMenuItem("Add new student");
        new_Student.setBackground(Color.WHITE);
        new_Student.setForeground(Color.blue);
        new_Student.addActionListener(this);
        newInformation.add(new_Student);
        
        new_faculty=new JMenuItem("Add new Faculty");
        new_faculty.setBackground(Color.WHITE);
        new_faculty.setForeground(Color.blue);
        new_faculty.addActionListener(this);
        newInformation.add(new_faculty);
        
        JMenu Details = new JMenu("Details");
        Details.setForeground(Color.RED);
        mb.add(Details);
        
        FacultyInfo=new JMenuItem("View Faculty Info");
        FacultyInfo.setBackground(Color.WHITE);
        FacultyInfo.setForeground(Color.red);
        FacultyInfo.addActionListener(this);
        Details.add(FacultyInfo);
        
        StudentInfo=new JMenuItem("View Student Info");
        StudentInfo.setBackground(Color.WHITE);
        StudentInfo.setForeground(Color.red);
        StudentInfo.addActionListener(this);
        Details.add(StudentInfo);
        
        
        //Leave 
        JMenu leave = new JMenu("Apply Leave");
        leave.setForeground(Color.BLUE);
        mb.add(leave);
        
        Facultyleave=new JMenuItem("Apply Faculty Leave");
        Facultyleave.setBackground(Color.WHITE);
        Facultyleave.setForeground(Color.BLUE);
        Facultyleave.addActionListener(this);
        leave.add(Facultyleave);
        
        Studentleave=new JMenuItem("Apply Student Leave");
        Studentleave.setBackground(Color.WHITE);
        Studentleave.setForeground(Color.BLUE);
        Studentleave.addActionListener(this);
        leave.add(Studentleave);
        
        //Leave Details
        JMenu leaveDetails = new JMenu("Leave Details");
        leaveDetails.setForeground(Color.RED);
        mb.add(leaveDetails);
        
        F_leave_Details=new JMenuItem("Faculty Leave Details");
        F_leave_Details.setBackground(Color.WHITE);
        F_leave_Details.setForeground(Color.red);
        F_leave_Details.addActionListener(this);
        leaveDetails.add(F_leave_Details);
        
        Stu_leave_Details=new JMenuItem("Student Leave Details");
        Stu_leave_Details.setBackground(Color.WHITE);
        Stu_leave_Details.setForeground(Color.red);
        Stu_leave_Details.addActionListener(this);
        leaveDetails.add(Stu_leave_Details);
        
        //Exams
        JMenu Exam = new JMenu("Examination");
        Exam.setForeground(Color.BLUE);
        mb.add(Exam);
        
        Exam_result=new JMenuItem("Examination Result");
        Exam_result.setBackground(Color.WHITE);
        Exam_result.setForeground(Color.blue);
        Exam_result.addActionListener(this);
        Exam.add(Exam_result);
        
        enter_marks=new JMenuItem("Result Upload");
        enter_marks.setBackground(Color.WHITE);
        enter_marks.setForeground(Color.blue);
        enter_marks.addActionListener(this);
        Exam.add(enter_marks);
        
        //update
        JMenu Update = new JMenu("Update Details");
        Update.setForeground(Color.RED);
        mb.add(Update);
        
        U_fac_info=new JMenuItem("Update Faculty Info");
        U_fac_info.setBackground(Color.WHITE);
        U_fac_info.setForeground(Color.red);
        U_fac_info.addActionListener(this);
        Update.add(U_fac_info);
        
        U_stu_info=new JMenuItem("Update Student Info");
        U_stu_info.setBackground(Color.WHITE);
        U_stu_info.setForeground(Color.red);
        U_stu_info.addActionListener(this);
        Update.add(U_stu_info );
        
        //fee
        JMenu Fee = new JMenu("Fee Details");
        Fee.setForeground(Color.BLUE);
        mb.add(Fee);
        
        fee_structure=new JMenuItem("Fee Structure");
        fee_structure.setBackground(Color.WHITE);
        fee_structure.setForeground(Color.blue);
        fee_structure.addActionListener(this);
        Fee.add(fee_structure);
        
        Fee_form=new JMenuItem("Fee Fill Form");
        Fee_form.setBackground(Color.WHITE);
        Fee_form.setForeground(Color.blue);
        Fee_form.addActionListener(this);
        Fee.add(Fee_form );
        
        //utility
        JMenu Utility = new JMenu("Utility");
        Utility.setForeground(Color.RED);
        mb.add(Utility);
        
        Notepad=new JMenuItem("Notepad");
        Notepad.setBackground(Color.WHITE);
        Notepad.setForeground(Color.red);
        Notepad.addActionListener(this);
        Utility.add(Notepad);
        
        Calculator=new JMenuItem("Calculator");
        Calculator.setBackground(Color.WHITE);
        Calculator.setForeground(Color.red);
        Calculator.addActionListener(this);
        Utility.add(Calculator);
        
        //about
         JMenu about = new JMenu("About");
        about.setForeground(Color.blue);
        mb.add(about);
        
        ab=new JMenuItem("About Me");
        ab.setForeground(Color.blue);
        ab.addActionListener(this);
        about.add(ab);
        
        
        //Exit
         JMenu Exit = new JMenu("Exit");
        Exit.setForeground(Color.red);
        mb.add(Exit);
        
        ex=new JMenuItem("Exit");
        ex.setForeground(Color.red);
        ex.addActionListener(this);
        Exit.add(ex);
        
        setJMenuBar(mb);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String msg=ae.getActionCommand();
        if(msg.equals("Exit")){
            setVisible(false);    
        }
        else if(msg.equals("Calculator")){
            try{
                Runtime.getRuntime().exec("calc.exe");
            }catch(Exception e){
                
            }
            
        }
        else if(msg.equals("Notepad")){
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }catch(Exception e){
                
            }
        }
        else if(msg.equals("Fee Fill Form")){
            
        }
        else if(msg.equals("Fee Structure")){
            new Fee_Structure();
        }
        else if(msg.equals("Apply Faculty Leave")){
            new teacher_leave();
        }
        else if(msg.equals("Apply Student Leave")){
            new Student_Leave();
        }
        else if(msg.equals("Faculty Leave Details")){
            new Faculty_leave_details();
        }
        else if(msg.equals("View Student Info")){
            new Student_details();
        }
        else if(msg.equals("View Faculty Info")){
            new Teacher_Details();
        }
        else if(msg.equals("Student Leave Details")){
            new Student_leave_details();
        }
        else if(msg.equals("Update Faculty Info")){
            new update_faculty_info();
        }
        else if(msg.equals("Update Student Info")){
            new update_Student_info();
        }
        else if(msg.equals("Add new Faculty")){
            new Add_Faculty();
        }
        else if(msg.equals("Add new student")){
            new Add_student();
        }
         else if(msg.equals("Examination Result")){
            new Exams_results();
        } else if(msg.equals("Result Upload")){
            new Enter_marks();
        }
        else if(msg.equals("About Me")){
            new About_me();
        }
    }
    
    public static void main(String[]args){
        new Project();
    }


}
