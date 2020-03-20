import java.util.Arrays;
import java.util.Random;

public class Quicksort {

//************************************************//
	//***** Global variables and objects *****//
	
		static final boolean DEBUG = true;
		static final int TEST_ARRAYS_NUM = 10;
		static final int TEST_ARRAYS_SIZE = 10;
		static final int TEST_ARRAYS_RANGE = 100;
		static Random rand = new Random();
		
//************************************************//
		
		
		/**
		 * Main method, generates integer arrays and sorts them using quicksort() and randomizedQuicksort().
		 * @param args
		 */
		public static void main(String[] args) {

			int[][] testArrays = new int[TEST_ARRAYS_NUM][TEST_ARRAYS_SIZE];
			System.out.printf("Welcome to Jesse Reeve's quicksort algorithm tester!\n");
			System.out.printf("The main method has static variables for number of test arrays, test array size, and range of values in test arrays.\n");
			System.out.printf("Turn on DEBUG to see the algorithms at work.\n");
			System.out.printf("Happy grading!\n\n");
			System.out.printf("Creating %d arrays of %d integers each, range 0 to %d:\n",TEST_ARRAYS_NUM, TEST_ARRAYS_SIZE,TEST_ARRAYS_RANGE);
			for (int i=0; i<TEST_ARRAYS_NUM; i++) {
				for (int j=0; j<TEST_ARRAYS_SIZE; j++) {
					testArrays[i][j]=rand.nextInt(TEST_ARRAYS_RANGE);
				}//for
				System.out.printf("%s", Arrays.toString(testArrays[i]));
				System.out.println();
				System.out.println();
			}//for
			
			//test quicksort
			for (int i=0; i<TEST_ARRAYS_NUM/2; i++) {
				System.out.printf("Calling quicksort on test array %d.\n",i);
				System.out.printf("Array contents:\n%s\n", Arrays.toString(testArrays[i]));
				quicksort(testArrays[i],0,testArrays[i].length-1);
				System.out.printf("Sorted array:\n%s\n", Arrays.toString(testArrays[i]));
				System.out.println();
			}//for
			
			//test randomizedQuicksort
			for (int i=TEST_ARRAYS_NUM/2; i<TEST_ARRAYS_NUM; i++) {
				System.out.printf("Calling randomizedQuicksort on test array %d.\n",i);
				System.out.printf("Array contents:\n%s\n", Arrays.toString(testArrays[i]));
				randomizedQuicksort(testArrays[i],0,testArrays[i].length-1);
				System.out.printf("Sorted array:\n%s\n", Arrays.toString(testArrays[i]));
				System.out.println();
			}//for
		}//main

		/**
		 * Implements the naive quicksort algorithm.
		 * 
		 * @param A int[] array to be sorted
		 * @param p first index in the range to be sorted
		 * @param r final index in the range to be sorted
		 */
		static void quicksort(int[] A, int p, int r){
			if(DEBUG) System.out.printf("Quicksort has been invoked on index range %d - %d\n", p,r);
			if (p<r) {
				int q = partition(A, p, r);
				quicksort(A,p,q-1);
				quicksort(A,q+1,r);
			}//if
		}//quicksort
		
		/**
		 * Implements quicksort algorithm using a randomized pivot.
		 * 
		 * @param A int[] array to be sorted
		 * @param p first index in the range to be sorted
		 * @param r final index in the range to be sorted
		 */
		static void randomizedQuicksort(int[]A, int p, int r) {
			if (p<r) {
				int randomIndex = rand.nextInt(r-p) + p;
				if (DEBUG) System.out.printf("Randomly generated index: %d (range: %d to %d)\n", randomIndex,p,r);
				swap(A,r,randomIndex);
				int q = partition(A, p, r);
				randomizedQuicksort(A,p,q-1);
				randomizedQuicksort(A,q+1,r);
			}//if
		}//randomizedQuicksort
		
		/**
		 * Implements the partition phase of the quicksort algorithm.
		 * 
		 * @param A int[] array to be sorted
		 * @param p first index in the range to be sorted
		 * @param r final index in the range to be sorted
		 * @return
		 */
		static int partition(int[]A, int p, int r) {
			int pivot = A[r];
			int i = p-1;
			for (int j=p; j<r;j++) {
				if (A[j] <= pivot) {
					i++;
					swap(A,i,j);
				}//if
			}//for
			swap(A,i+1,r);
			if (DEBUG) System.out.printf("Partition index is %d.\n", i+1);
			return (i+1);
		}//partition
		
		
		/**
		 * Swaps the values of two indices of an array.
		 * 
		 * @param A			the target int[] array
		 * @param index1	index of the first value
		 * @param index2	index of the second value
		 */
		static void swap(int[] A, int index1, int index2) {
			if (DEBUG) System.out.printf("Now swapping A[%d] (%d) and A[%d] (%d)\n",index1, A[index1],index2,A[index2]);
			int temp = A[index1];
			A[index1] = A[index2];
			A[index2] = temp;
		}//swap

}
