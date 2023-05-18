package juego;

import java.awt.Color;

import entorno.Entorno;

public class DestructorEstelar {
	
	private int x;
	private int y;
	private int ancho;
	private int alto;
	private int velocidad;
	private int contadorMovimientos;
	private int sentidoMovimiento;
	
	DestructorEstelar(int x, int y,int ancho,int alto){
		
		this.x = (int) (Math.random()*800 + 1);
		this.y = 1;
		this.ancho = ancho;
		this.alto = alto;
		this.velocidad = 1;
		this.contadorMovimientos = 0;
		this.sentidoMovimiento = 1;
	}
	
	void dibujarse(Entorno entorno) {
		entorno.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, 0, Color.GREEN);
	}

	void mover(int sentido, boolean zigZag){
		if (zigZag == true){
			if (this.contadorMovimientos == 90){
				contadorMovimientos = 0;
				this.sentidoMovimiento = this.sentidoMovimiento * (-1);
			}
		}
			this.y = this.y + this.velocidad;
			this.x = this.x - this.velocidad * sentido * this.sentidoMovimiento;
			this.contadorMovimientos ++;
	}
	// void moverDerecha(){
	// 	this.y = this.y + this.velocidad;
	// 	this.x = this.x - this.velocidad * (-1);
	// 	this.contadorMovimientos ++;
	// }

	// void moverIzquierda(){
	// 	this.y = this.y + this.velocidad;
	// 	this.x = this.x - this.velocidad;
	// 	this.contadorMovimientos ++;
	// }
}

