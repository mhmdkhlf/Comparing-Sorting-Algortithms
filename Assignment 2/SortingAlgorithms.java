/*
Sorting algorithms implemented:
-Merge 
-Merge-Insertion
-Quick
-Quick-Insertion
-Heap
-Radix	
*/

public class SortingAlgorithms {
	
	// Quick Sort
	private static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	private static int partition(int[] A, int left, int right) {
		int piv = A[right];
		int i = left-1;
		for (int j=left; j<right; j++) { 
			if (A[j] < piv) {
				i++;
				swap(A, i, j);
			}
		}
		swap(A, right, i+1);
		return i+1;
	}
	private static void quickSort(int[] A, int left, int right) {
		if (left < right) {
			int p = partition(A, left, right);
			quickSort(A, left, p-1);
			quickSort(A, p+1, right);
		}
	}
	static void quickSort(int[] array){
		quickSort(array, 0, array.length-1);
	}	
	
	
	//hybrid sort: Quick-Insertion Sort
	private static void insertionSort(int array[], int left, int right) { 
	    for (int j = 1+left; j < right+1; j++) {
	        int current = array[j];
	        int i = j-1;
	        while ((i > -1) && (array[i] > current)) {
	            array[i+1] = array[i];
	            i--;
	        }
	        array[i+1] = current;
	    }
	}
	final static int THRESHHOLD = 5;
	private static void quickInsertionSort(int[] A, int left, int right) {
		if (left < right) {
			if (right -left < THRESHHOLD) {
				insertionSort(A, left, right);
			}
			else {
				int p = partition(A, left, right);
				quickInsertionSort(A, left, p-1);
				quickInsertionSort(A, p+1, right);
			}
		}
	}
	static void quickInsertionSort(int[] array) {
		quickInsertionSort(array, 0, array.length-1);
	}


	//merge sort
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
	private static void mergeSort(int[] array, int left, int right) { //merge sort
		if (left < right) {
			int mid = (left+right) / 2;
			mergeSort(array, left, mid);
			mergeSort(array, mid+1, right);
			merge(array, left, mid, right);
		}
	}	
	static void mergeSort(int[] array) {
		mergeSort(array, 0, array.length-1);
	}
	
	
	//hybrid sort: Merge-Insertion Sort
	final static int threshHold = 7;
	private static void mergeInsertionSort(int[] array, int left, int right) { 
		if (left < right) {
			if ((right - left) < threshHold) {
				insertionSort(array, left, right);
			}else {
				int mid = (left+right) / 2;
				mergeInsertionSort(array, left, mid);
				mergeInsertionSort(array, mid+1, right);
				merge(array, left, mid, right);
			}
		}
	}
	static void mergeInsertionSort(int[] array) {
		mergeInsertionSort(array, 0, array.length-1);
	}
	
	
	//Heap class that includes insert and sorting algorithm
	static class MaxHeap{
		int[] arr;
		int size;
		
		MaxHeap(int length){
			arr = new int[length];
			size = 0;	
		}
		
		private int left(int i) {
			return 2*i + 1;
		}
		private int right(int i) {
			return 2*i + 2;
		}
		private int parent(int i) {
			return (i-1) / 2;
		}
		
		void insert(int x) {
			arr[size++] = x;
			int i = size-1;
			int temp = x;
			while (i > 0 && x > arr[parent(i)]) {
				arr[i] = arr[parent(i)];
				i = parent(i);
			}
			arr[i] = temp;
		}
		private void swap(int[] A, int i, int j) {
			int temp = A[j];
			A[j] = A[i];
			A[i] = temp;
		}
		private void extractMax() {
			swap(arr, 0, --size);
			int i = 0;
			while (right(i) < size) {
				int maxChild = Math.max(arr[left(i)], arr[right(i)]);
				int indexMaxChild = arr[left(i)] > arr[right(i)] ? left(i) : right(i);
				int elementToSwap = arr[i];	
				if (elementToSwap < maxChild) {
					swap(arr, i, indexMaxChild);
					i = indexMaxChild;
				}				
				else break;
			}
		}
		void sort() {
			int nbOfIterations = size;
			for (int i=0; i<nbOfIterations;i++)
				extractMax();
			if (arr[0] > arr[1])
				swap(arr, 0, 1);
		}
	}
	
	
	// radix sort
	private static int getMax(int[] A) {
		int max = A[0];
		for (int i=1; i<A.length; i++) 
			if (A[i] > max)
				max = A[i];
		return max;
	} 
	private static void countingSort(int[] A, int powerOf10) {
		int[] count = new int[10];
		for (int i=0; i<A.length; i++) 
			count[(A[i]/powerOf10) % 10]++;
		
		for (int i=1; i<10; i++)
			count[i] += count[i-1];
		
		int[] outputA = new int[A.length];
		for (int i=A.length-1; i>=0; i--) {
			outputA[count[(A[i]/powerOf10) % 10] - 1] = A[i];
			count[(A[i] / powerOf10) % 10]--;
		}
		
		for (int i = 0; i < A.length; i++)
	        A[i] = outputA[i];
	}
	static void radixSort(int[] A) {
		int max = getMax(A);
		for (int pow = 1; 0<(max/pow); pow*=10)
			countingSort(A, pow);
	}
	
}
