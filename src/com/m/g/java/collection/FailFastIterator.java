package com.m.g.java.collection;
/**
 * when two iterator instances are used on the same list.
 * Using first iterator instance we are changing the structure of the list.
 * And trying to iterate the list using the second iterator.
 * 
 * What happens?
 * Whenever the structure of a list is modified once a iterator() method is called on it.
 * then it raises Concurrent Modification Exception.
 * 
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FailFastIterator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> l = new ArrayList<>();
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(4);
		l.add(5);
		// first Iterator Instance
		Iterator<Integer> itr1 = l.iterator();
		// Second Iterator Instance.
		Iterator<Integer> itr2 = l.iterator();
		while (itr1.hasNext()) {
			// Changing the structure of the list on the below condition.
			if (itr1.next() == 4) {
				l.remove(new Integer(4));
			}
		}
		System.out.println(l);
		// Iterating the list after modification by first Iterator
		while (itr2.hasNext()) {
			System.out.println(itr2.next());
		}
	}

}
