package juego;

public class ColisionDeObjetos {
	
	public static boolean colision(Asteroide Asteroide, AstroMegaShip AstroMegaShip) {
		
		boolean colisionX = Asteroide.getX() + Asteroide.getAncho() >= AstroMegaShip.getX() && AstroMegaShip.getX() + AstroMegaShip.getAncho() >= Asteroide.getX();
		
		boolean colisionY = Asteroide.getY() + Asteroide.getAlto() >= AstroMegaShip.getY() && AstroMegaShip.getY() + AstroMegaShip.getAlto() >= Asteroide.getY();
	
		return colisionX && colisionY;
	}

}