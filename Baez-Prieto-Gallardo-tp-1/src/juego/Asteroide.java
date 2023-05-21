package juego;

import java.awt.Color;

import entorno.Entorno;

public class Asteroide {

	private int x;
	private int xInicial;
	private int y;
	private int ancho;
	private int alto;
	private int velocidad;
	
	Asteroide(int x, int y,int ancho,int alto){
		
		this.xInicial = (int) (Math.random()*800 + 1);
		this.x = this.xInicial; // Asigna a x la primera coordenada (de donde arranca) para definir si se mueve hacia la derecha o izquierda
		this.y = 1;
		this.ancho = ancho;
		this.alto = alto;
		this.velocidad = 1;
	}
	
	void dibujarse(Entorno entorno) {
		entorno.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, 0, Color.RED);
	}


	void moverDerecha() {
		this.y = this.y + this.velocidad;
		this.x = this.x - this.velocidad * (-1);
	}
	void moverIzquierda() {
		this.y = this.y + this.velocidad;
		this.x = this.x - this.velocidad;
	}
	public boolean salioDePantalla() {
		return (this.y>600); 		
	}
	
	public int getX() {
		return x;
	}

	public int getxInicial() {
		return xInicial;
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