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
        
        System.out.println("Ingrese imagen a comprimir o descomprimir");
        img = entrada.next();
        
        if (img.contains("(")) 
        {
            i.setImgComprimida(img);
            i.descomprimir(img);
            System.out.println("Imagen descomprimida:\n"+i.getImgDescomprimida());
        }
        else
        if (img.length() <= 250) // Solo si la cadena contiene como maximo 250 letras entramos al if
        {
            i.setImgDescomprimida(img);
            i.comprimir(img);
            System.out.println("Imagen Comprimida:\n"+i.getImgComprimida());
        }
        else
        {
            System.out.println("Imagen muy grande, intentelo devuelta con una longitud maxima de 250 letras");
        }
    }
    
}
