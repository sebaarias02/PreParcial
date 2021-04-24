/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preparcial;

/**
 *
 * @author Seba y Mauro :D
 */
public class Imagenes {
    // atributos
    private String src;
    
    // Constructor
    public Imagenes (String src){
        
    }
    
    // Metodos
    public String getSrc(){
        return src;
    }
    
    public void setSrc(String src){
        this.src = src;
    }
    
    public void descomprimir(String src){
        char cadena[] = src.toCharArray(); //Transforma el String en una cadena de caracteres tipo char.
        char [] cadenaNueva = new char[150]; //La cadena descomprimida.
        int k=0; //Ir guardando los datos en la cadena descomprimida.
        int guardo=0; //Guarda la posición de la letra.
        int repite = 0; //Guarda el numero de veces que se repite la letra.
        for(int i=0; i<cadena.length; i++){ //Recorre toda la cadena
            if(cadena[i] == '('){ //Si se repite muchas veces una letra.
                i=i+2; //Me paro en la posicion del numero.
                guardo=i-1; //Guarda la posicion de la letra.
                repite = Character.getNumericValue(cadena[i]); //Contiene el numero de veces que se repite la letra.
                do{
                    if(cadena[i+1] != ')'){ //Si el numero, en realidad, contiene mas de un digito.
                        repite = repite*10 + Character.getNumericValue(cadena[i+1]);
                        i++;
                    }
                }while(cadena[i+1] != ')'); //Si ya terminó de operar con la letra que se repite, avenza.
                i++;
                for(int j=0; j<repite;j++){ //Ingresa en la cadena descomprimida la cantidad de veces que se desea ingreas la leta.
                    cadenaNueva[k] = cadena[guardo];
                    k++;
                }
            }else{ //Si es solo una letra.
                cadenaNueva[k] = cadena[i];
                k++;
            }
        }
        System.out.println("Mostrando cadena:");
        System.out.println(cadenaNueva);
    }
    
}
