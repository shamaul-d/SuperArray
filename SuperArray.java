// Shamaul Dilmohamed
// APCS1 pd10
// HW39 -- Array of Steel
// 2015-12-01

/*****************************
 * SKELETON for
 * class SuperArray --  A wrapper class for an array. 
 * Maintains functionality:
 *  access value at index
 *  overwrite value at index
 * Adds functionality to std Java array:
 *  resizability
 *  ability to print meaningfully
 *****************************/

public class SuperArray {
    
    //~~~~~INSTANCE VARS~~~~~
    //underlying container, or "core" of this data structure:
    private int[] _data;
    
    //position of last meaningful value
    private int _lastPos;
    
    //size of this instance of SuperArray
    private int _size;
    
		
    //~~~~~METHODS~~~~~
    //default constructor – initializes 10-item array
    public SuperArray() {
	_data = new int[10];
	_lastPos = -1; // no initialized values, so nothing of importance
	_size = 0; // again, no significance
    }
    
    
    //output array in [a,b,c] format, eg
    // {1,2,3}.toString() -> "[1,2,3]"
    public String toString() { 
	String ans = "[";
	for (int a = 0; a < _data.length; a++) {
	    ans += _data[a] + ",";
	}
	if (ans.length() > 1) {
	    ans = ans.substring(0, ans.length()-1); // gets rid of last comma
	}
	ans += "]";
	return ans;
    }
    
    
    //double capacity of this SuperArray
    private void expand() { 
	int[] nums = new int[_data.length * 2]; //creates an array twice as long
	for (int ctr = 0; ctr < _data.length; ctr++) {
	    nums[ctr] = _data[ctr];
	} 
	_data = nums; // sets data to new array
    }

    //accessor -- return value at specified index
    public int get( int index ) { 
	return _data[index]; 
    }
    
    //mutator -- set value at index to newVal, 
    //           return old value at index
    public int set( int index, int newVal ) {
	int old = get(index); //saves old val
	_data[index] = newVal; //updates stuff
	return old;
    }
    

    //main method for testing
    public static void main( String[] args ) {
	//*****INSERT ADEQUATE TEST CALLS HERE*****
	SuperArray shan = new SuperArray();
	System.out.println(shan);
	shan.expand();
	System.out.println(shan);
	System.out.println(shan.get(19));
	shan.set(1,525600);
	System.out.println(shan.get(1));
	System.out.println(shan);	
    }//end main
    
}//end class
