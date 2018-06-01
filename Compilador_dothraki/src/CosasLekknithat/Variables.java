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
public class Variables extends Simbolo{
    private String identificador;
    private String codigo;
    private String tipo;
    private String valorInicializacion;

    public Variables(String identificador, String codigo, String tipo, String valorInicializacion) {
        this.identificador = identificador;
        this.codigo = codigo;
        this.tipo = tipo;
        this.valorInicializacion = valorInicializacion;
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

    public String getValorInicializacion() {
        return valorInicializacion;
    }

    public void setValorInicializacion(String valorInicializacion) {
        this.valorInicializacion = valorInicializacion;
    }

    @Override
    public String toString() {
        return "Variables{" + "identificador=" + identificador + ", codigo=" + codigo + ", tipo=" + tipo + ", valorInicializacion=" + valorInicializacion + '}';
    }
    
    
}
