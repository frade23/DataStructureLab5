package quicksort;

import java.util.Random;

public class Quicksort {
    private static int CUTOFF = 5;
    private Quicksort() { }

    // Your code here
    static int[] sort(int[] unsorted) {
        sort(unsorted, 0, unsorted.length - 1);
        return unsorted;
    }

    private static void sort(int[] array, int left, int right){
        if(left + CUTOFF >= right){
            int pivotIndex = findpivot (array, left, right);
            swapReferences(array, pivotIndex, right);
            int k = partition (array, left-1, right, array[right]);
            swapReferences(array, k, right);
            if ((k-left)>1) sort (array, left, k-1);
            if ((right-k)>1) sort (array, k+1, right);
        }
        else insertSort(array,left,right);

    }

    private static int partition(int[] array, int l, int r, int pivot) {
        do {
            while (array[++l] < pivot);
            while ((r!=0) && (array[--r] > pivot));
            swapReferences(array, l, r);
        } while (l<r);
        swapReferences(array, l, r);
        return l;
    }

    private static int findpivot(int [] unsorted, int left, int right){
        int center = (left + right)/2;
        if (unsorted[center] < unsorted[left])
            swapReferences(unsorted, left, center);
        if (unsorted[right] < unsorted[left])
            swapReferences(unsorted, left, right);
        if (unsorted[right] < unsorted[center])
            swapReferences(unsorted, right, center);

        swapReferences(unsorted, center, right - 1);
        return unsorted[right - 1];
    }

    private static void swapReferences(int[] unsorted, int left, int right){
        int temp = unsorted[left];
        unsorted[left] = unsorted[right];
        unsorted[right] = temp;
    }

    private static void insertSort(int[] a, int left, int right) {
        int j;
        for(int p = 1;p < a.length;p++){
            int tmp = a[p];
            for(j = p;j > 0 && tmp<a[j-1];j--)
                a[j] = a[j-1];
            a[j] = tmp;
        }
    }
    
    // Your code here
    public static void main(String[] args) {

//    	for (CUTOFF = 0; CUTOFF < 31; CUTOFF++){
//    	    int[] unsorted = new int[10000];
//            int i = 0;
//            while (i < unsorted.length) {
//                int j = (int)(Math.random() * 100000);
//                unsorted[i++] = j;
//            }
//
//            sort(unsorted);

//        }
        for(CUTOFF=0;CUTOFF <= 30;CUTOFF++){
            long time1 = System.currentTimeMillis();
            TestQuicksort testQuicksort = new TestQuicksort();
            testQuicksort.testQuicksort();
            long time2 = System.currentTimeMillis();
            System.out.println("M: " + (time2-time1) + " ms");
        }
    }
}
