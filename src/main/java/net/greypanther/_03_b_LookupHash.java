package net.greypanther;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Setup;

import it.unimi.dsi.fastutil.ints.Int2IntMap;
import it.unimi.dsi.fastutil.ints.Int2IntOpenHashMap;

public class _03_b_LookupHash extends _03_a_HashLookup {
	private Int2IntMap map;

	@Setup
	@Override
	public void setUp() {
		super.setUp();

		map = new Int2IntOpenHashMap();
		for (int i = 0; i < size; ++i) {
			map.put(i, i);
		}
	}

	@Benchmark
	public int sumMap2() {
		int result = 0;
		int size = this.size;
		for (int i = 0; i < size; ++i) {
			result += map.get(i);
		}
		return result;
	}
}
