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
    private String imagen;
    private String imgComprimida;
    private String imgDescomprimida;
    
    // Constructor
    public Imagenes (){
        
    }
   
    // Metodos
    public String getImagen(){
        return imagen;
    }
    
    public void setImagen(String img){
        this.imagen = img;
    }
    
    public void comprimir(String img){
        int cant = 1;
        char imagen[] = img.toCharArray(); // Convertir cadena en array de caracteres
        char caracter = imagen[0]; // Asigno el primero elemento del array a la variable caracter
        String comprimido = "";
        
        for(int i = 0; i < (imagen.length-1); i++){ 

            if (caracter == imagen[i+1]){ // Comparar si una caracter es igual al caracter siguiente en el array
                cant++; // Incrementamos la variable
            }
            else
            {   
                comprimido+= comprimirCadena(cant, caracter); // Concatena la cadena comprimida con la nueva cadena comprimida
                
                cant = 1; // Reseteamos la variable
                caracter = imagen[i+1]; // Asignamos el caracter siguiente del array a la variable caracter para luego volver a comparar con el nuevo caracter
            }
        }
        
        comprimido+= comprimirCadena(cant,caracter); // Concatena la cadena comprimida con la ultima cadena comprimida
        this.imagen = comprimido; // Guarda la imagen completamente comprimida
    }
    
    // Funcion para comprimir la nueva cadena
    public String comprimirCadena(int cant, char caracter){
        
        String cadena = "";
    
        if(cant > 4){
            
            cadena+= "("+caracter+cant+")"; // Comprime la letra junto a su numero de veces que se repite
        }
        else
        {   // Entra al else si la cantidad de letra que se repite es menor o igual a 4
            for (int j = 0;j < cant;j++){
                
                cadena+= caracter; // Bucle para repetir la letra repetida
            }
        }
        return cadena; // Retorna la cadena comprimida
    }
        
    
    public void descomprimir(String src){
        char cadena[] = src.toCharArray(); //Transforma el String en una cadena de caracteres tipo char.
        char [] cadenaNueva = new char[1000]; //La cadena descomprimida.
        int k=0; //Ir guardando los datos en la cadena descomprimida.
        int guardo; //Guarda la posición de la letra.
        int repite; //Guarda el numero de veces que se repite la letra.
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
        String descomprimida = "";
        for(int i=0; i<k; i++){
            descomprimida=descomprimida+Character.toString(cadenaNueva[i]);
        }
        this.imagen = descomprimida;
    }
}
