/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int s = 0;
        int e = n; 

        return guessRecursively(s, e);
    };

    private int guessRecursively(int s, int e){

        int m = s + (e - s) / 2;

        int check = guess(m);

        if(check == 0){
            return m;
        }

        if(check == -1){
            return guessRecursively(s, m - 1);
        } else {
            return guessRecursively(m + 1, e);
        }
    }
}