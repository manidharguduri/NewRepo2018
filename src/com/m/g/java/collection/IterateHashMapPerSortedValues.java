package com.m.g.java.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/***
 * This class iterates the map per the sorted values of the map.
 * 
 *
 */

public class IterateHashMapPerSortedValues {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Integer> m = new HashMap<>();
		m.put("Box", 2);
		m.put("cat", 1);
		m.put("Apple", 3);
		m.put("Dog", 4);
		System.out.println("Original map ::" + m);
		Set<Entry<String, Integer>> s = m.entrySet();
		List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(s);
		Collections.sort(list, new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {

				Map.Entry<String, Integer> m1 = (Map.Entry<String, Integer>) o1;
				Map.Entry<String, Integer> m2 = (Map.Entry<String, Integer>) o2;
				Integer value1 = m1.getValue();
				Integer value2 = m2.getValue();
				return value1.compareTo(value2);
			}

		});

		for (Map.Entry<String, Integer> tmp : list) {
			System.out.println(tmp.getKey() + "----" + tmp.getValue());
		}

	}

}
