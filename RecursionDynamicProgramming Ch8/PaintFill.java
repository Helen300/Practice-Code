// Paint fill 
// GIVEN: 
// screen (2d array of colors)
// point
// new color

// TO DO: 
// fill surrounding area until color changes from original



// dfs


enum Color {Black, White, Red, Yellow, Green}

boolean PaintFill(Color[][] screen, 
				  int r, int c, 
				  Color ncolor) {

	// is alreayd that color...
	if (screen[r][c] == ncolor) return false; 
	// current color and color to change to
	return PaintFill(screen, r, c, screen[r][c], ncolor);

}

// DEPTH FIRST SEARCH
// TRAVERSING ALL SURROUNDING PIXELS

boolean PaintFill(Color[][] screen, 
				  int r, int c, 
				  Color ocolor, 
				  Color ncolor) {

	// BASE out of Bound 
	if (r < 0 || r >= screen.length || c < 0 || c>=screen[0].length) {
		return false; 
	}

	if (screen[r][c] == ocolor) {
		screen[r][c] = ncolor;  // color it 
		// then keep coloring to each side all the way
		PaintFill(screen, r - 1, c, ocolor, ncolor); // up
		PaintFill(screen, r + 1, c, ocolor, ncolor); // down
		PaintFill(screen, r, c - 1, ocolor, ncolor); // left
		PaintFill(screen, r, c + 1, ocolor, ncolor); // right
	}
	return true; 
}