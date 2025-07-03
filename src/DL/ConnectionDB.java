
package DL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    
    public static Connection GetConnection(){
        
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String username = "KMedranoProgramacionNCapasMayo2025";
        String password = "password1";
        
        try{
            Connection context = DriverManager.getConnection(url, username, password);
            
            return context;
        }
        catch(SQLException ex){
            System.out.println("NO");
            return null;
        }
        
    }
    
}
