import java.util.Arrays;

/**
 * Created by pawel on 04.03.15.
 */
public class main {
    private static int arraySize = 100000;
    private static int max = 100;
    public static void main(String [] args){
        main m= new main();
        m.run();
    }

    public void run(){
        ArrayGenerator generator = new ArrayGenerator();
        ArraySorter sorter = new ArraySorter();
        double[] array = generator.generateRandomNumbers(arraySize);
        //printArray(array);
//        testInsertion(array,sorter);
//        testBubble(array,sorter);
        testMerge(array,sorter);


    }

    public void testBubble(double[] array, ArraySorter sorter){
        String method = "Bubble sort";
        long timeStart = System.currentTimeMillis();
        double[] sorted = sorter.bubbleSort(array);
        //printArray(sorted);
        long timeStop = System.currentTimeMillis();
        printExecutionResults(method,timeStop-timeStart,checkSort(sorted));
    }

    public void testInsertion(double[] array,ArraySorter sorter){
        String method = "Insertion sort";
        long timeStart = System.currentTimeMillis();
        double[] sorted = sorter.insertionSort(array);
        long timeStop = System.currentTimeMillis();
        printExecutionResults(method,timeStop-timeStart,checkSort(sorted));

    }

    public void testMerge(double[] array, ArraySorter sorter){
        String method = "Merge sort";
        double[] sorted = Arrays.copyOf(array, array.length);
        long timeStart = System.currentTimeMillis();
        sorter.mergeSort(sorted);
        long timeStop = System.currentTimeMillis();
        printExecutionResults(method,timeStop-timeStart,checkSort(sorted));
    }

    private void printExecutionResults(String method,long executionTime,String isCorrect){
        System.out.println(method+" is "+isCorrect+" execution time: "+(double)executionTime/1000+" s");
    }

    private String checkSort(double[] array){
        for(int i = 0;i < array.length-1; i++){
            if (array[i]>array[i+1]){
                return "incorrect";
            }
        }
        return "correct";
    }

    public static void printArray(double[] array){
        for (int i = 0; i < array.length; i++){
            System.out.format("%.3f ",array[i]*max);
        }
        System.out.print("\n");
    }
}
