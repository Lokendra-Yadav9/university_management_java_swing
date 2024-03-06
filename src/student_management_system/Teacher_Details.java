package student_management_system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class Teacher_Details extends JFrame  implements ActionListener{
    
    Choice scroll;
    JTable table;
    JButton search, print,update,add,cancel;
    Teacher_Details(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel sear_teacher=new JLabel("Search by Employee Id ");
        sear_teacher.setBounds(40, 20, 180, 20);
        sear_teacher.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(sear_teacher);
        
       

        scroll =new Choice();
        scroll.setBounds(240, 20, 150, 20);
        add(scroll);
        
        try{
            conn c=new conn();
            String Query="SELECT * FROM new_teacher ";
            ResultSet rs=c.s.executeQuery(Query);
            while(rs.next()){
                scroll.add(rs.getString("Employee_id"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        table=new JTable();
        try{
            conn c=new conn();
            String query="SELECT * FROM new_teacher";
            ResultSet rs=c.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,100,1000,600);
        add(jsp);
        
        search=new JButton("Search");
        search.setBounds(20,60,100,25);
        search.addActionListener(this);
        add(search);
        
        print=new JButton("Print");
        print.setBounds(160,60,100,25);
        print.addActionListener(this);
        add(print);
        
        update=new JButton("Update");
        update.setBounds(300,60,100,25);
        update.addActionListener(this);
        add(update);
        
        add=new JButton("Add");
        add.setBounds(440,60,100,25);
        add.addActionListener(this);
        add(add);
        
        cancel=new JButton("Cancel");
        cancel.setBounds(580,60,100,25);
        cancel.addActionListener(this);
        add(cancel);
        
        

        setLocation(300,100);
        setSize(1000,700);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==search){
                conn c=new conn();
                String query="SELECT * FROM new_teacher WHERE Employee_id='"+scroll.getSelectedItem()+"'";
            try{
                ResultSet rs=c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==print){
            try{
            table.print();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==update){
            setVisible(false);
            new update_faculty_info();
        }
        else if(ae.getSource()==add){
            setVisible(false);
            new Add_Faculty();
        }
        else if(ae.getSource()==cancel){
            setVisible(false);
            new Project();
        }
    }
    
    public static void main(String[] args){
        new Teacher_Details();
    }
}
