package Modelo;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Pinguino extends Usuarios {
	
	//Variables
    private String color;
    private String nombre;
    private int posicion;
    private Inventario inventario;  // Cada pingüino tiene un acceso al inventario

    //Lista estática de pingüinos
    public static ArrayList<Pinguino> ListaPinguinos = new ArrayList<>();
    public int turno;

    //Constructor
    public Pinguino(int ID, String color, String nombre, int posicion, Inventario inventario) {
        super(ID);
        this.color = color;
        this.nombre = nombre;
        this.posicion = posicion;
        this.inventario = inventario;  //Se asigna el inventario de la clase a cada pingüino
        
        ListaPinguinos.add(this); //Añadir el pingüino a la lista
    }

    //Métodos de la clase Pinguino
    public int tirarDado(int dado) {
        Scanner sc = new Scanner(System.in);
        Random rn = new Random();

        System.out.println("Elige el tipo de dado:");
        System.out.println("1- Dado normal");
        System.out.println("2- Dado rápido");
        System.out.println("3- Dado lento");
        int tipoDado = sc.nextInt();

        // Verificar si el dado es válido
        if (!esDadoValido(tipoDado)) {
            System.out.println("Tipo de dado no válido. Por favor, elige un número entre 1 y 3.");
            return -1;  //Indicamos un valor no válido si el dado es incorrecto
        }

        int resultado = 0;  //Variable para el resultado del dado
        //Casos para el tipo de dado
        switch(tipoDado) {
            case 1:
                //Dado normal: 1 a 6
                System.out.println("Has elegido dado Normal");
                resultado = rn.nextInt(6) + 1;  // Generar número entre 1 y 6
                break;
            case 2: 
                //Dado rápido: 5 a 10
                System.out.println("Has elegido dado Rápido");
                resultado = rn.nextInt(6) + 5;  // Generar número entre 5 y 10
                //Eliminar el dado rápido del inventario
                eliminarDado(3);  //El ID del dado rápido es 3
                break;
            case 3:
                //Dado lento: 1 a 3
                System.out.println("Has elegido dado Lento");
                resultado = rn.nextInt(3) + 1;  //Generar número entre 1 y 3
                //Eliminar el dado lento del inventario
                eliminarDado(4);  //El ID del dado lento es 4
                break;
        }

        System.out.println("El resultado del dado es: " + resultado);
        return resultado;
    }

    //Método privado para comprobar si el dado seleccionado es válido
    private boolean esDadoValido(int tipoDado) {
        //El dado debe ser 1, 2 o 3
        return tipoDado >= 1 && tipoDado <= 3;
    }

    //Método privado para eliminar el dado del inventario (en caso de ser dado rápido o lento)
    private void eliminarDado(int idDado) {
        //Eliminamos el dado del inventario de este pingüino
        inventario.eliminarObjeto(idDado);
    }

    //Getters y Setters
    public Inventario getInventario() {
        return inventario;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    //ToString
    public String toString() {
        return super.toString() + ", Color: " + color + ", Nombre: " + nombre;
    }
}
