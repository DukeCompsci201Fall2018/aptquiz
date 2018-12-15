import java.util.*;

public class Charity {
	public String[] generous(String[] donors) {
		TreeMap<String,Double> map = new TreeMap<>();
		for(String s : donors) {
			String[] d = s.split(":");
			String name = d[0];
			double a = Double.parseDouble(d[1]);
			if (! map.containsKey(name)) {
				map.put(name,0.0);
			}
			map.put(name, map.get(name) + a);
		}
		double max = Collections.max(map.values());
		ArrayList<String> list = new ArrayList<>();
		for(String s : map.keySet()) {
			if (map.get(s) == max) {
				list.add(s);
			}
		}
		return list.toArray(new String[0]);
	}
}
