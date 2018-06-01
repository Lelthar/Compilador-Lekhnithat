/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador_dothraki;

import java.util.ArrayList;


/**
 *
 * @author mailon2
 */
public class TablaHash {
    private Hash[] tabla;
    private int[] repeticiones;
    private ArrayList<Tupla> repetidos;
    private int size;
    
    public TablaHash(int size){
        this.tabla = new Hash[size];
        this.repeticiones = new int[size];
        this.repetidos = new ArrayList<>();
        this.size = size;
        for (int i = 0; i < size; i++) {
            tabla[i] = new Hash(null, 0,"null");
            repeticiones[i] = 0;
        }
    }
    
    public int funcionDispersion(String clave,int size){
        int result = 0;
        for(int i=0;i<clave.length();i++){
            result+= clave.charAt(i);
        }
        result=result-98;
        return ((result+1)%size);
    }
    
    public void insertarHash(String clave,Simbolo dato){
        boolean bandera = false;        
        int j = funcionDispersion(clave, size);
        boolean repetido=false; //Si no se inserto a la primera
        int desplazamiento = 0; //Cuantos lugares lo ubico
        do{
            if(tabla[j].estado==0 || tabla[j].estado==1){
                tabla[j].dato=dato;
                tabla[j].estado = 2;
                tabla[j].clave=clave;
                bandera=true;
                if(repetido){                    
                    Tupla inser = new Tupla(clave, desplazamiento);
                    repetidos.add(inser);
                }
            }else{
                if(!tabla[j].clave.equals(clave)){
                    if(!repetido){
                    repeticiones[j]=1;
                    repetido=true;
                    }
                    desplazamiento+=1;
                    j++;
                }else{
                    System.out.println("Elemento ya existe");
                    bandera=true;
                    break;
                }
            }
            
        }while(j<size && !bandera);
        if(bandera){
            System.out.println("Insertado");
        }else{
            System.out.println("Tabla llena");
        }
    }
    
    public Simbolo buscarHash(String clave){
        int j= funcionDispersion(clave, size);
        
        if(tabla[j].estado==0){
            return null;
        }else if(tabla[j].estado==1){
            return null;
        }else if(repeticiones[j]==0){
            return tabla[j].dato;                    
       }else{
            for(int i=0;i<repetidos.size();i++){
                if(repetidos.get(i).clave == null ? clave == null : repetidos.get(i).clave.equals(clave)){
                    if(tabla[i].clave == null ? clave == null : tabla[i].clave.equals(clave)){
                        return tabla[j+repetidos.get(i).desplazamiento].dato;
                    }else{
                        return null;
                    }
                    
                }
            }
            return tabla[j].dato;                  
        }        
   }
    
    public void eliminarHash(String clave){
        int j= funcionDispersion(clave, size);
        if(repeticiones[j]==0){
            Simbolo sim = buscarHash(clave);
            if(sim!=null){
                tabla[j].estado = 1;
            }
        }else{
            int i;
            int n=0;
            for(i=0;i<repetidos.size();i++){
                if(repetidos.get(i).clave == null ? clave == null : repetidos.get(i).clave.equals(clave)){
                    n = j+repetidos.get(i).desplazamiento;
                    break;
                }
            }
            repetidos.remove(i);
            tabla[n].estado = 1;
            
        }
    }
    
    public class Tupla{
        private String clave;
        private int desplazamiento;

        public Tupla(String clave, int desplazamiento) {
            this.clave = clave;
            this.desplazamiento = desplazamiento;
        }       
        
        public String getClave() {
            return clave;
        }

        public void setClave(String clave) {
            this.clave = clave;
        }

        public int getDesplazamiento() {
            return desplazamiento;
        }

        public void setDesplazamiento(int desplazamiento) {
            this.desplazamiento = desplazamiento;
        }
              
    }

    public void imprimirDatos(){
        for(int i=0;i<size;i++){
            Hash h = tabla[i];
            System.out.println("Valor: "+h.toString()+" Repeticiones: "+repeticiones[i]);
        }
    }
    
    public void imprimiRepetidos(){
        for(int i=0;i<size;i++){
            Hash h = tabla[i];
            System.out.println("Valor: "+h.toString());
        }
    }
}
