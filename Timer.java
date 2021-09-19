import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class Timer {
	
	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter("C:\\Users\\moham\\Desktop\\CSC310\\LAB2\\times.txt", true);
		Random rand = new Random();
		final int TESTS = 25;
		long[] times = new long[TESTS]; 
		int[] largeArray = null;
		for (int t=0; t<TESTS; t++) {
			largeArray = new int[100];
			
			for (int i=0; i<largeArray.length; i++)
				largeArray[i] = rand.nextInt(10_000_000);
			
			long startTime = System.nanoTime();
			SortingAlgorithms.mergeSort(largeArray,0,largeArray.length-1);
			long endTime = System.nanoTime();
			long duration = (endTime - startTime);
			times[t] = duration; 
			System.out.printf("%d ns\n", duration);
		}
		System.out.printf("on array of size %d\n", largeArray.length);
		System.out.println(Arrays.toString(times));
		fw.write(String.format("\tarray of size %d\n", largeArray.length));
		fw.write(Arrays.toString(times)+"\n");
		fw.close();
	}

}
