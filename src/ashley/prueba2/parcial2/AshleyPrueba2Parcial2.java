/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ashley.prueba2.parcial2;

/**
 *
 * @author ashley
 */

import java.util.ArrayList;
import java.util.Scanner;

public class AshleyPrueba2Parcial2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        // TODO code application logic here
        
        Scanner leer = new Scanner(System.in);
        GestorTareas gestor = new GestorTareas();
        
        int opcion = 0;
        
        while (opcion != 4){
            
            System.out.println("GESTOR DE TAREAS");
            System.out.println("====================");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Mostrar tareas");
            System.out.println("3. Completar tarea");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");
            
            opcion = leer.nextInt();
            leer.nextLine();
            
            if (opcion == 1){
                
                System.out.print("Ingresa la nueva tarea: ");
                String tarea = leer.nextLine();
                
                gestor.agregarTarea(tarea);
                
                System.out.println();
                System.out.println("✓ Tarea agregada: " + tarea);
                System.out.println();
            }
            
            if (opcion == 2){
                
                ArrayList<String> tareas = gestor.leerTareas();
                
                System.out.println();
                System.out.println("LISTA DE TAREAS");
                System.out.println("====================");
                
                int contador = 1;
                for (String linea : tareas) {
                    
                    String[] partes = linea.split("\\|");
                    String estado = partes[0];
                    String tarea = partes[1];
                    
                    if (estado.equals("1")) {
                        System.out.println(contador + ". [✓] " + tarea);
                    } else {
                        System.out.println(contador + ". [ ] " + tarea);
                    }
                    
                    contador++;
                }
                System.out.println();
            }

            if (opcion == 3){

                System.out.print("Número de tarea a completar: ");
                int numero = leer.nextInt();
                leer.nextLine();

                String tarea = gestor.completarTarea(numero);
                System.out.println();
                
                if (!tarea.equals("")){
                    System.out.println("✓ Tarea #" + numero + " completada: " + tarea);
                    
                } else{
                    System.out.println("Número de tarea inválido");
                }
                
                System.out.println();
            }
            
            if (opcion == 4) {
                System.out.println("Saliendo...");
            }
        }
        
        leer.close();
        
    }
    
}
