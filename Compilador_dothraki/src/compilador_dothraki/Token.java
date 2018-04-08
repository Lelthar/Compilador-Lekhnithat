/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador_dothraki;

/**
 *
 * @author Gerald
 */
public class Token {
    int codigo_familia;
    String lexema;
    int fila;
    int columna_inicio;
    int columna_final;
    int codigo_error;

    public Token(int codigo_familia, String lexema, int fila, int columna_inicio, int columna_final, int codigo_error) {
        this.codigo_familia = codigo_familia;
        this.lexema = lexema;
        this.fila = fila;
        this.columna_inicio = columna_inicio;
        this.columna_final = columna_final;
        this.codigo_error = codigo_error;
    }
    
    @Override
    public String toString(){
        return "Codigo de familia: "+Integer.toString( this.codigo_familia)+"\n"
                +"Codigo de error: "+Integer.toString( this.codigo_error)+"\n"
                +"columna de inicio: "+Integer.toString( this.columna_inicio)+"\n"
                +"columna de fin: "+Integer.toString( this.columna_final)+"\n"
                +"fila: "+Integer.toString( this.fila)+"\n"
                +"Lexema: "+Integer.toString( this.lexema.length())+"\n";
    }
    
}
