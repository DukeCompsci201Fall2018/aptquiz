import java.util.*;

public class SetAside {
	public String common(String[] list) {
		Set<String> set = new HashSet<>();
		if (list.length == 0) return "";
		set.addAll(Arrays.asList(list[0].split(" ")));
		for(int k=1; k < list.length; k++){
			Set<String> s2 = new HashSet<>(Arrays.asList(list[k].split(" ")));
			set.retainAll(s2);
		}
		String[] ret = set.toArray(new String[0]);
		Arrays.sort(ret);
		return String.join(" ",ret);
	}

}
