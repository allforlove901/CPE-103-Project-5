import java.util.Arrays;

/**
 * Brett Nelson bnelso26@calpoly.edu
 * 3/9/16
 * Project 5
 */

//class to test the functionality of Sorting methods
public class SortTests {

	//main method
	public static void main(String args[]){
		
		Sorts sorter = new Sorts();
		Comparable[] arr = new Comparable[10];
		for(int i=0; i<10; i++){
			arr[i] = (int) (Math.random()*100);
		}
		
		sorter.selectionSort(arr, arr.length);
		System.out.println(Arrays.toString(arr));
	}
	
}
