/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CosasLekknithat;

import compilador_dothraki.Simbolo;

/**
 *
 * @author mailon2
 */
public class Constantes extends Simbolo{
    private String identificador;
    private String codigo;
    private String valor;

    public Constantes(String identificador, String codigo, String valor) {
        this.identificador = identificador;
        this.codigo = codigo;
        this.valor = valor;
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

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
    
}
