/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fca;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import util.Edad;


/**
 *
 * @author Gómez Contreras Juan Miguel
 */

public class Alumno implements Serializable {
    
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String numeroCuenta;
    private Calendar fechaNacimiento;
    private int edad;

    public Alumno(String nombre, String apellidoPaterno, String apellidoMaterno, String numeroCuenta, Calendar fechaNacimiento) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.numeroCuenta = numeroCuenta;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = new Edad(fechaNacimiento).getAnios();
        
        
    }

    public Alumno() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public static void main(String args[]){
        SimpleDateFormat f = new SimpleDateFormat("dd/MMMM/yyyy hh:mm:ss");
        Alumno a = new Alumno("Juna", "Gómez", "Contreras", "318092678", new GregorianCalendar(2002,05,25)       
        );
        
        System.out.println("Nombre: " + a.getNombre());
        System.out.println("Apellido paterno: " + a.getApellidoPaterno());
        System.out.println("Appelido paterno: " + a.getApellidoMaterno());
        System.out.println("Numero de cuenta: " + a.getNumeroCuenta());
        System.out.println("Edad: " + a.getEdad());
    }
    
}
