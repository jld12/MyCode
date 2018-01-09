
public class Driver {

	public static void main(String[] args) {
		
		String testKey = "ababcxc";
		Serial testSerial = new Serial(testKey);		
		testSerial.SetSerial("xyz");
		
		System.out.println("Key: " + testSerial.GetKey());
		System.out.println("Serial Code: " + testSerial.GetSerial());
		System.out.println(testSerial.FindMatch('K'));
		
		System.out.println(testSerial.GetNextSerial());
		System.out.println(testSerial.GetNextSerial());
		System.out.println(testSerial.GetNextSerial());
		System.out.println(testSerial.GetNextSerial());
		System.out.println(testSerial.GetNextSerial());
		System.out.println(testSerial.GetNextSerial());
		System.out.println(testSerial.GetNextSerial());
		System.out.println(testSerial.GetNextSerial());
		System.out.println(testSerial.GetNextSerial());
		System.out.println(testSerial.GetNextSerial());
		System.out.println(testSerial.GetNextSerial());
		System.out.println(testSerial.GetNextSerial());
		System.out.println(testSerial.GetNextSerial());
		System.out.println(testSerial.GetNextSerial());
	}

}
