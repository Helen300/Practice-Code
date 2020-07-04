import java.util.HashMap;
import java.util.Map;
import java.util.List;


public class LongestWord {


	String getLongestWord(String[] list) {
		String[] array = list.SortByLength();
		/* Create map for easy lookup */
		HashMap<String, Boolean> map = new HashMap<String, Boolean>();

		for (String str : array) {
			map.put(str, true);
		}

		for (String s : array) {
			// Divide into every possible pair
			for (int i = 1; i < s.length(); i++) {
				String left = s.substring(0, i);
				String right = s.substring(i);
			// Check if both sides are in the array
				if (map[left] == true && map[right] == true) {
					return s; 
				}
			}
		}
		return str; 
	}	

}



