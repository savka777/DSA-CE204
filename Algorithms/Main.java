package Algorithms;
import static Algorithms.SelectionSort.selectionSort;

public class Main {
    public static void main(String[] args) {
        int[] arr = {4,1,2,7,5};

        selectionSort(arr);

        for(int i : arr){
            System.out.println(i);
        }

    }
}
