package application;

import java.util.*;

public class RocketRepository {
	
private static List<Rocket> rockets=new ArrayList<>();
	
	public RocketRepository(){}
	
	public List<Rocket> getAllRockets(){
		return new ArrayList<>(rockets);
	}
	
	public void addRocket(Rocket rocket) throws Exception{
		if(rocket==null) throw new Exception();
		rockets.add(rocket);	
	}
}
