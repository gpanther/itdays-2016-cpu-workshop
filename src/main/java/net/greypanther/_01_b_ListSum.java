package net.greypanther;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Setup;

import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntList;

public class _01_b_ListSum extends _01_a_SumList {
	private IntList arrayList;

	@Setup
	@Override
	public void setUp() {
		super.setUp();

		arrayList = new IntArrayList(size);
		for (int i = 0; i < size; ++i) {
			arrayList.add(i);
		}
	}

	@Benchmark
	public int sumArrayList2() {
		return sum(arrayList);
	}

	private int sum(IntList list) {
		int result = 0;
		int size = list.size();
		for (int i = 0; i < size; ++i) {
			result += list.getInt(i);
		}
		return result;
	}

}
