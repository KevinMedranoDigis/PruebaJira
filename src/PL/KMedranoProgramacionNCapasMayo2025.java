
package PL;

import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;


public class KMedranoProgramacionNCapasMayo2025 {

    
    public static void main(String[] args) {
        
        
        System.out.println("1.-Add");
        System.out.println("2.-GetAll");
        
        Scanner scanner = new Scanner(System.in);
        
        int opcion = scanner.nextInt();
        
        switch (opcion) {
            case 1:
                Alumno.Add();
                break;
            case 2:
                Alumno.GetAll();
                break;
        }
    }
    
    
    
    public static void AddAlumno(){
        
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String username = "KMedranoProgramacionNCapasMayo2025";
        String password = "password1";
        
        try(Connection context = DriverManager.getConnection(url, username, password);
                PreparedStatement preparedStatement = context.prepareStatement("INSERT INTO Alumno(Nombre, ApellidoPaterno, ApellidoMaterno) VALUES (?,?,?)")){
            
            preparedStatement.setString(1, "Alejadro");
            preparedStatement.setString(2, "Garcia");
            preparedStatement.setString(3, "Torres");
            
            int rowsAffected = preparedStatement.executeUpdate();
            
            if(rowsAffected > 0){
                System.out.println("Se inserto el nuevo alumno");

            }else{
                System.out.println("No pudo insertarse el alumno");
            }
        }
        catch(Exception ex){
            System.out.println(ex.getLocalizedMessage());
        }
        
        
    }
    
    public static void GetAllAlumno(){
        
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String username = "KMedranoProgramacionNCapasMayo2025";
        String password = "password1";
        
        try(Connection context = DriverManager.getConnection(url, username, password);
                Statement statement = context.createStatement()){
            ResultSet resultSet = statement.executeQuery("SELECT Nombre, ApellidoPaterno, ApellidoMaterno FROM Alumno");
            
            while(resultSet.next()){
                    String Nombre = resultSet.getString("Nombre");
                    String ApellidoPaterno = resultSet.getString("ApellidoPaterno");
                    String ApellidoMaterno = resultSet.getString("ApellidoMaterno");
                    
                    System.out.println("Nombre: " + Nombre + "\nApellido Paterno: " + ApellidoPaterno + "\nApellido Materno: " + ApellidoMaterno + "\n");
                }
            
        }
        catch(Exception ex){
            System.out.println(ex.getLocalizedMessage());
        }
        
    }
}
