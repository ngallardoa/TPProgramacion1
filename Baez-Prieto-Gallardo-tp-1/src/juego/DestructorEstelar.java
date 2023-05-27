package juego;
import java.awt.Color;
import entorno.Entorno;

public class DestructorEstelar {
	
	private double x;
	private double y;
	private int ancho;
	private int alto;
	private double velocidad;
	private double contadorMovimientos;
	private double sentidoMovimiento;
	private int altoPantalla = 600;	
	
	DestructorEstelar(double x, double y, int ancho, int alto){
		
		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.alto = alto;
		this.velocidad = 0.5;
		this.contadorMovimientos = 0;
		this.sentidoMovimiento = 1;
	}
	public ProyectilDestructor lanzarProyectil() {
		ProyectilDestructor ionDestructor = new ProyectilDestructor(this.x,this.y);
		return ionDestructor;
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

	public double getVelocidad() {
		return velocidad;
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

	public boolean salioDePantalla() {
		return (this.y > altoPantalla); //devuelve si el proyectil salio de la pantalla
	}
}

