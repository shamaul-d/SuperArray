public interface ListInt {

    /*preconds: 
     postconds: list of ints has appended n to the list*/
    void add(int n);

    /*preconds: index is smaller than the size of the list 
      postconds: n is inserted at the index specifed, shifting the elements to the right*/
    void add(int index, int n);

    /*preconds: 
     postconds:*/

    void remove(int index);
    /*preconds: 
     postconds:*/

    int size();
    /*preconds: 
     postconds:*/

    int get(int n);
    /*preconds: 
     postconds:*/

    int set(int index, int n);
    /*preconds: 
     postconds:*/

}
