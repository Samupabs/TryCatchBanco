import java.util.InputMismatchException;
import java.util.Scanner;

public class Banco {
    private int cuentaBancaria;
    private String nombreTitular;

    public Banco (){
        this.cuentaBancaria = 0;
        this.nombreTitular = "";
    }

    public Banco(int cuentaBancaria, String nombreTitular) {
        setCuentaBancaria();
        setNombreTitular();
    }

    public int getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria() {
        Scanner sc = new Scanner(System.in);
        boolean boton1 = false;
        int ingresoRetirada = 0;

        System.out.println("Tu saldo actual es de: "+getCuentaBancaria()+"€");
        System.out.println();
        System.out.println("¿Desea hacer un ingreso o una retirada?");
        System.out.println("Pulse 1: Para realizar un ingreso. Pulse 2: Para realizar una retirada");
        while (!boton1){
            try {
                ingresoRetirada = sc.nextInt();
                if(ingresoRetirada != 1 && ingresoRetirada != 2){
                    throw new InputMismatchException();
                }
                boton1 = true;
            } catch (InputMismatchException e) {
                sc.nextLine(); // Limpiar el buffer de entrada
                System.err.println("Selecciona 1 o 2");
            } //Fin Trycatch
        } //Fin While
        this.cuentaBancaria = operaciones(ingresoRetirada);
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public String setNombreTitular() {
        boolean boton = false;
        Scanner sc = new Scanner (System.in);
        String nombre = "";

        while (!boton){
            try{
                System.out.println("Dame el nombre del titular de la cuenta");
                nombre = sc.nextLine();
                boton = true;
            }catch(InputMismatchException e){
                System.err.println("No me des un número. Intenta de nuevo.");
            } //Fin TryCatch
            System.out.println("El nombre registrado es: "+nombre);
        } // Fin boton
        return nombre;
    }

    public int operaciones (int opcion){
        Scanner sc = new Scanner (System.in);
        int resultado = 0;

        switch (opcion){

            case 1: //Ingreso
                int ingreso = 0;
                boolean boton1 = false;
                while (!boton1) {
                    try {
                        System.out.println("¿Cuánto dinero quiere ingresar?");
                        ingreso = sc.nextInt();
                        if (ingreso <= 0) {
                            System.err.println("Introduce un numero mayor de 0");
                        } else {
                            boton1 = true;
                        }//Fin if
                    }
                    catch (InputMismatchException a){
                        sc.nextLine();
                        System.err.println("Introduce un número");
                    }//Fin tryCatch
                }//Fin while
                    resultado = getCuentaBancaria() + ingreso;

                System.out.println("Ha ingresado correctamente: "+ingreso+"€");
                break;

            case 2: //Retirada
                int retirada = 0;
                boolean boton2 = false;
                while (!boton2) {
                    try {
                        System.out.println("¿Cuánto dinero quiere retirar?");
                        retirada = sc.nextInt();
                        if (retirada > getCuentaBancaria()) {
                            System.err.println("No tienes tanto dinero. Por favor escoge una cantidad menor");
                            System.out.println("Su saldo actual es de: " + getCuentaBancaria()+"€");
                            System.out.println();
                        } else if(retirada <= 0){
                            System.err.println("Número no valido. Intente de nuevo.");
                            System.out.println("Su saldo actual es de: " + getCuentaBancaria()+"€");
                            System.out.println();
                        }
                        else if (retirada < getCuentaBancaria()) {
                            resultado = getCuentaBancaria() - retirada;
                            boton2 = true;
                        }//Fin if
                    } catch (InputMismatchException a){
                        sc.nextLine();
                        System.err.println("Introduce un numero");
                    }//Fin trycatch
                }//Fin while
                System.out.println();
                System.out.println("Ha retirado correctamente: "+retirada+"€");
                break;
        }//Fin Switch

        System.out.println();
        System.out.println("Su saldo actual queda así: "+resultado+"€");
        return resultado;
    }//Fin operaciones
}
