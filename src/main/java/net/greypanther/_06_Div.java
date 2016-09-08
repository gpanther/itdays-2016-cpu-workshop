package net.greypanther;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

@State(Scope.Benchmark)
public class _06_Div {
	private int ia, ib;
	private float fa, fb;

	@Setup
	public void setUp() {
		ia = 42;
		ib = 7;
		fa = 42;
		fb = 7;
	}

	@Benchmark
	public int intDiv() {
		return ia / ib;
	}

	@Benchmark
	public float floatDiv() {
		return fa / fb;
	}
}
