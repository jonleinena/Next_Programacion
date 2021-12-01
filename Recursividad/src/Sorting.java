import java.util.ArrayList;
import java.util.Collections;

/**
 * Class that contains the different algorithms used for sorting
 * Algorithms are: Merge Sort and Quick Sort (using id numbers to sort elements and name)
 *
 * @author Jon Leiñena  - https://github.com/jonleinena
 * @author Mikel Ferrer - https://github.com/FerreMikel
 */
public class Sorting {

    /**
     * Generic Merge Sort using id number
     *
     * @param list list to be sorted
     * @param <T>  type of the objects to sort
     * @return sorted list
     */
    public static <T extends I_Comparable<T>> ArrayList<T> mergeSortNum(ArrayList<T> list) {
        if (list.size() == 1) return list;
        else {
            ArrayList<T> listLeft = new ArrayList<T>(list.subList(0, list.size() / 2));
            ArrayList<T> listRight = new ArrayList<T>(list.subList(list.size() / 2, list.size()));

            listLeft = mergeSortNum(listLeft);
            listRight = mergeSortNum(listRight);

            return mergeNum(listLeft, listRight);
        }


    }

    /**
     * Generic Merge function to merge and sort the divided lists (using id)
     *
     * @param a   left list
     * @param b   right list
     * @param <T> type of the objects in the list
     * @return merged (and sorted) list
     */
    public static <T extends I_Comparable<T>> ArrayList<T> mergeNum(ArrayList<T> a, ArrayList<T> b) {
        ArrayList<T> c = new ArrayList<>();
        while (!a.isEmpty() && !b.isEmpty()) {
            if (a.get(0).compareNum(b.get(0))) {
                c.add(b.get(0));
                b.remove(0);
            } else {
                c.add(a.get(0));
                a.remove(0);
            }
        }
        //At this point either a or b is empty
        while (!a.isEmpty()) {
            c.add(a.get(0));
            a.remove(0);
        }
        while ((!b.isEmpty())) {
            c.add(b.get(0));
            b.remove(0);
        }
        return c;
    }

    /**
     * Generic Merge Sort using name
     *
     * @param list list to be sorted
     * @param <T>  type of the objects to sort
     * @return sorted list
     */
    public static <T extends I_Comparable<T>> ArrayList<T> mergeSortStr(ArrayList<T> list) {
        if (list.size() == 1) return list;
        else {
            ArrayList<T> listLeft = new ArrayList<T>(list.subList(0, list.size() / 2));
            ArrayList<T> listRight = new ArrayList<T>(list.subList(list.size() / 2, list.size()));

            listLeft = mergeSortStr(listLeft);
            listRight = mergeSortStr(listRight);

            return mergeStr(listLeft, listRight);
        }


    }

    /**
     * Generic Merge function to merge and sort the divided lists (using name)
     *
     * @param a   left list
     * @param b   right list
     * @param <T> type of the objects in the list
     * @return merged (and sorted) list
     */
    public static <T extends I_Comparable<T>> ArrayList<T> mergeStr(ArrayList<T> a, ArrayList<T> b) {
        ArrayList<T> c = new ArrayList<>();
        while (!a.isEmpty() && !b.isEmpty()) {
            if (a.get(0).compareStr(b.get(0))) {
                c.add(b.get(0));
                b.remove(0);
            } else {
                c.add(a.get(0));
                a.remove(0);
            }
        }
        //At this point either a or b is empty
        while (!a.isEmpty()) {
            c.add(a.get(0));
            a.remove(0);
        }
        while ((!b.isEmpty())) {
            c.add(b.get(0));
            b.remove(0);
        }
        return c;
    }

    /**
     * Generic Quicksort method
     * @param a Array to be sorted
     * @param low Index of the first element
     * @param high Index of the last element
     * @param <E> Type of the elements in the array
     */
    public static <E extends I_Comparable<E>> void quicksortStr(ArrayList<E> a, int low, int high) {
        if (low < high) {
            int pivotLocation = partition(a, low, high);
            quicksortStr(a, low, pivotLocation);
            quicksortStr(a, pivotLocation + 1, high);
        }
    }

    /**
     * Method to calculate the mid element in the Arrray
     * @param a Array to be sorted
     * @param low Index of the first element
     * @param high Index of the last element
     * @param <E> Type of the elements in the array
     * @return The index of the mid element
     */
    private static <E extends I_Comparable<E>> int partition(ArrayList<E> a, int low, int high) {
        E pivot = a.get(low);
        int left = low;
        for (int i = low + 1; i < high; i++) {
            if (a.get(i).compareStr(pivot)) {
                Collections.swap(a, i, left);
                left += 1;
            }
        }
        Collections.swap(a, low, left);
        return left;
    }

}