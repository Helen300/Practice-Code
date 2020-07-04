// Check if linked list = Palindrome



/* SOLUTION 1 (pg 217)
 * Reverse and compare 
 * reverse Linked list, compare reversed to original list
 * list reversal ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * 1. iterate through list
 * 2. as iterating, set the current nodes next
 * 3. to be the previous current node 
 * 4. building up so that end is now head of the reversed list
 * 5. check reversed w/ original 
 * 6. if it is the same then it is a palindrome 
 */ 



/* SOLUTION 2 (pg 218)
 * Iterative Approach
 * Detect linked list where first half = second half reversed
 * with a stack ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * 1. find length of stack 
 * to find length #######################################
 	perhaps use fast and slow runner
 	- by the time slow runner has reached middle, fast has reached end
 	- fast will know length 
 * 2. depending on even and odd we know when to stop push
 * 3. when to start pop
 * 4. once we reached the end of first half, we can start
 * 5. popping off and checking with second half of list
 * 6. if no difference found it is palindrome
 */ 


/* SOLUTION 3 (pg 219)
 * Recursive Approach
*/

