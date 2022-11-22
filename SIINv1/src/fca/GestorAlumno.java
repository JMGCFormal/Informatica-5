/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Lficenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fca;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Gómez Contreras Juan Miguel
 */
public class GestorAlumno {
    
    public static void serializar(Object o){
        Alumno a= (Alumno) o;
        
        try {
            ObjectOutputStream oss = new ObjectOutputStream(
                new FileOutputStream(
                        a.getNumeroCuenta()+ ".ser"));
            oss.writeObject(a);
            oss.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static Object hidratar(String nombreArchivo){
        Object o = null;
        try{
            FileInputStream fis = new FileInputStream(nombreArchivo);
            ObjectInputStream ois = new ObjectInputStream(fis);
            o = ois.readObject();
            ois.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return o;
    }

    public static void serializar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
