/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador_dothraki;
import Gramatica.*;
import java.util.ArrayList;

/**
 *
 * @author gerald
 */
public class Parser {
    public ArrayList<Token> lista_tokens;
    public ArrayList<Integer> pila_parsing;
    public Token token_actual;
    private int eof_familia;
    private int elemento_actual_proceso;
    private int regla;
    private int simbolo_inicial;
    
    public Parser(ArrayList<Token> pLista_tokens) {
        lista_tokens = pLista_tokens;
        System.out.println(lista_tokens.size());
        pila_parsing = new ArrayList<>();
        token_actual = null;
        eof_familia = 129;
        
    }
    
    public void iniciar_parsing(){
        int indice_lista_token = 0; //contador de la biblioteca de tokens
        
        token_actual = lista_tokens.get(indice_lista_token); //Obtiene el primer token
        
        push_pila_parsing(pila_parsing,Gramatica.NO_TERMINAL_INICIAL); //pushea el numero del no terminal inicial
        
        while(token_actual.codigo_familia != eof_familia){ // mientras no encuentre el EOF
            elemento_actual_proceso = pop_pila_parsing(pila_parsing); //obtiene el numero que del primer no terminal
            
            if(Gramatica.esTerminal(elemento_actual_proceso)){ //si el elemento es terminal
                System.out.println("Terminal");
                if(elemento_actual_proceso ==  token_actual.codigo_familia){
                    indice_lista_token++;
                    token_actual = lista_tokens.get(indice_lista_token);
                }else{
                    indice_lista_token++;
                    token_actual = lista_tokens.get(indice_lista_token);
                    System.out.println("Error");
                }
            }else{
                System.out.println("No-Terminal");
                regla = Gramatica.getTablaParsing((elemento_actual_proceso-Gramatica.NO_TERMINAL_INICIAL), token_actual.codigo_familia);
                if(regla < 0){
                    System.out.println("Error sintactico");
                }else{
                    int i = 0;
                    while((Gramatica.getLadosDerechos(regla,i)) > -1 && (i < Gramatica.MAX_LADO_DER)){                       
                        push_pila_parsing(pila_parsing, Gramatica.getLadosDerechos(regla,i++));
                    }
                }
            }
            
        }
        if(!pila_parsing.isEmpty()){
            System.out.println("Largo: "+Integer.toString(pila_parsing.size()));
            System.out.println("Este es: "+Integer.toString(pila_parsing.get(pila_parsing.size()-1)));
            System.out.println("ERROR: Fin de archivo inesperado");
        }
    }
    
    private int pop_pila_parsing(ArrayList<Integer> pPila_parsing){
        int resultado = pPila_parsing.get(pPila_parsing.size()-1);
        pPila_parsing.remove(pPila_parsing.size()-1);
        return resultado;
    }
    
    private void push_pila_parsing(ArrayList<Integer> pPila_parsing,int pSimboloInicial){
        pPila_parsing.add(pSimboloInicial);
    }
    
}
