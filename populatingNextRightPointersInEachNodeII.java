// Follow up for problem "Populating Next Right Pointers in Each Node".

// What if the given tree could be any binary tree? Would your previous solution still work?

// Note:

// You may only use constant extra space.
// For example,
// Given the following binary tree,
//          1
//        /  \
//       2    3
//      / \    \
//     4   5    7
// After calling your function, the tree should look like:
//          1 -> NULL
//        /  \
//       2 -> 3 -> NULL
//      / \    \
//     4-> 5 -> 7 -> NULL

public class Solution {
  public void connect(TreeLinkNode root) {
    TreeLinkNode previous = null;
    TreeLinkNode levelLeftMost = root;
    while(levelLeftMost != null) {
      TreeLinkNode parent = levelLeftMost;
      levelLeftMost = null;
      previous = null;
      while(parent != null) {
        if(levelLeftMost == null) {
          levelLeftMost = parent.left;
        }
        if(levelLeftMost == null) {
          levelLeftMost = parent.right;
        }
        previous = connectNodes(previous, parent.left);
        previous = connectNodes(previous, parent.right);
        parent = parent.next;
      }
    }
  }
  private TreeLinkNode connectNodes(TreeLinkNode previous, TreeLinkNode next) {
    if(previous != null) {
      previous.next = next;
    }
    return (next == null) ? previous : next;
  }
}