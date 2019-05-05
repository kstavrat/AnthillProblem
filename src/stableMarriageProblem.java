/**
 * @author Stavratis Konstantinos AEM: 3137
 */

import java.util.*;

public class stableMarriageProblem {

    private Map<redAnt, ArrayList<blackAnt>> preferencesOfRedAnts = new HashMap<>();
    private Map<blackAnt, ArrayList<redAnt>> preferencesOfBlackAnts = new HashMap<>();

    private LinkedList<redAnt> listSeparatedRedAnts;
    private LinkedList<blackAnt> listSeparetedBlackAnts;

    /**
     * This is the contructor of the stableMarriageProblem.
     *
     * @param receivedDataAllAnts all the ants of the problem in linked list form.
     */
    public stableMarriageProblem(LinkedList<Ant> receivedDataAllAnts) {


        ArrayList<redAnt> arraySeparatedRedAnts = new ArrayList<>();
        ArrayList<blackAnt> arraySeparatedBlackAnts = new ArrayList<>();

        listSeparatedRedAnts = new LinkedList<>();
        listSeparetedBlackAnts = new LinkedList<>();
        /*
        Parse all the data once with complexity O(n) to separate the red from the black ants.
         */
        for (Ant x : receivedDataAllAnts) {
            if (x instanceof redAnt) {
                listSeparatedRedAnts.add((redAnt) x);
            }
            if (x instanceof blackAnt) {
                listSeparetedBlackAnts.add((blackAnt) x);
            }
        }

        arraySeparatedRedAnts.addAll(listSeparatedRedAnts);
        arraySeparatedBlackAnts.addAll(listSeparetedBlackAnts);

        /*
        Creating preferencesOfRedAnts
         */
        for (int i = 0; i < arraySeparatedRedAnts.size(); i++) {
            ArrayList<blackAnt> temp = new ArrayList<>();
            for (int j = 0; j < arraySeparatedBlackAnts.size(); j++) {
                temp.add(arraySeparatedBlackAnts.get(j));
            }
            preferencesOfRedAnts.put(arraySeparatedRedAnts.get(i), temp);
        }

        /*
        Sorting preferencesOfRedAnts according ascending from closer to father from the key red ant.
         */
        for (redAnt red : preferencesOfRedAnts.keySet()) {

            preferencesOfRedAnts.get(red).sort(new Comparator<blackAnt>() {
                @Override
                public int compare(blackAnt o1, blackAnt o2) {
                    if (o1.getEuclidianDistanceFromRedAnt(red) > o2.getEuclidianDistanceFromRedAnt(red)) { return 1; }
                    else { if (o1.getEuclidianDistanceFromRedAnt(red) == o2.getEuclidianDistanceFromRedAnt(red)) { return 0;} }
                    return -1;
                }
            });

        }

        /*
        Creating preferencesOfBlackAnts
         */
        for (int i = 0; i < arraySeparatedBlackAnts.size(); i++) {
            ArrayList<redAnt> temp = new ArrayList<>();
            for (int j = 0; j < arraySeparatedRedAnts.size(); j++) {
                temp.add(arraySeparatedRedAnts.get(j));
            }
            preferencesOfBlackAnts.put(arraySeparatedBlackAnts.get(i), temp);
        }

        /*
        Sorting preferencesOfRedAnts according ascending from closer to father from the key red ant.
         */

        for (blackAnt black : preferencesOfBlackAnts.keySet()) {

            preferencesOfBlackAnts.get(black).sort(new Comparator<redAnt>() {
                @Override
                public int compare(redAnt o1, redAnt o2) {
                    if (o1.getEuclidianDistanceFromBlackAnt(black) > o2.getEuclidianDistanceFromBlackAnt(black)) { return 1; }
                    else { if (o1.getEuclidianDistanceFromBlackAnt(black) == o2.getEuclidianDistanceFromBlackAnt(black)) { return 0; } }
                    return -1;
                }
            });
        }
    }


    public TreeMap<redAnt, blackAnt> run() {

        TreeMap<blackAnt,redAnt> matchings = new TreeMap<>(new Comparator<blackAnt>() {
            @Override
            public int compare(blackAnt o1, blackAnt o2) {
                if(o1.getId()>o2.getId()){ return 1; }
                else{ if(o1.getId()==o2.getId()){ return 0; } }
                return -1;
            }
        });

        LinkedList<redAnt> freeRedAnts = new LinkedList<>();
        freeRedAnts.addAll(listSeparatedRedAnts);

        while(!(freeRedAnts.isEmpty())){ //a free red ant has a black ant to propose to.
            redAnt currentRedAnt = freeRedAnts.remove(0);
            ArrayList<blackAnt> currentRedAntPrefers = preferencesOfRedAnts.get(currentRedAnt);

            for(blackAnt black: currentRedAntPrefers){
                if(matchings.get(black)==null){//if black ant is free
                    matchings.put(black,currentRedAnt); //(current red ant, black) become engaged.
                    break;
                }
                else{ //some red ant - black ant pair already exists.
                    redAnt engagedRedAnt = matchings.get(black);
                    ArrayList<redAnt> currentBlackAntPrefers = preferencesOfBlackAnts.get(black);
                    if(currentBlackAntPrefers.indexOf(currentRedAnt)<currentBlackAntPrefers.indexOf(engagedRedAnt)){
                        //If black ant prefers the engaging ant more than the one it is already engaged to.
                        freeRedAnts.add(engagedRedAnt); //engaged black ant becomes free
                        matchings.put(black,currentRedAnt); //current red ant and black ant become engaged.

                        break;
                    }
                }
            }
        }

        /*
        Reverting the order of the ids from the even numbers to the odd ones.
         */
        TreeMap<redAnt,blackAnt> matchingsFinal = new TreeMap<>(new Comparator<redAnt>() {
            @Override
            public int compare(redAnt o1,redAnt o2) {
                if(o1.getId()>o2.getId()){ return 1; }
                else{ if(o1.getId()==o2.getId()){ return 0; } }
                return -1;
            }
        });

        for(blackAnt black : matchings.keySet()){
            matchingsFinal.put(matchings.get(black),black);
        }
        return matchingsFinal;
    }


}
