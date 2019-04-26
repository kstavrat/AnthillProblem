/**
 * In this class, the three wanted operations (ΛΕΙΤΟΥΡΓΙΑ Α, ΛΕΙΤΟΥΡΓΙΑ Β, ΛΕΙΤΟΥΡΓΙΑ Γ) are made available to the user
 * through one class.
 * @author Stavratis Konstantinos AEM: 3137
 */

import java.util.ArrayList;

public class Algorithms {

    private changeMakingProblem changeMakingProblem;
    private minimumSpanningTreeProblem minimumSpanningTreeProblem;

    public Algorithms(){
        changeMakingProblem = new changeMakingProblem();
        //minimumSpanningTreeProblem = new minimumSpanningTreeProblem();
    }

    /**
     * This is the change-making problem implementation (ΛΕΙΤΟΥΡΓΙΑ Γ)
     * @param coinVarieties the different values of seeds the black ant can carry.
     * @param basketMaximumCapacity the basket capacity of the red ant.
     * @returnan array list containing the number of times each seed is needed.
     * Should there be no such combination, an empty array list is returned.
     */
    public ArrayList<Integer> changeMakingProblem(ArrayList<Integer> coinVarieties, int basketMaximumCapacity){
       return changeMakingProblem.run(coinVarieties,basketMaximumCapacity);
    }
}
