package Subsets;

import java.util.*;

public class Hard_EvaluateExpression {

    public static List<Integer> evaluateExpressions(String input) {

        List<Integer> result = new ArrayList<>();
        Map<String, List<Integer>> map = new HashMap<>();

        if(map.containsKey(input))
            return map.get(input);
        if (!input.contains("+") && !input.contains("-") && !input.contains("*"))
            result.add(Integer.parseInt(input));
        else {

            for (int i = 0; i < input.length(); i++) {
                if (!Character.isDigit(input.charAt(i))) {

                    List<Integer> leftPart = evaluateExpressions(input.substring(0, i));
                    List<Integer> rightPart = evaluateExpressions(input.substring(i + 1));

                    Character symbol = input.charAt(i);
                    for (int part1 : leftPart) {
                        for (int part2 : rightPart) {

                            if (symbol == '+')
                                result.add(part1 + part2);
                            if (symbol == '-')
                                result.add(part1 - part2);
                            if (symbol == '*')
                                result.add(part1 * part2);
                        }
                    }
                }
            }
        }
        map.put(input, result);
        return result;
    }

    public static void main(String[] args) {
        List<Integer> result = evaluateExpressions("1+2*3");
        System.out.println("Expression evaluations: " + result);

        //result = EvaluateExpression.diffWaysToEvaluateExpression("2*3-4-5");
        //System.out.println("Expression evaluations: " + result);
    }
}
