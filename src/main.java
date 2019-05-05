/**
 * main function of the program.
 * @author Stavratis Konstantinos AEM: 3137
 */

import java.util.*;

public class main {
    public static void main(String[] args) {

        double startTime = System.nanoTime();

        System.out.println("TESTING WRITE FILE:");
        writeFile writeFile = new writeFile();
        //writeFile writeFile = new writeFile(args);

        System.out.println("TESTING WRITE FILE - MST");
        writeFile.writeMSTproblem();
        System.out.println("TESTING WRITE FILE - Stable Marriage problem");
        writeFile.writeStableMarriageProblem();
        System.out.println("TESTING WRITE FILE - Change making problem");
        writeFile.writeChangeMakingProblem();


        double endTime = System.nanoTime();

        System.out.println("Took " + (endTime-startTime)*0.000000001 + " seconds to complete objective A, B and C." );


    }
}
