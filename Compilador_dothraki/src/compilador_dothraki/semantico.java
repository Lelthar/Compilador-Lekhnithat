/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador_dothraki;

import java.util.ArrayList;

/**
 *
 * @author mailon2
 */
public class semantico {
    
    public semantico() {

    }
    
    public ArrayList<Integer>  prefijoTOsufijo(ArrayList<Token> lista_tokens){
        ArrayList<Integer> lista_interger = new ArrayList<>();
        ArrayList<Token> pila = new ArrayList<>();
        Token tk;      
        for(int i=0;i<lista_tokens.size();i++){
            
            Token TA = lista_tokens.get(i);
            int codigo = buscarPresedencia(TA.lexema);          
            //System.out.println("Codigo: "+codigo+" del lexema "+TA.lexema);
            if(TA.codigo_familia==129){               
            }else{
            switch(TA.codigo_familia){
                case 17: //parantesis (
                    push_pila_parsing(pila, TA);
                    break;
                case 18: //parentesisi )
                    for(int j=0;j<pila.size();j++){
                        if(!pila.isEmpty()){
                            Token token = pop_exp_pila_parsing(pila);
                            if(token.codigo_familia!=17){
                                lista_interger.add(pop_exp_pila_parsing(pila).codigo_familia); //saca el codigo de la pila
                                pop_pila_parsing(pila);
                            }else{
                                pop_pila_parsing(pila);
                                break;
                            }
                        }
                        pop_pila_parsing(pila);
                        break;
                    }
                    break;
                case 31: //parentesis cuadrado [
                    lista_interger.add(TA.codigo_familia); //agrega [ al resultado
                    break;
                case 32: 
                    lista_interger.add(TA.codigo_familia); // agrega ] al resultado
                    break;
                default: //Saber si un operador o valores
                    if(codigo!=-1){
                       // System.out.println("PROCESANDO OPERADOR");
                        if(pila.isEmpty()){
                            //System.out.println("Pila vacia");
                            push_pila_parsing(pila, TA);
                        }else{
                            for(int j=0;j<pila.size();j++){
                                if(!pila.isEmpty()){
                                    tk = pop_exp_pila_parsing(pila);
                                    int cd = buscarPresedencia(tk.lexema);
                                    if(codigo==cd){
                                        //System.out.println("IGUALES PRECEDENCIA");
                                        tk = pop_pila_parsing(pila);
                                        lista_interger.add(tk.codigo_familia); //agrega el -> al resultado
                                        push_pila_parsing(pila, TA);
                                        break;
                                    }else if(codigo>cd){
                                        //System.out.println("MAYOR PRECEDENCIA");
                                        //System.out.println("Codigo mayor: "+TA.lexema);
                                        push_pila_parsing(pila, TA);
                                        break;
                                    }else{
                                        //System.out.println("MENOR PRECEDENCIA");
                                        tk = pop_pila_parsing(pila);
                                        lista_interger.add(tk.codigo_familia); //agrega el -> al resultado
                                        push_pila_parsing(pila, TA);
                                    }
                                }

                                break;
                            }
                        }
                    }else{
                        lista_interger.add(TA.codigo_familia); //agrega el valor al resultado
                    }
                    break;
            }
            }
        }
        while(!pila.isEmpty()){
            tk = pop_pila_parsing(pila);
            lista_interger.add(tk.codigo_familia);
        }
        //operador = precedencia -> se cambia
        //operador > precedencia -> se agrega a pila
        //operador < precedencia -> se saca de la pila
        //parentisis derecho se saca la pila -> hasta el izquierdo
        return lista_interger;
    }
    
