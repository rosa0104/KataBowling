/**
 * Created by Thiemo on 19.12.2015.
 */
public class KataBowling {
    public static int calc(String s) {
        // initialize result with 0 to sum up the rolls
        int result = 0;
        for(int i = 0; i < s.length(); i++){
            //for every single roll evaluate value
            String current = s.substring(i,i+1);
            switch (current){
                case "-": break;
                //in case of spare call spare method and add result to result variable
                case "/": {
                    result = result + spare(s, i);
                    break;
                }
                default: {
                    //result++ begin from 0, except it is the bonus roll (previous roll was last frame of the game and spare-->method)
                    if ( i == 0 || isLastRollAndPreviousWasSpare(s, i)){
                        result = result + Integer.parseInt(current);
                    }
                }
            }

        }
        //return summed up rolls
        return result;
    }
    //returns true, iff(if and only if) previous roll was spare and current roll is the last roll of the game
    private static boolean isLastRollAndPreviousWasSpare(String s, int i) {
        return !(s.substring(i-1, i).equals("/")&& i == s.length()-1);
    }

    private static int spare(String s, int i) {
        //look to result previous roll, 10 - result
        String previous = s.substring(i - 1, i);

        int previousValue;
        if (previous.equals("-")){
            //- = 0 cannot be parsed
            previousValue = 0;
        }else {
            previousValue = Integer.parseInt(previous);
        }

        int currentValue = 10 - previousValue;
        //look to result next roll, sum = result spare value
        String next = s.substring(i+1, i+2);
        int nextValue = Integer.parseInt(next);
        return currentValue + nextValue;
    }
}
