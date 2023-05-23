package juego;

import java.awt.Color;

import entorno.Entorno;

public class Proyectil {
	
	private int x;
	private int y;
	private int ancho;
	private int alto;
	private int velocidad=2;
	

	Proyectil (int x, int y){
		
		this.x = x;
		this.y = y;
		this.ancho = 10;
		this.alto = 20;
		this.velocidad = 3;	
		
	}
	void dibujarse(Entorno entorno) {
		entorno.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, 0, Color.ORANGE);
	}
	void mover(){
		this.y -= velocidad; //el proyectil se mueve hacia arriba
	}
	
	public boolean salioDePantalla() {
		return (this.y < 0); 				//devuelve si el proyectil salio de la pantalla
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
