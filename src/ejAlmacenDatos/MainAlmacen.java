package ejAlmacenDatos;

import java.util.Scanner;
/**
 * La clase interactua con objetos de tipo Almacen de datos mediante un menu.
 * El programa termina al seleccionar 0 en el menu.
 * 
 * @author Alberto
 * @author Javier Sergio Prado
 * @version 1.0
 */
public class MainAlmacen {

	/**
	 * El metodo main inicializa un objeto de tipo Almacen1 o Almacen2 y lo gestiona con el menu.
	 * Modifica la instancia para elegir entre el tipo de almacen.
	 * 
	 * @param args No se reciben argumentos.
	 */
	public static void main(String[] args) {

		Almacen2 prueba = new Almacen2();
		Scanner sc = new Scanner(System.in);
		int opcion;

		do {
			mostrarMenu();
			opcion = sc.nextInt();
			procesarOpcion(opcion, prueba, sc);
		} while (opcion != 0);
		sc.close();
		
	}

	/**
	 * Metodo simple que muestra un menu por consola.
	 */
	static void mostrarMenu() {
		System.out.println("--- MENÚ DE  CONTROL DEL ALMACÉN -----");
		System.out.println(" 1.- Mostrar contenido del Almacén");
		System.out.println(" 2.- Poner un Valor  ");
		System.out.println(" 3.- Buscar un Valor ");
		System.out.println(" 4.- Borrar un Valor");
		System.out.println(" 5.- Contar posiciones ocupadas.");
		System.out.println(" 6.- Contar posiciones libres.");
		System.out.println(" 0.- Terminar");
        System.out.print(" Introduzca una opción:[1-6]:");
	}

	// Procesa la opción introducida operando sobre el objeto Almacen1
	/**
	 * Este metodo selecciona el comportamiento del objeto Almacen por cada vuelta del ciclo del menu.
	 * Modifica el parametro de Almacen segun quieras usar tipo Almacen1 o Almacen2
	 * 
	 * @param opcion Es un entero que selecciona el caso.
	 * @param parAlmacen Es el objeto de tipo Almacen1.
	 * @param sc Es un objeto de tipo Scanner para selecciones dentro de cada caso.
	 */
	static void procesarOpcion(int opcion, Almacen2 parAlmacen, Scanner sc) {

		switch (opcion) {
		
			case 1:{
				System.out.println("\n" + parAlmacen.toString() + "\n");
				break;
			}
			case 2:{
				System.out.print("\nIntroduce valor -->");
				System.out.println(parAlmacen.ponValor(sc.nextInt()) + "\n");
				break;
			}
			case 3:{
				System.out.print("\nIntroduce valor -->");
				System.out.println(parAlmacen.estaValor(sc.nextInt()) + "\n");
				break;
			}
			case 4:{
				System.out.print("\nIntroduce valor -->");
				System.out.println(parAlmacen.sacarValor(sc.nextInt()) + "\n");
				break;
			}
			case 5:{
				System.out.println("\nPosiciones ocupadas = " + parAlmacen.numPosicionesOcupadas() + "\n");
				break;
			}
			case 6:{
				System.out.println("\nPosiciones libres = " + parAlmacen.numPosicionesLibres() + "\n");
				break;
			}
		  
		}

	}

}