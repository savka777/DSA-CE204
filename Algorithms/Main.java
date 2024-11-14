package Algorithms;
import static Algorithms.InsertionSort.insertionSort;
import static Algorithms.SelectionSort.selectionSort;

public class Main {
    public static void main(String[] args) {
        int[] arr = {4,1,2,7,5};

//        selectionSort(arr);
        insertionSort(arr);

        for(Integer i: arr){
            System.out.println(i);
        }

    }
}
