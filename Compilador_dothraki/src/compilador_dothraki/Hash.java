/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador_dothraki;

/**
 *
 * @author mailon2
 */
public class Hash {
    Simbolo dato;
    int estado; //0 = Vacío, 1 = Eliminado, 2 = Ocupado
    String clave;

    public Hash(Simbolo dato, int estado, String clave) {
        this.dato = dato;
        this.estado = estado;
        this.clave = clave;
    }

    public Simbolo getDato() {
        return dato;
    }

    public void setDato(Simbolo dato) {
        this.dato = dato;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        return "Hash{" + "dato=" + dato + ", estado=" + estado + ", clave=" + clave + '}';
    }

}
