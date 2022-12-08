    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */
package utils;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

/**
 *
 * @author Juan Miguel Gómez Contreras
 * */
public class CampoTexto extends JTextField {//Herencia
    public static final int SOLO_NUMEROS = 1;
    public static final int SOLO_LETRAS_MAY = 2;
    public static final int SOLO_LETRAS_MIN = 3;
    public static final int SOLO_LETRAS_ACENTUADAS = 4;
    public static final int SOLO_LETRAS_ACENTUADAS_MAY = 5;
    public static final int SOLO_LETRAS_ACENTUADAS_MIN = 6;
    public static final int SOLO_CARACTERES_ESPECIALES = 7;

    public static final int DE_MAY_A_MIN = 8;
    public static final int DE_MIN_A_MAY = 9;
    public static final int SOLO_LETRAS = 10;
    public static final int PRIMERA_MAY = 11;

    public CampoTexto(){

    }

    public CampoTexto(int valorMax, Color focusGanado, Color focusPerdido, int caracter){
        addFocusListener(new FocusListener(){//Esto es una clase anónima
            @Override
            public void focusGained(FocusEvent e) {
                setBackground(focusGanado);
            }

            @Override
            public void focusLost(FocusEvent e) {
                setBackground(focusPerdido);
            }
        });
        addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                int k = e.getKeyChar();
                char c = e.getKeyChar();
                System.out.println("Teclado " + k);
                System.out.println("Teclado " + c);

                int opcion = caracter;
                switch(opcion) {
                    case 1:
                        System.out.println("Solo números " + caracter);
                        if (k >= 32 && k <= 47 || k >= 58 && k <= 255) {
                            e.setKeyChar((char) KeyEvent.VK_CLEAR);
                        }
                        break;
                    case 2:
                        System.out.println("Solo mayusculas " + caracter);
                        if (c >= 32 & c <= 64 || c >= 91 && c <= 191 || c >= 224 && c <= 255){
                            e.setKeyChar((char) KeyEvent.VK_CLEAR);
                        }
                        break;
                    case 3:
                        System.out.println("Solo minusculas " + caracter);
                        if (c >= 32 & c <= 96 || c >= 123 && c <= 223 || c == 247){
                            e.setKeyChar((char) KeyEvent.VK_CLEAR);
                        }
                        break;
                    case 4:
                        System.out.println("Solo letras acentuadas " + caracter);
                        if(!(c=='\u00E1' || c=='\u00C1' || c=='\u00E9' || c=='\u00C9'
                                || c=='\u00ED' || c=='\u00CD' || c=='\u00F3' || c=='\u00D3'
                                || c=='\u00FA' || c=='\u00DA' || c=='\u00F1' || c=='\u00D1'
                                || c=='\u00DC' || c=='\u00FC' || c==' ')){
                            e.consume();
                        }
                        break;
                    case 5:
                        System.out.println("Solo letras acentuadas mayusculas " + caracter);
                        if(!(c=='\u00C1' || c=='\u00C9' || c=='\u00CD' || c=='\u00D3'
                                || c=='\u00DA' || c=='\u00D1' || c=='\u00DC' || c==' ')){
                            e.consume();
                        }
                        break;
                    case 6:
                        System.out.println("Solo letras acentuadas minusculas " + caracter);
                        if(!(c=='\u00E1' || c=='\u00E9' || c=='\u00ED' || c=='\u00F3'
                                || c=='\u00FA' || c=='\u00F1' || c=='\u00FC' || c==' ')){
                            e.consume();
                        }
                        break;
                    case 7:
                        System.out.println("Solo letras acentuadas minusculas " + caracter);
                        if (k == 32 || k >= 48 && c <= 57 || c >= 65 && c <= 90
                                || c >= 97 && c<= 122 ||  c== 173 || c >= 192 && c <= 246
                                || c >= 248 && c <= 255){
                            e.setKeyChar((char) KeyEvent.VK_CLEAR);
                        }
                        break;
                    case 8:
                        System.out.println("De mayusculas a minusculas " + caracter);
                        if (!(c >= 32 & c <= 64 || c >= 91 && c <= 96 || c >= 123 && c <= 191 || c == 247)){
                            setText(getText().toLowerCase());
                            setCaretPosition(getCaretPosition());
                        }else {
                            e.setKeyChar((char) KeyEvent.VK_CLEAR);
                        }
                        break;
                    case 9:
                        System.out.println("De minusculas a mayusculas " + caracter);
                        if (!(c >= 32 & c <= 64 || c >= 91 && c <= 96 || c >= 123 && c <= 191 || c == 247)){
                            setText(getText().toUpperCase());
                            setCaretPosition(getCaretPosition());
                        }else {
                            e.setKeyChar((char) KeyEvent.VK_CLEAR);
                        }
                        break;
                    case 10:
                        System.out.println("Solo letras " + caracter);
                        if (c >= 32 & c <= 64 || c >= 91 && c <= 96 || c >= 123 && c <= 191 || c == 247){
                            e.setKeyChar((char) KeyEvent.VK_CLEAR);
                        }
                        break;
                    case 11:
                        System.out.println("Primera mayuscula " + caracter);
                        if (!(c >= 32 & c <= 64 || c >= 91 && c <= 96 || c >= 123 && c <= 191 || c == 247)){
                            if(getText().length() == (valorMax - (valorMax-1))){
                                setText(getText().toUpperCase());
                                setCaretPosition(getCaretPosition());
                            }
                        }else {
                            e.setKeyChar((char) KeyEvent.VK_CLEAR);
                        }
                        break;
                    default:
                        System.out.println("Cualquier tecla.");
                }
                if(getText().length() >= valorMax){
                    e.consume();
                }
            }
        });
    }
}

