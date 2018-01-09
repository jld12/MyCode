/**
 * Programmer: 				D. Yoas
 * Program Error Checker: 	Jennifer Daniel
 * Course:					Secure Software Development
 * Program:					Error Checking - Serial
 */

public class Serial {
	boolean Carry;
	char SerialNumber[];
	char KeySet[];
	int SerialMax, SerialPos, KeyPos, KeySetMax, SerialChar;

	
	Serial(String Key) {
		// Key must have only unique characters if increment method is to work properly.
		// If the key is unique, it continues as normal. If the key is not unique, it alerts
		// the user, trims the duplicates out of the key, and proceeds.
		
		if (isUnique(Key) == true){
			KeySetMax = Key.length();
			KeySet = new char[KeySetMax];
			KeySet = Key.toCharArray();
		}
		
		else {
			
			Key = remDupes(Key);			
			System.out.println("Repeated characters trimmed.");
			
			KeySetMax = Key.length();
			KeySet = new char[KeySetMax];
			KeySet = Key.toCharArray();
		}
		
		// I initialized the variable values to 0.
		SerialMax = 0; SerialPos = 0; KeyPos = 0; SerialChar = 0;
		
	}
	
	void SetSerial(String Serial) {
		// The SetSerial method would allow for a serial of size zero. If the serial is size zero,
		// trying to run the IncSerial method would result in an error. Therefore, I've decided to make
		// it so that if someone tries to set a serial of size zero, the system will notify them and set
		// it to a default value. If the serial is 1 or greater, it will proceed as before.
		
		if (Serial.length() < 1){
			Serial = "defaultValue";
			SerialNumber = new char[Serial.length()];
			SerialNumber = Serial.toCharArray();			
			System.out.println("Invalid serial size. Serial has been set to a default value.");
		}
		
		else{
			SerialNumber = new char[Serial.length()];
			SerialNumber = Serial.toCharArray();	
		}
		
	}
	
	String GetSerial() {
		return String.valueOf(SerialNumber);
	}
	
	String GetKey() {
		return String.valueOf(KeySet);
	}
	
	String GetNextSerial() {
		IncSerial();
		return this.GetSerial();
	}
	
	void IncSerial() {
		// This method seems to bug out if the key has any of the same letters in it.
		// In addition, it only ever modifies the last letter of the serial.
		
		// The else section of the while loop was missing its curly braces, so I added those.
		
		Carry = true;
		SerialPos = SerialNumber.length - 1;
		
		while (Carry && SerialPos >= 0) {
			KeyPos = FindMatch(SerialNumber[SerialPos]) + 1;
			if (KeyPos == KeySetMax) {
				SerialNumber[SerialPos] = KeySet[0];
				SerialPos--;
			} else {
				SerialNumber[SerialPos] = KeySet[KeyPos];
				Carry = false;
			}
		}
	}
	
	int FindMatch(char Seek) {
		for (int Position = 0; Position < KeySetMax; Position++) {
			if (KeySet[Position] == Seek) return Position;
		}
		
		return -1;
	}
	
	// The key only iterates the serial code correctly if it contains only unique letters.
	// So, I added a method to detect if the String has unique characters.
	
	boolean isUnique(String key) {
	    if (key.length() > 256) { // More than the number of possible characters.
	        return false; 
	    }
	    int checker = 0;
	    for (int i = 0; i < key.length(); i++) {
	        int val = key.charAt(i) - 'a';
	        if ((checker & (1 << val)) > 0) return false;
	        checker |= (1 << val);
	    }
	    return true;
	}
	
	
	// I added a method to remove the duplicate characters from the key if it is entered with duplicates.
	// This makes the increment serial method work properly.
	
	String remDupes(String key){
		 boolean seen[] = new boolean[256];
		    StringBuilder sb = new StringBuilder(seen.length);

		    for (int i = 0; i < key.length(); i++) {
		        char ch = key.charAt(i);
		        if (!seen[ch]) {
		            seen[ch] = true;
		            sb.append(ch);
		        }
		    }

		    return sb.toString();
    }
	
	
}