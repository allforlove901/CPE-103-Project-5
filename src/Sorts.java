import java.lang.reflect.Array;

/**
 * Brett Nelson bnelso26@calpoly.edu
 * 3/9/16
 * Project 5
 */

//class to implement basic sorting methods
public class Sorts {

	//sorts the list of 'size' elements contained 
	//in the array arr[0...size-1] using selection sort
	public static<T extends Comparable<? super T>> void selectionSort(T[] arr, int size){
		for(int i=0; i<size-1; i++){
			T smallest = arr[i];   //store first in subsection
			int smallestIndex = i; //store first's index
			for(int j=i; j<size; j++){ //iterate through rest of arr
				if(arr[j].compareTo(smallest)<0){
					smallest = arr[j];
					smallestIndex = j;
				}
			}
			T store = arr[i];
			arr[i] = smallest;
			arr[smallestIndex] = store;
		}
	}
	
	//sorts the list of 'size' elements contained 
	//in the array arr[0...size-1] using bubble sort
	public static<T extends Comparable<? super T>> void bubbleSort(T[] arr, int size){
		for(int i=0; i<size-1; i++){
			for(int j=0; j<size-1; j++){
				if(arr[j].compareTo(arr[j+1])>0){
					T store = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = store;
				}
			}
		}
	}
	
	//sorts the list of 'size' elements contained 
	//in the array arr[0...size-1] using insertion sort
	public static<T extends Comparable<? super T>> void insertionSort(T[] arr, int size){
		for(int i=1; i<size; i++){
			int j = i;
			while(j>0 && arr[j-1].compareTo(arr[j])>0){
				T store = arr[j-1];
				arr[j-1] = arr[j];
				arr[j] = store;
				j--;
			}
		}	
	}
	
	//sorts the list of 'size' elements contained 
	//in the array arr[0...size-1] using merge sort
	public static<T extends Comparable<? super T>> void mergeSort(T[] arr, int size){
		@SuppressWarnings("unchecked")
		T[] tmp = (T[]) new Comparable[size];
		mergeSort(arr, tmp, 0, arr.length - 1);
	}
	
	//private method that splits array and merges the two
	private static<T extends Comparable<? super T>> void mergeSort(T[] arr, T[] tmp, int left, int right){
		if(left < right){
			int center = (left + right)/2;
			mergeSort(arr, tmp, left, center);
			mergeSort(arr, tmp, center+1, right);
			merge(arr, tmp, left, center+1, right);
		}
	}
	
	//private method that merges two arrays whilst sorting them
	private static<T extends Comparable<? super T>> void merge(T[] arr, T[] tmp, int left, int right, int rightEnd){
		//store values of left and left end
		int leftEnd = right - 1;
        int k = left;
        int num = rightEnd - left + 1;

        while(left <= leftEnd && right <= rightEnd)
            if(arr[left].compareTo(arr[right]) <= 0)
                tmp[k++] = arr[left++];
            else
                tmp[k++] = arr[right++];

        while(left <= leftEnd)
            tmp[k++] = arr[left++];

        while(right <= rightEnd)
            tmp[k++] = arr[right++];

        for(int i = 0; i < num; i++, rightEnd--)
            arr[rightEnd] = tmp[rightEnd];
	}
}
