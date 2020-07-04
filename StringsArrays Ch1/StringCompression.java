/*
	Q: 



*/ 

public class StringCompression {


	/* seemingly duplicate code of the 
	   one beneath but will not necessarily affect runtime */ 

	private static int helperCountCompression(String str) {
		int compressedLen = 0;
		int countConsecutive = 0; 

		int strlen = str.length();
		for (int i = 0; i < strlen; i++) {
			countConsecutive++; 
			// checks whether or not we should append this.. 
			if (i + 1 >= strlen || str.charAt(i) != str.charAt(i+1)) {
				// letter plus the number of them 
			compressedLen += 1 + String.valueOf(countConsecutive).length();
			countConsecutive =0; 
			}
		}
		return compressedLen;

	}

	public static String preCheckCompress(String str) {
		// check in advance the final length of the string first
		/* if final of compressed if lonnger than original, 
		   simply return original, also by doing this we can know the
		   final size of our StringBuilderwhich is good since it
		   wouldn't have to double its size beneath the scenes */ 

		int finalLength = helperCountCompression(str);
		if (finalLength >= str.length()) return str;

		StringBuilder compressedStr = new StringBuilder(finalLength);
		int countConsecutive = 0;
		int strlen = str.length();
		for (int i = 0; i < strlen; i++) {
			countConsecutive++; 
			// checks whether or not we should append this.. 
			if (i + 1 >= strlen || str.charAt(i) != str.charAt(i+1)) {
				// letter plus the number of them 
				compressedStr.append(str.charAt(i));
				compressedStr.append(Integer.toString(countConsecutive));
				// reset to 0
				countConsecutive = 0; 
			}
		}		
		return compressedStr.toString(); 
	}


	// STRINGBUILDER = faster when we want to concat stuff 
	public static String StringBuilderCompress(String str) {
		// initialize a StringBuilder
		StringBuilder compressedStr = new StringBuilder();
		int countConsecutive = 0;
		int strlen = str.length();
		for (int i = 0; i < strlen; i++) {
			countConsecutive++; 
			// checks whether or not we should append this.. 
			if (i + 1 >= strlen || str.charAt(i) != str.charAt(i+1)) {
				// letter plus the number of them 
				compressedStr.append(str.charAt(i));
				compressedStr.append(Integer.toString(countConsecutive));
				// reset to 0
				countConsecutive = 0; 
			}
		}
		// return shorter of the two
		// toString method for a StringBuilder obj
		return compressedStr.length() < strlen ? compressedStr.toString() : str;
	}



	// RUNTIME = O(p + k^2) - p = size of original string
	// k = num of character sequences (diff  char sequences)
	// string concat = O(n^2) = slow... therefore use StringBuilder
	public static String bruteCompress(String str) {
		// building onto an empty string
		System.out.println("in brute");
		String compressedStr = ""; 
		int countConsecutive = 0;
		int strlen = str.length();
		for (int i = 0; i < strlen; i++) {
			countConsecutive++; 
			// checks whether or not we should append this.. 
			if (i + 1 >= strlen || str.charAt(i) != str.charAt(i+1)) {
				// letter plus the number of them 
				compressedStr += str.charAt(i) + Integer.toString(countConsecutive);
				// reset to 0
				countConsecutive = 0; 
			}
		}
		// if len is greater than the current length, then we want to return the original str
		// otherwise we can return compressed version 
		System.out.printf("resulting is %s\n", compressedStr);
		// depending on which one is shorter, return that one
		return compressedStr.length() < strlen ? compressedStr : str;
	}

	// main does not return anything 
	public static void main(String[] argv) {
		// does not take the file name as an arg
		System.out.println(argv[0]);
		String bruteStr = bruteCompress(argv[0]);
		// for ones with string formats need to do printf
		System.out.printf("Printing compressed string %s\n", bruteStr);

		String sbstr = StringBuilderCompress(argv[0]);
		System.out.printf("Printing string builder compressed string %s\n", sbstr);

		String pre = preCheckCompress(argv[0]);
		System.out.printf("Printing precheck compressed string %s\n", pre);
	}

}

