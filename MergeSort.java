import java.util.Scanner;

class MergeSort {
    private int[] array; // input array
    private int[] tempArray; // temporary array for merging

    public MergeSort(int[] arr) {
        this.array = arr;
        this.tempArray = new int[arr.length];
    }

    public void sort() {
        mergeSort(0, array.length - 1);
    }

    // recursive function for merge sort
    private void mergeSort(int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;

            // divide the array into two halves recursively
            mergeSort(low, mid);
            mergeSort(mid + 1, high);

            // merge the two sorted halves
            merge(low, mid, high);
        }
    }

    // merge two sorted sub-arrays
    private void merge(int low, int mid, int high) {
        // copy the elements of the input array into the temporary array
        for (int i = low; i <= high; i++) {
            tempArray[i] = array[i];
        }

        int i = low; // starting index of left sub-array
        int j = mid + 1; // starting index of right sub-array
        int k = low; // starting index of merged array

        while (i <= mid && j <= high) {
            if (tempArray[i] <= tempArray[j]) {
                array[k] = tempArray[i];
                i++;
            } else {
                array[k] = tempArray[j];
                j++;
            }
            k++;
        }

        // copy the remaining elements of the left sub-array into the merged array
        while (i <= mid) {
            array[k] = tempArray[i];
            i++;
            k++;
        }
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Get the input array from the user
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        int[] arr = new int[size];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        // Create an object of MergeSort class
        MergeSort ms = new MergeSort(arr);

        // Perform Merge sort
        ms.sort();

        System.out.println("Sorted array:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}