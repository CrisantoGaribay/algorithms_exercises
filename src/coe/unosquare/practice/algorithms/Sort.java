package coe.unosquare.practice.algorithms;

public class Sort {
    private void sort() {
        int[] numbers = {3, 15, 23, 2, 7};

        int current_index = 0;
        int prev_number = 0;
        int next_number = 0;

        for (int i= numbers.length -1; i > current_index; i--) {

            prev_number = numbers[current_index];
            next_number = numbers[i];

            numbers[current_index] = next_number;
            numbers[i] = prev_number;

            current_index++;
        }

        for (int i=0; i<numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }
}
