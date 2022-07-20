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

    public static Set<Set<String>> powerSet(Set<String> ints) {
        // convertir conjunto a una lista
        List<String> S = new ArrayList<>(ints);

        // `N` almacena el número total de subconjuntos
        long N = (long) Math.pow(2, S.size());

        // Establecer para almacenar subconjuntos
        Set<Set<String>> result = new HashSet<>();

        // generar cada subconjunto uno por uno
        for (int i = 0; i < N; i++) {
            Set<String> set = new HashSet<>();

            // revisa cada bit de `i`
            for (int j = 0; j < S.size(); j++) {
                // si se establece el j-ésimo bit de `i`, agregue `S[j]` al conjunto actual
                if ((i & (1 << j)) != 0) {
                    set.add(S.get(j));
                }
            }
            result.add(set);
        }

        return result;
    }

    public static Set<Set<String>> recursivePowerSet(Set<String> set) {
        if (set.isEmpty()) {
            Set<Set<String>> ret = new HashSet<>();
            ret.add(set);
            return ret;
        }

        String element = set.iterator().next(); //a
        Set<String> subSetWithoutElement = getSubSetWithoutElement(set, element); //a
        Set<Set<String>> powerSetSubSetWithoutElement = recursivePowerSet(subSetWithoutElement);
        System.out.println("recursive");
        System.out.println(powerSetSubSetWithoutElement);
        Set<Set<String>> powerSetSubSetWithElement = addElementToAll(powerSetSubSetWithoutElement, element);

        Set<Set<String>> powerSet = new HashSet<>();
        powerSet.addAll(powerSetSubSetWithoutElement);
        powerSet.addAll(powerSetSubSetWithElement);
        return powerSet;
    }

    private static Set<Set<String>> addElementToAll(Set<Set<String>> powerSetSubSetWithoutElement, String element) {
        Set<Set<String>> powerSetSubSetWithElement = new HashSet<>();
        for (Set<String> subsetWithoutElement : powerSetSubSetWithoutElement) {
            Set<String> subsetWithElement = new HashSet<>(subsetWithoutElement);
            subsetWithElement.add(element);
            powerSetSubSetWithElement.add(subsetWithElement);
        }
        return powerSetSubSetWithElement;
    }

    private static Set<String> getSubSetWithoutElement(Set<String> set, String element) {
        Set<String> without = new HashSet<>(Set.copyOf(set));
        without.remove(element);

        return without;
    }

    private static Set<String> getSubSetWithoutElement(Set<String> set, Set<String> element) {
        Set<String> without = new HashSet<>(Set.copyOf(set));
        without.removeAll(element);

        return without;
    }
}
