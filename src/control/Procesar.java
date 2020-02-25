/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;
import vistas.VistasPrincipal;

/**
 *
 * @author bondy
 */
public class Procesar {
    public String procesarTexto(String texto) throws IOException{
        String resultado="";
        File archivo = new File("archivo.txt");
        try {
            PrintWriter escribir = new PrintWriter(archivo);
            escribir.print(texto);
            escribir.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(VistasPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            Reader lector = new BufferedReader(new FileReader("archivo.txt"));
            Lexer lexer = new Lexer(lector);
            
            while (true) {
                Tokens token= lexer.yylex();
                if (token==null) {
                    resultado+="\nFin\n";
                    return resultado;
                }
                switch (token) {
                    case ERROR:
                        resultado+= " Símbolo no definido\n";
                        break;
                    case Suma:  case Resta: case Multiplicacion: case Division: case Asignacion:
                        resultado+= lexer.lexeme +" Es un Operador Aritmético\n";
                        break;
                    case Numero:  case Identificador:
                        resultado+= lexer.lexeme +" Es un "+token+"\n";
                        break;
                    case Reservadas:
                        resultado+= lexer.lexeme+" Es una palabra reservada \n";
                        break;
                    case Cadena:
                        resultado+= lexer.lexeme+" Es una cadena \n";
                        break;
                    case TipoDeDato:
                        resultado+= lexer.lexeme+" Es un Tipo de dato \n";
                        break;
                    case OR:
                        resultado+= lexer.lexeme+" Es OR \n";
                        break;
                    case Decremento:
                        resultado+= lexer.lexeme+" Es un decremento \n";
                        
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(VistasPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            return resultado;
        }
        
    }
}
