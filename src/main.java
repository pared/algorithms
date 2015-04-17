import java.util.Arrays;

/**
 * Created by pawel on 04.03.15.
 */
public class main {
    private static int arraySize = 10000000;
    private static int max = 1;
    public static void main(String [] args){
        main m= new main();
        m.run();
    }

    public void run(){
        ArrayGenerator generator = new ArrayGenerator();
        ArraySorter sorter = new ArraySorter();
        double[] array = generator.generateRandomNumbers(arraySize);
        double[] original_sorted = Arrays.copyOf(array,array.length);
        sortUsingStdLibs(original_sorted);
        //printArray(array);
//        testInsertion(array,sorter,original_sorted);
//        testBubble(array,sorter,original_sorted);
        testMerge(array,sorter,original_sorted);
        testQuick(array, sorter,original_sorted);
        testHeap(array, sorter,original_sorted);

    }

    public void sortUsingStdLibs(double[] array){
        long timeStart = System.currentTimeMillis();
        Arrays.sort(array);
        long timeStop = System.currentTimeMillis();
        System.out.println("Sorting time using standard Arrays.sort function: "+ (double)(timeStop-timeStart)/1000+" s");
        System.out.println("Use output of Arrays.sort to compare output of implemented algorithms.");
    }
    public void testHeap(double[] array, ArraySorter sorter,double[] original){
        String method = "Heap sort";
        double[] sorted = Arrays.copyOf(array,array.length);
        long timeStart = System.currentTimeMillis();
        sorter.heapSort(sorted);
        long timeStop = System.currentTimeMillis();
        printExecutionResults(method,timeStop-timeStart,checkSort(sorted,original));
    }

    public void testBubble(double[] array, ArraySorter sorter,double[] original){
        String method = "Bubble sort";
        long timeStart = System.currentTimeMillis();
        double[] sorted = sorter.bubbleSort(array);
        //printArray(sorted);
        long timeStop = System.currentTimeMillis();
        printExecutionResults(method,timeStop-timeStart,checkSort(sorted,original));
    }

    public void testInsertion(double[] array,ArraySorter sorter,double[] original){
        String method = "Insertion sort";
        long timeStart = System.currentTimeMillis();
        double[] sorted = sorter.insertionSort(array);
        long timeStop = System.currentTimeMillis();
        printExecutionResults(method,timeStop-timeStart,checkSort(sorted,original));

    }

    public void testMerge(double[] array, ArraySorter sorter,double[] original){
        String method = "Merge sort";
        double[] sorted = Arrays.copyOf(array, array.length);
        long timeStart = System.currentTimeMillis();
        sorter.mergeSort(sorted);
        long timeStop = System.currentTimeMillis();
        printExecutionResults(method,timeStop-timeStart,checkSort(sorted,original));
    }

    public void testQuick (double[] array, ArraySorter sorter,double[] original){
        String method = "Quicksort";
        double[] sorted = Arrays.copyOf(array,array.length);
        long timeStart = System.currentTimeMillis();
        sorter.quickSort(sorted,0,array.length-1);
        long timeStop = System.currentTimeMillis();
        printExecutionResults(method, timeStop - timeStart, checkSort(sorted,original));
    }

    private void printExecutionResults(String method,long executionTime,String isCorrect){
        System.out.println(method+" is "+isCorrect+" execution time: "+(double)executionTime/1000+" s");
    }

    private String checkSort(double[] array,double[] original){
        if (Arrays.equals(array,original)){
            return "correct";
        } else {
            return "incorrect";
        }
    }

    public static void printArray(double[] array){
        for (int i = 0; i < array.length; i++){
            System.out.format("%.3f ",array[i]*max);
        }
        System.out.print("\n");
    }
}
