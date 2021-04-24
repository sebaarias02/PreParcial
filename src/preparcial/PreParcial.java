/*
Pre parcial (Copy&&Paste)
 */
package preparcial;
import java.util.Scanner;
/**
 *
 * @author Seba y Mauro :D
 */
public class PreParcial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        String img = "";
        Imagenes i = new Imagenes(); // Instanciamos el objeto con la clase
        boolean valido;
        do{
            valido=true;
            System.out.println("Ingrese imagen a comprimir o descomprimir (0 SALIR): ");
            img = entrada.next();
            i.setImagen(img);
            if(!img.equals("0")){
                if (img.contains("(")) {
                    i.descomprimir(img);
                    if(i.getImagen().length() <= 250)
                        System.out.println("Imagen descomprimida:\n"+i.getImagen());
                    else
                        System.out.println("Imagen muy grande, intentelo devuelta con una longitud maxima de 250 letras");
                }else
                    if (img.length() <= 250){ // Solo si la cadena contiene como maximo 250 letras entramos al if
                        i.comprimir(img);
                        System.out.println("Imagen Comprimida:\n"+i.getImagen());
                    }else{
                        System.out.println("Imagen muy grande, intentelo devuelta con una longitud maxima de 250 letras");
                    }
            }else{
                valido = false;
            }
        }while(valido);
    }
}