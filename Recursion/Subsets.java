package Recursion;

import java.util.ArrayList;
import java.util.List;
/* 78. Subsets : https://leetcode.com/problems/subsets/

*/
public class Subsets {

    static List<List<Integer>> powerSet = new ArrayList<>();
    static int k;

   public static List<List<Integer>> generatePowerSet(List<Integer> inputList) {
       //initialize the var to return
         subsetHelper(0, new ArrayList<>(), inputList);
       return powerSet;

   }

    private static void subsetHelper(int index, ArrayList<Integer> currentSet, List<Integer> inputList) {
        // base case
       if(index == inputList.size()) {
           powerSet.add(new ArrayList<>(currentSet));
           return;
       }
       // add it to current set
       currentSet.add(inputList.get(index));

       subsetHelper(index+1, currentSet, inputList);
       //remove the changes made
        currentSet.remove(currentSet.size()-1);

        subsetHelper(index+1, currentSet, inputList);
   }



    public static void main(String[] args) {
        List <Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);
        List<List<Integer>> result = generatePowerSet(input);

        for(List<Integer> l : result){
            System.out.print("<");
            for (int i : l){
                System.out.print(i+" ");
            }
            System.out.print("> ,");
        }
    }
}
