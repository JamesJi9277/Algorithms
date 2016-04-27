// Given an array of integers, find out whether there are two distinct indices i and j in the array 
// such that the difference between nums[i] and nums[j] is at most t and the difference between i and j is at most k.
//brute force, On2 and TLE
public class Solution {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if(nums == null || nums.length == 0 || k < 0) {
			return false;
		}
		for(int i = 0; i < nums.length; i++) {
			for(int j = i + 1; j <= i + k && j < nums.length; j++) {
				if(Math.abs(nums[i] - nums[j]) <= t) {
					return true;
				}
			}
		}
		return false;
	}
}


//ac, using TreeSet, time O(nlogk)
public class Solution{
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if(nums == null || k < 0 || t < 0) {
			return false;
		}
		TreeSet<Integer> set = new TreeSet<Integer>();
		for(int i = 0; i < nums.length; i++) {
			if(i - k - 1 >= 0) {
				set.remove(nums[i - k - 1]);
			}
			int n = nums[i];
			if(set.floor(n) != null && n <= t + set.floor(n) || set.ceiling(n) != null 
				&& set.ceiling(n) <= t + n) {
				return true;
			}
			set.add(n);
		}
		return false;
	}
}


//sorted set
public class Solution {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (k < 1 || t < 0)
			return false;
		SortedSet<Long> set = new TreeSet<Long>();
		for (int j = 0; j < nums.length; j++) {
			long leftBoundary = (long) nums[j] - t;
			long rightBoundary = (long) nums[j] + t + 1;
			SortedSet<Long> subSet = set.subSet(leftBoundary, rightBoundary);
			if (!subSet.isEmpty())
				return true;
			set.add((long) nums[j]);
			if (j >= k) {
				set.remove((long) nums[j - k]);
			}
		}
		return false;
	}
}

//answer from Web, using binary search tree
public class Solution{
class TreeNode
{
    int value;
    TreeNode left;
    TreeNode right;
    TreeNode parent;

    public TreeNode(TreeNode parent,int value)
    {
        this.value=value;
        this.parent=parent;
    }
}

class BST
{
    TreeNode root=null;
    public BST()
    {

    }

    public boolean insert(int x)
    {
        if(root==null)
        {
            root=new TreeNode(null,x);
        }
        else
        {
            TreeNode parent=root,cur=root;
            while(cur!=null)
            {
                if(x==cur.value)
                {
                    break;
                }
                else if(x<cur.value)
                {
                    parent=cur;
                    cur=cur.left;
                    if(cur==null)
                        parent.left=new TreeNode(parent,x);
                }
                else
                {
                    parent=cur;
                    cur=cur.right;
                    if(cur==null)
                        parent.right=new TreeNode(parent,x);
                }
            }

        }
        return true;
    }

    public TreeNode find(int x)
    {
            TreeNode cur=root;
            while(cur!=null)
            {
                if(x==cur.value)
                {
                    return cur;
                }
                else if(x<cur.value)
                {
                    cur=cur.left;
                }
                else
                {
                    cur=cur.right;
                }
            }
            return cur;
    }

    public void remove(int x)
    {
        TreeNode node=find(x);
        TreeNode y=null;
        if(node.left==null||node.right==null)
            y=node;
        else
            y=successor(node);
        TreeNode child=null;
        if(y.left!=null)
        {
            child=y.left;
        }
        else
        {
            child=y.right;
        }
        if(child!=null)
        {
            child.parent=y.parent;
        }

        if(y==root)
        {
            root=child;
        }
        else
        {
            if(y==y.parent.left)
            {
                y.parent.left=child;
            }
            else
            {
                y.parent.right=child;
            }
        }

        if(y!=node)
        {
            node.value=y.value;
        }

        return ;

    }

    private TreeNode successor(TreeNode node) {

        if(node.right!=null)
        {
            TreeNode cur=node.right;
            while(cur.left!=null)
                cur=cur.left;
            return cur;
        }
        else
        {
            TreeNode p=node.parent;
            while(p!=null&&node==p.right)
            {
                node=p;
                p=p.parent;
            }
            return p;
        }
    }

    public boolean containsInRange(int s,int e)
    {
        TreeNode cur=root;
        while(cur!=null)
        {

            if(cur.value>=s&&cur.value<=e)
            {
                return true;
            }
            else if(cur.value>e)
            {
                cur=cur.left;
            }
            else
            {
                cur=cur.right;
            }
        }
        return false;
    }


}

public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    if(nums==null||nums.length==0)
        return false;
    if(t<0)
        return false;
    BST bst=new BST();

    for(int i=0;i<nums.length;i++)
    {
        if(i>k)
        {
            bst.remove(nums[i-k-1]);
        }
        int low=nums[i]>Integer.MIN_VALUE+t?nums[i]-t:Integer.MIN_VALUE;
        int high=nums[i]<Integer.MAX_VALUE-t? nums[i]+t:Integer.MAX_VALUE;
        if(bst.containsInRange(low,high))
        {
            return true;
        }
        else
        {
            bst.insert(nums[i]);
        }
    }

    return false;
}
}