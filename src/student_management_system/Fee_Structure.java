package student_management_system;
import java.awt.Color;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class Fee_Structure extends JFrame {
    
    JTable table;
    
    Fee_Structure(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel heading = new JLabel("Fee Structure");
        heading.setBounds(10, 20, 400, 55);
        heading.setFont(new Font("Tahoma",Font.BOLD,30));
        add(heading);
        
        table=new JTable();
        
        try{
            conn c=new conn();
            String Query="SELECT * FROM fee_details";
            ResultSet rs=c.s.executeQuery(Query);
            while(rs.next()){
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,100,1000,600);
        jsp.setFont(new Font("Tahoma",Font.BOLD,20));
        add(jsp);
        
        setLocation(250,100);
        setSize(1000,700);
        setVisible(true);
    }
    public static void main(String [] args){
        new Fee_Structure();
    }  
}
