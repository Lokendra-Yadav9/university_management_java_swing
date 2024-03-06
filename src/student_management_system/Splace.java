
package student_management_system;
import javax.swing.*;
import java.awt.*;
public class Splace extends JFrame implements Runnable{
        Thread t;
          Splace(){
             ImageIcon mg=new ImageIcon(ClassLoader.getSystemResource("img/bg_clg_img8.jpg"));
             Image m1=mg.getImage().getScaledInstance(1200, 650, Image.SCALE_DEFAULT);
             ImageIcon mgg=new ImageIcon(m1);
             JLabel image=new JLabel(mgg);
             add(image);
             
             
             t=new Thread(this);
             t.start();
             
             int x=1;
             setVisible(true);
             for(int i=2;i<=600;i+=4,x+=1){
                setLocation(600-((i+x)/2),300-i/2); 
                setSize(i+3*x,i+x/2);
             }
             try{
                 Thread.sleep(100);
             }catch(Exception e){
                 
             }
             
             
             
          }
          public void run(){
              try{
                  Thread.sleep(5000);
                  setVisible(false);
                  new Login();
              }catch(Exception e){
                  
              }
          }
    public static void main(String []args){
        new Splace();
    }
       
}
