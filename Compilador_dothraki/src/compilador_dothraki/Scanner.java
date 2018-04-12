/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador_dothraki;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;


/**
 *
 * @author Gerald
 */
public class Scanner {
    public ArrayList<Token> lista_tokens; 
    public String archivo_nombre = "prueba.txt";
    public int lineas;
    public int columna;
    public int estado_actual;
    public int estado_reserva;
    public String lexema;
    public int posicion;
    public byte[] buffer_size;
    public String buffer;
    public FileInputStream file; 
    public int largo;
    public char caracter_actual;
    public int[][] tabla_transiciones; 
    public HashMap<Character,Integer> alfabeto;

    
    public Scanner() throws IOException {
        lista_tokens = new ArrayList<>();
        alfabeto = new HashMap<Character,Integer>();
        generar_tabla_alfabeto();
        tabla_transiciones = obtener_tabla_transiciones();
    }
         
    public void Inicializar_scanner(String archivo) throws FileNotFoundException, IOException{
       archivo_nombre = archivo;
       if(archivo_nombre.endsWith(".lht")){
           lineas = 0;
           columna = 0;
           //estado_actual = 0;
           estado_reserva = -1;
           posicion = 0;
           buffer = "";
           caracter_actual = '1';
           boolean bandera_token = true;

           buffer_size = new byte[1024];
           file = new FileInputStream(archivo); 
           largo = -1;
           lexema = "";

           while ((largo = file.read(buffer_size)) != -1){ 
               buffer = new String(buffer_size, 0, largo).toLowerCase();
               estado_actual = 130;
               
               for(posicion = 0; posicion < buffer.length();posicion++){
                   
                   deme_siguiente_caracter();
         
                   if(caracter_actual > 0){
                        estado_actual = tabla_transiciones[estado_actual][alfabeto.get(caracter_actual)];
                        
                        if(posicion+1 == buffer.length() && lexema.length() > 0){
                            lexema += caracter_actual;
                            caracter_actual = ' ';
                            estado_actual = tabla_transiciones[estado_actual][alfabeto.get(caracter_actual)];
                        }
       
                        if(estado_actual < 125){ //Pone el tamaño de los terminales

                            if(bandera_token && lexema.length() > 1 && (caracter_actual != ' ' && caracter_actual != '\t' && caracter_actual != '\n' && caracter_actual != (char) 39 && caracter_actual != (char) 34)){
                                /*System.out.println("-------");
                                System.out.println("Posicion if 1: "+Integer.toString(posicion));
                                //System.out.println("Columna: "+);
                                System.out.println("-------");*/
                                bandera_token = false;
                                deme_token();
                                 //System.out.println("Token guardado");
                                estado_actual = 130; //Le pone el estado inicial
                                lexema = "";
                                lexema += caracter_actual;
                                tome_este_caracter();
                                caracter_actual = 0;
                            }else if(bandera_token){
                                bandera_token = true;

                                //
                                if((caracter_actual != ' ' && caracter_actual != '\t' && caracter_actual != '\n')){
                                    lexema += caracter_actual;
                                }

                               /* System.out.println("-------");
                                System.out.println("Posicion if 2: "+Integer.toString(posicion));
                                System.out.println("Estado: "+Integer.toString(estado_actual));
                                System.out.println("Lexema: "+lexema);
                                System.out.println("-------");*/

                                deme_token();

                                estado_actual = 130; //Le pone el estado inicial
                                lexema = "";

                                this.columna++;
                                caracter_actual = 0;

                            }else{
                                /*System.out.println("-------");
                                System.out.println("Posicion if 3: "+Integer.toString(posicion));
                                System.out.println("Estado: "+Integer.toString(estado_actual));
                                System.out.println("Lexema: "+lexema);
                                System.out.println("-------");*/
                                bandera_token = true;
                                //lexema += caracter_actual;
                                deme_token();

                                estado_actual = 130; //Le pone el estado inicial
                                lexema = "";
                                this.columna++;
                                caracter_actual = 0;

                            }
                        }else{
                            lexema += caracter_actual;
                            this.columna++;
                        }
                   }
                   

               }

           }
           for(int i = 0; i < lista_tokens.size(); i++){
               System.out.println(lista_tokens.get(i).toString());
           }

       }else{
           System.out.println("Error en la extensión del archivo introducido");
       }




    }

 
    public void deme_siguiente_caracter(){
       while(this.posicion < buffer.length()){
           if(this.buffer.charAt(this.posicion) == ' ' && this.lexema.isEmpty()){
               this.columna += 1;
               this.posicion++;
               //System.out.println("Espacio");
           }else if(buffer.charAt(this.posicion) == '\t' && this.lexema.isEmpty()){
               this.columna += 4;
               this.posicion++;
               //System.out.println("Tab");
           }else if(this.buffer.charAt(this.posicion) == '\n' && this.lexema.isEmpty()){
               this.lineas += 1;
               this.posicion++;
               this.columna = 0;
               //System.out.println("Salto de linea");
               //System.out.println("Salto de linea");
           }else{
               if(this.buffer.charAt(this.posicion) == ' '){
                    this.columna += 1;
                    //this.posicion++;
                    //System.out.println("Espacio");
                }else if(buffer.charAt(this.posicion) == '\t'){
                    this.columna += 4;
                    //this.posicion++;
                    //System.out.println("Tab");
                }else if(this.buffer.charAt(this.posicion) == '\n'){
                    this.lineas += 1;
                    //this.posicion++;
                    this.columna = 0;
                }
               //System.out.println("Salto de linea");
               //System.out.println("Salto de linea");
               //System.out.println("Caracter: "+Integer.toString(posicion));
               this.caracter_actual = this.buffer.charAt(this.posicion);
               break;
           }
       }

    }

