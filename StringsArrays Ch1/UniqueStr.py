
from sys import argv, stderr, exit
from os import path 
# DETERMINE IF A GIVEN STRING IS UNIQUE

# EXTENDED ASCII HAS 256 CHARACTERS
# REGULAR ASCII HAS 128 CHARACTERS

def uniqueStrInt(string): 
	if len(string) == 1 or len(string) == 0: 
		print('string is unique: ', string)
		return True
	if len(string) > 128:
		print('string is not unique: ', string)
		return False
	else: 
		checker = 0 
		# when you | (bitwise or) two numbers, you add them 
		for i in string:
			# assumes that the string only uses lowercase letters (a - z)
			val = ord(i) - ord('a')
			# left shift bit 
			# 1 * 2^(val)
			# & operator copies bit to result if exists in both 
			# if bit gets copied, this means that value must be greater than 0 
			# bc of this, we only use lowercase letters from a to z 
			if ((checker & (1 << val)) > 0):
				print('string is not unique: ', string)
				return False
			# copies bit if exists in either operand
			# therefore, we keep track of all the bits we've seen 
			checker |= ( 1 << val)
		print('string is unique: ', string)
		return True


# uses boolean array to check for unique characters 
# FOR ASCII CHARACTERS, CHECK IF STRING IS UNIQUE
""" uses a additional array so space would be o[1] 
	however bc our array is dependent on the 
	alphabet and not the length of the string """

""" time complexity = O(n), n = len of string, but
	can also argue that it'll be O(1) since we'll
	never iterate more than 128 characters if all
	are unique """

""" FOR non-assuming fixed character set, we can
	express complexity as O(c) = space, 
	O(min(c,n)) for time, c = size of character set """
def uniqueStrBool(string):
	# if only one character or none, must be unique
	if len(string) == 1 or len(string) == 0: 
		print('string is unique: ', string)
		return True
	# cannot form a unique string out of whats more than alphabet 	
	if len(string) > 128:
		print('string is not unique: ', string)
		return False
	else:
		# initializes boolean array with all False len (128)
		boolUnique = [False] * 128
		for i in string:
			index = ord(i)
			#print(index)
			if boolUnique[index]:
				print('string is not unique: ', string)
				return False
			else:
				boolUnique[index] = True
		print('string is unique: ', string)
		return True



def main(argv):
	print('program Name: ' + argv[0])
	# print('string is: ' + argv[1])
	uniqueStrBool(argv[1])
	uniqueStrInt(argv[1])



if __name__ == '__main__':
	main(argv)