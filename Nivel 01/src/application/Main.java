package application;


public class Main {
		
		private static RocketController controller=new RocketController();
		
		public static void main(String[] args) throws Exception {
			
			try {
				
				controller.createRocket(1, "32WESSDS", 3);
				controller.createRocket(2, "LDSFJA32", 6);
				
								
				String allRockets=controller.getAllRockets();
				
				System.out.println("ROCKETS:\n\n" + allRockets + " \n");
			
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("\n\n\tERROR!\n\t" + e.getMessage() + "\n");
			}
			
		}
}
