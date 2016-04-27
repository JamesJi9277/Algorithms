public class Solution {. From 1point 3acres bbs
        int shallowest = 0;   // the shallowest level that I visited in backtracking after I got the first target node. Waral 鍗氬鏈夋洿澶氭枃绔�,
        boolean getFirstTarget = false;    // whether I got the first target node
        TreeNode tempLCA;   // the node corresponding the shallowest level, which is a LCA candidate. from: 1point3acres.com/bbs 
        TreeNode LCA;    // the result, LCA. more info on 1point3acres.com
        
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return root;. 鐣欏鐢宠璁哄潧-涓€浜╀笁鍒嗗湴
                dfsFind(root, p, q, 0);
                return LCA;
    }

    public void dfsFind(TreeNode root, TreeNode p, TreeNode q, int curLev){
                if (root == p || root == q) {
                        if (!getFirstTarget){
                                getFirstTarget = true;
                                shallowest = curLev;. from: 1point3acres.com/bbs 
                                tempLCA = root;
                        }
                        LCA = tempLCA;
                }
                
            if (getFirstTarget && curLev <= shallowest) {  //after get the first deepest leaf node candidate, mark the shallowest level when backtracking
                        shallowest = curLev;
                        tempLCA = root;
                }
                
                if (root.left != null){   // dfs for left node 
                    dfsFind(root.left, p, q, curLev + 1);
                    if (getFirstTarget && curLev <= shallowest) {   //mark the shallowest level when backtracking
                            shallowest = curLev;
                            tempLCA = root;
                    }
                }. 1point 3acres 璁哄潧
                
                if (root.right != null){   //dfs for right node. more info on 1point3acres.com
                    dfsFind(root.right, p, q, curLev + 1);
                    if (getFirstTarget && curLev <= shallowest) {    //mark the shallowest level when backtracking
                            shallowest = curLev;
                            tempLCA = root;
                    }
                }
        }
}
