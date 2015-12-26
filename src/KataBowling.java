public class KataBowling {
    public static int calc(String s) {
        // initialize result with 0 to sum up the rolls
        int result = 0;
        for(int i = 0; i < s.length(); i++){
            //for every single roll evaluate value
            String current = s.substring(i,i+1);
            if (isOneOfTheLastTwoRollsAndPreviousWasStrike(s,i)){
                // continue means jump directly to the next loop iteration and ignore switch(case
                continue;
            }
            switch (current){
                case "-": break;
                //in case of spare call spare method and add result to result variable
                case "/": {
                    result = result + spare(s, i);
                    break;
                }
                case "X": {
                    result = result + strike(s, i);
                    break;

                }
                default: {
                    //result++ begin from 0, except it is the bonus roll (previous roll was last frame of the game and spare-->method)
                    if ( i == 0 || !isLastRollAndPreviousWasSpare(s, i)){
                        result = result + Integer.parseInt(current);
                    }
                }
            }

        }
        //return summed up rolls
        return result;
    }

    //returns true, iff i is one of the last two rolls of the game and third-last roll of the game was a strike
    private static boolean isOneOfTheLastTwoRollsAndPreviousWasStrike(String s, int i) {
    return (s.substring(s.length()-3, s.length() - 2).equals("X")&& i >= s.length()-2);
    }

    //returns true, iff(if and only if) previous roll was spare and current roll is the last roll of the game
    private static boolean isLastRollAndPreviousWasSpare(String s, int i) {
        return (s.substring(i-1, i).equals("/")&& i == s.length()-1);
    }
    private static int strike(String s, int i) {
        int currentValue = 10;
        //look to result next rolls, sum = result strike value
        int nextValue = evaluateIntegerValue(s, i+1);
        int nextNextValue = evaluateIntegerValue(s, i+2);
        return currentValue + nextValue + nextNextValue;
    }



    private static int spare(String s, int i) {

        int currentValue = evaluateIntegerValue(s, i);
        //look to result next roll, sum = result spare value
        //evaluate IntegerValue of String Next (außerhalb der Klammer wird die Variable deklariert)
        int nextValue = evaluateIntegerValue(s, i+1);
            return currentValue + nextValue;
    }

    private static int evaluateIntegerValue(String wholeGame, int rollToEvaluate) {
        //get the single roll at index rollToEvaluate from the wholeGame String
        String stringValue = wholeGame.substring(rollToEvaluate, rollToEvaluate +1);

        //return the integer value of the single roll
        switch (stringValue) {
            case "-":
                return 0;
            case "/": {
                int previousValue = evaluateIntegerValue(wholeGame, rollToEvaluate - 1);
                return 10 - previousValue;
            }
            case "X":
                return 10;
            default:
                return Integer.parseInt(stringValue);
        }
    }
}
