import java.util.ArrayList;
import java.util.Random;

public class test_Qi_Ji {
	public void bubbleSort(int[] array) {
		if(array == null || array.length == 0) {
			return;
		}
		int length = array.length;
		for(int i = 0; i < length; i++) {
			for(int j = 1; j < length - i; j++) {
				if(array[j - 1] > array[j]) {
					int temp = array[j - 1];
					array[j - 1] = array[j];
					array[j] = temp;
				}
			}
		}
	}
	
	public void selectionSort(int[] array) {
		if(array == null || array.length == 0) {
			return;
		}
		int length = array.length;
		for(int i = 0; i < length; i++) {
			//这里一定要保存的是index信息，因为还要进行置换处理
			int minIndex = i;
			for(int j = i + 1; j < length; j++) {
				if(array[j] < array[minIndex]) {
					minIndex = j;
				}
			}
			int temp = array[minIndex];
			array[minIndex] = array[i];
			array[i] = temp;
		}
	}
	
	public void insertionSort(int[] array) {
		if(array == null || array.length == 0) {
			return;
		}
		int length = array.length;
		for(int i = 0; i < length; i++) {
			int index = i;
			int array_i = array[i];
			while(index > 0 && array[index - 1] > array_i) {
				//不断的往前换
				array[index] = array[index - 1];
				index--;
			}
			array[index] = array_i;
		}
	}

	public void mergeSort(int[] array) {
		if(array == null || array.length == 0) {
			return;
		}
		doSort(array, 0, array.length - 1);
	}
	private static void doSort(int[] array, int start, int end) {
		if(start >= end) {
			return;
		}
		int mid = start + (end - start) / 2;
		doSort(array, start, mid);
		doSort(array, mid + 1, end);
		doMerge(array, start, mid, end);
	}
	private static void doMerge(int[] array, int start, int mid, int end) {
		int[] copy = new int[array.length];
		for(int i = start; i <= end; i++) {
			copy[i] = array[i];
		}
		int i = start;
		int j = mid + 1;
		for(int k = start; k <= end; k++) {
			if(i > mid) {
				array[k] = copy[j];
				j++;
			}
			else if(j > end) {
				array[k] = copy[i];
				i++;
			}
			else if(copy[i] > copy[j]) {
				array[k] = copy[j];
				j++;
			}
			else {
				array[k] = copy[i];
				i++;
			}
		}
	}
	
	public void quickSort(int[] array) {
		if(array == null || array.length == 0) {
			return;
		}
		doQuickSort(array, 0, array.length - 1);
	}
	private static void doQuickSort(int[] array, int low, int high) {
		if(low < high) {  
			int pivotLoc = partition(array, low, high); //将array一分为二，pivotLoc是枢轴位置  
            doQuickSort(array, low, pivotLoc - 1); //对低子表递归排序  
            doQuickSort(array, pivotLoc + 1, high); //对高子表递归排序  
        }
	}
	 //交换数组array[]中子组中的记录位置 
	private static int partition(int[] array, int low, int high) {
		int pivotKey = array[low];//用子表的低位做枢轴
		while(low < high) {
			while(low < high && array[high] >= pivotKey) {
				high--;
			}
			array[low] = array[high];//将比枢轴小的记录移到低端
			while(low < high && array[low] <= pivotKey) {
				low++;
			}
			array[high] = array[low]; //将比枢轴大的记录移到高端
		}
		array[low] = pivotKey;//枢轴值放在中间
		return low;//返回枢轴位置 
	}
	
	public static void main(String args[]) {
		Random rand = new Random();
		test_Qi_Ji sort = new test_Qi_Ji();
		int[] input = new int[10];
		System.out.println("The original array is: ");
		for(int i = 0; i < input.length; i++) {
			input[i] = rand.nextInt(200);
			System.out.print(input[i] + " ");
		}
		
		//bubble sort
		sort.bubbleSort(input);
		System.out.println(" ");
		System.out.println("Bubble sort");
		for(int item : input) {
			System.out.print(item + " ");
		}
		//selection sort
		sort.selectionSort(input);
		System.out.println(" ");
		System.out.println("Selection sort");
		for(int item : input) {
			System.out.print(item + " ");
		}
		//insertion sort
		sort.insertionSort(input);
		System.out.println(" ");
		System.out.println("Insertion sort");
		for(int item : input) {
			System.out.print(item + " ");
		}
		//merge sort
		sort.mergeSort(input);
		System.out.println(" ");
		System.out.println("Merge sort");
		for(int item : input) {
			System.out.print(item + " ");
		}
		//quicksort
		sort.quickSort(input);
		System.out.println(" ");
		System.out.println("Quick sort");
		for(int item : input) {
			System.out.print(item + " ");
		}
	}
}
