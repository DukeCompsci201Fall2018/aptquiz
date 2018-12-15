import java.util.*;

public class ContainerShip {
	public String[] contains(String[] list, String str) {
		ArrayList<String> a = new ArrayList<>();
		for(String s : list) {
			if (s.contains(str) && ! a.contains(s)) {
				a.add(s);
			}
		}
		return a.toArray(new String[0]);
	}
}
