// Given two binary trees, write a function to check if they are equal or not.

// Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
//recursive solution
public class Solution1{
	public boolean isSameTree(TreeNode p, TreeNode q){
		if(p == null && q == null)
			return true;
		if((p == null && q != null) || (p != null && q == null))
			return false;
		//这一步判断很重要， 通过反面来判断而不是通过p.val ==q.val
		if(p.val!=q.val)
			return false;
		if(isSameTree(p.left, q.left) && isSameTree(p.right, q.right))
			return true;
		else
			return false;
	}
}

//iterative
//可以考虑将两棵树分别进行先序遍历，看得到的结果是不是一样的，结果一样的话说明是same tree，不一样的话就不是，在叶子结点空白的地方加上#，这样就不会出现异构的情况
public class Solution2{
	public boolean isSameTree(TreeNode p, TreeNode q){
		if(p == null && q == null)
			return true;
		if(p == null && q != null)
			return false;
		if(p != null && q == null)
			return false;
		Stack<TreeNode> stackP = new Stack<TreeNode>();
		Stack<TreeNode> stackQ = new Stack<TreeNode>();
		stackP.push(p);
		stackQ.push(q);
		while(!stackP.isEmpty() && !stackQ.isEmpty())
		{
			TreeNode temp1 = stackP.pop();
			TreeNode temp2 = stackQ.pop();
			if(temp1.val != temp2.val)
				return false;
			if((temp1.left!= null && temp2.left == null) || (temp1.right!= null && temp2.right == null)
				||(temp1.left == null && temp2.left!= null) ||(temp1.right == null && temp1.right !=null))
				return false;
			if(temp1.right!= null)
				stackP.push(temp1.right);
			if(temp2.right != null)
				stackQ.push(temp2.right);
			if(temp1.left!= null)
				stackP.push(temp1.left);
			if(temp2.left!=null)
				stackQ.push(temp2.left);
		}
		return true;
	}
}



//iterative,在前序遍历的基础上对每一个叶子结点终结的地方加上了符号，以确保pre order的唯一性
public class Solution3{
	public boolean isSameTree(TreeNode p, TreeNode q){
		List<String> preOrderP = new ArrayList<String>();
		List<String> preOrderQ = new ArrayList<String>();
		preTraverse(p, preOrderP);
		preTraverse(q, preOrderQ);
		if(preOrderP.size()!= preOrderQ.size())
			return false;
		if(preOrderP.size() == preOrderQ.size())
		{
			for(int i =0; i<preOrderP.size();i++)
			{
				//String一定是不能写==，要写equals
				if(!preOrderP.get(i).equals(preOrderQ.get(i)))
					return false;
			}
		}
		return true;
	}
	private void preTraverse(TreeNode root, List<String> res){
		if(root == null)
		{
			res.add("*");
			return;
		}
		res.add(root.val+"");
		preTraverse(root.left, res);
		preTraverse(root.right, res);
	}
}



