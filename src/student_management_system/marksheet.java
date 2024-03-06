package student_management_system;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.awt.event.*;
import java.awt.print.*;

public class marksheet extends JFrame implements ActionListener,Printable{
    String roll_no;
    JLabel sub1,sub2,sub3,sub4,sub5,mar1,mar2,mar3,mar4,mar5;
    JLabel SName,SrollNo,Subject,SDOb,Ssem,Scourse,Sbranch;
    JButton Print;
    marksheet(String roll_no){
        this.roll_no=roll_no;
        
        setLayout(null);
        
        setTitle("Student Marksheet");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(750, 800);
        setLocation(400,10);

        
        JPanel contentPane;
        contentPane = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon background = new ImageIcon(ClassLoader.getSystemResource("img/sati_lgo.png"));
        Image img = background.getImage();

        Graphics2D g2d = (Graphics2D) g;

   
        float opacity = 0.5f;
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));

       
        g2d.drawImage(img, 250, 250, 250, 250, null);

    
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));

        g.setColor(new Color(255, 255, 255, 100));
        g.fillRect(0, 0, getWidth(), getHeight());
    }
};


       contentPane.setLayout(null); 

         ImageIcon igg=new ImageIcon(ClassLoader.getSystemResource("img/sati_lgo.png"));
            Image img=igg.getImage().getScaledInstance(90, 100, Image.SCALE_SMOOTH);
            ImageIcon imc=new ImageIcon(img);
            JLabel Jimg=new JLabel(imc);
            Jimg.setBounds(20,20, 90, 100);
            contentPane.add(Jimg);
            
            JLabel college=new JLabel("Samrat Ashok Technological Institute Vidisha 464001");
            college.setBounds(130,40 ,800 ,25 );
            college.setForeground(Color.BLACK);
            college.setFont(new Font("tahoma",Font.PLAIN,25));
            contentPane.add(college);
            
            JLabel resultYear=new JLabel("Result Of Examination 2023");
            resultYear.setBounds(250,90 ,400 ,25 );
            resultYear.setFont(new Font("tahoma",Font.BOLD,25));
            contentPane.add(resultYear);
            
            
            
            
            JLabel Name=new JLabel("Name");
            Name.setBounds(70,150 ,150 ,25 );
            Name.setFont(new Font("tahoma",Font.PLAIN,20));
            contentPane.add(Name);
            
            SName=new JLabel();
            SName.setBounds(180,150 ,150 ,25 );
            SName.setFont(new Font("tahoma",Font.PLAIN,18));
            contentPane.add(SName);
            
            
            JLabel rollno=new JLabel("Roll No   ");
            rollno.setBounds(430,150 ,250 ,25 );
            rollno.setFont(new Font("tahoma",Font.PLAIN,20));
            contentPane.add(rollno);
            
            SrollNo =new JLabel();
            SrollNo.setBounds(560,150 ,150 ,25 );
            SrollNo.setFont(new Font("tahoma",Font.PLAIN,18));
            contentPane.add(SrollNo);
            SrollNo.setText(roll_no);
            
            
            JLabel semesters=new JLabel("Semester");
            semesters.setBounds(70,190 ,150 ,25 );
            semesters.setFont(new Font("tahoma",Font.PLAIN,20));
            contentPane.add(semesters);
            
            Ssem=new JLabel();
            Ssem.setBounds(180,190 ,150 ,25 );
            Ssem.setFont(new Font("tahoma",Font.PLAIN,18));
            contentPane.add(Ssem);
           
            
            JLabel dob=new JLabel("Date of Birth");
            dob.setBounds(430,190 ,250 ,25 );
            dob.setFont(new Font("tahoma",Font.PLAIN,19));
            contentPane.add(dob);
            
            SDOb =new JLabel();
            SDOb.setBounds(560,190 ,150 ,25 );
            SDOb.setFont(new Font("tahoma",Font.PLAIN,17));
            contentPane.add(SDOb);
            
            
            
            
            JLabel course=new JLabel("course");
            course.setBounds(70,230 ,150 ,25 );
            course.setFont(new Font("tahoma",Font.PLAIN,20));
            contentPane.add(course);
            
            Scourse=new JLabel();
            Scourse.setBounds(180,230 ,150 ,25 );
            Scourse.setFont(new Font("tahoma",Font.PLAIN,18));
            contentPane.add(Scourse);
           
            
            JLabel Branch=new JLabel("Branch");
            Branch.setBounds(430,230 ,250 ,25 );
            Branch.setFont(new Font("tahoma",Font.PLAIN,19));
            contentPane.add(Branch);
            
            Sbranch =new JLabel();
            Sbranch.setBounds(560,230 ,150 ,25 );
            Sbranch.setFont(new Font("tahoma",Font.PLAIN,17));
            contentPane.add(Sbranch);
            
            
           
            
            
            
            Subject=new JLabel("SUBJECTS");
            Subject.setBounds(70,280 ,150 ,25 );
            Subject.setFont(new Font("tahoma",Font.BOLD,22));
            contentPane.add(Subject);
            
            
            
            sub1=new JLabel();
            sub1.setBounds(75,340 ,150 ,25 );
            sub1.setFont(new Font("tahoma",Font.PLAIN,20));
            contentPane.add(sub1);
            
            sub2=new JLabel();
            sub2.setBounds(75,380 ,150 ,25 );
            sub2.setFont(new Font("tahoma",Font.PLAIN,20));
            contentPane.add(sub2);
            
            sub3=new JLabel();
            sub3.setBounds(75,420 ,150 ,25 );
            sub3.setFont(new Font("tahoma",Font.PLAIN,20));
            contentPane.add(sub3);
            
            sub4=new JLabel();
            sub4.setBounds(75,460 ,150 ,25 );
            sub4.setFont(new Font("tahoma",Font.PLAIN,20));
            contentPane.add(sub4);
            
            sub5=new JLabel();
            sub5.setBounds(75,500 ,150 ,25 );
            sub5.setFont(new Font("tahoma",Font.PLAIN,20));
            contentPane.add(sub5);
            
            
            
            
            JLabel total=new JLabel("Total");
            total.setBounds(300,280 ,300 ,25 );
            total.setFont(new Font("tahoma",Font.BOLD,25));
            contentPane.add(total);
            
            JLabel mark1=new JLabel("100");
            mark1.setBounds(320,340 ,150 ,25 );
            mark1.setFont(new Font("tahoma",Font.PLAIN,20));
            contentPane.add(mark1);
            
            JLabel mark2=new JLabel("100");
            mark2.setBounds(320,380 ,150 ,25 );
            mark2.setFont(new Font("tahoma",Font.PLAIN,20));
            contentPane.add(mark2);
            
            JLabel mark3=new JLabel("100");
            mark3.setBounds(320,420 ,150 ,25 );
            mark3.setFont(new Font("tahoma",Font.PLAIN,20));
            contentPane.add(mark3);
            
            JLabel mark4=new JLabel("100");
            mark4.setBounds(320,460 ,150 ,25 );
            mark4.setFont(new Font("tahoma",Font.PLAIN,20));
            contentPane.add(mark4);
            
            JLabel mark5=new JLabel("100");
            mark5.setBounds(320,500 ,150 ,25 );
            mark5.setFont(new Font("tahoma",Font.PLAIN,20));
            contentPane.add(mark5);
            
            
            
            
            
            JLabel obtained=new JLabel("Marks Obtained");
            obtained.setBounds(500,280 ,300 ,25 );
            obtained.setFont(new Font("tahoma",Font.BOLD,25));
            contentPane.add(obtained);
            
            
            mar1=new JLabel();
            mar1.setBounds(550,340 ,150 ,25 );
            mar1.setFont(new Font("tahoma",Font.PLAIN,20));
            contentPane.add(mar1);
            
            mar2=new JLabel();
            mar2.setBounds(550,380 ,150 ,25 );
            mar2.setFont(new Font("tahoma",Font.PLAIN,20));
            contentPane.add(mar2);
            
            mar3=new JLabel();
            mar3.setBounds(550,420 ,150 ,25 );
            mar3.setFont(new Font("tahoma",Font.PLAIN,20));
            contentPane.add(mar3);
            
            mar4=new JLabel();
            mar4.setBounds(550,460 ,150 ,25 );
            mar4.setFont(new Font("tahoma",Font.PLAIN,20));
            contentPane.add(mar4);
            
            mar5=new JLabel();
            mar5.setBounds(550,500 ,150 ,25 );
            mar5.setFont(new Font("tahoma",Font.PLAIN,20));
            contentPane.add(mar5);
            
            
            JLabel Gradtotal=new JLabel("Grand Total-");
            Gradtotal.setBounds(80,560 ,200 ,25 );
            Gradtotal.setFont(new Font("tahoma",Font.BOLD,25));
            contentPane.add(Gradtotal);
            
            JLabel totalMark=new JLabel("500");
            totalMark.setBounds(360,560 ,150 ,25 );
            totalMark.setFont(new Font("tahoma",Font.BOLD,25));
            contentPane.add(totalMark);
            
            JLabel obtained_marks=new JLabel();
            obtained_marks.setBounds(520,560 ,150 ,25 );
            obtained_marks.setFont(new Font("tahoma",Font.BOLD,25));
            contentPane.add(obtained_marks);
            
            JLabel result=new JLabel("Result -");
            result.setBounds(480,620 ,150 ,25 );
            result.setFont(new Font("tahoma",Font.BOLD,20));
            contentPane.add(result);
            
            JLabel result_Student=new JLabel();
            result_Student.setBounds(570,620 ,150 ,25 );
            result_Student.setFont(new Font("tahoma",Font.PLAIN,18));
            contentPane.add(result_Student);
            
            try{
                conn c=new conn();
                String Query="SELECT * FROM subject WHERE roll_no='"+roll_no+"' ";
//                String Query="SELECT * FROM subject WHERE roll_no="+15336573+" ";
                ResultSet rs=c.s.executeQuery(Query);
                while(rs.next()){
                    sub1.setText(rs.getString("subject1"));
                    sub2.setText(rs.getString("subject2"));
                    sub3.setText(rs.getString("subject3"));
                    sub4.setText(rs.getString("subject4"));
                    sub5.setText(rs.getString("subject5"));
                    
                    Ssem.setText(rs.getString("semester"));
                    SrollNo.setText(rs.getString("roll_no"));
                   
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            
            Float mark_num;
             try{
                conn c=new conn();
                String Query="SELECT * FROM marks WHERE roll_no='"+roll_no+"' ";
//                String Query="SELECT * FROM marks WHERE roll_no="+15336573+" ";
                ResultSet rs=c.s.executeQuery(Query);
                while(rs.next()){
                    mar1.setText(rs.getString("marks1"));
                    mar2.setText(rs.getString("marks2"));
                    mar3.setText(rs.getString("marks3"));
                    mar4.setText(rs.getString("marks4"));
                    mar5.setText(rs.getString("marks5"));
                    
                    String totals=rs.getString("total_mark");
                    
                    obtained_marks.setText(totals);
                    
                    try {
                       int totalInt = Integer.parseInt(totals);
                       if(totalInt>165){
                           result_Student.setText("Pass");
                       }
                       else{
                           result_Student.setText("Fail");
                       }
                         } catch (NumberFormatException e) {
                        e.printStackTrace();
                     }
                    
                    
                   
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            
            try{
                conn c=new conn();
                String Query="SELECT * FROM new_Student WHERE roll_no='"+roll_no+"' ";
//                String Query="SELECT * FROM new_Student WHERE roll_no="+15336573+" ";
                ResultSet rs=c.s.executeQuery(Query);
                while(rs.next()){
                    SName.setText(rs.getString("Stu_name"));
                    SDOb.setText(rs.getString("date_of_birth"));
                    Scourse.setText(rs.getString("course"));
                    Sbranch.setText(rs.getString("branch"));
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            
            
            
            JLabel Issue_date=new JLabel("Issue Date");
            Issue_date.setBounds(50,660 ,150 ,25 );
            Issue_date.setFont(new Font("tahoma",Font.PLAIN,20));
            contentPane.add(Issue_date);
            
            JLabel date=new JLabel();
            date.setBounds(50,690 ,150 ,25 );
            date.setFont(new Font("tahoma",Font.PLAIN,16));
            contentPane.add(date);
            
            Date current_date=new Date();
            SimpleDateFormat formateDate=new SimpleDateFormat("yyyy-MM-dd");
            formateDate.setTimeZone(TimeZone.getTimeZone("UTC"));
            String formatted_date=formateDate.format(current_date);
            date.setText(formatted_date);
            
            Print=new JButton("Print");
            Print.setBounds(600,690 ,120 ,25 );
            Print.setFont(new Font("tahoma",Font.PLAIN,18));
            Print.addActionListener(this);
            Print.setBackground(Color.BLACK);
            Print.setForeground(Color.WHITE);
            contentPane.add(Print);
            
            
            
            
        contentPane.setBackground(Color.WHITE);
        setContentPane(contentPane);
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==Print){
             PrinterJob job = PrinterJob.getPrinterJob();
             job.setPrintable(this);

            if (job.printDialog()) {
                try {
                    job.print();
                } catch (PrinterException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public int print(Graphics g, PageFormat pf, int pageIndex) throws PrinterException {
        if (pageIndex > 0) {
            return Printable.NO_SUCH_PAGE;
        }

        printAll(g);

        return Printable.PAGE_EXISTS;
    }
    
    public static void main(String[] args)
    {
        new marksheet("");
    }
}
