package ua.di1.algo.rec.binary;

/**
 * Created by I on 2016-02-13.
 *
 */
public class BinarySearch {
    public static int find(int[] mas, int key){
        if (mas.length == 0) return -1;

        int result;

        int start = 0;
        int end = mas.length-1;
        int mid = (end - start) / 2;

        if (mid  < 0 ) return -1;

        // check element value
        if (key == mas[mid]) return mid;

        int[] newMas;
        if (key > mas[mid] ) {
            start = start + mid + 1;
            newMas = new int[end-start+1];
            System.arraycopy(mas,start,newMas,0, end-start+1);
        } else {
            end = end - mid - 1;
            newMas = new int[end - start + 1];
            System.arraycopy(mas,start,newMas,0, end - start + 1);
        }
        result = mid + find(newMas, key);

        return result;
    }
}
