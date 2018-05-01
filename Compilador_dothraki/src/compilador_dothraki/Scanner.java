/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador_dothraki;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

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
    public String lexema;
    public int posicion;
    public byte[] buffer_size;
    public String buffer;
    public FileInputStream file; 
    public int largo;
    public char caracter_actual;
    public int[][] tabla_transiciones; 
    public HashMap<Character,Integer> alfabeto;
    public HashMap<Integer,String> paleta_colores;
    public int codigo_error;

    
    public Scanner() throws IOException {
        lista_tokens = new ArrayList<>();
        alfabeto = new HashMap<Character,Integer>();
        generar_tabla_alfabeto();
        tabla_transiciones = obtener_tabla_transiciones();
        paleta_colores = new HashMap<Integer,String>();
        generar_paleta_colores();
    }
         
    public void Inicializar_scanner(String archivo) throws FileNotFoundException, IOException{
       archivo_nombre = archivo;
       if(archivo_nombre.endsWith(".lht")){
           lineas = 0;
           columna = 0;
           //estado_actual = 0;
           posicion = 0;
           buffer = "";
           caracter_actual = '1';
           boolean bandera_token = true;

           buffer_size = new byte[1024];
           file = new FileInputStream(archivo); 
           largo = -1;
           lexema = "";
           estado_actual = 130;
           codigo_error = 0;

           while ((largo = file.read(buffer_size)) != -1){ 
               buffer = new String(buffer_size, 0, largo).toLowerCase();
              // 
               
               for(posicion = 0; posicion < buffer.length();posicion++){
                   
                   deme_siguiente_caracter();
         
                   if(caracter_actual > 0){
                        if(alfabeto.containsKey(caracter_actual)){
                            estado_actual = tabla_transiciones[estado_actual][alfabeto.get(caracter_actual)];
                        }else{
                            estado_actual = 467;
                        }
                        
                        if(estado_actual < 125){ //Pone el tamaño de los terminales
                           

                            if(caracter_actual == ' ' || caracter_actual == '\t' || caracter_actual == '\n'){
                               
                                deme_token();

                                estado_actual = 130; //Le pone el estado inicial
                                lexema = "";
                                
                                caracter_actual = 0;
                                
                                if(this.buffer.charAt(this.posicion) == ' '){
                                    this.columna += 1;

                                }else if(buffer.charAt(this.posicion) == '\t'){
                                    this.columna += 4;

                                }else if(this.buffer.charAt(this.posicion) == '\n'){
                                    this.lineas += 1;

                                    this.columna = 0;
                                }
                               
                            }else{
                                
                                deme_token();
                        
                                estado_actual = 130; //Le pone el estado inicial
                                lexema = "";
                                tome_este_caracter();
                                caracter_actual = 0;
                                
                                

                            }
                            
                        }else if(estado_actual > 467){

                            //lexema += caracter_actual;
                           
                            codigo_error = 1;

                            deme_token();

                            estado_actual = 130; //Le pone el estado inicial
                            lexema = "";
                            
                            codigo_error = 0;

                            tome_este_caracter();
                            caracter_actual = 0;
                                
                        }else{
                            lexema += caracter_actual;
                            this.columna++;
                        }
                   }

               }

           }
           if(lexema.length() > 0){
                caracter_actual = ' ';
                estado_actual = tabla_transiciones[estado_actual][alfabeto.get(caracter_actual)];
                            
                if(estado_actual < 125){
                    deme_token();
                }
            }
            Token token = new Token(129,"EOF",this.lineas,this.columna++,this.columna++,0);
            this.lista_tokens.add(token);
            generar_muro_ladrillos();
            /*for(int i = 0; i < lista_tokens.size(); i++){
                System.out.println(lista_tokens.get(i).toString());
            }*/
           

       }else{
           System.out.println("Error en la extensión del archivo introducido");
       }

    }

 
    public void deme_siguiente_caracter(){
       while(this.posicion < buffer.length()){
           if(this.buffer.charAt(this.posicion) == ' ' && this.lexema.isEmpty()){
               this.columna += 1;
               this.posicion++;
               
           }else if(buffer.charAt(this.posicion) == '\t' && this.lexema.isEmpty()){
               this.columna += 4;
               this.posicion++;
               //System.out.println("Tab");
           }else if(this.buffer.charAt(this.posicion) == '\n' && this.lexema.isEmpty()){
               this.lineas += 1;
               this.posicion++;
               this.columna = 0;

           }else{
               this.caracter_actual = this.buffer.charAt(this.posicion);
               break;
           }
       }

    }

    public void tome_este_caracter(){
       //lexema += caracter_actual;
       this.posicion--;
    }

    public void finalizar_scanner() throws IOException{
        this.file.close(); //Finalizar scanner
    }


    public void deme_token(){
        Token token = new Token(this.estado_actual,this.lexema,this.lineas,this.columna-lexema.length(),this.columna-1,this.codigo_error);
        this.lista_tokens.add(token);
    }
    
    public void generar_paleta_colores(){
        this.paleta_colores.put(0,"#0d62bb");
        this.paleta_colores.put(1,"#060c73");
        this.paleta_colores.put(2,"#07da0d");
        this.paleta_colores.put(3,"#09a7a7");
        this.paleta_colores.put(4,"#0b7541");
        this.paleta_colores.put(5,"#0d42db");
        this.paleta_colores.put(6,"#0f1075");
        this.paleta_colores.put(7,"#10de0f");
        this.paleta_colores.put(8,"#12aba9");
        this.paleta_colores.put(9,"#147943");
        this.paleta_colores.put(10,"#1646dd");
        this.paleta_colores.put(11,"#181477");
        this.paleta_colores.put(12,"#19e211");
        this.paleta_colores.put(13,"#1bafab");
        this.paleta_colores.put(14,"#1d7d45");
        this.paleta_colores.put(15,"#1f4adf");
        this.paleta_colores.put(16,"#211879");
        this.paleta_colores.put(17,"#22e613");
        this.paleta_colores.put(18,"#24b3ad");
        this.paleta_colores.put(19,"#268147");
        this.paleta_colores.put(20,"#284ee1");
        this.paleta_colores.put(21,"#2a1c7b");
        this.paleta_colores.put(22,"#2bea15");
        this.paleta_colores.put(23,"#2db7af");
        this.paleta_colores.put(24,"#2f8549");
        this.paleta_colores.put(25,"#3152e3");
        this.paleta_colores.put(26,"#33207d");
        this.paleta_colores.put(27,"#34ee17");
        this.paleta_colores.put(28,"#36bbb1");
        this.paleta_colores.put(29,"#38894b");
        this.paleta_colores.put(30,"#3a56e5");
        this.paleta_colores.put(31,"#3c247f");
        this.paleta_colores.put(32,"#3df219");
        this.paleta_colores.put(33,"#3fbfb3");
        this.paleta_colores.put(34,"#418d4d");
        this.paleta_colores.put(35,"#435ae7");
        this.paleta_colores.put(36,"#452881");
        this.paleta_colores.put(37,"#46f61b");
        this.paleta_colores.put(38,"#48c3b5");
        this.paleta_colores.put(39,"#4a914f");
        this.paleta_colores.put(40,"#4c5ee9");
        this.paleta_colores.put(41,"#4e2c83");
        this.paleta_colores.put(42,"#4ffa1d");
        this.paleta_colores.put(43,"#51c7b7");
        this.paleta_colores.put(44,"#539551");
        this.paleta_colores.put(45,"#5562eb");
        this.paleta_colores.put(46,"#573085");
        this.paleta_colores.put(47,"#58fe1f");
        this.paleta_colores.put(48,"#5acbb9");
        this.paleta_colores.put(49,"#5c9953");
        this.paleta_colores.put(50,"#5e66ed");
        this.paleta_colores.put(51,"#603487");
        this.paleta_colores.put(52,"#620221");
        this.paleta_colores.put(53,"#63cfbb");
        this.paleta_colores.put(54,"#659d55");
        this.paleta_colores.put(55,"#676aef");
        this.paleta_colores.put(56,"#693889");
        this.paleta_colores.put(57,"#6b0623");
        this.paleta_colores.put(58,"#6cd3bd");
        this.paleta_colores.put(59,"#6ea157");
        this.paleta_colores.put(60,"#706ef1");
        this.paleta_colores.put(61,"#723c8b");
        this.paleta_colores.put(62,"#740a25");
        this.paleta_colores.put(63,"#75d7bf");
        this.paleta_colores.put(64,"#77a559");
        this.paleta_colores.put(65,"#7972f3");
        this.paleta_colores.put(66,"#7b408d");
        this.paleta_colores.put(67,"#7d0e27");
        this.paleta_colores.put(68,"#7edbc1");
        this.paleta_colores.put(69,"#80a95b");
        this.paleta_colores.put(70,"#8276f5");
        this.paleta_colores.put(71,"#84448f");
        this.paleta_colores.put(72,"#861229");
        this.paleta_colores.put(73,"#87dfc3");
        this.paleta_colores.put(74,"#89ad5d");
        this.paleta_colores.put(75,"#8b7af7");
        this.paleta_colores.put(76,"#8d4891");
        this.paleta_colores.put(77,"#8f162b");
        this.paleta_colores.put(78,"#90e3c5");
        this.paleta_colores.put(79,"#92b15f");
        this.paleta_colores.put(80,"#947ef9");
        this.paleta_colores.put(81,"#964c93");
        this.paleta_colores.put(82,"#981a2d");
        this.paleta_colores.put(83,"#99e7c7");
        this.paleta_colores.put(84,"#9bb561");
        this.paleta_colores.put(85,"#9d82fb");
        this.paleta_colores.put(86,"#9f5095");
        this.paleta_colores.put(87,"#a11e2f");
        this.paleta_colores.put(88,"#a2ebc9");
        this.paleta_colores.put(89,"#a4b963");
        this.paleta_colores.put(90,"#a686fd");
        this.paleta_colores.put(91,"#a85497");
        this.paleta_colores.put(92,"#aa2231");
        this.paleta_colores.put(93,"#abefcb");
        this.paleta_colores.put(94,"#adbd65");
        this.paleta_colores.put(95,"#af8aff");
        this.paleta_colores.put(96,"#b15899");
        this.paleta_colores.put(97,"#b32633");
        this.paleta_colores.put(98,"#b4f3cd");
        this.paleta_colores.put(99,"#b6c167");
        this.paleta_colores.put(100,"#b88f01");
        this.paleta_colores.put(101,"#ba5c9b");
        this.paleta_colores.put(102,"#bc2a35");
        this.paleta_colores.put(103,"#bdf7cf");
        this.paleta_colores.put(104,"#bfc569");
        this.paleta_colores.put(105,"#c19303");
        this.paleta_colores.put(106,"#c3609d");
        this.paleta_colores.put(107,"#c52e37");
        this.paleta_colores.put(108,"#c6fbd1");
        this.paleta_colores.put(109,"#c8c96b");
        this.paleta_colores.put(110,"#ca9705");
        this.paleta_colores.put(111,"#cc649f");
        this.paleta_colores.put(112,"#ce3239");
        this.paleta_colores.put(113,"#cfffd3");
        this.paleta_colores.put(114,"#d1cd6d");
        this.paleta_colores.put(115,"#d39b07");
        this.paleta_colores.put(116,"#d568a1");
        this.paleta_colores.put(117,"#d7363b");
        this.paleta_colores.put(453,"#d9363b");
        this.paleta_colores.put(454,"#e7363b");
        this.paleta_colores.put(455,"#f93f0b");
        this.paleta_colores.put(456,"#f7363b");
        this.paleta_colores.put(457,"#a7363b");
        this.paleta_colores.put(458,"#f9993b");
        this.paleta_colores.put(459,"#d0063b");
        this.paleta_colores.put(460,"#f0003b");
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
        this.alfabeto.put((char) 92,13);
        this.alfabeto.put('0',14);
        this.alfabeto.put('1',15);
        this.alfabeto.put('2',16);
        this.alfabeto.put('3',17);
        this.alfabeto.put('4',18);
        this.alfabeto.put('5',19);
        this.alfabeto.put('6',20);
        this.alfabeto.put('7',21);
        this.alfabeto.put('8',22);
        this.alfabeto.put('9',23);
        this.alfabeto.put(' ',24);
        this.alfabeto.put('\n',25);
        this.alfabeto.put('\t',26);
        this.alfabeto.put(':',27);
        this.alfabeto.put(';',28);
        this.alfabeto.put('<',29);
        this.alfabeto.put('=',30);
        this.alfabeto.put('>',31);
        this.alfabeto.put('?',32);
        this.alfabeto.put('@',33);
        this.alfabeto.put('[',34);
        this.alfabeto.put(']',35);
        this.alfabeto.put('^',36);
        this.alfabeto.put('_',37);
        this.alfabeto.put('a',38);
        this.alfabeto.put('b',39);
        this.alfabeto.put('c',40);
        this.alfabeto.put('d',41);
        this.alfabeto.put('e',42);
        this.alfabeto.put('f',43);
        this.alfabeto.put('g',44);
        this.alfabeto.put('h',45);
        this.alfabeto.put('i',46);
        this.alfabeto.put('j',47);
        this.alfabeto.put('k',48);
        this.alfabeto.put('l',49);
        this.alfabeto.put('m',50);
        this.alfabeto.put('n',51);
        this.alfabeto.put('o',52);
        this.alfabeto.put('p',53);
        this.alfabeto.put('q',54);
        this.alfabeto.put('r',55);
        this.alfabeto.put('s',56);
        this.alfabeto.put('t',57);
        this.alfabeto.put('u',58);
        this.alfabeto.put('v',59);
        this.alfabeto.put('w',60);
        this.alfabeto.put('x',61);
        this.alfabeto.put('y',62);
        this.alfabeto.put('z',63);
        this.alfabeto.put('{',64);
        this.alfabeto.put('|',65);
        this.alfabeto.put('}',66);
        this.alfabeto.put('~',67);
        this.alfabeto.put((char) 39,68);
        this.alfabeto.put((char) 34,69);
        this.alfabeto.put('M',70);
    }
    
   public int[][] obtener_tabla_transiciones() throws IOException{
        int[][] resultado = new int[472][71];
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
   
   public void generar_muro_ladrillos() throws FileNotFoundException, IOException{
       int largo_tokens = lista_tokens.size();
       int contador = 0;
       int tokens_cantidad = 0;
       String inicio_html = "<!DOCTYPE html>\n" +
                            "<html>\n" +
                            "<head>\n" +
                            "<title>Muro de ladrillos</title>\n" +
                            "</head>\n" +
                            "<body>\n";
       String final_html = "</body>\n" +
                            "</html>";
       
       Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("muro_ladrillos.html")));
       
       writer.write(inicio_html);
       //writer.write("<p>\n");
       for(int i = 0; i < largo_tokens; i++){
            writer.write("<span style='background-color: "+paleta_colores.get(lista_tokens.get(i).codigo_familia)+"'>"+lista_tokens.get(i).lexema+"</span>\n");
       }
       //writer.write("<p>\n");
       writer.write(final_html);
       writer.close();
   }
}
