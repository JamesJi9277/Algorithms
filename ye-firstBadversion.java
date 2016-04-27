考虑直接上二分法,找到最开始的bad version

时间Ologn，空间O1
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if(n < 1) {
        	return 0;
        }
        int start = 1;
        int end = n;
        while(start + 1 < end) {
        	int mid = start + (end - start) / 2;
        	if(isBadVersion(mid) == true) {
        		end = mid;
        	}
        	else {
        		start = mid;
        	}
        }
        if(isBadVersion(start) == true) {
        	return start;
        }
        else if(isBadVersion(end) == true) {
        	return end;
        }
        else {
        	return 0;
        }
    }
}

时间On，空间O1
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if(n < 1) {
            return 0;
        }
        int index = 1;
        while(index <= n) {
            if(isBadVersion(index)) {
                break;
            }
            else {
                index++;
            }
        }
        return index;
    }
}