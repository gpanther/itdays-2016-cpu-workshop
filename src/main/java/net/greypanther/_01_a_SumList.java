package net.greypanther;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

@State(Scope.Benchmark)
public class _01_a_SumList {
	@Param({"10", "1000", "1000000"})
	public int size;
	
	private List<Integer> arrayList, linkedList;

	@Setup
	public void setUp() {
		arrayList = getFilledList(new ArrayList<>(), size);
		linkedList = getFilledList(new LinkedList<>(), size);
	}
	
	@Benchmark
	public int sumArrayList() {
		return sum(arrayList);
	}

	@Benchmark
	public int sumLinkedList() {
		return sum(linkedList);
	}

	private List<Integer> getFilledList(List<Integer> list, int size) {
		for (int i = 0; i < size; ++i) {
			list.add(i);
		}
		return list;
	}

	private int sum(List<Integer> list) {
		int result = 0;
		for (int i: list) {
			result += i;
		}
		return result;
	}
}
