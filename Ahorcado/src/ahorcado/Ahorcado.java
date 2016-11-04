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
        
        if(error <= 6){
            for(int i=0;i<vPalabra.length;i++){
                System.out.print(vPalabra[i]); 
            }
        }
    }
    
    public static int juego(String vLetras[],String vPalabra[],String vErrores[],String letra,int error){
        
        Scanner leer = new Scanner(System.in);
        boolean fallo = true;
        int devolver = error;
        boolean comprueba = false;
        
        if(error < 6){
            System.out.println("");
            System.out.println("");
            System.out.println("Introduzca la letra");
            letra = leer.nextLine();
            System.out.println("");
            
            comprueba = buscarErrores(vErrores,letra);
        }
        
        for(int i=0;i<vLetras.length;i++){
            if(vLetras[i].equals(letra)){
                vPalabra[i] = letra;
                fallo = false;
            }
        }
        
        if (fallo){
            
            if(comprueba == true){
                System.out.println("Palabra repetida");
                System.out.println("");
            }else{
                vErrores[error] = letra;
                devolver++;
            }
        }
        
        System.out.println("Errores:");
        
        for(int i=0;i<vErrores.length;i++){
            if(vErrores[i] != null){
                System.out.print(vErrores[i] + ",");
            }
        }
        
        return devolver;
    }
    
    public static boolean buscarErrores(String vErrores[],String letra){
        
        boolean comprueba = false;
        
        for(int i=0;i<vErrores.length;i++){
            if(vErrores[i] != null)
            if(vErrores[i].equals(letra)){
                comprueba = true;
                i = vErrores.length + 1;
            }
        }
        
        return comprueba;
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
        int acierto = 0;
        boolean averiguada = false; 
        
        System.out.println("Escriba la palabra que desee averiguar:");
        palabra = leer.nextLine();
        
        String vLetras[] = new String[palabra.length()];
        String vPalabra[] = new String[palabra.length()];
        String vErrores[] = new String[6];
        
        inicializarVPalabra(vPalabra);
        separarPalabra(vLetras,palabra);
        
        do{
            System.out.println("");
            dibujar(vPalabra,error);
            
            if(error == 6){
                System.out.println("");
                System.out.println("");
                System.out.println("NO TE QUEDAN INTENTOS");
                averiguada = true;
                
            }else{
                
                error = juego(vLetras,vPalabra,vErrores,letra,error);
                
                acierto=0;
                for(int i=0;i<vPalabra.length;i++){
                    if(vPalabra[i].equalsIgnoreCase(vLetras[i])){
                        acierto++;
                    }
                }
                
                if(acierto == vPalabra.length){
                    System.out.println("");
                    System.out.println("!HAS GANADO¡");
                    averiguada = true; 
                }
            }    
        }while(averiguada != true);
    }
}
    

