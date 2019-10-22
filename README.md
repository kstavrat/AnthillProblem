# AnthillProblem
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
Το όνομα του αρχείου αυτού θα πρέπει να δίνεται ως το μοναδικό όρισμα στο εκτελέσιμο αρχείο jar του κώδικά σας κατά την εκτέλεσή του
από command line (προσοχή: πρέπει να διαβάζεται απευθείας από τον ίδιο φάκελο του jar και να μην χρειάζεται pathpath, π.χ. datadata.txt)

2. Η έξοδος των αποτελεσμάτων για την λειτουργία Α θα γίνεται σε αρχείο txt όπου στην πρώτη γραμμή θα έχει το συνολικό βάρος MST,
ενώ στις επόμενες γραμμές του θα έχει τα ζεύγη των Ids των μυρμηγκιών που σχηματίζουν τις ακμές (με το μικρότερο Id να αναγράφεται πρώτο),
ταξινομημένα ως προς το πρώτο Id και κατόπιν ως προς το δεύτερο, π.χ.,
1422.654

1 4

2 7

2 12

3 5

...

Τα Ids πρέπει να χωρίζονται με κενά ή tabs.
Το αρχείο αυτό θα πρέπει να αποθηκεύεται στον ίδιο φάκελο όπως πριν χωρίς path).

3. Η έξοδος των αποτελεσμάτων για την λειτουργία Β θα γίνεται σε αρχείο txt όπου στις γραμμές του θα έχει τα τελικά ζεύγη των Ids (περιττός και άρτιος) των μυρμηγκιώ του ευσταθούς ταιριάσματος, ταξινομημένα ως προς το πρώτο Id, π.χ.,

1 8

3 6

5 4

...

Τα Ids πρέπει να χωρίζονται με κενά ή tabs.
Το αρχείο αυτό θα πρέπει να αποθηκεύεται στον ίδιο φάκελο όπως πριν (χωρίς path).

4. Η έξοδος των αποτελεσμάτων για την λειτουργία Γ θα γίνεται σε αρχείο txt όπου στις γραμμές του θα έχει τα ζεύγη των Ids (περιττός και άρτιος) των μυρμηγκιών στα οποία επιτυγχάνεται πλήρες γέμισμα, ταξινομημένα ως προς το πρώτο Id, και θα ακολουθούν 5 ακέραιοι που θα εκφράζουν πόσες φορές χρησιμοποιήθηκε ο κάθε αντίστοιχος σπόρος, π.χ.

5 6  6 1 4 0 31 17

11 12   0 0 11 24 3

...

Τα αποτελέσματα σε κάθε γραμμή πρέπει να χωρίζονται με κενά ή tabs.
Το αρχείο αυτό θα πρέπει να αποθηκεύεται στον ίδιο φάκελο όπως πριν (χωρίς path).

5. Το πρόγραμμα από τη στιγμή που θα δεχθεί τα δεδομένα της εισόδου θα πρέπει να εκτελέσει τις λειτουργίες Α, Β, Γ και να παράγει τα αποτελέσματα.

6. Να χρησιμοποιήσετε Java 1.8

7..
Ο πηγαίος κώδικας πρέπει να έχει συνοπτικά σχόλια μέσα στον κώδικα (inline) όπου είναι η απαραίτητο, και εκτενή σχόλια επάνω από κάθε συνάρτηση, τα οποία να εξηγούν το σκεπτικό της υλοποίησής σας.
