from sys import argv, stderr, exit
from os import path 


# determines whether or not a given stringis a permutation of a palindrome
# PALINDROME = WORD/PHRASE THAT READS THE SAME BACKWARDS/FORWARDS


def main(argv):

	print('program Name: ' + argv[0])
	# print('string is: ' + argv[1])
	string1 = argv[1]
	palindromePerm(string1)


# determines whether or not it is a palindrome permutation via odd counts of letters
def palindromePerm(string):
	stringNoSpace = string.replace(" ", "")
	# print(string), removes spaces from the world 
	oddCount = 0
	charTable = [0] * 26
	for i in stringNoSpace:
		index = getCharNum(i)
		charTable[index] += 1
		if charTable[index] % 2 != 0:
			oddCount += 1
		else:
			oddCount -= 1
	print(oddCount)
	if oddCount > 1:
		print(string + ' not a permutation of a palindrome')
		return True
	else:
		print(string + ' is a permutation of a palindrome')
		return False



# maps character to a number, case insensitive
# non letters map to -1 
def getCharNum(c):
	# takes all and makes it uppercase 
	c = c.upper()
	val = ord(c)
	# returns a proper index between 0-25
	return val - ord('A')


if __name__ == '__main__':
	main(argv)