package application;

import java.util.ArrayList;

public class Rocket {
	
	//Creamos la variable y el arraylist.
	private String id;
	public ArrayList<Engine> engines;
	
	//Creamos el constructor.
	public Rocket(String id, ArrayList<Engine> engines) {
		this.id = id;
		this.engines = engines;
	}
	
	public Rocket(String id) {
		this.id = id;
		this.engines = new ArrayList<Engine>();
	}
	
	//Creamos los getters y setters.
	public String getid() {
		return id;
	}

	//Creamos el método add para añadir propulsores.
	//Este método hace referencia a la clase Engine.
	public void addEngine(Engine eng) {
		engines.add(eng);
		eng.setRocket(this);
	}
	
	//Creamos unos métodos para printar rápidamente.
	public String printame() {
		String print = "\nRocket ID = " + id + ": Tiene "+ engines.size() +" propulsores. \nPotencia máxima propulsores: ";
		for(Engine e: engines) {
			print += e.getpotenciaMax() + " ";
		}
		return print;
	}
	
	//Creamos los métodos que permiten conducir el rocket.
	
	//SETOBJETIVO permite establecer una potencia OBJETIVO en el MAIN.
	//Sería como si tuviéramos el panel del control del cohete y le dijéramos: quiero ir a 10.

	public void setObjetivo(int obj) {
		for(Engine p: engines) {
			p.setObjetivo(obj);
		}
	}
	
	//LANZAMIENTO permite iniciar los propulsores.
	//Sería como si estuviéramos en un coche y giráramos la llave para hacer contacto.
	
	public void lanzamiento() {
		for(Engine p: engines) {
			p.start();
		}
	}
	
	public static void main(String[] args) {}
	
}
