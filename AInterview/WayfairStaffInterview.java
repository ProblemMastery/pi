package AInterview;

import java.util.*;

public class Interview {


        public static String[][] getStudentCoursePairs(String[][] studentCoursePairs){

            Map<Integer, HashSet<String>> map = new HashMap<>();

            for(int i = 0; i < studentCoursePairs.length; i++){

                int id = Integer.parseInt(studentCoursePairs[i][0]);
                String course = studentCoursePairs[i][1];
                HashSet<String> courseSet = new HashSet<>();
                courseSet.add(course);
                map.putIfAbsent(id, courseSet);
                if(map.containsKey(id)) {
                    HashSet<String> s = map.get(id);
                    s.add(course);
                    map.put(id, s);
                }
            }

            for( int k : map.keySet()){
                Iterator<String> itr = map
                        .get(k).iterator();
                System.out.print(k);

                while(itr.hasNext()){
                    System.out.println(" : "+itr.next());
                }
            }
           int rows = nCr(map.size(),2);
            String [][] result = new String[rows][2];
            int row = 0;

            for(int key1 : map.keySet()){

                for(int key2: map.keySet()){
                    if(key1 != key2 && (key1 > key2)){

                        Set<String> set1 = map.get(key1);
                        Set<String> set2 = map.get(key2);

                        result[row][0] = String.valueOf(key1)+ ","+String.valueOf(key2);
                        System.out.println("In row  "+row+": "+result[row][0]);
                        System.out.println("Set1:"+set1.toString());
                        System.out.println("Set2:"+set2.toString());

                        StringBuilder sb = new StringBuilder();

                        sb.append("-> [");
                        set1.retainAll(set2);
                        System.out.println("intersection is i:"+set1.toString());
                        Iterator<String> itr = set1.iterator();
                        while(itr.hasNext()){

                            sb.append(itr.next());
                            sb.append(",");
                        }

                        result[row][1] = sb.append("]").toString();
                        System.out.println(result[row][1]);
                        row++;
                    }
                }
            }

            return result;
        }
    static int nCr(int n, int r)
    {
        return fact(n) / (fact(r) *
                fact(n - r));
    }

    // Returns factorial of n
    static int fact(int n)
    {
        int res = 1;
        for (int i = 2; i <= n; i++)
            res = res * i;
        return res;
    }

    static int binaryPatternMatching(String pattern, String s) {

        int l = 0;
        int plen = pattern.length();
        int count = 0;
        Set<Character> vowelSet = new HashSet<>();

        vowelSet.add('a');
        vowelSet.add('e');
        vowelSet.add('i');
        vowelSet.add('o');
        vowelSet.add('u');

        while((l+plen) < s.length()){
            String substr = s.substring(l, l+(plen));
            if( patternMatch(substr, pattern, vowelSet)){
                count++;
            }
            l++;
        }
        return count;
    }

    private static  boolean patternMatch(String s, String pattern, Set<Character> vowelSet){

        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()){
            if (vowelSet.contains(c)){
                sb.append('0');
            }else {
                sb.append('1');
            }
        }
        return sb.toString().equals(pattern);
    }

    public static void main(String[] argv) {
        System.out.print(binaryPatternMatching("0","o"));

//            String[][] studentCoursePairs1 = {
//                    {"58", "Linear Algebra"},
//                    {"94", "Art History"},
//                    {"94", "Operating Systems"},
//                    {"17", "Software Design"},
//                    {"58", "Mechanics"},
//                    {"58", "Economics"},
//                    {"17", "Linear Algebra"},
//                    {"17", "Political Science"},
//                    {"94", "Economics"},
//                    {"25", "Economics"},
//                    {"58", "Software Design"}
//
//            };
//
//            String[][] studentCoursePairs2 = {
//                    {"42", "Software Design"},
//                    {"0", "Advanced Mechanics", "Software Design"},
//                    {"9", "Art History", "Software Design"},
//            };
//
//           String [][] res =  getStudentCoursePairs(studentCoursePairs1);
//
//           for (int i=0 ; i < res.length; i++){
//               System.out.print("In row "+i+": ");
//               System.out.print(res[i][0]);
//               System.out.print(":"+res[i][1]);
//               System.out.println();
//           }

        }
    }


