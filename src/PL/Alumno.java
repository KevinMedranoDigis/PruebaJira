
package PL;

import java.util.List;


public class Alumno {
    
    public static void Add(){
        ML.Alumno alumno = new ML.Alumno();
        alumno.setNombre("");
        alumno.setApellidoPaterno("");
        alumno.setApellidoMaterno("");
        
        ML.Result result = BL.Alumno.Add(alumno);
        
        if(result.correct){
            System.out.println("El alumno se inserto correctamente");
          
        }else{
            System.out.println("Fallo la insersion");
        }
        
    } 
    
    public static void GetAll(){
        
        
        BL.Alumno.GetAll();
        
        
    }
    
    
}
