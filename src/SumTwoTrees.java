
public class SumTwoTrees {
	public TreeNode add(TreeNode a, TreeNode b) {
		if (a == null && b == null) return null;
		if (a == null) {
			return new TreeNode(b.info,add(null,b.left),add(null,b.right));
		}
		if (b == null) {
			return new TreeNode(a.info,add(a.left,null),add(a.right,null));
		}
		TreeNode tree = new TreeNode(a.info + b.info,
				            add(a.left,b.left),
				            add(a.right,b.right));
		return tree;
	}
}
