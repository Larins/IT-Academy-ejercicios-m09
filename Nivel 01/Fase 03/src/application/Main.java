package application;

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
				
				//Printamos...
				System.out.println(r1.printame());
				System.out.println(r2.printame());
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("\n\n\tERROR!\n\t" + e.getMessage() + "\n");
			}
			
		}
}
