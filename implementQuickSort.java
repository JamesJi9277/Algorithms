import java.util.Random;
import java.util.Stack;

//create  class 
public class implementQuickSort {
	//implement recursive function
    public void doRecursive(int[] arr, int start, int end) {
    	//check for 3 corner cases
        if(arr == null || arr.length == 0) {
            return;
        }
        if(start > end) {
        	return;
        }
        if(end - start < 2) {
            return;
        }
        //initially set middle as pivot
        int pivot = start + (end - start) / 2;
        pivot = findPartition(arr, pivot, start, end);
        //call doRecursive function for the recursive steps, use pivot to separate priginal array into two parts
        doRecursive(arr, start, pivot);
        doRecursive(arr, pivot + 1, end);
    }

    //implement iterative function
    public void doIterative(int[] arr) {
    	//check for corner case
        if(arr == null || arr.length == 0) {
            return;
        }
        //using Stack to simulate recursive steps
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        stack.push(arr.length);
        while(!stack.isEmpty()) {
        	//the same as recursive step, find start and end
        	//be cautious stack is FILO, end = first pop()
            int end = stack.pop();
            int start = stack.pop();
            
            //check for corner case
            if(end - start < 2) {
                continue;
            }
            if(end < start) {
            	continue;
            }
            //set pivot, same step in doRecursive()
            int pivot = start + (end - start) / 2;
            pivot = findPartition(arr, pivot, start, end);

            stack.push(pivot + 1);
            stack.push(end);
            stack.push(start);
            stack.push(pivot);
        }
    }

    private static int findPartition(int[] arr, int p, int start, int end){
        int l = start;
        int h = end - 2;
        int pivot = arr[p];
        doSwap(arr, p, end - 1);
        //find partition index
        while(l < h) {
            if(arr[l] < pivot) {
                l++;
            }
            else if(arr[h] >= pivot) {
                h--;
            }
            else {
                doSwap(arr, l, h);
            }
        }
        int index = h;
        if(arr[h] < pivot) {
            index++;
        }
        
        doSwap(arr, end - 1, index);
        return index;
    }

    private static void doSwap(int[] arr, int temp1, int temp2) {
        int temp = arr[temp1];
        arr[temp1] = arr[temp2];
        arr[temp2] = temp;
    }

    public static void main(String args[]) {
    	//generate random number
    	Random rand = new Random(1000);
        implementQuickSort sorter = new implementQuickSort();

        //two array, one do recursively, one do iteratively
        int[] copy = new int[1000];
        for(int i = 0; i < 1000; i++) {
        	//generate random number in Integer range
        	copy[i] = rand.nextInt(Integer.MAX_VALUE);
        }

        int[] input = new int[1000];
        for(int m = 0; m < 1000; m++) {
            input[m] = copy[m];
        }

        int count = 0;

        System.out.println("The original random input array is:");
        System.out.println(" ");
        for(int i = 0; i < 1000; i++) {
            count++;
            //design output format
            System.out.print(input[i]);
            System.out.print(" ");
            System.out.print("->");
            System.out.print(" ");

            if(i == 999) {
                System.out.println(" ");
            }

            if(count == 20) {
                System.out.println(" ");
                count = 0;
            }
        }
        //do two kinds of sort
        sorter.doRecursive(input, 0, 1000);
        sorter.doIterative(copy);

        int count1 = 0;
        System.out.println(" ");
        System.out.println("After the quick sort(resursive), result is as follows:");
        System.out.println(" ");
        for(int j = 0; j < 1000; j++){
            count1++;
            System.out.print(input[j]);
            System.out.print(" ");
            System.out.print("->");
            System.out.print(" ");
            if(j == 999) {
                System.out.println(" ");
            }
            if(count1 == 20) {
                System.out.println(" ");
                count1 = 0;
            }
        }

        int count2 = 0;
        System.out.println(" ");
        System.out.println("After the quick sort(iterative), result is as follows:");
        System.out.println(" ");
        
        for(int k = 0; k < 1000; k++) {
            count2++;
            System.out.print(input[k]);
            System.out.print(" ");
            System.out.print("->");
            System.out.print(" ");
            if(k == 999) {
                System.out.println(" ");
            }
            if(count2 == 20) {
                System.out.println(" ");
                count2 = 0;
            }
        }
    }
}