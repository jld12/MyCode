public class MagicPlant {

	private int age;
	
	public MagicPlant(){ age = 0; }
	
	
	/**
	 * Returns the number of leaves on a magic plant based on the age of the plant.
	 * @param age		Age of the magic plant.
	 * @return
	 */
	public int numLeaves(int age){
		int numLeaves = 0;
		
		for(int i = 1; i <= age; i++){
			
			if(i == 1){ numLeaves += 2; }
			else if(i % 3 != 0){ numLeaves *= 2; }
			else{ numLeaves *= 3; }
			
		}
		
		return numLeaves;
	}
	
	
	/**
	 * Returns the age of the plant when given the number of leaves. Non-recursive.
	 * @param numLeaves
	 * @return
	 */
	public int ageNonRecursive(int numLeaves){
		age = 0;
		if(numLeaves <= 1) return age;
		
		while(numLeaves > 1){
		
			if(numLeaves % 3 == 0){ numLeaves /= 3; age++; }
			else{ numLeaves /= 2; age ++; }
		}
		
		return age;
	}
	
	
	/**
	 * Returns the age of the plant when given the number of leaves. Recursive.
	 * @param numLeaves		Number of leaves on the magic plant.
	 * @return
	 */
	public int ageRecursive(int numLeaves){
		
		if(numLeaves == 0 || numLeaves == 1){ return age; }
		if(numLeaves % 2 == 0){ return ageRecursive(numLeaves/2); }
		if(numLeaves % 3 == 0){ return ageRecursive(numLeaves/3); }
		else return age;
	}
	
}
