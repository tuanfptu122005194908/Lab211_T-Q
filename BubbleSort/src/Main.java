
public class Main {

    public static void main(String[] args) {
        int n = BubbleSort.inputSizeOfArray();
        int[] a = BubbleSort.generateRandomInt(n);
        // display array before sorted
        BubbleSort.display("Unsorted array: ", a);

        //sorted by bubble sort
        BubbleSort.sortArrayByBubbleSort(a);

        // display array after sorted
        BubbleSort.display("Sorted array: ", a);
    }
}
