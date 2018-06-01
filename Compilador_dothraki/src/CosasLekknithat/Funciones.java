/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CosasLekknithat;

import java.util.ArrayList;
import compilador_dothraki.Simbolo;

/**
 *
 * @author mailon2
 */
public class Funciones extends Simbolo{
    private String identificador;
    private String codigo;
    private ArrayList<String> parametros;
    private ArrayList<String> cadaTipos;
    private ArrayList<String> tipos;
    private String valorRetorno;

    public Funciones(String identificador, String codigo, ArrayList<String> parametros, ArrayList<String> cadaTipos, ArrayList<String> tipos, String valorRetorno) {
        this.identificador = identificador;
        this.codigo = codigo;
        this.parametros = parametros;
        this.cadaTipos = cadaTipos;
        this.tipos = tipos;
        this.valorRetorno = valorRetorno;
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

    public ArrayList<String> getParametros() {
        return parametros;
    }

    public void setParametros(ArrayList<String> parametros) {
        this.parametros = parametros;
    }

    public ArrayList<String> getCadaTipos() {
        return cadaTipos;
    }

    public void setCadaTipos(ArrayList<String> cadaTipos) {
        this.cadaTipos = cadaTipos;
    }

    public ArrayList<String> getTipos() {
        return tipos;
    }

    public void setTipos(ArrayList<String> tipos) {
        this.tipos = tipos;
    }

    public String getValorRetorno() {
        return valorRetorno;
    }

    public void setValorRetorno(String valorRetorno) {
        this.valorRetorno = valorRetorno;
    }

    @Override
    public String toString() {
        return "Funciones{" + "identificador=" + identificador + ", codigo=" + codigo + ", parametros=" + parametros + ", cadaTipos=" + cadaTipos + ", tipos=" + tipos + ", valorRetorno=" + valorRetorno + '}';
    }
    
    
}
