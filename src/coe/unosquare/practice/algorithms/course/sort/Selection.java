package coe.unosquare.practice.algorithms.course.sort;


public class Selection {

    public static  void selectionAlgorithm () {
        /**
         * Big O notation

            This is O(n^2)
         */
        System.out.println("Selection sort algorithm >>>>>");
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        for(int lastUnsortedIndex = intArray.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {

            int largest = 0;
            for (int i = 1; i <= lastUnsortedIndex; i++) {
                if (intArray[i] > intArray[largest]) {
                    largest = i;
                }
            }

            swap(intArray, largest, lastUnsortedIndex);
        }

        for (int j : intArray) {
            System.out.println(j);
        }

        System.out.println("Bubble algorithm <<<<<<");
    }

    private static void swap (int[] array, int i, int j) {
        if(i == j) {
            return;
        }

        int temp = array[i];
        array[i] = array[j];
        array[j] =  temp;
    }
}
