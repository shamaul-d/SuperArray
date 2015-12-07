//Team blah -- Shanjeed Ali, Shamaul Dilmohamed
//APCS1 pd10
//HW42 -- Array of Titanium
//2015-12-07
/*****************************
 * class SuperArray --  A wrapper class for an array. 
 * Maintains functionality:
 *  access value at index
 *  overwrite value at index
 *  report number of meaningful items
 * Adds functionality to std Java array:
 *  resizability
 *  ability to print meaningfully
 *  add item (at end)
 *  insert item
 *  remove item (while maintaining "left-justification")
 *****************************/

public class SuperArray implements ListInt{
 
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
	_lastPos = -1; //flag to indicate no lastpos yet
	_size = 0;	
    }

		
    //output array in [a,b,c] format, eg
    // {1,2,3}.toString() -> "[1,2,3]"
    public String toString() 
    { 
	String foo = "[";
	for( int i = 0; i < _size; i++ ) {
	    foo += _data[i] + ",";
	}
	//shave off trailing comma
	if ( foo.length() > 1 )
	    foo = foo.substring( 0, foo.length()-1 );
	foo += "]";
	return foo;
    }

		
    //double capacity of this SuperArray
    private void expand() 
    { 
	int[] temp = new int[ _data.length * 2 ];
	for( int i = 0; i < _data.length; i++ )
	    temp[i] = _data[i];
	_data = temp;
    }

		
    //accessor -- return value at specified index
    public int get( int index ) { return _data[index]; }

		
    //mutator -- set value at index to newVal, 
    //           return old value at index
    public int set( int index, int newVal ) 
    { 
 	int temp = _data[index];
	_data[index] = newVal;
	return temp;
    }


    // ~~~~~~~~~~~~~~ PHASE II ~~~~~~~~~~~~~~
    //adds an item after the last item
    public void add( int newVal ) {
	if (_size == _data.length) {
	    expand();
	}
	set(_size, newVal ); 
	_size += 1;
	_lastPos += 1;
    }

    //inserts an item at index
    //shifts existing elements to the right
    public void add( int index, int newVal ) {
	if (_size == _data.length) {
	    expand();
	}
	for (int ctr = _size; ctr > index; ctr--) {
	    _data[ctr] = _data[ctr-1];
	}
	_data[index] = newVal;
	_size += 1;
	_lastPos += 1;
    }

    //removes the item at index
    //shifts elements left to fill in newly-emptied slot
    public void remove( int index ) { 
	for (int ctr = index; ctr < _lastPos; ctr++) {
	    _data[ctr] = _data[ctr+1];
	}
	_size -= 1;
	_lastPos -= 1;
    }

    //return number of meaningful items in _data
    public int size() { 
	return _size;
    }

    //main method for testing
    public static void main( String[] args ) 
    {
	ListInt curtis = new SuperArray();

	System.out.println("Printing empty SuperArray curtis...");
	System.out.println(curtis);

	/*for( int i = 0; i < curtis._data.length; i++ ) {
	    curtis.set(i,i*2);
	    curtis._size++; //necessary bc no add() method yet
	    }*/

	System.out.println("Using add() to populate curtis.\nPrinting populated SuperArray curtis...");
	
	curtis.add(21);
	curtis.add(18);
	curtis.add(15);
	curtis.add(12);
	curtis.add(9);
	curtis.add(6);
	curtis.add(3);
	
	System.out.println(curtis);

	System.out.println("Testing get()...");
	for( int i = 0; i < curtis.size(); i++ ) {
	    System.out.print( "item at index" + i + ":\t" );
	    System.out.println( curtis.get(i) );
	}

	System.out.println("Testing set()...");
	System.out.println(curtis.set(0,300) + " was replaced with 300");

	System.out.println("Now curtis looks like:\n" + curtis);

	System.out.println("Testing size()...");
	System.out.println("curtis contains "+curtis.size()+" meaningful ints.");

	System.out.println("Testing add at an index...");
	curtis.add(1,303);
	System.out.println("303 was added at index 1:\n"+curtis);

	System.out.println("Testing remove()...");
	curtis.remove(0);
	curtis.remove(0);
	System.out.println("300 and 303 were removed. Now curtis looks like:\n" + curtis);
	
	/*System.out.println("Expanded SuperArray curtis:");
	curtis.expand();
	System.out.println(curtis);*/


	/*SuperArray mayfield = new SuperArray();
	System.out.println("Printing empty SuperArray mayfield...");
	System.out.println(mayfield);

	  mayfield.add(5);
	  mayfield.add(4);
	  mayfield.add(3);
	  mayfield.add(2);
	  mayfield.add(1);

	  System.out.println("Printing populated SuperArray mayfield...");
	  System.out.println(mayfield);

	  mayfield.remove(3);
	  System.out.println("Printing SuperArray mayfield post-remove...");
	  System.out.println(mayfield);
	  mayfield.remove(3);
	  System.out.println("Printing SuperArray mayfield post-remove...");
	  System.out.println(mayfield);

	  mayfield.add(3,99);
	  System.out.println("Printing SuperArray mayfield post-insert...");
	  System.out.println(mayfield);
	  mayfield.add(2,88);
	  System.out.println("Printing SuperArray mayfield post-insert...");
	  System.out.println(mayfield);
	  mayfield.add(1,77);
	  System.out.println("Printing SuperArray mayfield post-insert...");
	  System.out.println(mayfield);*/

    }//end main
		
}//end class
