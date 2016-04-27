The API: int read4(char *buf) reads 4 characters at a time from a file.

The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.

By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

Note:
The read function will only be called once for each test case.

/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int bufEnd = 0;
        char[] temp = new char[4];
        while(n > bufEnd) {
        	int read = read4(temp);
        	for(int i = 0; i < read && bufEnd < n; i++) {
        		buf[bufEnd++] = temp[i];
        	}
        	if(read < 4) {
        		break;
        	}
        }
        return bufEnd;
    }
}