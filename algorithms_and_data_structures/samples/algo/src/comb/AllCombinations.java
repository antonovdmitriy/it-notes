package comb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllCombinations {


    public static List<Object[]> getAllCombinationsAlt(Object[] things) {

        if (things.length == 0) {
            List<Object[]> result = new ArrayList<>();
            result.add(new Object[]{});
            return result;
        }

        Object first = things[0];
        Object[] rest = Arrays.copyOfRange(things, 1, things.length);

        List<Object[]> combsWithoutFirst = getAllCombinations(rest);
        List<Object[]> combsWithFirst = new ArrayList<>();

        combsWithoutFirst.forEach(objects -> {

            Object[] combWithFirst = Arrays.copyOf(objects, objects.length + 1);
            combWithFirst[combWithFirst.length - 1] = first;
            combsWithFirst.add(combWithFirst);
        });

        List<Object[]> result = new ArrayList<>();
        result.addAll(combsWithFirst);
        result.addAll(combsWithoutFirst);
        return result;

    }

    public static List<Object[]> getAllCombinations(Object[] things) {
        return getAllCombinations(things, new Object[]{}, 0);
    }


    public static List<Object[]> getAllCombinations(Object[] things, Object[] currentArray, int index) {
        if (index == things.length) {
            List<Object[]> result = new ArrayList<>();
            result.add(currentArray);
            return result;
        }

        Object[] nextArray = Arrays.copyOf(currentArray, currentArray.length + 1);
        nextArray[nextArray.length - 1] = things[index];

        List<Object[]> result = new ArrayList<>();
        result.addAll(getAllCombinations(things, currentArray, index + 1));
        result.addAll(getAllCombinations(things, nextArray, index + 1));
        return result;
    }

    public static void printAllCombinations(Object[] things) {
        printAllCombinations(things, new Object[]{}, 0);
    }

    public static void printAllCombinations(Object[] things, Object[] currentArray, int index) {

        if (index == things.length) {
            System.out.println(Arrays.toString(currentArray));
            return;
        }

        Object[] nextArray = Arrays.copyOf(currentArray, currentArray.length + 1);
        nextArray[nextArray.length - 1] = things[index];

        printAllCombinations(things, currentArray, index + 1);
        printAllCombinations(things, nextArray, index + 1);
    }

    public static void main(String[] args) {
        getAllCombinationsAlt(new Object[]{"a", "b", "c"}).forEach(e -> System.out.println(Arrays.toString(e)));
    }
}
