package net.greypanther;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

@State(Scope.Benchmark)
public class _02_Arraycopy {
	@Param({"10", "1000", "1000000"})
	public int size;

	private byte[] source, destination;

	@Setup
	public void setUp() {
		source = new byte[size];
		destination = new byte[size];
		for (int i = 0; i < size; ++i) {
			source[i] = (byte)i;
		}
	}

	@Benchmark
	public byte[] copyUp() {
		for (int i = 0; i < size; ++i) {
			destination[i] = source[i];
		}
		return destination;
	}

	@Benchmark
	public byte[] copyDown() {
		for (int i = size - 1; i >= 0; --i) {
			destination[i] = source[i];
		}
		return destination;
	}

	@Benchmark
	public byte[] systemArraycopy() {
		System.arraycopy(source, 0, destination, 0, size);
		return destination;
	}
}
