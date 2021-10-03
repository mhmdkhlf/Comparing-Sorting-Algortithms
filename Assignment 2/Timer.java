import java.util.Arrays;
import java.util.Random;

public class Timer {
	private static int averageTime(int[] times) {
		int sum = 0;
		for(int time : times)
			sum += time;
		return sum / times.length;
	}
	public static void main(String[] args) {
		Random rand = new Random();
		final int TESTS = 54;
		int[] times = new int[TESTS];
		final int ARRAY_SIZE = 1_000_000;
		int[] largeArray = new int[ARRAY_SIZE];
		
		for (int t=0; t<TESTS; t++) {
			for (int i=0; i<ARRAY_SIZE; i++)
				largeArray[i] = rand.nextInt(10_000_000);
			SortingAlgorithms.MaxHeap heap = new SortingAlgorithms.MaxHeap(ARRAY_SIZE);
			long startTime = System.nanoTime();
			for (int i=0; i<ARRAY_SIZE; i++)
				heap.insert(largeArray[i]);
			heap.sort();
//			SortingAlgorithms.mergeSort(largeArray); 
			long endTime = System.nanoTime();
			int duration = (int) (endTime - startTime) / 1_000_000;
			times[t] = duration; 
			System.out.printf("%d ms\n", duration);
		}		
		System.out.println(Arrays.toString(times));
		System.out.println(averageTime(times)+" ms");
	}
}
