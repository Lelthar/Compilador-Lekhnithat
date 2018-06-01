    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CosasLekknithat;

import compilador_dothraki.Simbolo;
import java.util.ArrayList;

/**
 *
 * @author mailon2
 */
public class Registros extends Simbolo{
    private String identificador;
    private String codigo;
    private ArrayList<Campos> campos;
    private ArrayList<String> inicializacion;

    public Registros(String identificador, String codigo, ArrayList<Campos> campos, ArrayList<String> inicializacion) {
        this.identificador = identificador;
        this.codigo = codigo;
        this.campos = campos;
        this.inicializacion = inicializacion;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public ArrayList<Campos> getCampos() {
        return campos;
    }

    public void setCampos(ArrayList<Campos> campos) {
        this.campos = campos;
    }

    public ArrayList<String> getInicializacion() {
        return inicializacion;
    }

    public void setInicializacion(ArrayList<String> inicializacion) {
        this.inicializacion = inicializacion;
    }
    
    
    
}
