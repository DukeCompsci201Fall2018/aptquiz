import java.util.*;

public class ValidAddresses {
	ArrayList<String> myList = new ArrayList<>();
	
	public String[] valid(String possible) {
		String[] parts = new String[4];
		helper(possible,0,parts);
		Collections.sort(myList);
		return myList.toArray(new String[0]);
	}
	
	/**
	 * find all valid IP-addresses and add each complete
	 * one found to myList (instance variable)
	 * @param possible is string of digits to form addresses
	 * @param index the location/index of to-be-filled entry in parts
	 * @param parts is the array of dotted quad parts,
	 * filled in order parts[0], [1], [2], [3]
	 */
	private void helper(String possible, int index, String[] parts) {
		if (index == parts.length) {
			if (possible.length() == 0) {
				myList.add(String.join(".",parts));
			}
			return;
		}
		
		int end = Math.min(3, possible.length());
		for(int k=1; k <= end; k++) {
			String first = possible.substring(0, k);
			String rest = possible.substring(k);
			if (dottedQuadOk(first)) {
				parts[index] = first;
				helper(rest,index+1,parts);
			}
		}
	}
	private boolean dottedQuadOk(String s) {
		if (s.charAt(0) == '0') {
			return s.length() == 1;
		}
		int val = Integer.parseInt(s);
		return 0 <= val && val <= 255;
	}
	
	public static void main(String[] args) {
		ValidAddresses ip = new ValidAddresses();
		String s = "111111111";
		String[] res = ip.valid(s);
		System.out.println(String.join("\n", res));
	}
}
