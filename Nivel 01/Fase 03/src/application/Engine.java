package application;

public class Engine extends Thread { //Antes no hab�a especificado que los propulsores son threads porque no era necesario.
	
	//Creamos la variable y el arraylist.
	private int potenciaMax; //antes se llamaba solo "potencia"
	private int potenciaAct;
	private int potenciaObj;
	private Rocket rocket;
	
	//Creamos el constructor.
	//Incluimos solo las variables de valor FIJO, o sea el id y la potencia m�xima.
	//Las variables cuyo valor modifica el propio programa se definen en los setters m�s abajo.
	public Engine(String id, int potenciaMax) {
		this.potenciaMax = potenciaMax;
	}
	
	//Creamos los getters y setters.
	public int getpotenciaMax() {
		return potenciaMax;
	}

	public void setRocket(Rocket rocket) {
		this.rocket=rocket;		
	}
	
	//Marcamos las condiciones de la potencia OBJETIVO.
	//Como m�ximo, ser� igual a la potencia M�XIMA.
	//Como m�nimo, ser� cero.
	//En el resto de casos, es igual a s� misma.
	public void setObjetivo(int obj) {
		if (obj>potenciaMax) {
			this.potenciaObj = potenciaMax;
		}else if (obj<0) {
			this.potenciaObj = 0;			
		}else {
			this.potenciaObj = obj;
		}
	}
	
	//Creamos el RUN donde va a desarrollarse la din�mica de los propulsores.
	//En el MAIN introduciremos un valor que ser� la potencia OBJETIVO (con los m�todos de ROCKET).
	//Ser�a como si tuvi�ramos el panel del control del cohete y le dij�ramos: quiero ir a 10.
	//La din�mica de THREADS har� que los recursos se vayan distribuyendo en los diferentes propulsores.
	//Y el programa realizar� dos tareas: frenar y acelerar.
	//Acelerar� hasta que la potencia ACTUAL sea igual a la inferior de las siguientes: OBJETIVO o M�XIMA.
	//Llegados a ese punto, frenar�.
	//El programa adem�s nos ir� indicando en qu� valores est�, como si fuera la sala de mandos del Rocket.
	
	public void run() {
		boolean conseguida=false;
		while(true) {
			if (potenciaAct>potenciaObj) {
				potenciaAct--;//frenar
				System.out.println(this.rocket.getid() + " - " + Thread.currentThread().getName() + ": Potencia ACTUAL " + potenciaAct + " - Potencia OBJETIVO: "+ potenciaObj + " - Potencia M�XIMA: " + potenciaMax);
				 conseguida=false;
			}
			else if (potenciaAct<potenciaObj) {
				potenciaAct++;//accelerar
				System.out.println(this.rocket.getid() + " - " + Thread.currentThread().getName() + ": Potencia ACTUAL " + potenciaAct + " - Potencia OBJETIVO: "+ potenciaObj + " - Potencia M�XIMA: " + potenciaMax);
				 conseguida=false;
			}else{//actual==objetivo
				if (!conseguida) {
					System.out.println(this.rocket.getid() + " - " + Thread.currentThread().getName() + ": Potencia ACTUAL " + potenciaAct + " - Potencia OBJETIVO: "+ potenciaObj + " - Potencia M�XIMA: " + potenciaMax);
				 conseguida=true;
				}
			}
			try {Thread.sleep(500);} catch (InterruptedException e) {}
		}
	}
	
	
	
	
	
}
