import java.util.Arrays;

public class AlphaPath {
    public int[][] grid;
    public String hasPath(String[] maze){
        grid = new int[maze.length][maze[0].length()];
        int row=0,col=0;
        for(int j=0; j < maze.length; j++){
            for(int k=0; k < maze[0].length(); k++){
                grid[j][k] = maze[j].charAt(k);   
                if (grid[j][k] == 'A'){
                    row = j;
                    col = k;
                }
            }
        }
        if (path(row,col,'A')){
        	return "YES";
        }
        return "NO";
    }
    public boolean path(int row, int col, int target) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length){
            return false;
        }
        if (grid[row][col] == target) {
            if (target == 'Z') {
                return true;
            }
            int next = target+1;
            return path(row+1,col,next) ||
                   path(row-1,col,next) ||
                   path(row,col-1,next) ||
                   path(row,col+1,next);
        }
        return false;
    }
    public static void print(String[] a) {
    	if (a.length == 1) {
    		System.out.printf("[\"%s\"]\n", a[0]);
    		return;
    	}
    	System.out.printf("[\"%s\",\n", a[0]);
    	for(int k=1; k < a.length-1; k++) {
    		System.out.printf(" \"%s\",\n",a[k]);
    	}
    	System.out.printf(" \"%s\"]\n", a[a.length-1]);
    }
    public static void main(String[] args) {
    	AlphaPath ap = new AlphaPath();
    	String[] x1 = //yes
    		{
    		    "A........",
    		    "BC.......",
    		    ".D....YZ.",
    		    ".EF...X..",
    		    "..GHIJWV.",
    		    "...MLK.UT",
    		    "...NOPQRS",
    		    "........."
    		};
    	String[] x2 = //no
    		{
        		    "A........",
        		    "BC.......",
        		    ".D....ZY.",
        		    ".EF...X..",
        		    "..GHIJWV.",
        		    "...MLK.UT",
        		    "...NOPQRS",
        		    "........."
        		};
    	String[] x3 = {"..............", "..............", "..............", "...DEFGHIJK...", "...C......L...", "...B......M...", "...A......N...", "..........O...", "..ZY..TSRQP...", "...XWVU.......", ".............."};
    	String[] x4 = {"ABC.......", "...DEFGHIJ", "TSRQPONMLK", "UVWXYZ...."};
    	String[] x5 = {
    			"........Z.....",
    			"....UVWXY.....",
    			"....T.........",
    			"....SRQPO.....",
    			"....JKLMN.....",
    			"....I.........",
    			"....HGFED.....",
    			"........C.....",
    			"........B.....",
    			"........A....."
    	};
    	String[] x6 = {
    			"ABCD....",
    			"HGFE....",
    			"IJKL....",
    			"PONM....",
    			"QRST....",
    			"XWVU....",
    			"YZ......",
    	};
    	String[] x7 = {"ABCDEFGHIJKLMNOPQRSTUVWXYZ"};
    	String[] x8 = {"ZYXWVUTSRQPONMLKJIHGFEDCBA"};
    	String[] x9 = {
    			"..Z..",
    			"..Y..",
    			"..X..",
    			"..WVU",
    			"....T",
    			"....S",
    			"....R",
    			"....Q",
    			"LMNOP",
    			"KJIHG",
    			"....F",
    			"....E",
    			"....D",
    			"..ABC"
    	};
    	String[] x10 = {"ZYXWVUTSRQPOMNLKJIHGFEDCBA"};
    	String[] x11 = {
    			"Z.........................",
    			".YXWVUTSRQPOMNLKJIHGFEDCBA"};
    	String[] x12 = {
    			"ABCD....",
    			"HGFE....",
    			"IJKL....",
    			"PONM....",
    			"Q.STR...",
    			"XWVU....",
    			"YZ......",
    	};
    	String[][] all =
    		{x1,x2,x3,x4,x5,x6,x7,x8,x9,x10,x11,x12};
    	for(String[] a : all) {
    		
    		print(a);
    		String x = ap.hasPath(a);
    		System.out.printf("%s %s\n",x,x);
    	}
    }
}