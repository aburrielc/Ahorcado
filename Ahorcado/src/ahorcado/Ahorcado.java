package ahorcado;

import java.util.Random;
import java.util.Scanner;


public class Ahorcado {
    
    //Muestra el dibujo,los errores y las letras acertadas de la palabra a averiguar.
    public static void dibujar(String vPalabra[],String vErrores[],int error){
        
        //Dibuja en función del número de errores cometidos.
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
        
        //Condición: para poder ver los aciertos que he hecho durante la partida.
        //Incluso aunque no tenga más intentos.
        if(error <= 6){
            for(int i=0;i<vPalabra.length;i++){
                System.out.print(vPalabra[i].toUpperCase()); 
            }
        }
        
        System.out.println("");
        System.out.println("");
        System.out.println("Errores:");
        
        //Muestra todos los errores cometidos hasta el momento.
        for(int i=0;i<vErrores.length;i++){
            if(vErrores[i] != null){
                System.out.print(vErrores[i] + ",");
            }
        }
    }
    
    //Contiene toda la mecánica del juego.
    //Devuelve el número de errores que ha cometido el usuario.
    public static int juego(String vLetras[],String vPalabra[],String vErrores[],String letra,int error){
        
        Scanner leer = new Scanner(System.in);
        boolean fallo = true;
        
        //Para trabajar con el número de errores.
        int devolver = error;
        
        boolean comprueba = false;
        
        //Pide letra mientras el usuario no haya llegado al número tope de intentos.
        //En este caso, puede cometer hasta 6 errores (de 0 a 5).
        if(error < 6){
            System.out.println("");
            System.out.println("");
            System.out.println("Introduzca la letra");
            letra = leer.nextLine().substring(0,1).toLowerCase();
            System.out.println("");
            
            comprueba = buscarErrores(vErrores,letra);
        }
        
        //Si la letra introducida coincide con la palabra a averiguar, la guarda en aciertos.
        for(int i=0;i<vLetras.length;i++){
            if(vLetras[i].equals(letra)){
                vPalabra[i] = letra;
                fallo = false;
            }
        }
        
        //Si el usuario falla la letra
        if (fallo){
            
            //Comprueba si el fallo está repetido o no.
            //En caso de que no este repetida, la guardará en el número correspondiente al error y sumará +1 al número total de errores.
            if(comprueba == true){
                System.out.println("Palabra repetida");
                System.out.println("");
            }else{
                vErrores[error] = letra;
                devolver++;
            }
        }
        
        return devolver;
    }
    
    //Comprueba si el usuario a repetido una de las letras fallidas.
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
    
    //Trozea la palabra a averiguar y la guarda en un vector.
    public static void separarPalabra(String vLetras[],String palabra){
        for(int i=0;i<vLetras.length;i++){
            vLetras[i] = palabra.substring(i,i+1).toLowerCase();
        }
    }
    
    //Inicializa el vector que contendrá los aciertos del usuario.
    //Así sabremos que su contenido será distinto de null.
    public static void inicializarVPalabra(String vPalabra[]){
        for(int i=0;i<vPalabra.length;i++){
            vPalabra[i] = " _ ";
        }
    }
    
    //Selecciona una de las palabras escogidas para averiguar de forma aleatoria.
    public static String iniciarPalabra(String diezPalabras[]){
        Random aleatorio = new Random();
        int numero = aleatorio.nextInt(10);
        
        String palabra = "";
        
        diezPalabras[0] = "ISOSCELES";
        diezPalabras[1] = "HIPOTENUSA";
        diezPalabras[2] = "HIPOPOTAMO";
        diezPalabras[3] = "MURCIELAGO";
        diezPalabras[4] = "ORNITORRINCO";
        diezPalabras[5] = "VIDEOJUEGO";
        diezPalabras[6] = "JOYSTICK";
        diezPalabras[7] = "PICAPORTE";
        diezPalabras[8] = "SOL";
        diezPalabras[9] = "LUNA";
        
        palabra = diezPalabras[numero];
        
        return palabra;
    }
    
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        String palabra = "";
        String letra = "";
        int error = 0;
        int acierto = 0;
        boolean averiguada = false; 
        
        String diezPalabras[] = new String[10];
        
        palabra = iniciarPalabra(diezPalabras);
        
        String vLetras[] = new String[palabra.length()];
        String vPalabra[] = new String[palabra.length()];
        String vErrores[] = new String[6];
        
        inicializarVPalabra(vPalabra);
        separarPalabra(vLetras,palabra);
        
        do{
            System.out.println("");
            dibujar(vPalabra,vErrores,error);
            
            //Si el usuario comete 6 fallos, se le avisa y se cierra el programa.
            //Sino, se realizará la mecánica del juego.
            if(error == 6){
                System.out.println("");
                System.out.println("");
                System.out.println("NO TE QUEDAN INTENTOS");
                averiguada = true;
                
            }else{
                
                error = juego(vLetras,vPalabra,vErrores,letra,error);
                
                //Igualo acierto a 0 en todo momento, puesto que, solo la utilizo como "bandera".
                //En cuanto acierto coincida con la longitud del vector, querra decir que el usuario ha averiguado la palabra.
                //Por lo tanto, finalizará el programa.
                acierto=0;
                for(int i=0;i<vPalabra.length;i++){
                    if(vPalabra[i].equalsIgnoreCase(vLetras[i])){
                        acierto++;
                    }
                }
                
                if(acierto == vPalabra.length){
                    System.out.println("");
                    dibujar(vPalabra,vErrores,error);
                    System.out.println("");
                    System.out.println("");
                    System.out.println("!HAS GANADO¡");
                    averiguada = true; 
                }
            }    
        }while(averiguada != true);
    }
}
    

