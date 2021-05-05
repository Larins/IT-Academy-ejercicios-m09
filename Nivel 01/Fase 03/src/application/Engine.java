package application;

public class Engine extends Thread { //Antes no había especificado que los propulsores son threads porque no era necesario.
	
	//Creamos la variable y el arraylist.
	private int potenciaMax; //antes se llamaba solo "potencia"
	private int potenciaAct;
	private int potenciaObj;
	private Rocket rocket;
	
	//Creamos el constructor.
	//Incluimos solo las variables de valor FIJO, o sea el id y la potencia máxima.
	//Las variables cuyo valor modifica el propio programa se definen en los setters más abajo.
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
	//Como máximo, será igual a la potencia MÁXIMA.
	//Como mínimo, será cero.
	//En el resto de casos, es igual a sí misma.
	public void setObjetivo(int obj) {
		if (obj>potenciaMax) {
			this.potenciaObj = potenciaMax;
		}else if (obj<0) {
			this.potenciaObj = 0;			
		}else {
			this.potenciaObj = obj;
		}
	}
	
	//Creamos el RUN donde va a desarrollarse la dinámica de los propulsores.
	//En el MAIN introduciremos un valor que será la potencia OBJETIVO (con los métodos de ROCKET).
	//Sería como si tuviéramos el panel del control del cohete y le dijéramos: quiero ir a 10.
	//La dinámica de THREADS hará que los recursos se vayan distribuyendo en los diferentes propulsores.
	//Y el programa realizará dos tareas: frenar y acelerar.
	//Acelerará hasta que la potencia ACTUAL sea igual a la inferior de las siguientes: OBJETIVO o MÁXIMA.
	//Llegados a ese punto, frenará.
	//El programa además nos irá indicando en qué valores está, como si fuera la sala de mandos del Rocket.
	
	public void run() {
		boolean conseguida=false;
		while(true) {
			if (potenciaAct>potenciaObj) {
				potenciaAct--;//frenar
				System.out.println(this.rocket.getid() + " - " + Thread.currentThread().getName() + ": Potencia ACTUAL " + potenciaAct + " - Potencia OBJETIVO: "+ potenciaObj + " - Potencia MÁXIMA: " + potenciaMax);
				 conseguida=false;
			}
			else if (potenciaAct<potenciaObj) {
				potenciaAct++;//accelerar
				System.out.println(this.rocket.getid() + " - " + Thread.currentThread().getName() + ": Potencia ACTUAL " + potenciaAct + " - Potencia OBJETIVO: "+ potenciaObj + " - Potencia MÁXIMA: " + potenciaMax);
				 conseguida=false;
			}else{//actual==objetivo
				if (!conseguida) {
					System.out.println(this.rocket.getid() + " - " + Thread.currentThread().getName() + ": Potencia ACTUAL " + potenciaAct + " - Potencia OBJETIVO: "+ potenciaObj + " - Potencia MÁXIMA: " + potenciaMax);
				 conseguida=true;
				}
			}
			try {Thread.sleep(500);} catch (InterruptedException e) {}
		}
	}
	
	
	
	
	
}
