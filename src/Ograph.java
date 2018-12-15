import java.util.*;

public class Ograph {
	Map<String,Set<String>> myGraph;
	Set<String> myVisited;
	public int[] components(String[] data) {
		makeGraph(data);
		myVisited = new TreeSet<>();
		ArrayList<Integer> list = new ArrayList<>();
		for(String v : myGraph.keySet()) {
			if (! myVisited.contains(v)) {
				list.add(compSize(v));
			}
		}
		int[] ret = new int[list.size()];
		for(int k=0; k < list.size(); k++) {
			ret[k] = list.get(k);
		}
		Arrays.sort(ret);
		return ret;
	}
	
	private int compSize(String v) {
		Set<String> visited = new TreeSet<>();
		Stack<String> s = new Stack<>();
		visited.add(v);
		s.add(v);
		while (s.size() > 0) {
			v = s.pop();
			for(String adj : myGraph.get(v)) {
				if (! visited.contains(adj)) {
					s.push(adj);
					visited.add(adj);
				}
			}
		}
		myVisited.addAll(visited);
		return visited.size();
	}

	private void makeGraph(String[] data) {
		myGraph = new TreeMap<>();
		for(int k=0; k < data.length; k++) {
			String s = data[k];
			String v = ""+k;
			String[] adj = s.split(" ");
			//System.out.print(v+" : ");print(adj);
			for(String a : adj) {
				myGraph.putIfAbsent(v, new TreeSet<>());
				myGraph.putIfAbsent(a, new TreeSet<>());
				myGraph.get(v).add(a);
				myGraph.get(a).add(v);
			}
		}
		//System.out.println(myGraph);
	}
	
	public static void main(String[] args) {
		Ograph og = new Ograph();
		String[] a1 = {
				"1 2", "0 2", "1 3", "2 4", "3 5", "4 6", "5 4",
				"8 9", "7 9", "7 8"
		};
		
		String[] a2 = {
			"1 3", "0 2", "1 3", "0 2", "5", "4 6", "5 7", "6 8", "7",
			"10 11 12", "9 11 12", "9 10 12", "9 10 11"
		};
		String[] a3 = {
		   "1", "0 2", "1 3", "2 4", "3 5", "4 6", "5",
		   "8", "7 9", "8"
		};
		String[] a4 = {"0", "1", "2", "3", "4"};
		String[] a5 = {"1", "0 2", "1 3", "3"};
		String[][] all = {a1,a2,a3,a4,a5};
		for(String[] a : all) {
			print(a);
			int[] ret = og.components(a);
			System.out.println(Arrays.toString(ret));
		}
	}

	private static void print(String[] a) {
		if (a.length == 0) {
			System.out.println("[]");
			return;
		}
		System.out.print("[\"");
		System.out.print(String.join("\",\"", a));
		System.out.println("\"]");
	}
	
}
