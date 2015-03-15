import java.util.Arrays;

/**
 * Created by pawel on 05.03.15.
 */
public class ArraySorter {

    public double[] insertionSort(double[] array) {
        double[] toSort = Arrays.copyOf(array, array.length);
        for (int i = 1; i < toSort.length; i++) {
            double key = toSort[i];
            int j = i-1;
            while(j >= 0 && toSort[j] > key){
                toSort[j+1]=toSort[j];
                j--;
            }
            toSort[j+1]=key;
        }
        return toSort;
    }

    public double[] bubbleSort(double[] array){
        double[] toSort = Arrays.copyOf(array,array.length);
        int numberSortedElements = 0;
        for (int i = 0; i < toSort.length - 1 ;i++){
            for(int j = 0; j < toSort.length - numberSortedElements -1;j++){
                if(toSort[j] > toSort[j+1]){
                    double swap = toSort[j+1];
                    toSort[j+1] = toSort[j];
                    toSort[j] = swap;
                }
            }
        }
        return toSort;
    }

    public void mergeSort(double[] array){
        
        if (array.length>1) {
            int mid = array.length / 2;
            double[] left = Arrays.copyOfRange(array, 0, mid);
            double[] right = Arrays.copyOfRange(array, mid, array.length);
            mergeSort(left);
            mergeSort(right);

            int i = 0;
            int j = 0;
            int k = 0;

            while (i < left.length && j < right.length){
                if(left[i] < right[j]){
                    array[k] = left[i];
                    i++;
                } else {
                    array[k] = right[j];
                    j++;
                }
                k++;
            }
            while (i < left.length){
                array[k] = left[i];
                k++;
                i++;
            }

            while (j < right.length){
                array[k] = right[j];
                k++;
                j++;
            }


        }
      
    }

}
