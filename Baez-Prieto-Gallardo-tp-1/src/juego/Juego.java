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
	private Proyectil miProyectil;
	private DestructorEstelar destructores [ ] ;
	private ProyectilDestructor ionDestructor;
	
	
	
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
		
		this.destructor = new DestructorEstelar(5,1,20,20);
		
		this.destructores = new DestructorEstelar [4];
		int destructorX = 20; // el X donde se genera el destructor
		int destructorY = 10;//el y donde se genera el destructor 
		for (int i=0;i<destructores.length;i++) {
			
			destructores[i]= new DestructorEstelar(destructorX,destructorY,20,20); // genera los 4 destructores iniciales
			destructorX+=200;
			destructorY+=30;
			
			
		}
		
		
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
		if (this.asteroides!=null) {
			this.asteroides.dibujarse(this.entorno); // se dibuja el asteroide
			if (this.asteroides.getxInicial() > 400) {
				this.asteroides.moverIzquierda();
				//System.out.print(this.asteroides.getxInicial());
			}
			else {
				this.asteroides.moverDerecha();
				//System.out.print(this.asteroides.getxInicial());
			}
			if(this.asteroides.salioDePantalla())
				this.asteroides=null;
		
			
		}
		if (this.asteroides==null)
			asteroides=new Asteroide(((int) (Math.random()*800 + 1)),1,20,20); // si el asteroide es eliminado o sale de pantalla se genera un nuevo asteroide
		
			
		//this.destructor.dibujarse(this.entorno); // se dibuja un destructor estelar
		//this.destructor.moverDerecha();
		//this.destructor.moverIzquierda();
		for (int i=0;i<destructores.length;i++) {
			destructores[i].dibujarse(this.entorno);
			destructores[i].mover(-1, true);
			if (ionDestructor==null)
				ionDestructor= this.destructores[i].lanzarProyectil();
			if (ionDestructor!=null) {
				ionDestructor.dibujarse(this.entorno);
				ionDestructor.mover();
				if(ionDestructor.salioDePantalla())
					ionDestructor=null;
			}
		}
		
		
		
		
		this.naveMegaShip.dibujarse(this.entorno);
		if ((this.entorno.estaPresionada(this.entorno.TECLA_DERECHA)||(this.entorno.estaPresionada('d')))
				&& this.naveMegaShip.getX() + this.naveMegaShip.getAncho() / 2 < this.entorno.ancho()) {
			this.naveMegaShip.moverDerecha();
		}
		if ((this.entorno.estaPresionada(this.entorno.TECLA_IZQUIERDA)||(this.entorno.estaPresionada('a')))
				&& this.naveMegaShip.getX() - this.naveMegaShip.getAncho() / 2 > 0) {
			this.naveMegaShip.moverIzquierda();
		}
		if (this.entorno.sePresiono(this.entorno.TECLA_ESPACIO) && miProyectil == null) {
			miProyectil = this.naveMegaShip.lanzarProyectil();
		}
		if (miProyectil!=null) {					//mientras el objeto existe se dibuja en pantalla y se mueve
			miProyectil.dibujarse(this.entorno);
			miProyectil.mover();
			if (miProyectil.salioDePantalla())
				miProyectil=null; 					//si el proyectil sale de la pantalla, se elimina el objeto
			
		}
		

	}
	

	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Juego juego = new Juego();
	}
}
