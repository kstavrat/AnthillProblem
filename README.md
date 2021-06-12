# Anthill Problem
Project requested for the needs of the 4th semester subject "Algorithms" of the Aristotle University of Thessaloniki.

Red and black ants live in an anthill.
1. The point where each ant is located is determined by (given) coordinates (x,y) , where (x,y) belong in R^2.
2. The black ants collect their food (seeds) in some locations, from which the red ants carry them back to the anthill.
3. The red ants are equal in number as the black ones. The red ones have a odd-number Id, while the black ones have an even-number Id.
4. The red ants carry a basket of different seed capacity.
5. The black ants carry seeds of multiple varieties.
6. Each seed variety has a different weight.
7. Each black ant chooses whichever 5 varieties it wants.
At a certain point of time, we have data of the following structure for all ants

Id         x  y Coordinates       Other Information

1(red)     0.123 0.876          1567 (basket capacity , integer)

2 (black)  0.821 0.526          12 14 34 46 24 (weight of each seed variety , integers)

3 (red)    0.345 0.653          1002 (basket capacity , integer)

4 (black)  0.812 0.913          42 44 24 26 14 (weight of each seed variety , integers)

...

Implement a program which executes the following independent operations:

OPERATION Α
The ants decide not to move again, until the decide the shortest path network (Minimum Spanning Tree) which links all the ants. Find that network using the Kruskal+Union algorithm efficiently (suppose that the distances are Euclidean).

OPERATION B
The red ants have to make pairs with the red ants, so that they put the seeds into the baskets. The ants prefer to make pairs with the closest ant of different colour. Make pairs of ants applying efficinently the stable marriage algorithm (Gale Shapley), on the assumption that red ants propose (the distances are Euclidean).

OPERATION C
Suppose that the 1st red ant (id=1) and the 1st black ant (id=2) make pair. The red ant wants to check whether it can fill its basket FULLY, with as less seed varieties that the black ant offers as possible Check whether there is such a way and which is it for every pair (in the order in which they exist in the input data), efficiently using a dynamic programming algorithm.
The problem is similar to coin change problem.

Implementation remarks:
1.
The input will be read from a .txt file which follows the format mentioned above, that is:

1

0.123 0.876 1567

2

0.821 0.526 12 14 34 46 24

3

0.345 0.653 1002

4

0.812 0.913 42 44 24 26 14

...

The data should be separated with whitespaces or tabs.
The name of the file is to be given as a single argument to the executable jar file in the command prompt (warning: it should be read from the same directory executable jar is in without needing to define a path).


2. The resulting output for operation A is to be a txt file where the first line has the total value of the MST, while the next lines are to be pairs of ids of ants which form edges (with the smallest id being referred first), sorted by the first id, followed by the second, e.g.
1422.654

1 4

2 7

2 12

3 5

...

The Ids are to be separated by spaces or tabs.
The file must be stored in the same directory (just like before, without specifying a path).


3. The results for operation B are extracted as a txt file whose lines include the final pairs of ids (odd and even) of the ants of the stable marriage, sorted by the first id, e.g. ,

1 8

3 6

5 4

...

The data are to be separated with whitespaces or tabs.
The name of the file is to be given as a single argument to the executable jar file in the command prompt (warning: it should be read from the same directory executable jar is in without needing to define a path).

4. The output of operation C is to be a txt file whose llines will contain the pairs of ids (odd and even) of the ants which have successfully filled their baskets fully, sorted by the the first id, followed by 5 integers which express the number of times each seed was selected, e.g.

5 6  6 1 4 0 31 17

11 12   0 0 11 24 3

...

The results of each line are to be separated by spaces or tabs.
The file is to be stored in the same directory (without defining a path).

5. The moment the program receives the input data as an argument must execute operations A, B, C and produce the corresponding results.

6. Use Java 1.8

7. The source code should contain short inline comments wherever necessary, and long comments above each function, which explain the train of thought for your implementation.
