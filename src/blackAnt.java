/**
 * Implementation of "Black Ant" class.
 * @author Stavratis Konstantinos AEM: 3137
 */

import java.util.ArrayList;
import java.util.Collections;

public class blackAnt extends Ant {

    private ArrayList<Integer> seedVarieties;

    /**
     * Constructor of black ant.
     * @param id of ant. Only even ids are considered black ants.
     * @param Xcoordinate of ant. The cartesian plain has only to axes.
     * @param Ycoordinate of ant. The cartesian plain has only to axes.
     * @param seedVarieties all the varieties of seeds (up to 5) that the black ant can carry.
     *                      NOTE: that it can cary ANY number from THOSE (up to five) varieties.
     */
    public blackAnt(int id, double Xcoordinate, double Ycoordinate, ArrayList<Integer> seedVarieties){
        super(id, Xcoordinate, Ycoordinate);
        /*
        Checking in the internal constructor whether the constructor of mother class "Ant" was implemented successfully.
         */
        if(this.getColour()){
            throw new java.lang.Error("This 'blackAnt' object is not black.");
        }
        /*
        The content of the given Integer ArrayList is copied to the object SORTED.
        This will be useful when implementing the change-making problem.
        If you desire to do so, ordering and unordering must be removed from class "changeMakingProblem".
         */
        //Collections.sort(seedVarieties);

        this.seedVarieties = new ArrayList<>();
        this.seedVarieties.addAll(seedVarieties);
    }

    public ArrayList<Integer> getSeedVarieties(){ return seedVarieties; }
    public Integer getVariety(int variety) { return seedVarieties.get(variety); }

    public double getEuclidianDistanceFromRedAnt(redAnt a){
        return  Math.sqrt(Math.pow(this.getXcoordinate()-a.getXcoordinate(),2) + Math.pow(this.getYcoordinate()-a.getYcoordinate(),2));
    }
}
