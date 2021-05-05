package application;

import java.util.Scanner;

public class Main {
				
		public static void main(String[] args) throws Exception {
			
			try {
				
				//En el controller añadimos los datos básicos: número de cohete, id y null para el arraylist.
				Rocket r1 = new Rocket("32WESSDS");
				Rocket r2 = new Rocket("LDSFJA32");
				
				//Usamos el método add para añadir los detalles de los propulsores:
				r1.addEngine(new Engine("1",10));
				r1.addEngine(new Engine("2",30));
				r1.addEngine(new Engine("3",80));
				
				r2.addEngine(new Engine("1",30));
				r2.addEngine(new Engine("2",40));
				r2.addEngine(new Engine("3",50));
				r2.addEngine(new Engine("4",50));
				r2.addEngine(new Engine("5",30));
				r2.addEngine(new Engine("6",10));
				
				//Printamos las características de los Rockets.
				System.out.println(r1.printame());
				System.out.println(r2.printame());
				System.out.println("\n\n");
				
				//Lanzamos la distribución de los recursos.
				//Sería como si estuviéramos en un coche y giráramos la llave para hacer contacto.
				//Nos printará:
					//ID del cohete
					//ID del propulsor
					//Potencia ACTUAL (que en este punto será cero porque siempre empiezan a cero).
					//Potencia OBJETIVO (que en este punto también será cero porque no la hemos introducido).
					//Potencia MÁXIMA (que tendrá los valores que hemos introducido arriba para cada propulsor).
				r1.lanzamiento();
				r2.lanzamiento();
				
				//En el WHILE podemos ver la progresión de potencia de los motores.
				//Para ello hay que introducir primero un valor por consola.
				
				Scanner sc = new Scanner(System.in);
				System.out.println("\n\nPor favor, introduce una potencia objetivo.");
				//Este valor es la potencia OBJETIVO.
				//Sería como si tuviéramos el panel del control del cohete y le dijéramos: quiero ir a 10.
				//Este bucle va distribuyendo los recursos.
				//Terminará cuando todos los propulsores alcancen la potencia OBJETIVO o la potencia MÁXIMA.
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
