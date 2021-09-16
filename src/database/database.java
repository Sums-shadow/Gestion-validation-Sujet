
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class database {
       Connection con = null;
    public Connection getcon (){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/db_tfc_stage","root","");
            System.out.println("connection reusssi");
        }catch(ClassNotFoundException | SQLException e){
        
         System.out.println("connection echouee "+e.getMessage());
        }
        return con;
    }
}
