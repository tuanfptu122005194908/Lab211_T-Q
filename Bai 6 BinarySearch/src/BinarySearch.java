import java.util.Arrays;
import java.util.Random;

public class BinarySearch {
    private Validation valid = new Validation();
    private int[] array;
    
    public void run() {
        int size = valid.getPositiveInteger("Enter number of array: ");
        
        generateArray(size);
        
        int searchValue = valid.getInteger("Enter search value: ");
        
        Arrays.sort(array);
        
        displayArray();
        
        int index = binarySearch(searchValue);
        
        displayResult(index, searchValue);
    }
    
    private void generateArray(int size) {
        array = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(100);
        }
    }
    
    private int binarySearch(int value) {
        return binarySearchRecursive(0, array.length - 1, value);
    }
    
    private int binarySearchRecursive(int left, int right, int value) {
        if (left > right) {
            return -1;
        }
        
        int mid = left + (right - left) / 2;
        
        if (array[mid] == value) {
            return mid;
        } else if (array[mid] > value) {
            return binarySearchRecursive(left, mid - 1, value);
        } else {
            return binarySearchRecursive(mid + 1, right, value);
        }
    }
    
    private void displayArray() {
        System.out.print("Sorted array: [");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    
    private void displayResult(int index, int value) {
        if (index != -1) {
            System.out.println("Found " + value + " at index: " + index);
        } else {
            System.out.println(value + " is not found in the array");
        }
    }
}