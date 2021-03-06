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

	//Creamos el m?todo add para a?adir propulsores.
	//Este m?todo hace referencia a la clase Engine.
	public void addEngine(Engine eng) {
		engines.add(eng);
		eng.setRocket(this);
	}
	
	//Creamos unos m?todos para printar r?pidamente.
	public String printame() {
		String print = "\nRocket ID = " + id + ": Tiene "+ engines.size() +" propulsores. \nPotencia m?xima propulsores: ";
		for(Engine e: engines) {
			print += e.getpotenciaMax() + " ";
		}
		return print;
	}
	
	//Creamos los m?todos que permiten conducir el rocket.
	
	//SETOBJETIVO permite establecer una potencia OBJETIVO en el MAIN.
	//Ser?a como si tuvi?ramos el panel del control del cohete y le dij?ramos: quiero ir a 10.

	public void setObjetivo(int obj) {
		for(Engine p: engines) {
			p.setObjetivo(obj);
		}
	}
	
	//LANZAMIENTO permite iniciar los propulsores.
	//Ser?a como si estuvi?ramos en un coche y gir?ramos la llave para hacer contacto.
	
	public void lanzamiento() {
		for(Engine p: engines) {
			p.start();
		}
	}
	
	public static void main(String[] args) {}
	
}
