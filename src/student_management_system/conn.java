
package student_management_system;
import java.sql.*;
public class conn {
    Connection c;
    Statement s;
    conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
             c=DriverManager.getConnection("jdbc:mysql:///Student_management","root","Lokendra12");
             s=c.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
