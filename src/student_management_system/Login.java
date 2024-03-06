package student_management_system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JButton Sign_in,cancel;
    JTextField user_name;
    JPasswordField pswd;
    
    Login(){
        
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        
        JLabel User_N=new JLabel("Username ");
        User_N.setBounds(60, 20,100, 20);
        User_N.setFont(new Font("Raleway",Font.BOLD,14));
        add(User_N);
        
        user_name=new JTextField();
        user_name.setBounds(160, 20, 180, 25);
        add(user_name);
        
        JLabel pswd_N=new JLabel("Password ");
        pswd_N.setBounds(60, 70,100, 20);
        pswd_N.setFont(new Font("Raleway",Font.BOLD,14));
        add(pswd_N);
        
        pswd=new JPasswordField();
        pswd.setBounds(160, 70, 180, 25);
        add(pswd);
        
        Sign_in=new JButton("Sign In");
        Sign_in.setBounds(60,120, 120,30);
        Sign_in.setBackground(Color.BLACK);
        Sign_in.setForeground(Color.WHITE);
        Sign_in.addActionListener(this);
        Sign_in.setFont(new Font("Tahoma",Font.BOLD,15));
        add(Sign_in);
        
        cancel=new JButton( "Cancel");
        cancel.setBounds(220,120, 120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma",Font.BOLD,15));
        add(cancel);
        
        ImageIcon sec_img=new ImageIcon(ClassLoader.getSystemResource("img/second2.png"));
        Image img=sec_img.getImage().getScaledInstance(100, 120, Image.SCALE_DEFAULT);
        ImageIcon user_img=new ImageIcon(img);
        JLabel JLimg=new JLabel(user_img);
        JLimg.setBounds(370, 20, 130, 140);
        add(JLimg);
        
        setLocation(450,300);
        setSize(560,250);
        setVisible(true);
    }
      @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==Sign_in){
            String username=user_name.getText();
            String password=pswd.getText();
            
            String Query="SELECT * FROM Login_user WHERE User_name='"+username+"' AND password='"+password+"'";
            
            try{
                conn c=new conn();
                ResultSet rs=c.s.executeQuery(Query);
                if(rs.next()){
                    setVisible(false);
                    new Project();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Invalid Username or passWord");
                }
            }catch(Exception e){
                e.printStackTrace();
                setVisible(false);
            }
        }
        else if(ae.getSource()==cancel){
            setVisible(false);
        }
    }
    
    public static void main(String[]args){
       new Login();
    }            

  
    
}
