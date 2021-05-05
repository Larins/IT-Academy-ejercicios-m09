package application;

public class RocketController {
	
	private RocketRepository repository;
	
    public RocketController() {
    	repository = new RocketRepository();
    }
    
    public void createRocket(int num, String id, int enginesNum) throws Exception {
	    try {
	    	Rocket rocket = new Rocket(num, id, enginesNum);
	        repository.addRocket(rocket);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("\nERROR: " + e.getMessage());	
		}
    }
    
    public String getAllRockets() {
        StringBuilder sb = new StringBuilder();
        for (Rocket rocket : repository.getAllRockets())
            sb.append("Rocket nº: ").append(rocket.getnum()).append(". Rocket ID: ").append(rocket.getid()).append(". Propulsores: ").append(rocket.getenginesNum()).append("\n\n");
        return sb.toString();
    }




}
