package student_management_system;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;

public class About_me extends JFrame{
    About_me(){
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon igg=new ImageIcon(ClassLoader.getSystemResource("img/univeristy2.jpg"));
        Image img=igg.getImage().getScaledInstance(300, 200, Image.SCALE_SMOOTH);
        ImageIcon imc=new ImageIcon(img);
        JLabel imgg=new JLabel(imc);
        imgg.setBounds(250, 10, 300, 200);
        add(imgg);
        
        
       
        JLabel university=new JLabel("<html> University <br>Management System</html>");
        university.setBounds(20, 0, 230, 200);
        university.setFont(new Font("Courier New", Font.BOLD, 35));
        add(university);
        
        JLabel name=new JLabel("Name   -  Lokendra Yadav B.tech (Final Year) ");
        name.setBounds(100, 250, 500, 20);
        name.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(name);
        
        JLabel about=new JLabel("<html>Branch  - Electronics and Communication <br> Contact Details: <br> Mob no. 7471172041 <br> Mail id  - Lokendrasinghy111@gmail.com </html> ");
        about.setBounds(100, 265, 450, 100);
        about.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(about);
        
        JLabel project=new JLabel("About Project - ");
        project.setBounds(10, 400, 200, 20);
        project.setFont(new Font("Tahoma",Font.BOLD,20));
        add(project);
        
         JLabel PRO_details=new JLabel("<html>This project is University Management Project by Using <br> Java, Java swing for GUI , MySQL for DataBase.</html>");
        PRO_details.setBounds(170, 320, 400, 200);
        PRO_details.setFont(new Font("Ariel",Font.PLAIN,16));
        add(PRO_details);
        
        
        setLocation(500,100);
        setSize(590,520);
        setVisible(true);
    }
    public static void main(String[] args){
        new About_me();
    }
}
