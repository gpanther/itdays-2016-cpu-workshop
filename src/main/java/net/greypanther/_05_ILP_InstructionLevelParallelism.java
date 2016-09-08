package net.greypanther;

import java.util.Arrays;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

@State(Scope.Benchmark)
public class _05_ILP_InstructionLevelParallelism {
	@Param({ "10", "1000", "1000000" })
	public int size;

	private byte[] values, valuesSorted;

	@Setup
	public void setUp() {
		values = new byte[size];
		for (int i = 0; i < size; ++i) {
			values[i] = (byte) (i % 5);
		}

		valuesSorted = new byte[size];
		System.arraycopy(values, 0, valuesSorted, 0, size);
		Arrays.sort(valuesSorted);
	}

	@Benchmark
	public int compute1() {
		return compute(values);
	}

	@Benchmark
	public int compute2() {
		return compute(valuesSorted);
	}

	private int compute(byte[] values) {
		int result = 0;
		for (byte b : values) {
			switch (b) {
			case 0:
				result += 1;
				break;
			case 1:
				result += 2;
				break;
			case 2:
				result += 3;
				break;
			case 3:
				result += 4;
				break;
			case 4:
				result += 5;
				break;				
			default:
				throw new IllegalArgumentException(Integer.toString(b));
			}
		}
		return result;
	}
}