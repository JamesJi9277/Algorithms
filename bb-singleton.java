eager模式
class Solution {
    /**
     * @return: The same instance of this class every time
     */
    private static final Solution solution = new Solution();
    public static Solution getInstance() {
        // write your code here
        
        return solution;
    }
};

lazy模式
class Solution {
	private static Solution solution;
	public static Solution getInstance() {
		if(solution == null) {
			solution = new Solution();
		}
		return solution;
	}
}