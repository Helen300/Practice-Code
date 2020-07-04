"""
	Q: Give img rep by NxN matrix, where each pixel in the img = 4 bytes.
	Write a method to rotate imag eby 90 degrees. Do it in place. 


"""


"""

	My Thoughts: 
	1. why is the each pixel in img = 4 bytes important?

"""

from sys import argv, stderr, exit
from os import path 

def main(argv):
	print('program Name: ' + argv[0])
	# print('string is: ' + argv[1])
	# need to properly read in a 2d ARRAY 
	rotateMatrix(matrix)



# must be O(n^2) bc we need to touch all elements 
def rotateMatrix(matrix):
	if len(matrix) == 0 or (len(matrix) != len(matrix[0])):
		# cannot be roated
		print(len(matrix))
		print(len(matrix[0]))
		print(len(matrix) != len(matrix[0]))
		return False

	# start from outermost layer, rotate each layer one by one 
	n = len(matrix)
	for i in range(0, int(n/2)):
		first = i
		last = n - 1 - i

		for j in range (first , last):
			offset = i - first
			# saving the top 
			top = matrix[first][i]
			# left -> top 
			matrix[first][i] = matrix[last - offset][first]
			# bottom -> left 
			matrix[last - offset][i] = matrix[last][last - offset]
			# right -> bottom 
			matrix[last][last - offset] = matrix[i][last]
			# top -> right (top was saved earlier)
			matrix[i][last] = top

	return True



if __name__ == '__main__':
	main(argv)