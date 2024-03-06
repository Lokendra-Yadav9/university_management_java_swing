package student_management_system;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class Exams_results extends JFrame implements ActionListener {
    
    JTextField search;
    JButton submit,cancel;
    JTable table; 
   
    Exams_results()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel heading=new JLabel("Check Result"); 
        heading.setBounds(30,30,400,30);
        heading.setFont(new Font("Tahoma",Font.BOLD,25));
        add(heading);
        
        search=new JTextField();
        search.setBounds(30,80,200,25);
        search.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(search);
        
        submit=new JButton("Search");
        submit.setBounds(300, 80, 100, 25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);
        
        cancel=new JButton("Back");
        cancel.setBounds(450, 80, 100, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
        
        table=new JTable();
        table.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(table);
        
        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(10, 120, 970,340 );
        add(jsp);
        
        
        try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("SELECT * FROM new_Student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
        
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
              int row=table.getSelectedRow();
              search.setText(table.getModel().getValueAt(row, 2).toString());
            }
            
        });
        
        
        setLocation(300,100);
        setSize(1000,500);
        setVisible(true);
    }    
    
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            setVisible(false);
            new marksheet(search.getText());
        }
        else if(ae.getSource()==cancel){
            search.setText("");
            setVisible(false);
        }
    }
    
 
    public static void main(String[]args){
        new Exams_results();
    }
}
