package juego;

import java.awt.Color;

import entorno.Entorno;

public class ProyectilDestructor {
	
	private double x;
	private double y;
	private int ancho;
	private int alto;
	private int velocidad=2;
	

	ProyectilDestructor (double x,double y) {
		
		this.x = x;
		this.y = y;
		this.ancho = 10;
		this.alto = 20;
		this.velocidad = 1;

	}
	
	void dibujarse(Entorno entorno) {
		entorno.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, 0, Color.WHITE);
	}
	void mover(){
		this.y += velocidad; //el proyectil se mueve hacia abajo
	}
	public boolean salioDePantalla() {
		return (this.y > 600); 				//devuelve si el proyectil salio de la pantalla
	}

	public double getX() {
		return x;
	}

	public double getY() {
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