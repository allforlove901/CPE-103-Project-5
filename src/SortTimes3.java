/**
 * Brett Nelson bnelso26@calpoly.edu
 * 3/9/16
 * Project 5
 */

//class to test sorting methods with random lists
public class SortTimes3 {

	//main method
	public static void main(String args[]){
		
		Sorts sorts = new Sorts();
		Comparable[] arr1, arr2, arr3, arr4;
		
		System.out.println("TEST3: random list");
		for(int n = 5000; n<=80000; n = n*2){
			for(int j=0; j<3; j++){
				arr1 = new Comparable[n];
				arr2 = new Comparable[n];
				arr3 = new Comparable[n];
				arr4 = new Comparable[n];
				for(int i=0; i<n; i++){
					arr1[i] = (int) (Math.random()*n);
					arr2[i] = (int) (Math.random()*n);
					arr3[i] = (int) (Math.random()*n);
					arr4[i] = (int) (Math.random()*n);
				}
				long startTime1 = System.nanoTime();
				sorts.selectionSort(arr1, n);
				long endTime1 = System.nanoTime();
				long time1 = (endTime1 - startTime1)/1000000;
				
				long startTime2 = System.nanoTime();
				sorts.bubbleSort(arr2, n);
				long endTime2 = System.nanoTime();
				long time2 = (endTime2 - startTime2)/1000000;
				
				long startTime3 = System.nanoTime();
				sorts.insertionSort(arr3, n);
				long endTime3 = System.nanoTime();
				long time3 = (endTime3 - startTime3)/1000000;
				
				long startTime4 = System.nanoTime();
				sorts.mergeSort(arr4, n);
				long endTime4 = System.nanoTime();
				long time4 = (endTime4 - startTime4)/1000000;
				System.out.println("N=" + n + ": T_ss=" + time1 + ", " +
						"T_bs=" + time2 + ", " +
						"T_is=" + time3 + ", " +
						"T_ms=" + time4);
			}
			System.out.print("\n");
		}
		System.out.println("END TEST 3");
	}
}
