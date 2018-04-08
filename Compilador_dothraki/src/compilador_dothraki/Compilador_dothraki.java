/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador_dothraki;

import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author Gerald
 */
public class Compilador_dothraki {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner scanner = new Scanner();
        scanner.Inicializar_scanner("prueba.lht");
        //System.out.println(Arrays.toString(scanner.tabla_transiciones));
        /*for(int i = 0; i < scanner.tabla_transiciones.length; i++){
            for(int j = 0; j < scanner.tabla_transiciones[0].length; j++){
                System.out.print(Integer.toString(scanner.tabla_transiciones[i][j])+", ");
            }
            System.out.println("");
            System.out.println("");
        }*/
        //System.out.println(scanner.tabla_transiciones[130][18]);
        //System.out.println(scanner.alfabeto.toString());;
    }
    
}
