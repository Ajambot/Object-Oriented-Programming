/*
Name: Martin Morales Arana
Student ID: 1172178
Lab 10, Q1

The program shows an implementation of binary search that works for all elements of class comparable.
It then tests it by running it on an array of the wrapper class Integer which is implemented with Comparable.
 */
import java.util.Arrays;

class BinarySearch
{
    /**
     Searches the array a for key. If key is not in the array segment, then -1 is
     returned. Otherwise returns an index in the segment such that key == a[index].
     Precondition: a[first] <= a[first + 1]<= ... <= a[last]
     */
    public static int search(Comparable[] a, int first, int last, Comparable key)
    {
        int result = 0; //to keep the compiler happy.
        if (first > last)
            result = -1;
        else
        {
            int mid = (first + last)/2;
            if (key.compareTo(a[mid])==0) // If key = a[mid]
                result = mid;
            else if (key.compareTo(a[mid])<0) // If key<a[mid]
                result = search(a, first, mid - 1, key);
            else if (key.compareTo(a[mid])>0) // If key>a[mid]
                result = search(a, mid + 1, last, key);
        }
        return result;
    }
}

public class Morales_Martin_Lab10_Q1 {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 3, 2, 10, 24, -12, 76, 36, 87};
        Arrays.sort(arr);
        System.out.print("The array after being sorted is: ");
        for(Integer a : arr){
            System.out.print(a + " ");
        }
        System.out.println("\nThe element 76 is at index " + BinarySearch.search(arr, 0, 8, (Integer)76));
    }
}