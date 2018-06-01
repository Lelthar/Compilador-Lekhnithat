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
public class TipoUsuario extends Simbolo{
    private String identificador;
    private String codigo;
    private String tipo;

    public TipoUsuario(String identificador, String codigo, String tipo) {
        this.identificador = identificador;
        this.codigo = codigo;
        this.tipo = tipo;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}
