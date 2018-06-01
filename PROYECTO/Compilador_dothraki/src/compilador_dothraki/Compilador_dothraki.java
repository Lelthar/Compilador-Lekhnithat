/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador_dothraki;

import CosasLekknithat.Funciones;
import CosasLekknithat.Procedimientos;
import CosasLekknithat.Variables;
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
        Scanner scanner = new Scanner("prueba.lht");
        scanner.Inicializar_scanner();
        Parser parser = new Parser(scanner.lista_tokens);
        parser.iniciar_parsing();
        
        //semantico seman = new semantico();
        //seman.crearArchivoFuente("ARCHIVO");
        /*
        int n = (int) (Math.pow(2, 5)*10);
        System.out.println("N:"+n);
        TablaHash tabla = new TablaHash(n);
        Simbolo var = new Variables("cteA","1", "int", "1");
        Simbolo var1 = new Variables("cteB","1", "int", "1");
        Simbolo var2 = new Variables("cteC","1", "int", "1");
        Simbolo var3 = new Variables("cteD","1", "int", "1");
        Simbolo var4 = new Variables("a","1", "int", "1");
        Simbolo var5 = new Variables("b","1", "int", "1");
        Simbolo var6 = new Variables("c","1", "int", "1");
        Simbolo var7 = new Variables("d","1", "int", "1");
        Simbolo var8 = new Variables("e","1", "int", "1");
        Simbolo var9 = new Variables("f","1", "int", "1");
        Simbolo var10 = new Variables("h","1", "int", "1");
        Simbolo vara = new Variables("edad","1", "int", "1");
        Simbolo varb = new Variables("anho","1", "int", "1");
        
        tabla.insertarHash("cteA", var);
        tabla.insertarHash("cteB", var1);
        tabla.insertarHash("cteC", var2);
        tabla.insertarHash("cteD", var3);
        tabla.insertarHash("edad", vara);
        tabla.insertarHash("anho", varb);
        tabla.insertarHash("a", var4);
        tabla.insertarHash("b", var5);
        tabla.insertarHash("c", var6);
        tabla.insertarHash("d", var7);
        tabla.insertarHash("e", var8);
        //tabla.insertarHash("f", var9);
        tabla.insertarHash("h", var10);
        
        Simbolo varDevulta = tabla.buscarHash("f");
        
        if(varDevulta!=null){
            if(varDevulta instanceof Variables){
                Variables varR = (Variables) varDevulta;
                System.out.println(varR.toString());
            }else if(varDevulta instanceof Funciones){
                Funciones varR = (Funciones) varDevulta;
                System.out.println(varR.toString());
            }else if(varDevulta instanceof Procedimientos){
                Procedimientos varR = (Procedimientos) varDevulta;
                System.out.println(varR.toString());
            }
        }*/
    }
    
}
