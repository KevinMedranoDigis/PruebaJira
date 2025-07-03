
package BL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

public class Alumno {
    public static ML.Result Add(ML.Alumno alumno){
    
            //prueba commit
        ML.Result result = new ML.Result();
        
        try(Connection context = DL.ConnectionDB.GetConnection();
                PreparedStatement preparedStatement = context.prepareStatement("INSERT INTO Alumno VALUES(?,?,?)"))
        {
            
            
            
            
           preparedStatement.setString(1, alumno.getNombre());
           preparedStatement.setString(2, alumno.getApellidoPaterno());
           preparedStatement.setString(3, alumno.getApellidoMaterno());
           
           int rowsAffected = preparedStatement.executeUpdate();
           
            if (rowsAffected > 0 ) {
                result.correct = true;
            }
            return result;
        }
        catch(SQLException ex)
        {
            result.correct = false;
            return result;
        }
        
        
    }
    
    
    public static void GetAll(){
        
        ML.Result result = new ML.Result();
        //result.objects = new ArrayList<>();
        try(Connection context = DL.ConnectionDB.GetConnection(); Statement statement = context.createStatement())
        {
            ResultSet resulSet = statement.executeQuery("SELECT Nombre, ApellidoPaterno, ApellidoMaterno FROM Alumno");
             
            //result.objects = new ArrayList<>();
            
            while(resulSet.next()){
                result.objects = new ArrayList<>();
                
                //Primero mostrarlo con prints
                
                System.out.println(resulSet.getString("Nombre"));
                System.out.println(resulSet.getString("ApellidoPaterno"));
                System.out.println(resulSet.getString("ApellidoMaterno"));
                
                
                
//                ML.Alumno alumno = new ML.Alumno();
//                alumno.setNombre(resulSet.getString("Nombre"));
//                alumno.setNombre(resulSet.getString("ApellidoPaterno"));
//                alumno.setNombre(resulSet.getString("ApellidoMaterno"));
                
                //result.objects.add(alumno);
            }
            //return alumnos;
            
        }
        
        catch(SQLException ex){}
        
    }
    
    
   
}
