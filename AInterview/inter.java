//package Pramp;
//
//public class inter {
//    /*
//
//a: [1, 2, 2]
//b: [2, 3]
//query:
//[[1,4],
// [0,0,3],
// [1,5]]
//
//     */
//    int[] coolFeature(int[] a, int[] b, int[][] query) {
//
//        List<Integer>result = new ArrayList<>();
//
//        for (int i = 0 ; i < query.length; i++){
//            if(query[i].length == 2){
//                //two sum
//                int count = twoSum(a,b,query[i][1]);
//                result.add(count);
//            }
//            if(query[i].length == 3){
//                int index = query[i][1];
//                if(b.length> index){
//                    b[index] = query[i][2];
//                }
//            }
//
//        }
//        int [] resultArray = new int [result.size()];
//        for (int i = 0 ; i < result.size(); ++i){
//            resultArray[i] = result.get(i);
//        }
//        return resultArray;
//    }
//
//    private int twoSum(int[]a, int [] b, int target){
//        int count = 0;
//
//        Map<Integer, Integer> map = new HashMap<>();
//        for(int i = 0 ; i < a.length; i ++){
//            map.put(a[i], i);
//        }
//
//        for( int i = 0 ; i < a.length; i++){
//            int complement = target - b[i];
//            if(map.containsKey(complement) ){
//                count++;
//            }
//        }
//        return count;
//    }
//}
