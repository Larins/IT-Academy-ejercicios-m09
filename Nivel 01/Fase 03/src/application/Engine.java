package application;

public class Engine {
	
	//Creamos la variable y el arraylist.
	private int potencia;
	private Rocket rocket;
	
	//Creamos el constructor.
	public Engine(String id, int potencia) {
		this.potencia = potencia;
	}
	
	//Creamos los getters y setters.
	public int getpotencia() {
		return potencia;
	}

	public void setRocket(Rocket rocket) {
		this.rocket=rocket;		
	}
	
	
}
