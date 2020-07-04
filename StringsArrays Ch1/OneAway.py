from sys import argv, stderr, exit
from os import path 


def main(argv):

	print('program Name: ' + argv[0])
	# print('string is: ' + argv[1])
	string1 = argv[1]
	string2 = argv[2]
	oneAway(string1, string2)

# we have to go through each of the letters in both strings once therefore 
# runtime is at least O(n) where n = length of shorter string (by 1 char), either works tbh
# O(1) if strings are very different in length 
def oneAway(original, new):
	# insertion, replacement, deletion

	if (len(original) == len(new)):
		return checkReplacement(original, new)
	elif (len(original) + 1 == len(new)):
		return checkEdit(original, new)
	elif (len(original) - 1 == len(new)):
		return checkEdit(new, original)

	print(original + ' and ' + new + ' are not one edit away')
	return False

# everything else must be the same in the same index except 1 character 
def checkReplacement(original, new):
	print('replacing')
	foundDiff = False
	for i in range(len(original)):
		# if we found a difference 
		if original[i] != new[i]:
			# but it is not the first difference found 
			# next time another diff is found, this will be true we must break
			if (foundDiff):
				print(original + ' and ' + new + ' are not one edit away')
				return False
			# we found a difference, set it true 
			foundDiff = True
	if foundDiff == False: 
		print(original + ' and ' + new + ' are the same')
		return True
	print(original + ' and ' + new + ' are one edit away')
	return True

# everything else must be the same in the same index except 1 character 
def checkEdit(original, new):
	foundDiff = False
	i1 = 0 
	i2 = 0 
	while (i2 < len(new) and i1 < len(original)): 
		# if we found a difference 
		if original[i1] != new[i2]:
			# but it is not the first difference found 
			# next time another diff is found, this will be true we must break
			if (i1 != i2):
				print(original + ' and ' + new + ' are not one edit away')
				return False
			# we found a difference, set it true 
			else:
				i2 += 1
		else:
			i1 += 1
			i2 += 1
	print(original + ' and ' + new + ' are one edit away')
	return True



if __name__ == '__main__':
	main(argv)