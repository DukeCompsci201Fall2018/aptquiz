import java.util.*;

public class FindPath {
	ArrayList<String> paths = new ArrayList<>();
	public String path(TreeNode tree, int target) {
		doWork(tree,target,"");
		Collections.sort(paths);
		Collections.sort(paths, Comparator.comparing(String::length));
		if (paths.size() == 0) return "nopath";
		return paths.get(0);
	}
	public void doWork(TreeNode t, int target, String path) {
		if (t == null) return;
		if (t.info == target) {
			paths.add(path);
		}
		doWork(t.left,target,path+'0');
		doWork(t.right,target,path+'1');
	}
}
