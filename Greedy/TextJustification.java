package Greedy;


//solution based on Tushar Roy
public class TextJustification {

    public static String justifyText( String [] words, int width) {

        int[][] cost = new int[words.length][words.length];


        //first 2 loops is calc cost

        for (int i = 0; i < words.length; i++) {
            cost[i][i] = width - words[i].length();
            for (int j = i + 1; j < words.length; j++)
                cost[i][j] = cost[i][j - 1] - words[j].length() - 1;
        }

        for (int i = 0; i < words.length; i++) {
            for (int j = i; j < words.length; j++) {
                if (cost[i][j] < 0)
                    cost[i][j] = Integer.MAX_VALUE;
                else
                    cost[i][j] = (int) Math.pow(cost[i][j], 2);
            }
        }

        System.out.println("costMatrix is :");
        for (int i = 0; i < cost.length; i++) {
            for (int j = 0; j < cost[0].length; j++) {
                if (cost[i][j] == Integer.MAX_VALUE)
                    System.out.print(" MAX, ");
                else
                    System.out.print(" " + cost[i][j] + ", ");
            }
            System.out.print("\n");
        }



        //initialize 2 arrays; one for min cost and the other for next index.

        int [] minCost = new int [words.length];
        int [] nextIndex = new int [words.length];

        for (int i = words.length-1; i >= 0 ; i--){
            // initialize max value i.e pack as many words as possible in each row
            // and make next index as last word in words arra.
            //therefore
            minCost[i] = cost[i][words.length-1];// each row, last col
            nextIndex[i] = words.length;
            for (int j = words.length-1; j >i; j--){
                if(cost[i][j-1] == Integer.MAX_VALUE){
                    continue;
                }
                if (minCost[i] > minCost[j]+ cost[i][j-1]){
                    minCost[i] = minCost[j]+ cost[i][j-1];
                    nextIndex[i] = j;
                }

            }
        }
        System.out.println ("minCost is");
        for (int i : minCost)
            System.out.print(i+",");

        System.out.println ("nextIndex  is");
        for (int i : nextIndex)
            System.out.print(i+",");

        System.out.println();
        int i = 0 , j;

        StringBuilder sb = new StringBuilder();
        do {
            j = nextIndex[i];
            //preint from i to nectIndex[i] which is j
            for (int k = i ; k < j ; k++) {
                sb.append(words[k]+" ");
            }
            sb.append("\n");
            // assign i to nextIndex[i]
            i = j;
        } while ( j < words.length);
        return sb.toString();

    }
    public static void main(String[] args) {

        String words1[] = {"aaa", "bbb", "c", "d", "ee", "ff", "ggggggg"};
        System.out.println(justifyText(words1, 11));
    }
}
