/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import fca.Alumno;
import fca.GestorAlumno;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Oscar Javier Martin Mancilla
 */
public class MenuPrincipal extends WindowAdapter{
    JFrame jf;
    JMenuBar jmb; 
    JMenu jmAlumno, jmInscripcion, jmAyuda;
    JMenuItem jmiNuevo, jmiAbrir, jmiConsultar, jmiReporte, jmiSalir, jmiAcercaDe;
    ImageIcon iconAlumno, iconAbrir,iconInscripcion, iconAyuda;
    ImageIcon iconNuevo, iconConsultar, iconReporte, iconSalir, iconAcercaDe;


    public MenuPrincipal(){
        jf = new JFrame("Sistema de Información de Inscrición.");
        jf.setLayout(null);
        jf.getContentPane().setBackground(new Color(0,150,150));
        jf.setResizable(true);
        jf.setSize(600, 700);
        jf.addWindowListener(this);
        jf.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        //Construccion de Iconos

        iconAlumno = new ImageIcon("images" + File.separator + "iconos" + File.separator + "alumno.png");
        iconInscripcion = new ImageIcon("images" + File.separator + "iconos" + File.separator + "inscripcion.png");
        iconAyuda = new ImageIcon("images" + File.separator + "iconos" + File.separator + "ayuda.png");
        iconSalir = new ImageIcon("images" + File.separator + "iconos" + File.separator + "SALIDA.png");
        iconNuevo = new ImageIcon("images" + File.separator + "iconos" + File.separator + "nuevo.png");
        iconAbrir = new ImageIcon("images" + File.separator + "iconos" + File.separator + "abrir.png");
        iconConsultar = new ImageIcon("images" + File.separator + "iconos" + File.separator + "consultar.png");
        iconReporte = new ImageIcon("images" + File.separator + "iconos" + File.separator + "reporte.png");
        iconAcercaDe = new ImageIcon("images" + File.separator + "iconos" + File.separator + "informacion.png");
        

        
        //Menu Items        
        
        jmb = new JMenuBar();
        jf.setJMenuBar(jmb);
        jmAlumno = new JMenu("Alumno");
            jmAlumno.setIcon(iconAlumno);
            jmAlumno.setMnemonic('A');
            
            jmiNuevo = new JMenuItem("Nuevo");
                jmiNuevo.setIcon(iconNuevo);
                jmiNuevo.setMnemonic('N');
                jmAlumno.add(jmiNuevo);
            
            jmiAbrir = new JMenuItem("Abrir");
                jmiAbrir.setIcon(iconAbrir);
                jmiAbrir.setMnemonic('b');
                jmAlumno.add(jmiAbrir);
            
            
            jmiConsultar = new JMenuItem("Consultar");
                jmiConsultar.setIcon(iconConsultar);
                jmiConsultar.setMnemonic('C');
                jmAlumno.add(jmiConsultar);
            jmiReporte = new JMenuItem("Reporte");
                jmiReporte.setIcon(iconReporte);
                jmiReporte.setMnemonic('R');
                jmAlumno.add(jmiReporte);
            jmAlumno.addSeparator();
            jmiSalir = new JMenuItem("Salir");
                jmiSalir.setIcon(iconSalir);
                jmiSalir.setMnemonic('S');
                jmAlumno.add(jmiSalir);
        jmb.add(jmAlumno);
        jmInscripcion = new JMenu("Inscripción");
            jmInscripcion.setIcon(iconInscripcion);
            jmInscripcion.setMnemonic('I');
        jmb.add(jmInscripcion);
            
        jmAyuda = new JMenu("Ayuda");
            jmAyuda.setIcon(iconAyuda);
            jmAyuda.setMnemonic('y');
        jmb.add(jmAyuda);

        jmiNuevo.addActionListener(
                new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new CapturaAlumno().setVisible(true);
            }
                    
                }
        );//Fin del action listener de jmiNuevo

        jmiAbrir.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFileChooser jfc = new JFileChooser();

                        jfc.setCurrentDirectory(new java.io.File("." + File.separator + "serializados"));
                        jfc.setDialogTitle("Cargar archivo para hidratar.");
                        jfc.setMultiSelectionEnabled(false);


                        jfc.setFileFilter(new FileNameExtensionFilter("Archivos serializados", "ser"));
                        int seleccion = jfc.showOpenDialog(null);
                        
                        System.out.println("Selección: " + seleccion);
                        
                        if (seleccion == JFileChooser.APPROVE_OPTION){
                            File f = jfc.getSelectedFile();
                            System.out.println("Ruta: " + f.getAbsolutePath());
                            
                            Object o;
                            o = GestorAlumno.hidratar(f.getAbsolutePath());
                            Alumno a = (Alumno)o;
                            SimpleDateFormat sdf =
                                    new SimpleDateFormat("dd/MMMMM/yyyy hh:mm:ss");
                            JOptionPane.showMessageDialog(null,
                                    "Nombre: " + a.getNombre() + "\n" +
                                    "Apellido Paterno: " + a.getApellidoPaterno() + "\n" +
                                    "Apellido Materno: " + a.getApellidoMaterno() + "\n" +
                                    "Numero de Cuenta: " + a.getNumeroCuenta() + "\n" +
                                    "Fecha de Nacimiento: " + sdf.format(a.getFechaNacimiento().getTime()) + "\n" +
                                    "Edad: " + a.getEdad() + "\n", "Alumnos encontrados", JOptionPane.INFORMATION_MESSAGE);
                        }
                        
                       
                        
                    }
            }
                
        );//Fin del action listener de jmiAbrir
        
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
    }//Fin del constructor
    
    public static void main(String args[]){
        new MenuPrincipal();
    }
    @Override
    public void windowClosing(WindowEvent e){
        System.out.println("Cerrando Ventana");
        if (JOptionPane.showConfirmDialog(null,"¿Desea salir?", "Confirmación",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, iconSalir)== JOptionPane.YES_OPTION){
            jf.dispose();
            System.exit(0);
        }
    }

}


