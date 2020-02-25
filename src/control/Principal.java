/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.File;

/**
 *
 * @author bondy
 */
public class Principal {
    public static void main(String[] args) {
        String rutaLexer = "C:/Users/bondy/Documents/NetBeansProjects/Automatas/src/control/Lexer.flex";
        generarLexer(rutaLexer);
    }
    public static void generarLexer(String rutaLexer){
        File archivo = new File(rutaLexer);
        JFlex.Main.generate(archivo);
    }
    
    
}
