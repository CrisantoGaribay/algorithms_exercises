package coe.unosquare.practice.algorithms.course.sort;


public class Insertion {

    public static  void selectionAlgorithm () {
        /**
         * Big O notation

            This is O(n^2)
         */
        String name = "Insertion sort";
        System.out.println(name + " algorithm >>>>>");
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        for(int firsUnsortedIndex = 1; firsUnsortedIndex < intArray.length; firsUnsortedIndex++) {

            int newElement = intArray[firsUnsortedIndex];

            int i;

            for (i = firsUnsortedIndex; i > 0 && intArray[i - 1] > newElement; i--) {
                intArray[i] = intArray[i - 1];
            }

            intArray[i] = newElement;

        }

        for (int j : intArray) {
            System.out.println(j);
        }

        System.out.println(name + " algorithm <<<<<<");
    }

}
