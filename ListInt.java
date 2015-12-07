//Team blah -- Shanjeed Ali, Shamaul Dilmohamed
//APCS1 pd10
//HW42 -- Array of Titanium
//2015-12-07

public interface ListInt {

    /*preconds: 
     postconds: list of ints has the int n appended to the list*/
    void add(int n);

    /*preconds: index is smaller than the size of the list and n is an int
      postconds: n is inserted at the index specifed, shifting the elements to the right*/
    void add(int index, int n);

    /*preconds: the index entered is < or = the list's max index(lastPos)
     postconds: an int is removed from the list and all elements past that int are shifted left to fill the empty slot*/
    void remove(int index);
    
    /*preconds: 
     postconds: returns number of ints in the array*/
    int size();
    
    /*preconds: n must be < or = max index of the list, to get meaningful data, n must be < or = lastPos
     postconds: returns int at the nth index of the list*/
    int get(int n);
    
    /*preconds: index is within the list
     postconds: the old value at the index is returned*/
    int set(int index, int n);
}
