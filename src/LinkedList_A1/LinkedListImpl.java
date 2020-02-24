/**
 * COMP 410
 *See inline comment descriptions for methods not described in interface.
 *
*/
package LinkedList_A1;

public class LinkedListImpl implements LIST_Interface {
  Node sentinel; //this will be the entry point to your linked list (the head)
  int sizeCount = 0;
  //Node head = this.sentinel.next;
  
  public LinkedListImpl(){//this constructor is needed for testing purposes. Please don't modify!
    sentinel=new Node(0); //Note that the root's data is not a true part of your data set!
  }
  
  
  //implement all methods in interface, and include the getRoot method we made for testing purposes. Feel free to implement private helper methods!
  
  public Node getRoot(){ //leave this method as is, used by the grader to grab your linkedList easily.
    return sentinel;
  }

@Override
public boolean insert(double elt, int index) {
	if (index < 0 || index > size()) {
		return false;
	}
	Node curr;
	if (sentinel.next == null && sizeCount == 0) {
		clear();
	}
	curr = sentinel.next;
	int count = 0;
	while (curr != sentinel && curr != null) {
		if (count < index) {
			curr = curr.next;
			count++;
		} else {
			break;
		}
	}
	Node newCell = new Node(elt);
	newCell.prev = curr.prev;
	curr.prev = newCell;
	newCell.prev.next = newCell;
	newCell.next = curr;
	sizeCount++;
	
	return true;
}

@Override
public boolean remove(int index) {
	if (index < 0 || index > size()) {
		return false;
	}
	Node curr;
	if (sentinel.next == null && sizeCount == 0) {
		clear();
	}
	curr = sentinel.next;
	int count = 0;
	while (curr != sentinel && curr != null) {
		if (count < index) {
			curr = curr.next;
			count++;
		} else {
			break;
		}
	}
	curr.next.prev = curr.prev;
	curr.prev.next = curr.next;
	sizeCount--;
	
	return true;
}

@Override
public double get(int index) {
	if (index < 0 || index > (size() - 1)) {
		return Double.NaN;
	}
	Node curr;
	if (sentinel.next == null && sizeCount == 0) {
		clear();
	}
	curr = sentinel.next;
	int count = 0;
	while (count != index) {
		curr = curr.next;
		count++;
	}
	return curr.data;
}

@Override
public int size() {
	return sizeCount;
}

@Override
public boolean isEmpty() {
	if (sizeCount == 0) { 
		return true;
	}
	return false;
}

@Override
public void clear() {
	sentinel.next = sentinel;
	sentinel.prev = sentinel;
	sizeCount = 0;
}
}