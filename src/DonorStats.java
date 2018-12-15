import java.util.*;

public class DonorStats {
	public String[] calculate(String[] donations) {
		Map<String,ArrayList<Integer>> map =
				new HashMap<>();
		for(String s : donations) {
			String[] d = s.split(":");
			String name = d[0];
			String[] dd = d[1].split(",");
			map.putIfAbsent(name, new ArrayList<>());
			for(String ss : dd) {
				map.get(name).add(Integer.parseInt(ss));
			}
		}
		String[] ret = new String[map.keySet().size()];
		ArrayList<String> sorted = new ArrayList<>(map.keySet());
		Collections.sort(sorted);
		int index = 0;
		for(String s : sorted) {
			ArrayList<Integer> a = map.get(s);
			int t = 0;
			for(int xx : a) {
				t += xx;
			}
			String f = String.format("%s:%d:%d", s,a.size(),t);
			ret[index] = f;
			index += 1;
		}
		return ret;
	}
}
