package AntsClasses; /**
 * Implementation of "Black AntsClasses.Ant" class.
 * @author Stavratis Konstantinos AEM: 3137  e-mail: kstavrat@csd.auth.gr
 */

import java.util.ArrayList;

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
        Checking in the internal constructor whether the constructor of mother class "AntsClasses.Ant" was implemented successfully.
         */
        if(this.getColour()){
            throw new java.lang.Error("This 'AntsClasses.blackAnt' object is not black.");
        }
        /*
        The content of the given Integer ArrayList is copied to the object SORTED.
        This will be useful when implementing the change-making problem.
        If you desire to do so, ordering and unordering must be removed from class "ObjectiveC.changeMakingProblem".
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

    /**
     * This override will be used for the Hash Map needed in Stable Marriage Problem.
     * @param obj Any object that is compared with a black ant.
     * @return Whether the objects are the same. That is only true if they have the same point
     * (meaning they are the same object) or if they have equal ids.
     */
    @Override
    public boolean equals(Object obj){
        if (obj==null){ return false; }
        if(!(obj instanceof blackAnt)) {return false;}
        if(obj == this){ return true;}
        return (this.getId() == ((blackAnt) obj).getId());
    }

    /**
     * This override will be used for the Hash Map needed in Stable Marriage Problem.
     * @return The key of the black ant is its id.
     */
    @Override
    public int hashCode(){return this.getId();}
}
