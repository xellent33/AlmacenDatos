package ejAlmacenDatos;

import java.util.Arrays;

/**
 * La clase Almacen2 implementa un almacen de enteros mediante un array unidimensional.
 * Se ordena la tabla con los numeros introducidos a la izquierda del array 
 * y las posiciones libres a la derecha.
 * 
 * @author Alberto
 * @author Javier Sergio Prado
 * @version 1.0
 */
public class Almacen2 {

	private int tvalores[];				// Array de enteros
	private int valoresAlmacenados = 0;	// Contador de ocupados
	
	/**
	 * El constructor por defecto genera un array de 10 llamando al constructor con parametro indicandole el tamaño.
	 */
	public Almacen2(){
		this(10);  
	}

	/**
	 * Constructor donde se fija el tamaño del array.
	 * 
	 * @param tamaño Indica el tamaño del array.
	 */
	public Almacen2( int tamaño){
		tvalores = new int [tamaño];
	}
	 
	/**
	 * Muestra una cadena con los valores de la tabla.
	 * Si la posicion esta libre para sobreescribirse mostrara el caracter '#' antes del entero.
	 * 
	 * @return sb.toString() Acumula entre corchetes el valor de cada posicion.
	 */
	public String toString (){
		StringBuilder sb = new StringBuilder();
		for (int i=0;i<this.valoresAlmacenados;i++) {
			sb.append("[" + tvalores[i] + "]");
		}
		for (int i=0;i<this.numPosicionesLibres();i++) {
			sb.append("[#" + tvalores[this.valoresAlmacenados+i] + "]");
		}
		return sb.toString();
	}
	
	/**
	 * Devuelve el numero de posiciones libres: tamaño del array - valores almacenados.
	 * 
	 * @return pl Posiciones libres.
	 */
	public int numPosicionesLibres(){
		int pl = tvalores.length - this.valoresAlmacenados;
		return pl;
	}
	
	/**
	 * Devuelve el número de posiones ocupadas
	 * 
	 * @return valoresAmacenados Posiciones ocupadas
	 */
	public int numPosicionesOcupadas(){
		
		return this.valoresAlmacenados;
	}
	
	/**
	 * Determina si un valor se encuentra en las posiciones ocupadas del array.
	 * 
	 * @param num El valor a buscar en el array.
	 * @return encontrado devuelve true si se encuentra y false si no esta.
	 */
	public boolean estaValor ( int num){
		boolean encontrado = false;
		for (int i=0;i<this.valoresAlmacenados;i++) {
			if (this.tvalores[i]==num) {
				encontrado = true;
				break;
			}
		}
		return encontrado;
	}
	
	/**
	 * Almacena el valor introducido en el array y aumenta el contador valoresAlmacenados. 
	 * Despues ordena los numeros almacenados.
	 * 
	 * @param num Valor a introducir en la tabla
	 * @return cabe devuelve true si el valor se almacena y false si no se almacena.
	 */
	public boolean ponValor (int num){
		
		boolean cabe = true;
		if (this.valoresAlmacenados == this.tvalores.length) {
			cabe = false;
		} else {
			this.tvalores[this.valoresAlmacenados] = num;
			this.valoresAlmacenados++;
			Arrays.sort(tvalores, 0, valoresAlmacenados);
		}
		return cabe;
	}
	
	/**
	 * Se realiza una busqueda del valor introducido. Si lo encuentra elimina la primera coincidencia.
	 * Despues reordena las posiciones ocupadas y copia el valor eliminado a la ultima posicion por seguridad.
	 * 
	 * @param num Valor a eliminar
	 * @return encontrado devuelve true si existe y false si no existe
	 */
	public boolean sacarValor (int num){			
		boolean encontrado = estaValor(num);
		
		if (encontrado) {
			for (int i=0;i<tvalores.length;i++) {
				if (tvalores[i]==num) {
					for (int j=i;j<tvalores.length-1;j++) {
						tvalores[j] = tvalores[j+1];
					}
					tvalores[tvalores.length-1] = num;
					this.valoresAlmacenados--;
					break;
				}
			}
		}
		return encontrado;
	}
      
	/**
	 * Indica si el almacen esta lleno
	 * 
	 * @return lleno devuelve true si esta lleno y false si quedan huecos libres.
	 */
	public boolean estaLleno (){	
		boolean lleno;
		if (this.valoresAlmacenados==this.tvalores.length) {
			lleno = true;
		} else {
			lleno = false;
		}
		return lleno;
	}
}