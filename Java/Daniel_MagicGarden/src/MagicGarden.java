public class MagicGarden {

	private int numPlants;
	
	public MagicGarden(int n){ numPlants = n; }
	
	public int plantGrow(int age){
		int n = numPlants;
		for(int i = 1; i <= age; i++){ if(i % 4 == 0){ n = n + (n * 2); } }
		return n;
	}
	
	
	
} 
