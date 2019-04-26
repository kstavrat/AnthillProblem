/**
 * Implementation of the Change Making Problem, needed for the 3rd part of the project.
 * @author Stavratis Konstantinos AEM: 3137
 */

import java.util.ArrayList;
import java.util.Collections;

public class changeMakingProblem {

    public changeMakingProblem(){}

    /**
     * This is the change-making problem implementation (ΛΕΙΤΟΥΡΓΙΑ Γ)
     * @param unsortedCoinVarieties the different values of seeds the black ant can carry.
     * @param basketMaximumCapacity the basket capacity of the red ant.
     * @return an array list containing the number of times each seed is needed.
     * Should there be no such combination, an empty array list is returned.
     */
    public ArrayList<Integer> run(ArrayList<Integer> unsortedCoinVarieties, int basketMaximumCapacity){

        ArrayList<Integer> sortedCoinVarieties = new ArrayList<>();
        sortedCoinVarieties.addAll(unsortedCoinVarieties);
        Collections.sort(sortedCoinVarieties);

        /*
        Keep track of the changes that were made.
         */
        int[] antistoixies = new int[sortedCoinVarieties.size()];
        for(int i=0; i<sortedCoinVarieties.size(); i++){
            for(int j=0 ; j<unsortedCoinVarieties.size(); j++){
                if(sortedCoinVarieties.get(i)== unsortedCoinVarieties.get(j)){
                    antistoixies[i] = j;
                }
            }
        }
        /*
        This is the closest somebody can get in the Java programming language.
        Integer allocates 4 bytes in memory, which is equal to 32 bits.
        Taking into account that 1 bit is used for the sign of the number,
        the maximum value a 31 bit number can produce is
        2^(31) = 2,147,483,648
        In any case, if the input is higher than this number, then integer overflow will take place.
        More specifically MAX_VALUE + 1 = 2,147,483,648 + 1 --> -2147483648 (integer overflow).
        For this specific reason the value 1 is subtracted from the "Integer.MAX_VALUE";
        When deciding the value of the cell of the table with the command: table[i][j] = Math.min(table[i-1][j], 1+ numberOfCoins)
        had there not been this subtraction, as mentioned previously, the integer overflow will cause the number to
        have the minimum value an int32 can support. Therefore, it will take the value -2147483648 instead of the one
        it is supposed to.

         */
        int infinity = Integer.MAX_VALUE-1;
        int m = sortedCoinVarieties.size() + 1;
        int n = basketMaximumCapacity + 1;
        int[][] table = new int[m][n];

        /*
        No coins are given back when there is no more change needed (remaining change = 0)
         */
        for(int i=1; i<m;i++){
            table[i][0] = 0;
        }
        /*
        An "infinite" amount of coins with the value "zero" (0) are given.
         */
        for(int i=1; i<n; i++){
            table[0][i] = infinity;
        }
        /*
        NOTE: Position table[0][0] is not accessible, as it is an invalid state of the problem.
        Java automatically initiates it to zero (0).
         */

        int numberOfCoins;
        /*
        Iterators "i" and "j" start from 1, as the first line and column are of no interest to the algorithm.
         */
        for (int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(j - sortedCoinVarieties.get(i-1)>=0){
                    numberOfCoins = table[i][j-sortedCoinVarieties.get(i-1)];
                }
                else{
                    numberOfCoins = infinity;
                }
                table[i][j] = Math.min(table[i-1][j], 1+ numberOfCoins);
            }
        }

        /*
        Back tracking to calculate the amount of times each seed is used.
         */

        //Initializing all counter to zero (0).
        ArrayList<Integer> sortedCountersOfSeeds = new ArrayList<>();
        ArrayList<Integer> unsortedCountersOfSeeds = new ArrayList<>();

        /*
        If the last place of the table is infinity, that means that there can be no combination of coins
        to satisfy the Change-Making problem.
        Therefore, only when the last element of the table is different than infinity is the back tracking initiated.
         */
        if(table[m-1][n-1]!=infinity) {
            for (int i = 0; i < sortedCoinVarieties.size(); i++) {
                sortedCountersOfSeeds.add(0);
            }
            int i = m - 1;
            int j = n - 1;
            while (i > 0) {
                if (table[i][j] < table[i - 1][j]) {
                    sortedCountersOfSeeds.set(i - 1, sortedCountersOfSeeds.get(i - 1) + 1);
                    j -= sortedCoinVarieties.get(i - 1);
                } else {
                    i--;
                }
            }

        /*
        Re-unorder the set.
         */
            unsortedCountersOfSeeds.addAll(sortedCountersOfSeeds);
            for (int k = 0; k < sortedCoinVarieties.size(); k++) {
                unsortedCountersOfSeeds.set(antistoixies[k], sortedCountersOfSeeds.get(k));
            }
        }

        return unsortedCountersOfSeeds;
    }
}
