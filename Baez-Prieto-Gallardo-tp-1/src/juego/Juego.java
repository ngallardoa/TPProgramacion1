package juego;


import entorno.Entorno;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego
{
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	private AstroMegaShip naveMegaShip; // se declara variable de instacia de la nave
	private Asteroide asteroides; //variable de instancia de asteroide
	private DestructorEstelar destructor;
	
	// Variables y métodos propios de cada grupo
	// ...
	
	Juego()
	{
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Lost Galaxian - Grupo ... - v1", 800, 600);
		
		// Inicializar lo que haga falta para el juego
		// ...
		this.naveMegaShip = new AstroMegaShip(400, 580, 30, 30); // asignamos valores a la variable
		
		this.asteroides = new Asteroide(((int) (Math.random()*800 + 1)),1,20,20);
		
		this.destructor = new DestructorEstelar(((int) (Math.random()*800 + 1)),1,20,20);

		// Inicia el juego!
		this.entorno.iniciar();
	}

	/**
	 * Durante el juego, el método tick() será ejecutado en cada instante y 
	 * por lo tanto es el método más importante de esta clase. Aquí se debe 
	 * actualizar el estado interno del juego para simular el paso del tiempo 
	 * (ver el enunciado del TP para mayor detalle).
	 */
	public void tick()
	{
		// Procesamiento de un instante de tiempo
		// ...
		this.asteroides.dibujarse(this.entorno); // se dibuja el asteroide
		this.asteroides.moverDerecha(); // direccion que toma el asteroide
		
		this.destructor.dibujarse(this.entorno); // se dibuja un destructor estelar
		this.destructor.moverDerecha();
		this.destructor.moverIzquierda();
		
		
		this.naveMegaShip.dibujarse(this.entorno);
		if (this.entorno.estaPresionada(this.entorno.TECLA_DERECHA)
				&& this.naveMegaShip.getX() + this.naveMegaShip.getAncho() / 2 < this.entorno.ancho()) {
			this.naveMegaShip.moverDerecha();
		}
		if (this.entorno.estaPresionada(this.entorno.TECLA_IZQUIERDA)
				&& this.naveMegaShip.getX() - this.naveMegaShip.getAncho() / 2 > 0) {
			this.naveMegaShip.moverIzquierda();
		}
		

	}
	

	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Juego juego = new Juego();
	}
}
