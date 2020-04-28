package Recursion;

import java.util.*;
import java.util.stream.Collectors;

public class Permutations {
    /*
    Given aan array of integers, generate its permutations
    eg : <2,3,5,7>
    <2,3,7,5> , <2,5,3,7>, <5,3,2,7> and so on.
     */

    public static List<List<Integer>> generatePermutations(List<Integer> inputList) {
        List<List<Integer>> result = new ArrayList<>();
        directedPermutations(0, inputList, result);
        return result;
    }

    private static void directedPermutations(int i, List<Integer> inputList,
                                             List<List<Integer>> result) {
        if (i == inputList.size() - 1) {
            result.add(new ArrayList<>(inputList));
            return;
        }

        // Try every possibility for A[i].
        for (int j = i; j < inputList.size(); ++j) {
            //use the same inputList swap the numbers.
            Collections.swap(inputList, i, j);
            // Generate all permutations for A.subList(i + 1, A.size()).
            directedPermutations(i + 1, inputList, result);
            Collections.swap(inputList, i, j);
        }
    }

    public static void main(String[] args) {
        List <Integer> input = new ArrayList<>();
        input.add(2);
        input.add(3);
        input.add(5);
        List<List<Integer>> result = generatePermutations(input);

        for(List<Integer> l : result){
            System.out.print("<");
            for (int i : l){
                System.out.print(i+",");
            }
            System.out.print("> ,");
        }
    }

}
