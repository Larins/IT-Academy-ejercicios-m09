package application;

import java.util.Scanner;

public class Main {
				
		public static void main(String[] args) throws Exception {
			
			try {
				
				//En el controller a�adimos los datos b�sicos: n�mero de cohete, id y null para el arraylist.
				Rocket r1 = new Rocket("32WESSDS");
				Rocket r2 = new Rocket("LDSFJA32");
				
				//Usamos el m�todo add para a�adir los detalles de los propulsores:
				r1.addEngine(new Engine("1",10));
				r1.addEngine(new Engine("2",30));
				r1.addEngine(new Engine("3",80));
				
				r2.addEngine(new Engine("1",30));
				r2.addEngine(new Engine("2",40));
				r2.addEngine(new Engine("3",50));
				r2.addEngine(new Engine("4",50));
				r2.addEngine(new Engine("5",30));
				r2.addEngine(new Engine("6",10));
				
				//Printamos las caracter�sticas de los Rockets.
				System.out.println(r1.printame());
				System.out.println(r2.printame());
				System.out.println("\n\n");
				
				//Lanzamos la distribuci�n de los recursos.
				//Ser�a como si estuvi�ramos en un coche y gir�ramos la llave para hacer contacto.
				//Nos printar�:
					//ID del cohete
					//ID del propulsor
					//Potencia ACTUAL (que en este punto ser� cero porque siempre empiezan a cero).
					//Potencia OBJETIVO (que en este punto tambi�n ser� cero porque no la hemos introducido).
					//Potencia M�XIMA (que tendr� los valores que hemos introducido arriba para cada propulsor).
				r1.lanzamiento();
				r2.lanzamiento();
				
				//En el WHILE podemos ver la progresi�n de potencia de los motores.
				//Para ello hay que introducir primero un valor por consola.
				
				Scanner sc = new Scanner(System.in);
				System.out.println("\n\nPor favor, introduce una potencia objetivo.");
				//Este valor es la potencia OBJETIVO.
				//Ser�a como si tuvi�ramos el panel del control del cohete y le dij�ramos: quiero ir a 10.
				//Este bucle va distribuyendo los recursos.
				//Terminar� cuando todos los propulsores alcancen la potencia OBJETIVO o la potencia M�XIMA.
				while(true) {
					int obj=sc.nextInt();
					r1.setObjetivo(obj);
					r2.setObjetivo(obj);	
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("\n\n\tERROR!\n\t" + e.getMessage() + "\n");
			}
			
		}
}
