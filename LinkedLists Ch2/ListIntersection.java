/* Determine if two linked list interesect ( by reference) and 
 * where they intersect 
 * 1. Running through each linked to get lengths + tails
 * 2. if tails not same - they don't, can just return false
 * 3. if tails same, they intersect 
 * 4. we can use lengths to find out how much longer on is than the other
 * 5. set pointers at head
 * 6. for longer list, advance pointer by diff in length
 * 7. traverse until pointers are same to find intersection */


// ALG takes O(A + B) time where A, B are lengths of two linked list
// must traverse both initially for lengths + tail nodes 
// space O(1) additional space
