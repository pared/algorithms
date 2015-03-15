/**
 * Created by pawel on 04.03.15.
 */
public class ArrayGenerator {
    public double[] generateRandomNumbers(int arraySize){
        double[] array = new double[arraySize];
        for (int i = 0;i<array.length;i++){
            array[i]=Math.random();
        }
        return array;
    }


}
