// 题目定义了一个CNode，其实跟ListNode一样，有val，有指针，
// list首尾相连而已，list里的node升序排列，题目也不难，
//首先这个题给你的start仅仅是一个循环list的开始，但并不是最小值，其次就是里面可能存在重复，所以说我要进行去重处理
//有两个方法，一个是先找到最小值然后开始判断，第二个方法是直接从start开始，比较直接明了
public class Solution {
	public static void insertValue(CNode start, int val) {
		if(start = null) {
			start.val = val;
			return;
		}
		//在这种cycle的题目里面，可以考虑使用while(true)来启动循环遍历完整个cycle
		while(true) {
			if(start.val == val) {
				break;
			}
			else if (start.val == start.next.val) {
				start = start.next;
			}
			else if (start.val < start.next.val) {
				if((start.val < val) && (val <= start.next.val)) {
					break;
				}
				else {
					start = start.next;
				}
			}
			else if (start.val > start.next.val) {
				if(val >= start.val || val <= start.next.val) {
					break;
				}
				else {
					start = start.next;
				}
			}
		}
		CNode tmp = new CNode(val);
		tmp.next = start.next;
		start.next = tmp;
	}
}