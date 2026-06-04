/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ashley.prueba2.parcial2;

/**
 *
 * @author ashley
 */

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;
import java.util.ArrayList;

public class GestorTareas {
    
    private File archivo = new File("tareas.txt");
    
    public void agregarTarea(String tarea){
        
        try {
            
            FileWriter escribir = new FileWriter(archivo, true);
            escribir.write("0|" + tarea + "\n");
            escribir.close();
            
        } catch (IOException e){
            System.out.println("Error al guardar la tarea.");
        }
    }

    public ArrayList<String> leerTareas(){
        
        ArrayList<String> tareas = new ArrayList<String>();
        
        try {
            
            if (!archivo.exists()){
                archivo.createNewFile();
            }
            
            FileReader lector = new FileReader(archivo);
            
            String texto = "";
            int caracter = lector.read();
            
            while (caracter != -1){
                texto += (char) caracter;
                caracter = lector.read();
            }
            
            lector.close();
            String[] lineas = texto.split("\n");

            for (int i = 0; i < lineas.length; i++){
                if (!lineas[i].trim().equals("")){
                    tareas.add(lineas[i]);
                }
            }
            
        } catch (IOException e){
            System.out.println("Error al leer el archivo.");
        }
        
        return tareas;
    }
    
    public String completarTarea(int numero) {
        
        ArrayList<String> tareas = leerTareas();
        
        if (numero < 1 || numero > tareas.size()) {
            return "";
        }
        
        String linea = tareas.get(numero - 1);
        String[] partes = linea.split("\\|");
        String tarea = partes[1];
        
        tareas.set(numero - 1, "1|" + tarea);
        
        try {
            FileWriter escribir = new FileWriter(archivo);
            
            for (int i = 0; i < tareas.size(); i++){
                escribir.write(tareas.get(i) + "\n");
            }
            
            escribir.close();

        } catch (IOException e) {
            System.out.println("Error al actualizar la tarea.");
            return "";
        }
        
        return tarea;
    }
    
}
