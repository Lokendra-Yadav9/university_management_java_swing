package student_management_system;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class Student_leave_details extends JFrame implements ActionListener{
    
    Choice Scroll;
    JTable table;
    JButton search,print,cancel;
    
    Student_leave_details(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel rollno_search=new JLabel("Search By Em.");
        rollno_search.setBounds(40, 20, 180, 20);
        rollno_search.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(rollno_search);
        
        Scroll =new Choice();
        Scroll.setBounds(240, 20, 150, 20);
        add(Scroll);
        
        try{
            conn c=new conn();
            String Query="SELECT * FROM stu_leave";
            ResultSet rs=c.s.executeQuery(Query);
            while(rs.next()){
                Scroll.add(rs.getString("roll_no"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        
        table=new JTable();
        try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("SELECT * FROM stu_leave");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0, 120, 650, 490);
        add(jsp);
        
        search=new JButton("Search"); 
        search.setBounds(20,60,100,25);
        search.addActionListener(this);
        add(search);
        
        
        print = new JButton("Print");
        print.setBounds(160,60,100,25);
        print.addActionListener(this);
        add(print);
        
        
        cancel = new JButton("Cancel");
        cancel.setBounds(300,60,100,25);
        cancel.addActionListener(this);
        add(cancel);
        
        
        setSize(650,500);
        setLocation(400,100);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== search){
            try{
                conn c=new conn();
                String query="SELECT * FROM stu_leave WHERE roll_no ='"+Scroll.getSelectedItem()+"'";
                ResultSet rs=c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
               e.printStackTrace();
            }
        }
        else if(ae.getSource()==print){
            try{
            table.print();        
            }catch(Exception e){
                e.printStackTrace();
            }       
        }else{
            setVisible(false);
        }
      
    }
    
    public static void main(String [] args){
        new Student_leave_details();
    }
}
