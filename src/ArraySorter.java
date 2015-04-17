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

    public void quickSort(double[] array,int from,int to){
        if(from < to) {
            double pivot = array[from];
            int leftMarker = from + 1;
            int rightMarker = to;
            boolean stop = false;

            while (!stop) {
                while (leftMarker <= rightMarker && array[leftMarker] < pivot) {
                    leftMarker++;
                }

                while ( leftMarker <= rightMarker && array[rightMarker] > pivot) {
                    rightMarker--;
                }

                if (leftMarker > rightMarker) {
                    stop = true;
                }else {
                    double temp = array[leftMarker];
                    array[leftMarker] = array[rightMarker];
                    array[rightMarker] = temp;
                }
            }
            double temp = array[from];
            array[from] = array[rightMarker];
            array[rightMarker] = temp;
            quickSort(array,from,rightMarker-1);
            quickSort(array,rightMarker+1,to);
        }
    }

    public void heapify(double[] array,int i,int length){
        int left = 2*i;
        int right = 2*i+1;
        int largest=i;
        if(left<=length && array[left-1] > array[i-1]){
            largest = left;
        }

        if(right <= length && array[right -1] > array[largest-1]){
            largest = right;
        }

        if(largest != i){
            double temp = array[i-1];
            array[i-1] = array[largest-1];
            array[largest-1] = temp;
            heapify(array,largest,length);
        }
    }

    public void heapSort(double[] array){
        int length = array.length;
        //create max heap
        for (int i = array.length/2+1;i>0;i--){
            heapify(array,i,length);
        }
        //sort
        for (int i = array.length;i>0;i--){
            double temp = array[0];
            array[0] = array[length-1];
            array[length-1] = temp;
            length--;
            heapify(array,1,length);
        }
    }

    public static void printArray(double[] array){
        for (int i = 0; i < array.length; i++){
            System.out.format("%.3f ",array[i]);
        }
        System.out.print("\n");
    }

}
