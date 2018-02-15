package ejAlmacenDatos;

/**
 * La clase Almacen1 implementa un almacen de enteros mediante un array unidimensional.
 * Se establecen las posiciones libres mediante el numero 0, por lo que no puede usarse.
 * 
 * @author Alberto
 * @author Javier Sergio Prado
 * @version 1.0
 */
public class Almacen1 {

	static private final int LIBRE = 0;	// Numero que indica la posicion libre
	private int tvalores[];				// Array de enteros
	private int valoresAlmacenados = 0;	// Contador de ocupados
	
	/**
	 * El constructor por defecto genera un array de 10 llamando al constructor con parametro indicandole el tamaño.
	 */
	public Almacen1(){
		this(10);  
	}

	/**
	 * Constructor donde se fija el tamaño del array.
	 * 
	 * @param tamaño Indica el tamaño del array.
	 */
	public Almacen1( int tamaño){
		tvalores = new int [tamaño];
		init();
	}
	
	/**
	 * Inicializa los valores del array a 0 para indicar que estan libres.
	 */
	public void init (){
		for (int i = 0; i < tvalores.length; i++) {
			tvalores[i] = Almacen1.LIBRE;
		}
		valoresAlmacenados = 0;
	}
	 
	/**
	 * Muestra una cadena con los valores de la tabla.
	 * 
	 * @return sb.toString() Acumula entre corchetes el valor de cada posicion.
	 */
	public String toString (){
		StringBuilder sb = new StringBuilder();
		for (int i=0;i<tvalores.length;i++) {
			sb.append("[" + tvalores[i] + "]");
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
	 * Determina si un valor se encuentra en el array.
	 * 
	 * @param num El valor a buscar en el array.
	 * @return encontrado devuelve true si se encuentra y false si no esta.
	 */
	public boolean estaValor ( int num){
		boolean encontrado = false;
		for (int value: tvalores) {
			if (value==num) {
				encontrado = true;
				break;
			}
		}
		return encontrado;
	}
	
	/**
	 * Almacena el valor introducido en la primera posicion vacia del array 
	 * y aumenta el contador valoresAlmacenados. Si el numero pasado es un 0 no se almacena.
	 * 
	 * @param num Valor a introducir en la tabla
	 * @return cabe devuelve true si el valor se almacena y false si no se almacena.
	 */
	public boolean ponValor (int num){
		
		boolean cabe = true;
		if ((this.valoresAlmacenados == this.tvalores.length)||num==0) {
			cabe = false;
		} else {
			for(int i=0;i<tvalores.length;i++) {
				if(tvalores[i]==0) {
					tvalores[i]=num;
					this.valoresAlmacenados++;
					break;
				}
			}
		}
		return cabe;
	}
	
	/**
	 * Se realiza una busqueda del valor introducido y evalua que sea distinto de 0.
	 * Si lo encuentra elimina la primera coincidencia.
	 * 
	 * @param num Valor a eliminar
	 * @return encontrado devuelve true si existe y false si no existe
	 */
	public boolean sacarValor (int num){
		boolean encontrado = (estaValor(num)&&num!=0);
		
		if (encontrado) {
			for (int i=0;i<tvalores.length;i++) {
				if (tvalores[i]==num) {
					tvalores[i] = 0;
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