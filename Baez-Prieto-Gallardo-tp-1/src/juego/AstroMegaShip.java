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
	private int contadorMovimientos;
	private int sentidoMovimiento;
	//private Image nave;
	
	
	
	AstroMegaShip(int x, int y , int ancho, int alto){
		this.x=x;
		this.y=y;
		this.ancho=ancho;
		this.alto=alto;
		this.velocidad = 2;
		this.contadorMovimientos = 0;
		this.sentidoMovimiento = 1;
		//this.nave = Herramientas.cargarImagen("ship1.jpg");
		
	}
	
	void dibujarse(Entorno entorno) {
		entorno.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, 0, Color.YELLOW);
	}

	void mover(int sentido, boolean zigZag){
		if (zigZag == true){
			if (this.contadorMovimientos == 3){
				contadorMovimientos = 0;
				this.sentidoMovimiento *= -1;
			}
		}
			// this.y = this.y + this.velocidad;
			this.x = this.x - this.velocidad * sentido * this.sentidoMovimiento;
		if (zigZag == true){
			this.contadorMovimientos ++;
		}
	}
	
	// void moverDerecha() {
	// 	this.x = this.x + this.velocidad;
	// }
	
	// void moverIzquierda() {
	// 	this.x = this.x - this.velocidad;
	// }

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
