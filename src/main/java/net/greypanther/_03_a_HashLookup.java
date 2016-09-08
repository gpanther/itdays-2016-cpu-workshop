package net.greypanther;

import java.util.HashMap;
import java.util.Map;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntList;

@State(Scope.Benchmark)
public class _03_a_HashLookup {
	@Param({"10", "1000", "1000000"})
	public int size;

	private IntList list;
	private Map<Integer, Integer> map;

	@Setup
	public void setUp() {
		list = new IntArrayList(size);
		for (int i = 0; i < size; ++i) {
			list.add(i);
		}

		map = new HashMap<>();
		for (int i = 0; i < size; ++i) {
			map.put(i, i);
		}
	}

	@Benchmark
	public int sumList() {
		int result = 0;
		int size = list.size();
		for (int i = 0; i < size; ++i) {
			result += list.getInt(i);
		}
		return result;
	}

	@Benchmark
	public int sumMap() {
		int result = 0;
		int size = this.size;
		for (int i = 0; i < size; ++i) {
			result += map.get(i);
		}
		return result;
	}
}
