""" Given two strings, s1 and s2, determine whether or
	not s2 is a rotation of s1 using only one call to
	isSubstring function (checks if one word is a 
	substring of another word) """

from sys import argv, stderr, exit
from os import path 


def main(argv):

	print('program Name: ' + argv[0])
	# print('string is: ' + argv[1])
	string1 = argv[1]
	string2 = argv[2]
	stringRotation(string1, string2)


def stringRotation(s1, s2):
	# regardless of division of rotation x and y
	# given s1 = xy
	# and s2 = yx 
	# we know that yx will always be a substring of xyxy
	# check that they are of equal length, not zero 
	if (len(s1) == len(s2) and len(s1) > 0):
		bigStr = s1 + s1
		# print(bigStr)
		if s2 in bigStr:
			print(s2 + ' is a rotation of ' + s1);
			return True 
	print(s2 + ' is not a rotation of ' + s1);
	return False


if __name__ == '__main__':
	main(argv)