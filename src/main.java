/**
 * main function of the program.
 * @author Stavratis Konstantinos AEM: 3137
 */

import java.util.*;

public class main {
    public static void main(String[] args) {


        System.out.println("READING FILE:");
        double startTime = System.nanoTime();
        //writeFile writeFile = new writeFile();
        writeFile writeFile = new writeFile(args);

        System.out.println("WRITING FILE - 'MSToutput.txt'");
        writeFile.writeMSTproblem();
        System.out.println("WRITING FILE - 'StableMarriageProblemOutput.txt'");
        writeFile.writeStableMarriageProblem();
        System.out.println("WRITING FILE - 'ChangeMakingProblemOutput.txt'");
        writeFile.writeChangeMakingProblem();


        double endTime = System.nanoTime();

        System.out.println("Took " + (endTime-startTime)*0.000000001 + " seconds to complete objective A, B and C." );


    }
}
