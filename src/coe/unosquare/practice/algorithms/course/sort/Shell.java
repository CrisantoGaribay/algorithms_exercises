package coe.unosquare.practice.algorithms.course.sort;


public class Shell {

    public static  void selectionAlgorithm () {
        /**
         * Big O notation

            This depends on the gap
         */
        String name = "Shell sort";
        System.out.println(name + " algorithm >>>>>");
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};


        for (int gap = intArray.length / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < intArray.length; i++) {
                int newElement = intArray[i];

                int j = i;

                while (j >= gap && intArray[j - gap] > newElement) {
                    intArray[j] = intArray[j - gap];
                    j -= gap;
                }

                intArray[j] = newElement;
            }
        }

        for (int j : intArray) {
            System.out.println(j);
        }

        System.out.println(name + " algorithm <<<<<<");
    }

}
