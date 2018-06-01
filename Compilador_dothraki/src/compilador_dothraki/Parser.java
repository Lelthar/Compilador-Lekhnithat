/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador_dothraki;
import CosasLekknithat.Constantes;
import CosasLekknithat.TipoUsuario;
import CosasLekknithat.Variables;
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
    
    //Analisis semantico dependencias
    TablaHash tabla;
    
    private String variableValor;
    private String idLexema;
    private String tipoValor;
    private String familiaToken;
    private String familia_asignacion;
    private int dimensionInicializacionArreglo;
    private int dimensionDeclaracionArreglo;
    private ArrayList<String> listaIds;
    private ArrayList<String> lista_dimensiones;
    private String dimensionesLexema;
    private ArrayList<Token> lista_expresion;
    private boolean dentroExpresion;
    private ArrayList<Boolean> pila_expresion;
    private int contador_parentesis;
       
    
    public Parser(ArrayList<Token> pLista_tokens) {
        lista_tokens = pLista_tokens;
        pila_parsing = new ArrayList<>();
        token_actual = null;
        eof_familia = 129;
        inicializar_estructuras_semanticas();
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
                    if (elemento_actual_proceso == token_actual.codigo_familia) {
                        indice_lista_token++;
                        System.out.println("Se valido el token: " + token_actual.lexema);
                        token_actual = lista_tokens.get(indice_lista_token);

                    } else {
                        System.out.println("Error  sintactico con el EAP(1): " + elemento_actual_proceso + " Y token: " + token_actual.lexema);
                        //System.out.println("Se esperaba: "+elemento_actual_proceso);
                    }
                } else if(Gramatica.esNoTerminal(elemento_actual_proceso)){

                    //System.out.println("Lexema: "+token_actual.lexema);
                    regla = Gramatica.getTablaParsing(abs(elemento_actual_proceso - Gramatica.NO_TERMINAL_INICIAL), token_actual.codigo_familia);

                    if (regla < 0) {
                        System.out.println("Error  sintactico con el EAP(2): " + elemento_actual_proceso + " Y token: " + token_actual.lexema);
                        //System.out.println("Procesando elemento: "+elemento_actual_proceso);
                        int follow = elemento_actual_proceso - Gramatica.NO_TERMINAL_INICIAL;
                        int i = 0;
                        ArrayList<Integer> listaFollow = new ArrayList<>();
                        while ((Gramatica.getTablaFollows(follow, i)) > -1 && (i < Gramatica.MAX_FOLLOWS - 1)) {
                            int valorFollow = Gramatica.getTablaFollows(follow, i++);
                            System.out.println("OBTIENE FOLLOW: " + valorFollow + " i: " + i);
                            listaFollow.add(valorFollow);

                        }
                        boolean bandera = false;
                        int valorPila = 0;
                        for (int j = 0; j < pila_parsing.size(); j++) {
                            valorPila = pop_pila_parsing(pila_parsing);
                            //System.out.println("ValorPila: "+valorPila);
                            for (int k = 0; k < listaFollow.size(); k++) {
                                int valorFollow = listaFollow.get(listaFollow.size() - 1 - k);
                                if (valorPila == valorFollow) {
                                    //System.out.println("Pila==Follow");
                                    bandera = true;
                                    break;
                                }
                            }
                            if (bandera == true) {
                                break;
                            }
                        }
                        if (bandera == false) {
                            push_pila_parsing(pila_parsing, valorPila);
                            //System.out.println("No se encontro follow correcto para:"+elemento_actual_proceso);                     
                            //System.out.println("Procesando NO-Teminal sin follow: "+ elemento_actual_proceso);
                            String desecho = "";
                            while (indice_lista_token++ < lista_tokens.size()) {
                                Token token = lista_tokens.get(indice_lista_token);
                                //System.out.println("Token de biblioteca: "+tken.lexema);
                                int existeRegla = Gramatica.getTablaParsing(abs(elemento_actual_proceso - Gramatica.NO_TERMINAL_INICIAL), token.codigo_familia);
                                if (existeRegla != -1) {
                                    push_pila_parsing(pila_parsing, elemento_actual_proceso);
                                    token_actual = token;
                                    System.out.println("Codigo invalido debido al error: " + desecho);
                                    break;
                                } else {
                                    desecho += token.lexema;
                                }
                            }
                        } else {
                            int valorCorrecto = pop_pila_parsing(pila_parsing);
                            if (Gramatica.esTerminal(valorCorrecto)) {
                                System.out.println("Procesando Teminal: " + valorCorrecto);
                                if (valorCorrecto == 111) {
                                    valorCorrecto = 129;
                                }
                                String desecho = "";
                                while (indice_lista_token++ < lista_tokens.size() - 1) {
                                    Token tken = lista_tokens.get(indice_lista_token);
                                    //System.out.println("VER: "+tken.codigo_familia);
                                    if (tken.codigo_familia == valorCorrecto) {
                                        push_pila_parsing(pila_parsing, valorCorrecto);
                                        System.out.println("Se encontro token del codigo con el token: " + tken.lexema);
                                        token_actual = tken;
                                        System.out.println("Codigo invalido debido al error: " + desecho);
                                        break;
                                    } else {
                                        desecho += tken.lexema;
                                    }
                                }

                            } else {
                                //System.out.println("Procesando NO-Teminal: "+ valorCorrecto);
                                String desecho = "";
                                while (indice_lista_token++ < lista_tokens.size()) {
                                    Token tken = lista_tokens.get(indice_lista_token);
                                    //System.out.println("Token de biblioteca: "+tken.lexema);
                                    int existeRegla = Gramatica.getTablaParsing(abs(valorCorrecto - Gramatica.NO_TERMINAL_INICIAL), tken.codigo_familia);
                                    if (existeRegla != -1) {
                                        push_pila_parsing(pila_parsing, valorCorrecto);
                                        token_actual = tken;
                                        System.out.println("Codigo invalido debido al error: " + desecho);
                                        break;
                                    } else {
                                        desecho += tken.lexema;
                                    }
                                    //System.out.println("Token invalido debido a errores: "+tken.lexema);
                                }
                            }
                        }

                    } else {
                        int i = 0;
                        //System.out.println("Reglas de "+Integer.toString(elemento_actual_proceso));
                        while ((Gramatica.getLadosDerechos(regla, i)) > -1 && (i < Gramatica.MAX_LADO_DER)) {
                            //System.out.println(Gramatica.getLadosDerechos(regla,i));
                            push_pila_parsing(pila_parsing, Gramatica.getLadosDerechos(regla, i++));
                        }
                    }
                    
                //Aqui empieza el analisis semantico
                }else if(Gramatica.esSimboloSemantico(elemento_actual_proceso)){
                    switch(elemento_actual_proceso){
                        case Gramatica.hake: //Agrega el nombre del programa a la tabla de simbolos
                            idLexema = lista_tokens.get(indice_lista_token).lexema;
                            break;
                        case Gramatica.constanteID:
                            idLexema = lista_tokens.get(indice_lista_token).lexema;
                            break;
                        case Gramatica.asignarValoresConstante1:
                            variableValor = lista_tokens.get(indice_lista_token).lexema;
                            break;
                        case Gramatica.agregarConjunto1:
                            variableValor += lista_tokens.get(indice_lista_token).lexema;
                            lista_expresion.add(token_actual);
                            break;
                        case Gramatica.agregarConjunto2:
                            variableValor += lista_tokens.get(indice_lista_token).lexema;
                            lista_expresion.add(token_actual);
                            break;
                        case Gramatica.agregarValoresConjunto1:
                            variableValor += lista_tokens.get(indice_lista_token).lexema;
                            lista_expresion.add(token_actual);
                            break;
                        case Gramatica.agregarValoresConjunto2:
                            variableValor += lista_tokens.get(indice_lista_token).lexema;
                            lista_expresion.add(token_actual);
                            break;
                        case Gramatica.agregarValoresConjunto3:
                            variableValor += lista_tokens.get(indice_lista_token).lexema;
                            lista_expresion.add(token_actual);
                            break;
                        case Gramatica.agregarArreglo1:
                            variableValor += lista_tokens.get(indice_lista_token).lexema;
                            dimensionInicializacionArreglo++;
                            lista_expresion.add(token_actual);
                            break;
                        case Gramatica.agregarArreglo2:
                            variableValor += lista_tokens.get(indice_lista_token).lexema;
                            lista_expresion.add(token_actual);
                            break;
                        case Gramatica.agregarNivelArreglo1:
                            variableValor += lista_tokens.get(indice_lista_token).lexema;
                            lista_expresion.add(token_actual);
                            dimensionInicializacionArreglo++;
                            break; 
                        case Gramatica.agregarNivelArreglo2:
                            variableValor += lista_tokens.get(indice_lista_token).lexema;
                            lista_expresion.add(token_actual);
                            break; 
                        case Gramatica.agrandarNivelArreglo1:
                            variableValor += lista_tokens.get(indice_lista_token).lexema;
                            lista_expresion.add(token_actual);
                            break;
                        case Gramatica.agregarValorArreglo1:
                            variableValor += lista_tokens.get(indice_lista_token).lexema;
                            lista_expresion.add(token_actual);
                            break;
                        case Gramatica.agregarValorArreglo2:
                            variableValor += lista_tokens.get(indice_lista_token).lexema;
                            lista_expresion.add(token_actual);
                            break;
                        case Gramatica.agregarValorArreglo3:
                            variableValor += lista_tokens.get(indice_lista_token).lexema;
                            lista_expresion.add(token_actual);
                            break;
                        case Gramatica.agregarCampo1:
                            variableValor += lista_tokens.get(indice_lista_token).lexema;
                            lista_expresion.add(token_actual);
                            break;
                        case Gramatica.agregarCampo2:
                            variableValor += lista_tokens.get(indice_lista_token).lexema;
                            lista_expresion.add(token_actual);
                            break;
                        case Gramatica.agregarCampo3:
                            variableValor += lista_tokens.get(indice_lista_token).lexema;
                            lista_expresion.add(token_actual);
                            break;
                        case Gramatica.agregarValorCampo1:
                            variableValor += lista_tokens.get(indice_lista_token).lexema;
                            lista_expresion.add(token_actual);
                            break;
                        case Gramatica.agregarValorCampo2:
                            variableValor += lista_tokens.get(indice_lista_token).lexema;
                            lista_expresion.add(token_actual);
                            break;
                        case Gramatica.agregarConstante: //Agrega la constante a la tabla de simbolos
                            Simbolo constanteTS = tabla.buscarHash(idLexema);
                            if(constanteTS == null){
                                System.out.println("Asignacion lexema es: "+variableValor+" El id es: "+idLexema);
                                constanteTS = new Constantes(idLexema,"1", variableValor);
                                tabla.insertarHash(idLexema, constanteTS);
                            }else{
                                System.out.println("ERROR: El nombre de la constante ya existe.");
                            }
                            
                            variableValor = "";
                            idLexema = "";
                            dimensionInicializacionArreglo = 0;
                            break;
                        case Gramatica.crearTipoNombre:
                            idLexema = lista_tokens.get(indice_lista_token).lexema;
                            break;
                        case Gramatica.asignarTipo1:
                            tipoValor = lista_tokens.get(indice_lista_token).lexema;
                            familiaToken = Integer.toString(lista_tokens.get(indice_lista_token).codigo_familia);
                            break;
                        case Gramatica.asignarTipo2:
                            tipoValor = lista_tokens.get(indice_lista_token).lexema;
                            familiaToken = Integer.toString(lista_tokens.get(indice_lista_token).codigo_familia);
                            break;
                        case Gramatica.asignarTipo3:
                            tipoValor = lista_tokens.get(indice_lista_token).lexema;
                            familiaToken = Integer.toString(lista_tokens.get(indice_lista_token).codigo_familia);
                            break;
                        case Gramatica.asignarTipo4:
                            tipoValor = lista_tokens.get(indice_lista_token).lexema;
                            familiaToken = Integer.toString(lista_tokens.get(indice_lista_token).codigo_familia);
                            break;
                        case Gramatica.asignarTipo5:
                            tipoValor = lista_tokens.get(indice_lista_token).lexema;
                            familiaToken = Integer.toString(lista_tokens.get(indice_lista_token).codigo_familia);
                            break;
                        case Gramatica.agregarNuevoTipo:
                            Simbolo tipoNuevo = tabla.buscarHash(idLexema);
                            if(tipoNuevo == null){
                                if(familiaToken.equals("1") && tabla.buscarHash(tipoValor) != null){
                                    System.out.println("Tipo  es: "+tipoValor+" El id es: "+idLexema);
                                    tipoNuevo = new TipoUsuario(idLexema,"2", tipoValor);
                                    tabla.insertarHash(idLexema, tipoNuevo);
                                }else if(familiaToken.equals("1") && tabla.buscarHash(tipoValor) == null){
                                    System.out.println("ERROR: El valor asignado no existe.");
                                }else{
                                    System.out.println("Tipo  es: "+tipoValor+" El id es: "+idLexema);
                                    tipoNuevo = new TipoUsuario(idLexema,"2", tipoValor);
                                    tabla.insertarHash(idLexema, tipoNuevo);
                                }
                                
                            }else{
                                System.out.println("ERROR: El nombre de la constante ya existe.");
                            }
                            tipoValor = "";
                            idLexema = "";
                            familiaToken = "";
                            break;
                        case Gramatica.nuevoVariableID1:
                            listaIds.add(lista_tokens.get(indice_lista_token).lexema);
                            break;
                        case Gramatica.nuevoVariableID2:
                            listaIds.add(lista_tokens.get(indice_lista_token).lexema);
                            break;
                        case Gramatica.asignarVariable1:
                            tipoValor = lista_tokens.get(indice_lista_token).lexema;
                            familiaToken = Integer.toString(lista_tokens.get(indice_lista_token).codigo_familia);
                            break;
                        case Gramatica.inicializacionVariable1:
                            variableValor = lista_tokens.get(indice_lista_token).lexema;
                            familia_asignacion = Integer.toString(lista_tokens.get(indice_lista_token).codigo_familia);
                            break;
                        case Gramatica.asignarVariable2:
                            tipoValor = lista_tokens.get(indice_lista_token).lexema;
                            familiaToken = Integer.toString(lista_tokens.get(indice_lista_token).codigo_familia);
                            break;
                        case Gramatica.inicializacionConjunto1:
                            variableValor += lista_tokens.get(indice_lista_token).lexema;
                            break;
                        case Gramatica.inicializacionConjunto2:
                            variableValor += lista_tokens.get(indice_lista_token).lexema;
                            break;
                        case Gramatica.asignarVariable3:
                            tipoValor = lista_tokens.get(indice_lista_token).lexema;
                            familiaToken = Integer.toString(lista_tokens.get(indice_lista_token).codigo_familia);
                            break;
                        case Gramatica.crearDimensionalidad1:
                            dimensionDeclaracionArreglo++;
                            dimensionesLexema += lista_tokens.get(indice_lista_token).lexema;
                            break;
                        case Gramatica.valorDimension1:
                            lista_dimensiones.add(lista_tokens.get(indice_lista_token).lexema);
                            dimensionesLexema += lista_tokens.get(indice_lista_token).lexema;
                            break;
                        case Gramatica.crearDimensionalidad2:
                            dimensionesLexema += lista_tokens.get(indice_lista_token).lexema;
                            break;
                        case Gramatica.agregarDimension1:
                            dimensionDeclaracionArreglo++;
                            dimensionesLexema += lista_tokens.get(indice_lista_token).lexema;
                            break;
                        case Gramatica.valorDimension2:
                            lista_dimensiones.add(lista_tokens.get(indice_lista_token).lexema);
                            dimensionesLexema += lista_tokens.get(indice_lista_token).lexema;
                            break;
                        case Gramatica.agregarDimension2:
                            dimensionesLexema += lista_tokens.get(indice_lista_token).lexema;
                            break;
                        case Gramatica.inicializarArreglo1:
                            dimensionInicializacionArreglo++;
                            variableValor += lista_tokens.get(indice_lista_token).lexema;
                            break;
                        case Gramatica.inicializarArreglo2:
                            variableValor += lista_tokens.get(indice_lista_token).lexema;
                            break; 
                        case Gramatica.creacionVariable1:
                            for(int i = 0; i < listaIds.size();i++){
                                Simbolo variableTS = tabla.buscarHash(listaIds.get(i));
                                //(String identificador, String codigo, String tipo, String valorInicializacion)
                                if(variableTS == null){
                                    if(familia_asignacion.equals("1") && tabla.buscarHash(variableValor) != null){
                                        System.out.println("Tipo  es: "+variableValor+" El id es: "+listaIds.get(i));
                                        variableTS = new Variables(listaIds.get(i),"3", tipoValor, variableValor);
                                        tabla.insertarHash(listaIds.get(i), variableTS);
                                    }else if(familia_asignacion.equals("1") && tabla.buscarHash(variableValor) == null){
                                        System.out.println("ERROR: El valor asignado no existe.");
                                    }else{
                                        System.out.println("Tipo  es: "+variableValor+" El id es: "+listaIds.get(i));
                                        variableTS = new Variables(listaIds.get(i),"3", tipoValor, variableValor);
                                        tabla.insertarHash(listaIds.get(i), variableTS);
                                    }
                                }else{
                                    System.out.println("ERROR: El nombre de la constante ya existe."+tabla.buscarHash(listaIds.get(i)));
                                }
                            }
                            listaIds.clear();
                            variableValor = "";
                            tipoValor = "";
                            break;
                        case Gramatica.agregarParentesisIzqExp:
                            lista_expresion.add(token_actual);
                            contador_parentesis++;
                            break;
                        case Gramatica.agregarParentesisDerExp:
                            lista_expresion.add(token_actual);
                            contador_parentesis--;
                            break;
                        case Gramatica.agregarOperandos1:
                            lista_expresion.add(token_actual);
                            break;
                        case Gramatica.agregarOperandos2:
                            lista_expresion.add(token_actual);
                            break;
                        case Gramatica.agregarOperandos3:
                            lista_expresion.add(token_actual);
                            break;
                        case Gramatica.agregarOperandos4:
                            lista_expresion.add(token_actual);
                            break;
                        case Gramatica.agregarOperandos5:
                            lista_expresion.add(token_actual);
                            break;
                        case Gramatica.agregarOperandos6:
                            lista_expresion.add(token_actual);
                            break;
                        case Gramatica.agregarOperandos7:
                            lista_expresion.add(token_actual);
                            break;
                        case Gramatica.agregarOperandos8:
                            lista_expresion.add(token_actual);
                            break;
                        case Gramatica.agregarOperandos9:
                            lista_expresion.add(token_actual);
                            break;
                        case Gramatica.accesoStrings1:
                            lista_expresion.add(token_actual);
                            break;
                        case Gramatica.accesoStrings2:
                            lista_expresion.add(token_actual);
                            break;
                        case Gramatica.accesoRegistros1:
                            lista_expresion.add(token_actual);
                            break;
                        case Gramatica.accesoRegistros2:
                            lista_expresion.add(token_actual);
                            break;
                        case Gramatica.agregarOperando1:
                            Simbolo variableTS = tabla.buscarHash(token_actual.lexema);
                            if(variableTS != null){
                                lista_expresion.add(token_actual);
                            }else{
                                System.out.println("Error: La variable no ha sido declarada anteriormente.");
                            }
                            
                            break;
                        case Gramatica.agregarOperando2:
                            lista_expresion.add(token_actual);
                            break;
                        case Gramatica.agregarOperando3:
                            lista_expresion.add(token_actual);
                            break;
                        case Gramatica.agregarOperando4:
                            lista_expresion.add(token_actual);
                            break;
                        case Gramatica.agregarOperando5:
                            lista_expresion.add(token_actual);
                            break;
                        case Gramatica.agregarOperacion1:
                            lista_expresion.add(token_actual);
                            break;
                        case Gramatica.agregarOperacion2:
                            lista_expresion.add(token_actual);
                            break;
                        case Gramatica.inicializarExpresion:
                            if(!dentroExpresion){
                                lista_expresion.clear();
                                dentroExpresion = true;
                            }
                            
                            break;
                        case Gramatica.finalizarExpresion1:
                            if(contador_parentesis == 0){
                                for(int i = 0; i < lista_expresion.size(); i++){
                                    System.out.println("Lexema: "+lista_expresion.get(i).lexema);
                                }
                                dentroExpresion = false;
                            }
                            
                            break;
                        case Gramatica.finalizarExpresion2:
                            if(contador_parentesis == 0){
                                for(int i = 0; i < lista_expresion.size(); i++){
                                    System.out.println("Lexema: "+lista_expresion.get(i).lexema);
                                }
                                dentroExpresion = false;
                            }
                            break;
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
    
    private void inicializar_estructuras_semanticas(){
        tabla = new TablaHash(320);
        dimensionInicializacionArreglo = 0;
        dimensionDeclaracionArreglo = 0;
        variableValor = "";
        idLexema = "";
        tipoValor = "";
        listaIds = new ArrayList<>();
        familia_asignacion = "";
        lista_dimensiones = new ArrayList<>();
        dimensionesLexema = "";
        lista_expresion = new ArrayList<>();
        dentroExpresion = false;
        pila_expresion = new ArrayList<>();
        contador_parentesis = 0;
    }
    
}
