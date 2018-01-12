public class Driver {

	public static void main(String[] args){
	
		MagicPlant test = new MagicPlant();
		
		System.out.println(test.numLeaves(6));
		System.out.println(test.ageNonRecursive(144));
		System.out.println(test.ageRecursive(144));
		
		MagicGarden test2 = new MagicGarden(1);
		System.out.println(test2.plantGrow(9));
		System.out.println("\n" + test2.ageNonRecursive(10));
		
		
		
	}
}
