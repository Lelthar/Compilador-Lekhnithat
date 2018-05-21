/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador_dothraki;
import Gramatica.*;
import static java.lang.Math.abs;
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
        pila_parsing = new ArrayList<>();
        token_actual = null;
        eof_familia = 129;
        
    }
    
    public void iniciar_parsing(){
        int indice_lista_token = 0; //contador de la biblioteca de tokens
        
        token_actual = lista_tokens.get(indice_lista_token); //Obtiene el primer token
        System.out.println("Familia: "+token_actual.codigo_familia );
        
        push_pila_parsing(pila_parsing,Gramatica.NO_TERMINAL_INICIAL); //pushea el numero del no terminal inicial
        
        while(token_actual.codigo_familia != eof_familia){ // mientras no encuentre el EOF
            if(token_actual.codigo_familia==113 || token_actual.codigo_familia==114){
                indice_lista_token++;
                token_actual = lista_tokens.get(indice_lista_token); //Obtiene el primer token
            }else{
                if(pila_parsing.isEmpty()){
                    System.out.println("Pila de parsing vacia");
                    break;
                }
                elemento_actual_proceso = pop_pila_parsing(pila_parsing); //obtiene el numero que del primer no terminal
                //System.out.println("PROCESANDO ELEMENTO DE LA PILA: "+elemento_actual_proceso);
                if(Gramatica.esTerminal(elemento_actual_proceso)){ //si el elemento es terminal
                    if(elemento_actual_proceso ==  token_actual.codigo_familia){
                        indice_lista_token++;
                        System.out.println("Se valido el token: "+token_actual.lexema);
                        token_actual = lista_tokens.get(indice_lista_token);

                    }else{
                        System.out.println("Error  sintactico con el EAP(1): "+elemento_actual_proceso+" Y token: "+token_actual.lexema+
                                " Fila: "+token_actual.fila+", entre columnas: "+token_actual.columna_inicio+"|"+token_actual.columna_final);
                        //System.out.println("Se esperaba: "+elemento_actual_proceso);
                    }
                }else{
                    //System.out.println("Lexema: "+token_actual.lexema);
                    regla = Gramatica.getTablaParsing(abs(elemento_actual_proceso-Gramatica.NO_TERMINAL_INICIAL), token_actual.codigo_familia);
                    if(regla < 0){
                        System.out.println("Error  sintactico con el EAP(2): "+elemento_actual_proceso+" Y token: "+token_actual.lexema+
                                " Fila: "+token_actual.fila+", entre columnas: "+token_actual.columna_inicio+"|"+token_actual.columna_final);
                        //System.out.println("Procesando elemento: "+elemento_actual_proceso);
                        int follow = elemento_actual_proceso-Gramatica.NO_TERMINAL_INICIAL;
                        int i = 0;
                        //System.out.println("OBTENIENDO FOLLOWS PARA: "+follow);
                        ArrayList<Integer> listaFollow = new ArrayList<>();
                        while((Gramatica.getTablaFollows(follow, i)) > -1 && (i < Gramatica.MAX_FOLLOWS-1)){
                            int valorFollow =Gramatica.getTablaFollows(follow, i++);
                            //System.out.println("OBTIENE FOLLOW: "+valorFollow+" i: "+i);
                            listaFollow.add(valorFollow);

                        }
                        boolean bandera = false;
                        int valorPila=0;
                        for(int j=0;j<pila_parsing.size();j++){
                            valorPila = pop_pila_parsing(pila_parsing);
                            //System.out.println("ValorPila: "+valorPila);
                            for(int k=0;k<listaFollow.size();k++){
                                int valorFollow= listaFollow.get(listaFollow.size()-1-k);
                                if(valorPila==valorFollow){
                                    //System.out.println("Pila==Follow");
                                    bandera = true;
                                    break;
                                }
                            }
                            if(bandera==true){
                                break;
                            }
                        }
                        if(bandera==false){
                            push_pila_parsing(pila_parsing, valorPila);
                            //System.out.println("No se encontro follow correcto para:"+elemento_actual_proceso);                     
                            //System.out.println("Procesando NO-Teminal sin follow: "+ elemento_actual_proceso);
                            String desecho="";
                            while(indice_lista_token++<lista_tokens.size()){
                                Token tken = lista_tokens.get(indice_lista_token);
                                //System.out.println("Token de biblioteca: "+tken.lexema);
                                int existeRegla = Gramatica.getTablaParsing(abs(elemento_actual_proceso-Gramatica.NO_TERMINAL_INICIAL), tken.codigo_familia);
                                if(existeRegla!=-1){                                
                                    push_pila_parsing(pila_parsing, elemento_actual_proceso);
                                    token_actual=tken;
                                    //System.out.println("Codigo invalido debido al error: "+desecho);
                                    break;
                                }else{
                                    desecho+=tken.lexema;
                                }
                            }
                        }else{
                            int valorCorrecto = pop_pila_parsing(pila_parsing);
                            if(Gramatica.esTerminal(valorCorrecto)){
                                //System.out.println("Procesando Teminal: "+ valorCorrecto);
                                if(valorCorrecto==111){
                                    valorCorrecto=129;
                                }
                                String desecho ="";
                                while(indice_lista_token++<lista_tokens.size()-1){
                                    Token tken = lista_tokens.get(indice_lista_token);
                                    //System.out.println("VER: "+tken.codigo_familia);
                                    if(tken.codigo_familia==valorCorrecto){
                                        push_pila_parsing(pila_parsing, valorCorrecto);
                                        //System.out.println("Se encontro token del codigo con el token: "+tken.lexema);
                                        token_actual=tken;
                                        System.out.println("Codigo invalido debido al error: "+desecho);
                                        break;
                                    }else{
                                        desecho+=tken.lexema;
                                    }
                                }

                            }else{
                                //System.out.println("Procesando NO-Teminal: "+ valorCorrecto);
                                String desecho = "";
                                while(indice_lista_token++<lista_tokens.size()){
                                    Token tken = lista_tokens.get(indice_lista_token);
                                    //System.out.println("Token de biblioteca: "+tken.lexema);
                                    int existeRegla = Gramatica.getTablaParsing(abs(valorCorrecto-Gramatica.NO_TERMINAL_INICIAL), tken.codigo_familia);
                                    if(existeRegla!=-1){                                
                                        push_pila_parsing(pila_parsing, valorCorrecto);
                                        token_actual=tken;
                                        System.out.println("Codigo invalido debido al error: "+desecho);
                                        break;
                                    }else{
                                        desecho+=tken.lexema;
                                    }
                                    //System.out.println("Token invalido debido a errores: "+tken.lexema);
                                }
                            }
                        }


                    }else{
                        int i = 0;
                        //System.out.println("Reglas de "+Integer.toString(elemento_actual_proceso));
                        while((Gramatica.getLadosDerechos(regla,i)) > -1 && (i < Gramatica.MAX_LADO_DER)){
                            //System.out.println(Gramatica.getLadosDerechos(regla,i));
                            push_pila_parsing(pila_parsing, Gramatica.getLadosDerechos(regla,i++));
                        }
                    }
                }
            }
            
            
        }
        if(!pila_parsing.isEmpty()){
            System.out.println("Fin del archivo, se ha procesado con exito...");
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
