/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador_dothraki;

import CosasLekknithat.Variables;
import java.util.ArrayList;

/**
 *
 * @author mailon2
 */
public class FactorySimbolos {
    public Simbolo fabricarPedido(int tipo, ArrayList<String> datos) {

        Simbolo elSimbolo = null;
        switch (tipo) {
            case 1:
                elSimbolo = new Variables(datos.get(0),datos.get(1),datos.get(2),datos.get(3));
                break;
            case 2:
                elSimbolo = null;
                break;
            case 3:
                elSimbolo = null;
                break;
        }
        return elSimbolo;
    }
}
