package student_management_system;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class Student_details extends JFrame implements ActionListener{
    Choice scroll;
    JTable table;
    JButton search,print,update,add,cancel;
    Student_details(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel roll_search=new JLabel("Search By Roll Number : ");
        roll_search.setBounds(40, 20, 180, 20);
        roll_search.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(roll_search);
        
        scroll=new Choice();
        scroll.setBounds(240, 20, 150, 20);
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
        
        
        table =new JTable();
         try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("SELECT * FROM new_Student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }
        
        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,100,1000,600);
        add(jsp);
        
        
        search = new JButton("Search");
        search.setBounds(20,60,100,25);
        search.addActionListener(this);
        add(search);
        
        print = new JButton("Print");
        print.setBounds(160,60,100,25);
        print.addActionListener(this);
        add(print);
        
        update = new JButton("Update");
        update.setBounds(300,60,100,25);
        update.addActionListener(this);
        add(update);
        
        add = new JButton("Add");
        add.setBounds(440,60,100,25);
        add.addActionListener(this);
        add(add);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(580,60,100,25);
        cancel.addActionListener(this);
        add(cancel);
        
        
        setLocation(300,100);
        setSize(1000,700);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==search){
            conn c=new conn();
            String query="SELECT * FROM new_Student WHERE roll_no ='"+scroll.getSelectedItem()+"'";
            try {
                ResultSet rs=c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==print){
            try{
                table.print();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==update){
            setVisible(false);
            new update_Student_info();
        }
        else if(ae.getSource()==add){
            setVisible(false);
            new Add_student();
        }
        else if(ae.getSource()==cancel){
            
        }
    }
    
    
    public static void main(String [] args){
        new Student_details();
    }
}
