package ahorcado;

import java.util.Scanner;

public class Ahorcado {
    
    public static void dibujar(String vPalabra[],int error){
        
        switch(error){
            case 0:
                System.out.println("__________");
                System.out.println("|        |");
                System.out.println("|         ");
                System.out.println("|         ");
                System.out.println("|         ");
                System.out.println("|         ");
                System.out.println("|_____________");
                break;
            case 1:
                System.out.println("__________");
                System.out.println("|        |");
                System.out.println("|        O");
                System.out.println("|         ");
                System.out.println("|         ");
                System.out.println("|         ");
                System.out.println("|_____________");
                break;
            case 2:
                System.out.println("__________");
                System.out.println("|        |");
                System.out.println("|        O");
                System.out.println("|        |");
                System.out.println("|         ");
                System.out.println("|         ");
                System.out.println("|_____________");
                break;
            case 3:
                System.out.println("__________");
                System.out.println("|        |");
                System.out.println("|        O");
                System.out.println("|       -|");
                System.out.println("|         ");
                System.out.println("|         ");
                System.out.println("|_____________");
                break;
            case 4:
                System.out.println("__________");
                System.out.println("|        |");
                System.out.println("|        O");
                System.out.println("|       -|-");
                System.out.println("|          ");
                System.out.println("|          ");
                System.out.println("|_____________");
                break;
            case 5:
                System.out.println("__________");
                System.out.println("|        |");
                System.out.println("|        O");
                System.out.println("|       -|-");
                System.out.println("|        ]");
                System.out.println("|          ");
                System.out.println("|_____________");
                break;
            case 6:
                System.out.println("__________");
                System.out.println("|        |");
                System.out.println("|        O");
                System.out.println("|       -|-");
                System.out.println("|        ][");
                System.out.println("|          ");
                System.out.println("|_____________");
                break;
        }
        
        if(error != 6){
            for(int i=0;i<vPalabra.length;i++){
                System.out.print(vPalabra[i]); 
            }
        }else{
            System.out.println("TE HAS QUEDADO SIN INTENTOS");
        }
    }
    
    public static int comprobarErrores(String vLetras[],String vPalabra[],String vErrores[],String letra,int error){
        
        boolean fallo = true;
        int devolver = error;
        
        for(int i=0;i<vLetras.length;i++){
            if(vLetras[i].equals(letra)){
                vPalabra[i] = letra;
                fallo = false;
            }
        }
        
        if (fallo){
            for(int i=0;i<vErrores.length;i++){
                if(vErrores[i] != null)
                if(vErrores[i].equals(letra)){
                    
                }
            }
            
            vErrores[error] = letra;
            devolver++;
        }
        
        
        return devolver;
    }
    
    public static void separarPalabra(String vLetras[],String palabra){
        for(int i=0;i<vLetras.length;i++){
            vLetras[i] = palabra.substring(i,i+1);
        }
    }

    public static void inicializarVPalabra(String vPalabra[]){
        for(int i=0;i<vPalabra.length;i++){
            vPalabra[i] = " _ ";
        }
    }
    
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        String palabra = "";
        String letra = "";
        int error = 0;
        boolean averiguada = false; 
        
        System.out.println("Escriba la palabra que desee averiguar:");
        palabra = leer.nextLine();
        
        String vLetras[] = new String[palabra.length()];
        String vPalabra[] = new String[palabra.length()];
        String vErrores[] = new String[6];
        
        inicializarVPalabra(vPalabra);
        separarPalabra(vLetras,palabra);
        
        do{
            dibujar(vPalabra,error);
            
            System.out.println("");
            System.out.println("");
            System.out.println("Introduzca la letra");
            letra = leer.nextLine();
            
            
            
        }while(error != 6 || averiguada == true);
        
    }
    
}
