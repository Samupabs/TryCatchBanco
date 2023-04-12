import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Escribe un programa Java que simule un cajero automático que permita a los usuarios realizar retiros y depósitos. El
 * programa debe manejar las excepciones que puedan surgir, como la introducción de una cantidad negativa, un retiro mayor
 * al saldo disponible, y la introducción de un valor no numérico. Si un usuario intenta retirar una cantidad mayor al
 * saldo disponible, el programa debe lanzar una excepción personalizada NoSuficienteSaldo y mostrar un mensaje de error
 * apropiado en la consola.
 *
 * El programa debe pedir al usuario que ingrese su saldo inicial y luego permitirle elegir entre realizar un depósito o
 * un retiro. Si el usuario elige realizar un depósito, el programa debe solicitar la cantidad y actualizar el saldo. Si
 * el usuario elige realizar un retiro, el programa debe solicitar la cantidad y verificar que haya suficiente saldo
 * disponible. Si hay suficiente saldo disponible, el programa debe actualizar el saldo y mostrar el saldo actualizado
 * en la consola. Si no hay suficiente saldo disponible, el programa debe lanzar la excepción NoSuficienteSaldo y mostrar
 * un mensaje de error en la consola.
 *
 * El programa debe seguir permitiendo al usuario realizar operaciones de depósito y retiro hasta que el usuario decida
 * salir del programa. Cuando el usuario sale del programa, el programa debe imprimir el saldo final en la consola.
 *
 * @author PHCHe
 * @date 12/04/2023
 */
public class Main {

    public static void main(String[] args) {
    Banco prueba = new Banco();
    boolean boton = false;
    Scanner sc = new Scanner(System.in);
    int respuesta = 0;

    prueba.setNombreTitular();

    while (!boton) {
        prueba.setCuentaBancaria();
        System.out.println();
        System.out.println("¿Desea algo más?");
        System.out.println();
        System.out.println("Pulse 1: para realizar más operaciones. Pulse 2: Para cerrar el programa");
            try {
                respuesta = sc.nextInt();
                if(respuesta != 1 && respuesta != 2){
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                sc.nextLine(); // Limpiar el buffer de entrada
                System.err.println("Selecciona 1 o 2");
            } //Fin Trycatch
        if (respuesta == 2){
            System.out.println("Gracias por su tiempo.");
            boton = true;
        }
    }//Fin Bucle

    } // Fin String[]Args

} //Fin Main