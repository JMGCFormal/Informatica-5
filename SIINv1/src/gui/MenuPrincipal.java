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
 * @author Gómez Contreras Juan Miguel
 */
public class MenuPrincipal extends WindowAdapter{
    JFrame jf; //frame
    JMenuBar jmb;  //barra de herramientas
    JMenu jmAlumno, jmInscripcion, jmAyuda; //Pestañas de la barra de herramientas
    JMenuItem jmiNuevo, jmiAbrir, jmiConsultar, jmiReporte, jmiSalir, jmiAcercaDe; //Items de las pestañas
    ImageIcon iconAlumno, iconAbrir,iconInscripcion, iconAyuda; //Iconos de las pestañas
    ImageIcon iconNuevo, iconConsultar, iconReporte, iconSalir, iconSalir32, iconAcercaDe; //Iconos de los items


    //Metodo constructor
    public MenuPrincipal(){
        //Instanciar y configurar el JFrame
        jf = new JFrame("Sistema de Información de Inscrición.");
        jf.setLayout(null);
        jf.getContentPane().setBackground(new Color(0,150,200));
        jf.setResizable(true);
        jf.setSize(600, 700);
        jf.addWindowListener(this);
        jf.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        //Construccion de Iconos
        iconAlumno = new ImageIcon("images" + File.separator + "iconos" + File.separator + "alumno.png");
        iconInscripcion = new ImageIcon("images" + File.separator + "iconos" + File.separator + "inscripcion.png");
        iconAyuda = new ImageIcon("images" + File.separator + "iconos" + File.separator + "ayuda.png");
        iconSalir = new ImageIcon("images" + File.separator + "iconos" + File.separator + "salir.png");
        iconSalir32 = new ImageIcon("images" + File.separator + "iconos" + File.separator + "salir32.png");
        iconNuevo = new ImageIcon("images" + File.separator + "iconos" + File.separator + "nuevo.png");
        iconAbrir = new ImageIcon("images" + File.separator + "iconos" + File.separator + "abrir.png");
        iconConsultar = new ImageIcon("images" + File.separator + "iconos" + File.separator + "consultar.png");
        iconReporte = new ImageIcon("images" + File.separator + "iconos" + File.separator + "reporte.png");
        iconAcercaDe = new ImageIcon("images" + File.separator + "iconos" + File.separator + "informacion.png");
        
        //Menu Items
        jmb = new JMenuBar();
        jf.setJMenuBar(jmb);
        //Pestaña Alumno
        jmAlumno = new JMenu("Alumno");
            jmAlumno.setIcon(iconAlumno);
            jmAlumno.setMnemonic('A');
            //Item Nuevo
            jmiNuevo = new JMenuItem("Nuevo");
                jmiNuevo.setIcon(iconNuevo);
                jmiNuevo.setMnemonic('N');
                jmAlumno.add(jmiNuevo);
            //Item Abrir
            jmiAbrir = new JMenuItem("Abrir");
                jmiAbrir.setIcon(iconAbrir);
                jmiAbrir.setMnemonic('b');
                jmAlumno.add(jmiAbrir);
            //Item Consultar
            jmiConsultar = new JMenuItem("Consultar");
                jmiConsultar.setIcon(iconConsultar);
                jmiConsultar.setMnemonic('C');
                jmAlumno.add(jmiConsultar);
            //Item Reporte
            jmiReporte = new JMenuItem("Reporte");
                jmiReporte.setIcon(iconReporte);
                jmiReporte.setMnemonic('R');
                jmAlumno.add(jmiReporte);
            //Item Salir
            jmAlumno.addSeparator();
            jmiSalir = new JMenuItem("Salir");
                jmiSalir.setIcon(iconSalir);
                jmiSalir.setMnemonic('S');
                jmAlumno.add(jmiSalir);
        jmb.add(jmAlumno);
        //Pestaña Inscripcion
        jmInscripcion = new JMenu("Inscripción");
            jmInscripcion.setIcon(iconInscripcion);
            jmInscripcion.setMnemonic('I');
        jmb.add(jmInscripcion);
        //Pestaña Ayuda
        jmAyuda = new JMenu("Ayuda");
            jmAyuda.setIcon(iconAyuda);
            jmAyuda.setMnemonic('y');
            //Item Acerca de
            jmiAcercaDe = new JMenuItem("Acerca de");
                jmiAcercaDe.setIcon(iconAcercaDe);
                jmiAcercaDe.setMnemonic('D');
                jmAyuda.add(jmiAcercaDe);
        jmb.add(jmAyuda);

        //Eventos

        //Evento jmiNuevo
        jmiNuevo.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                new CapturaAlumno().setVisible(true);
            }
                }
        );
        //Evento jmiAbrir
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
                            new CapturaAlumno(a,sdf).setVisible(true);
                        }
                    }
                }
        );
        //Fin del metodo constructor
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
    }

    //Metodo Main
    public static void main(String args[]){
        new MenuPrincipal();
    }
    //Overrides
    @Override
    public void windowClosing(WindowEvent e){
        System.out.println("Cerrando Ventana");
        if (JOptionPane.showConfirmDialog(null,"¿Desea salir?", "Confirmación",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, iconSalir32)== JOptionPane.YES_OPTION){
            jf.dispose();
            System.exit(0);
        }
    }

}


