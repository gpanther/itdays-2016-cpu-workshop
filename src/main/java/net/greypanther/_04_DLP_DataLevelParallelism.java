package net.greypanther;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

@State(Scope.Benchmark)
public class _04_DLP_DataLevelParallelism {
	@Param({ "20", "2000", "2000000" })
	public int size;

	private float[] values;

	@Setup
	public void setUp() {
		values = new float[size];
		for (int i = 0; i < size; ++i) {
			values[i] = i;
		}
	}

	@Benchmark
	public float sumSimple() {
		float sum = 0;
		for (float f : values) {
			sum += f;
		}
		return sum;
	}

	@Benchmark
	public float sumComplex() {
	    float sum1 = 0, sum2 = 0, sum3 = 0, sum4 = 0;
	    for (int i = 0; i < values.length; i += 4) {
	        sum1 += values[i];
	        sum2 += values[i + 1];
	        sum3 += values[i + 2];
	        sum4 += values[i + 3];
	    }
	    return sum1 + sum2 + sum3 + sum4;
	}
}
