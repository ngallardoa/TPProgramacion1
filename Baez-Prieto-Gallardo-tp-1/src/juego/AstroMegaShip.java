package juego;

//import java.awt.Image;
import java.awt.Color;

import entorno.Entorno;

public class AstroMegaShip {
	
	private int x;
	private int y;
	private int ancho;
	private int alto;
	private int velocidad;
	
	//private Image nave;
	
	
	
	AstroMegaShip(int x, int y , int ancho, int alto){
		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.alto = alto;
		this.velocidad = 3;
		//this.nave = Herramientas.cargarImagen("ship1.jpg");
		
	}
	
	void dibujarse(Entorno entorno) {
		entorno.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, 0, Color.YELLOW);
	}
	
	public Proyectil lanzarProyectil() {
		Proyectil miProyectil = new Proyectil(this.x,this.y);
		return miProyectil;
	}
	
	void moverDerecha() {
		this.x = this.x + this.velocidad;
	}
	
	void moverIzquierda() {
		this.x = this.x - this.velocidad;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getAncho() {
		return ancho;
	}

	public int getAlto() {
		return alto;
	}

	public int getVelocidad() {
		return velocidad;
	}	
	
}