    public void tome_este_caracter(){
       //this.columna--;
       this.posicion--;
    }

    public void finalizar_scanner() throws IOException{
        this.file.close(); //Finalizar scanner
    }


    public void deme_token(){
        Token token = new Token(this.estado_actual,this.lexema,this.lineas,this.columna-lexema.length(),this.columna,0);
        this.lista_tokens.add(token);
    }
 
    public void generar_tabla_alfabeto(){
        this.alfabeto.put('!',0);
        this.alfabeto.put('#',1);
        this.alfabeto.put('$',2);
        this.alfabeto.put('%',3);
        this.alfabeto.put('&',4);
        this.alfabeto.put('(',5);
        this.alfabeto.put(')',6);
        this.alfabeto.put('*',7);
        this.alfabeto.put('+',8);
        this.alfabeto.put(',',9);
        this.alfabeto.put('-',10);
        this.alfabeto.put('.',11);
        this.alfabeto.put('/',12);
        this.alfabeto.put('0',13);
        this.alfabeto.put('1',14);
        this.alfabeto.put('2',15);
        this.alfabeto.put('3',16);
        this.alfabeto.put('4',17);
        this.alfabeto.put('5',18);
        this.alfabeto.put('6',19);
        this.alfabeto.put('7',20);
        this.alfabeto.put('8',21);
        this.alfabeto.put('9',22);
        this.alfabeto.put(' ',23);
        this.alfabeto.put('\n',24);
        this.alfabeto.put('\t',25);
        this.alfabeto.put(':',26);
        this.alfabeto.put(';',27);
        this.alfabeto.put('<',28);
        this.alfabeto.put('=',29);
        this.alfabeto.put('>',30);
        this.alfabeto.put('?',31);
        this.alfabeto.put('@',32);
        this.alfabeto.put('[',33);
        this.alfabeto.put(']',34);
        this.alfabeto.put('^',35);
        this.alfabeto.put('_',36);
        this.alfabeto.put('a',37);
        this.alfabeto.put('b',38);
        this.alfabeto.put('c',39);
        this.alfabeto.put('d',40);
        this.alfabeto.put('e',41);
        this.alfabeto.put('f',42);
        this.alfabeto.put('g',43);
        this.alfabeto.put('h',44);
        this.alfabeto.put('i',45);
        this.alfabeto.put('j',46);
        this.alfabeto.put('k',47);
        this.alfabeto.put('l',48);
        this.alfabeto.put('m',49);
        this.alfabeto.put('n',50);
        this.alfabeto.put('o',51);
        this.alfabeto.put('p',52);
        this.alfabeto.put('q',53);
        this.alfabeto.put('r',54);
        this.alfabeto.put('s',55);
        this.alfabeto.put('t',56);
        this.alfabeto.put('u',57);
        this.alfabeto.put('v',58);
        this.alfabeto.put('w',59);
        this.alfabeto.put('x',60);
        this.alfabeto.put('y',61);
        this.alfabeto.put('z',62);
        this.alfabeto.put('{',63);
        this.alfabeto.put('|',64);
        this.alfabeto.put('}',65);
        this.alfabeto.put('~',66);
        this.alfabeto.put((char) 39,67);
        this.alfabeto.put((char) 34,68);
        this.alfabeto.put('M',69);
    }
    
   public int[][] obtener_tabla_transiciones() throws IOException{
        int[][] resultado = new int[407][70];
        try (
        BufferedReader br = new BufferedReader(new FileReader("src/compilador_dothraki/testfile.txt"))) {
        String line;
        int columna_actual = 0;
        int fila_actual = 0;
        while ((line = br.readLine()) != null) {
            String palabra = "";
        
           for(int i = 0; i < line.length(); i++){
               if(line.charAt(i) == '{' || line.charAt(i) == '}' || line.charAt(i) == ' '){
                   
               }else if(line.charAt(i) == ','){
                   resultado[fila_actual][columna_actual] = Integer.parseInt(palabra);
                   columna_actual++;
                   palabra = "";
               }else if(i+1 == line.length()){
                   resultado[fila_actual][columna_actual] = Integer.parseInt(palabra);
               }
               else{
                   palabra += line.charAt(i);
               }
           }
           //System.out.println(columna_actual);
           fila_actual++;
           columna_actual = 0;
        
        }       

        }
        return resultado;
   }
}
