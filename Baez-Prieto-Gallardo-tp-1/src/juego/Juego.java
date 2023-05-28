package juego;
import entorno.Entorno;
import entorno.InterfaceJuego;
import java.util.Random;
import entorno.Herramientas;
import java.awt.Image;

public class Juego extends InterfaceJuego
{
	// El objeto Entorno que controla el tiempo y otros

	private Entorno entorno;
	private AstroMegaShip naveMegaShip; // se declara variable de instacia de la nave
	private Asteroide asteroides; // variable de instancia de asteroide
	private DestructorEstelar destructor;
	private Proyectil miProyectil;
	private DestructorEstelar destructores[];
	private ProyectilDestructor ionDestructor;
	private int anchoPantalla = 800;
	private int altoPantalla = 600;	
	private int cantidadDestructores = 4;
	private long tiempoTranscurrido;
	// private VidaExtra vidaExtra;
	private int puntos;
	private Image fondo;
	private int cantidadDestructoresEliminados;
	
	// Variables y métodos propios de cada grupo

	private boolean esUnico(DestructorEstelar[] destructores, int numero, int indiceActual){

		int diferencia = 75;

		for (int i = 0; i < indiceActual; i++){
			if (destructores[i] != null && Math.abs(destructores[i].getX() - numero) <= diferencia) {
				return false;
			}
		}
		return true;
	}

	private void renderizarDestructorEstelar(DestructorEstelar[] destructores){
		Random random = new Random();
		for (int i = 0; i < destructores.length; i++) {		
			int destructorX = random.nextInt(anchoPantalla - 200) + 20;
			int destructorY = random.nextInt(30) - 20;
			while (!esUnico(destructores, destructorX, cantidadDestructores)){
				destructorX = random.nextInt(anchoPantalla - 200) + 20;
				System.out.println(" " + destructorX);
			}
			if (destructores[i] == null){
				destructores[i] = new DestructorEstelar(destructorX, destructorY, 20, 20); // genera destructores
			}		
		}
	}

	Juego()
	{
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Lost Galaxian - Grupo ... - v1", anchoPantalla, altoPantalla);
		// Inicializar lo que haga falta para el juego
		this.naveMegaShip = new AstroMegaShip(400, 580, 30, 30); // asignamos valores a la variable
		
		this.asteroides = new Asteroide(((int) (Math.random()*anchoPantalla + 1)),1,20,20);
		
		this.destructor = new DestructorEstelar(5,1,20,20);
		
		this.destructores = new DestructorEstelar[cantidadDestructores];

		this.tiempoTranscurrido = System.currentTimeMillis();

		renderizarDestructorEstelar(destructores);
		
		// Inicia el juego!
		this.entorno.iniciar();		
	}

	/**
	 * Durante el juego, el método tick() será ejecutado en cada instante y 
	 * por lo tanto es el método más importante de esta clase. Aquí se debe 
	 * actualizar el estado interno del juego para simular el paso del tiempo 
	 * (ver el enunciado del TP para mayor detalle).
	 */
	public void tick(){
		// Procesamiento de un instante de tiempo
		// ...
		this.entorno.escribirTexto("Enemigos eliminados:  " + puntos, entorno.ancho() - entorno.ancho() / 5, entorno.alto() / 35);
		if (this.asteroides != null) {
			this.asteroides.dibujarse(this.entorno); // se dibuja el asteroide
			if (this.asteroides.getxInicial() > (anchoPantalla / 2)) {
				this.asteroides.moverIzquierda();
			}
			else {
				this.asteroides.moverDerecha();
			}
			if(this.asteroides.salioDePantalla())
				this.asteroides = null;			
		}
		if (this.asteroides == null){
			asteroides = new Asteroide(((int) (Math.random() * anchoPantalla + 1)), 1, 20, 20); // si el asteroide es eliminado o sale de pantalla se genera un nuevo asteroide			
		}

		for (int i = 0; i < destructores.length; i++) {
			destructores[i].dibujarse(this.entorno);
			destructores[i].mover(-1, true);
			if ((System.currentTimeMillis() - tiempoTranscurrido >= 1000) && ionDestructor == null){
				tiempoTranscurrido = System.currentTimeMillis();
				ionDestructor = this.destructores[i].lanzarProyectil();
			}
			if (ionDestructor != null) {
				ionDestructor.dibujarse(this.entorno);
				ionDestructor.mover();
				if(ionDestructor.salioDePantalla())
				ionDestructor = null;
			}
			if (this.destructores[i].salioDePantalla()){ //modificado
				this.destructores[i] = null; //modificado
				renderizarDestructorEstelar(destructores);
			}
		}

		this.naveMegaShip.dibujarse(this.entorno);
		if ((this.entorno.estaPresionada(this.entorno.TECLA_DERECHA) || (this.entorno.estaPresionada('d')))
				&& this.naveMegaShip.getX() + this.naveMegaShip.getAncho() / 2 < this.entorno.ancho()) {
			this.naveMegaShip.moverDerecha();
		}
		if ((this.entorno.estaPresionada(this.entorno.TECLA_IZQUIERDA) || (this.entorno.estaPresionada('a')))
				&& this.naveMegaShip.getX() - this.naveMegaShip.getAncho() / 2 > 0) {
			this.naveMegaShip.moverIzquierda();
		}
		if (this.entorno.sePresiono(this.entorno.TECLA_ESPACIO) && miProyectil == null) {
			miProyectil = this.naveMegaShip.lanzarProyectil();
		}
		if (miProyectil != null) {					//mientras el objeto existe se dibuja en pantalla y se mueve
			miProyectil.dibujarse(this.entorno);
			miProyectil.mover();
			for (int i = 0; i < destructores.length; i++)
				if (this.miProyectil != null && this.destructores[i ]!= null && this.miProyectil.colisionoConDestructor(destructores[i])) {
					this.miProyectil = null;
					this.destructores[i] = null;
					puntos += 2;
					renderizarDestructorEstelar(destructores);
					cantidadDestructoresEliminados ++;		
				}
			if (miProyectil.salioDePantalla()){
				miProyectil = null; 					//si el proyectil sale de la pantalla, se elimina el objeto
			}
			if (this.naveMegaShip.colisionoConAsteroide(this.asteroides)) {
				this.asteroides = null;
				this.naveMegaShip = null;
			}
			if (this.naveMegaShip.colisionoIonDestructor(this.ionDestructor)) {
				this.ionDestructor = null;
				this.naveMegaShip = null;
			}
			if (this.miProyectil.colisionoConAsteroide(this.asteroides)) {
				this.asteroides = null;
				this.miProyectil = null;
				puntos += 1;
			}
		}	
	}

	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Juego juego = new Juego();
	}
}
