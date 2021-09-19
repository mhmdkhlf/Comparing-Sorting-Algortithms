
public class SortingAlgorithms {
	

	public static void bubbleSort(int[] array) { //bubble sort
		for (int i=0; i<array.length-1;i++) 
			for (int j=1; j<array.length - i; j++) 
				if (array[j-1] > array[j]) {
					array[j] = array[j] + array[j-1];
					array[j-1] = array[j] - array[j-1];
					array[j] -= array[j-1];
				}
	}
	
	
	public static void selectionSort(int[] array) { //selection sort
		for (int i=0; i<array.length-1; i++) {
			int minIndex = i;
			for (int j = i+1; j<array.length; j++) 
				if (array[minIndex] > array[j]) 
					minIndex = j;			
			if (minIndex!=i) {
				array[i] = array[i] + array[minIndex];
				array[minIndex] = array[i] - array[minIndex];
				array[i] -= array[minIndex];
			}
		}
	}
	
	
	public static void insertionSort(int[] array) { //insertion
		for (int i=1; i<array.length; i++) {
			int j = i;
			while (j>0 && array[j] < array[j-1]) {
				array[j] += array[j-1];
				array[j-1] = array[j] - array[j-1];
				array[j] -= array[j-1];
				j--;
			}
		}
	}	
	
	
	
	private static void merge(int[] arr, int left, int mid, int right) {
		int[] array1 = new int[mid - left + 1];
		int[] array2 = new int[right - mid];
		
		for (int i=0; i<mid-left+1; i++) 
			array1[i] = arr[left+i];
		for (int j=0; j<right-mid; j++) 
			array2[j] = arr[mid+1+j];
		
		int m = 0;
		int n = 0;
		int curr = left;
		while (m<array1.length && n<array2.length) {
			if (array1[m] < array2[n]) {
				arr[curr] = array1[m];
				m++;
			} else {
				arr[curr] = array2[n];
				n++;
			}
			curr++;
		}
		
		while(m<array1.length) 
			arr[curr++] = array1[m++];
		while(n<array2.length) 
			arr[curr++] = array2[n++]; 
	}
	public static void mergeSort(int[] array, int left, int right) { //merge sort
		if (left < right) {
			int mid = (left+right) / 2;
			mergeSort(array, left, mid);
			mergeSort(array, mid+1, right);
			merge(array, left, mid, right);
		}
	}
	
	
	
	private static void insertionSort(int[] array, int left, int right) {
		for (int i=left + 1; i<right+1; i++) {
			int j = i;
			while (j>left && array[j] < array[j-1]) {
				array[j] += array[j-1];
				array[j-1] = array[j] - array[j-1];
				array[j] -= array[j-1];
				j--;
			}
		}
	}
	private static void merge2(int[] arr, int left, int mid, int right) {
		int[] array1 = new int[mid - left + 1];
		int[] array2 = new int[right - mid];
		
		for (int i=0; i<mid-left+1; i++) 
			array1[i] = arr[left+i];
		for (int j=0; j<right-mid; j++) 
			array2[j] = arr[mid+1+j];
		
		int m = 0;
		int n = 0;
		int curr = left;
		while (m<array1.length && n<array2.length) {
			if (array1[m] < array2[n]) {
				arr[curr] = array1[m];
				m++;
			} else {
				arr[curr] = array2[n];
				n++;
			}
			curr++;
		}
		
		while(m<array1.length) 
			arr[curr++] = array1[m++];
		while(n<array2.length) 
			arr[curr++] = array2[n++]; 
	}
	static int threshHold = 43;
	public static void cleverSort(int[] array, int left, int right) {
		if (left < right) {
			if (right - left < threshHold) {
				insertionSort(array, left, right);
			}else {
				int mid = (left+right) / 2;
				cleverSort(array, left, mid);
				cleverSort(array, mid+1, right);
				merge2(array, left, mid, right);
			}
		}
	}
	
}