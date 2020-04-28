package My_Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/*
https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/
There are n people whose IDs go from 0 to n - 1 and each person belongs exactly to one group.
Given the array groupSizes of length n telling the group size each person belongs to,
return the groups there are and the people's IDs each group includes.
You can return any solution in any order and the same applies for IDs.
Also, it is guaranteed that there exists at least one solution.
Example 1:
Input: groupSizes = [3,3,3,3,3,1,3]
Output: [[5],[0,1,2],[3,4,6]]
Explanation:
Other possible solutions are [[2,1,6],[5],[0,4,3]] and [[5],[0,6,2],[4,3,1]].
Example 2:
Input: groupSizes = [2,1,3,3,3,2]
Output: [[1],[0,5],[2,3,4]]
 */
public class GroupSize {

    public static List<List<Integer>> groupThePeople(int[] groupSizesInput) {

        List<List<Integer>> resultantListofGroups = new ArrayList<List<Integer>>();
        HashMap<Integer,List<Integer>> groupMap = new HashMap<Integer, List<Integer>>();

        for(int i= 0 ; i < groupSizesInput.length; i++){
            List<Integer> indicesList = new ArrayList<Integer>();
            if(groupMap.get(groupSizesInput[i])!=null)
                indicesList = groupMap.get(groupSizesInput[i]);
            indicesList.add(i);
            groupMap.put(groupSizesInput[i],indicesList);
            //so the idea is as soon as the size of the indices list becomes the size of the value of group
            //i.e groupSizesInput[i], we ll remove the list.
            //i.e if groupSizesInput[i] = 3, if the list added to the key =3 in map, is size of 3,
            // then we ll remve the key.
            if(indicesList.size()==groupSizesInput[i]){
                resultantListofGroups.add(indicesList);
                groupMap.remove(groupSizesInput[i]);
            }
        }
        return resultantListofGroups;
    }
    public static void main(String[] args) {

        int[] group = new int[]{3, 3, 3, 3, 3, 1, 3};
        List<List<Integer>> result = groupThePeople(group);
        System.out.print(result.toString());
    }
}
