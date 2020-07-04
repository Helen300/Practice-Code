// JAVA has a bitset class

// HOW MANY BITS TO REPRESENT
// USUALLY WHEN INVOLVING MEMORY, GOOD IDEA TO USE BITS

class BitSet { 
	// array to represent size num of bits 
	int[] bitset;

	public BitSet(int size) {

		// divide by 32 bc each int represents 32 bits
		bitset = new int[(size >> 5) + 1]; 

	}

	boolean get(int pos) {
		// because each int = 32 bits, we must 
		// find the int offset 
		int wordNumber = (pos >> 5);
		// mod 32 to get the bit offset within that int
		int bitNumber = (pos & 0x1F); 
		// & with a mask to get its bit set at given position (bit wise pos)
		return ((bitset[wordNumber]) & (1 << bitNumber)) != 0; 

	}

	void set(int pos) {
		// find the int offset 
		int wordNumber = (pos >> 5);
		// mod 32 to get the bit offset within that int
		int bitNumber = (pos & 0x1F); 
		bitset[wordNumber] |= 1 << bitNumber;
	}
}

void checkDuplicates(int[] array) {
	BitSet bs = new BitSet(32000); 
	for (int i = 0; i < array.length; i++) {
		int num = array[i];
		// bit set starts at 0, nums start at 1 
		int num0 = num - 1; 
		if (bs.get(num0)) {// TRUE ALRDY EXIST THEREFORE DUP
			System.out.println(num);
		} else {
			bs.set(num0);
		}
	}
}