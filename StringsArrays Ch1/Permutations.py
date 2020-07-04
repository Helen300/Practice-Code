from sys import argv, stderr, exit
from os import path 





def main(argv):
	print('program Name: ' + argv[0])
	# print('string is: ' + argv[1])
	string1 = argv[1]
	string2 = argv[2]
	permutations(string1, string2)

# Assume whitespace is significant, case sensitive 

def permutations(str1, str2):
	# strings of different lengths cannot be permutations
	if len(str1) != len(str2):
		print(str1 + ' and ' + str2 + ' are not permutations')
		return False

	# sort strings


	# check for identical character counts
	# permutations must have same number of characters 
	charTable = [0] * 128
	# first increment count of each letter by going through one string 
	for i in str1:
		index = ord(i)
		charTable[index] += 1 

	# decrement the counts in another string 
	for i in str2:
		index = ord(i)
		charTable[index] -= 1
		# if ever negative, this means that they are not permutations
		# can break immediately 
		if (charTable[index] < 0):
			print(str1 + ' and ' + str2 + ' are not permutations')
			return False
	print(str1 + ' and ' + str2 + ' are permutations')
	return True




if __name__ == '__main__':
	main(argv)