    public ArrayList<String>  prefijoTOsufijoString(ArrayList<Token> lista_tokens){
        ArrayList<String> lista_interger = new ArrayList<>();
        ArrayList<Token> pila = new ArrayList<>();
        Token tk;      
        for(int i=0;i<lista_tokens.size();i++){
            
            Token TA = lista_tokens.get(i);
            int codigo = buscarPresedencia(TA.lexema);          
            //System.out.println("Codigo: "+codigo+" del lexema "+TA.lexema);
            if(TA.codigo_familia==129){               
            }else{
            switch(TA.codigo_familia){
                case 17: //parantesis (
                    push_pila_parsing(pila, TA);
                    break;
                case 18: //parentesisi )
                    for(int j=0;j<pila.size();j++){
                        if(!pila.isEmpty()){
                            Token token = pop_exp_pila_parsing(pila);
                            if(token.codigo_familia!=17){
                                lista_interger.add(pop_exp_pila_parsing(pila).lexema); //saca el codigo de la pila
                                pop_pila_parsing(pila);
                            }else{
                                pop_pila_parsing(pila);
                                break;
                            }
                        }
                        pop_pila_parsing(pila);
                        break;
                    }
                    break;
                case 31: //parentesis cuadrado [
                    lista_interger.add(TA.lexema); //agrega [ al resultado
                    break;
                case 32: 
                    lista_interger.add(TA.lexema); // agrega ] al resultado
                    break;
                default: //Saber si un operador o valores
                    if(codigo!=-1){
                        //System.out.println("PROCESANDO OPERADOR");
                        if(pila.isEmpty()){
                           // System.out.println("Pila vacia");
                            push_pila_parsing(pila, TA);
                        }else{
                            for(int j=0;j<pila.size();j++){
                                if(!pila.isEmpty()){
                                    tk = pop_exp_pila_parsing(pila);
                                    int cd = buscarPresedencia(tk.lexema);
                                    if(codigo==cd){
                                        //System.out.println("IGUALES PRECEDENCIA");
                                        tk = pop_pila_parsing(pila);
                                        lista_interger.add(tk.lexema); //agrega el -> al resultado
                                        push_pila_parsing(pila, TA);
                                        break;
                                    }else if(codigo>cd){
                                        //System.out.println("MAYOR PRECEDENCIA");
                                        //System.out.println("Codigo mayor: "+TA.lexema);
                                        push_pila_parsing(pila, TA);
                                        break;
                                    }else{
                                        //System.out.println("MENOR PRECEDENCIA");
                                        tk = pop_pila_parsing(pila);
                                        lista_interger.add(tk.lexema); //agrega el -> al resultado
                                        push_pila_parsing(pila, TA);
                                    }
                                }

                                break;
                            }
                        }
                    }else{
                        lista_interger.add(TA.lexema); //agrega el valor al resultado
                    }
                    break;
            }
            }
        }
        while(!pila.isEmpty()){
            tk = pop_pila_parsing(pila);
            lista_interger.add(tk.lexema);
        }
        //operador = precedencia -> se cambia
        //operador > precedencia -> se agrega a pila
        //operador < precedencia -> se saca de la pila
        //parentisis derecho se saca la pila -> hasta el izquierdo
        return lista_interger;
    }
    
    private Token pop_pila_parsing(ArrayList<Token> pPila_parsing){
        Token resultado = pPila_parsing.get(pPila_parsing.size()-1);
        pPila_parsing.remove(pPila_parsing.size()-1);
        return resultado;
    }
    //Obtiene el tope de la pila sin extraerlo
    private Token pop_exp_pila_parsing(ArrayList<Token> pPila_parsing){
        Token resultado = pPila_parsing.get(pPila_parsing.size()-1);
        return resultado;
    }
    
    private void push_pila_parsing(ArrayList<Token> pPila_parsing,Token pSimboloInicial){
        pPila_parsing.add(pSimboloInicial);
    }
    
    private int buscarPresedencia(String lexema){
        String[] nivel0 = {"@","->"};
        String[] nivel1 = {"vo","yath","zohhe","<_>","<^>","<&>","<#>","%!","athzhokwazar"};
        String[] nivel2 = {"*","//","%"};
        String[] nivel3 = {"+","-"};
        String[] nivel4 = {"|><|"};
        String[] nivel5 = {"%+","%-"};
        String[] nivel6 = {"%~","%&"};
        String[] nivel7 = {"%?"};
        String[] nivel8 = {">",">=","<","<="};
        String[] nivel9 = {"=","<>"};
        String[] nivel10 = {"ma"};
        String[] nivel11 = {"che"};
        String[] nivel12 = {"xche"};
        String[] nivel13 = {"!"};
        ArrayList<String[]> listaNiveles = new ArrayList<>();
        listaNiveles.add(nivel13);
        listaNiveles.add(nivel12);
        listaNiveles.add(nivel11); 
        listaNiveles.add(nivel10);
        listaNiveles.add(nivel9); 
        listaNiveles.add(nivel8); 
        listaNiveles.add(nivel7);
        listaNiveles.add(nivel6); 
        listaNiveles.add(nivel5); 
        listaNiveles.add(nivel4); 
        listaNiveles.add(nivel3);
        listaNiveles.add(nivel2); 
        listaNiveles.add(nivel1); 
        listaNiveles.add(nivel0);
        
        for(int i=0;i<listaNiveles.size();i++){
            String[] nivel =listaNiveles.get(i);
            for(int j=0;j<nivel.length;j++){
                if(nivel[j].equals(lexema)){
                    return i;
                }
            }
        }       
        return -1;
    }
    
    
}
