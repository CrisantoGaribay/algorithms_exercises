package coe.unosquare.practice.algorithms;

import java.util.*;
import java.util.stream.Collectors;

public class Subsets {

    public static void subsets() {
        String[] input = {"a", "c", "f", "j", "b"};
        String[][] output = new String[0][]; //[a], [c], [a, c], [f], [a, f], [c, f], [a, c, f], [j] ...

        for (String in : input) {

            String[][] subsets = new String[0][];

            output = insert(output, new String[]{in});
//            output = [a], [c]

            for (int n = 1; n < output.length; n++) {
                String[] current_value = output[n - 1];
                //a


                current_value = insert(current_value, in);
                //[a, c]
                subsets = insert(subsets, current_value);
                //[a, c]
            }
//            subsets = 0


            if (subsets.length > 0) {
                // [a], [c], [a, c]
                output = concatWithArrayCopy(output, subsets);
            }

        }

        System.out.println(Arrays.deepToString(output));
    }

    private static String[] insert(String[] array, String input) {
        array = Arrays.copyOf(array, array.length + 1);
        array[array.length - 1] = input;
        return array;
    }

    private static String[][] insert(String[][] array, String[] input) {
        array = Arrays.copyOf(array, array.length + 1);
        array[array.length - 1] = input;
        return array;
    }

    static <T> T[] concatWithArrayCopy(T[] array1, T[] array2) {
        T[] result = Arrays.copyOf(array1, array1.length + array2.length);
        System.arraycopy(array2, 0, result, array1.length, array2.length);
        return result;
    }



    public static void subsets2() {

        List<String> input = Arrays.asList("a", "c", "f", "j", "b");
        Set<Set<String>> output = new HashSet<>();


        input.forEach(in -> {
                    output.add(new HashSet<>(Collections.singleton(in)));
                    Set<Set<String>> subsetsSet = output.stream()
                            .map(out -> {
                                Set<String> outSet = new HashSet<>(out);
                                out.add(in);
                                return outSet;
                            })
                            .collect(Collectors.toSet());

                    output.addAll(subsetsSet);
                });

        System.out.println(output);

    }
}
