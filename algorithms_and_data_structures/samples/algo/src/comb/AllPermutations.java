package comb;

import java.util.ArrayList;
import java.util.List;

public class AllPermutations {


    public static void main(String[] args) {
        getAllPermutation(List.of("a", "b", "c")).forEach(System.out::println);
    }

    private static List<List<Object>> getAllPermutation(List<Object> objects) {

        if (objects == null || objects.isEmpty()) {
            return List.of(List.of());
        }

        Object firstElement = objects.get(0);
        List<Object> rest = objects.subList(1, objects.size());
        List<List<Object>> permsWithoutFirst = getAllPermutation(rest);

        List<List<Object>> result = new ArrayList<>();

        for (List<Object> perm : permsWithoutFirst) {
            for (int j = 0; j <= perm.size(); j++) {
                List<Object> permWithFirst = new ArrayList<>(perm);
                permWithFirst.add(j, firstElement);
                result.add(permWithFirst);
            }
        }

        return result;
    }

}
