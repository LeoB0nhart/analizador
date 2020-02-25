/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JOptionPane;
import vistas.VistasPrincipal;

/**
 *
 * @author bondy
 */
public class ControlArchivos {
    VistasPrincipal principal = new VistasPrincipal();
    FileInputStream archivoEntrada;
    FileOutputStream archivoSalida;
    
    public String leerArchivo(File archivo){
        String textoArchivo="";
        try{
            archivoEntrada = new FileInputStream(archivo);
            int ascii;
            while((ascii=archivoEntrada.read())!=-1){
                char caracter=(char)ascii;
                textoArchivo+=caracter;
            }
        }catch(IOException e){
            JOptionPane.showMessageDialog(principal,"Error al Leer el Archivo");
        }
        return textoArchivo;
    }
    
    public boolean guardarArchivo(File archivo, String cambios){
        boolean guardado;
        try{
            archivoSalida = new FileOutputStream(archivo);
            byte [] byteTxt=cambios.getBytes();
            archivoSalida.write(byteTxt);
            guardado=true;
        }catch(IOException e){
            guardado=false;
        }
        return guardado;
    }
}
