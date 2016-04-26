package ua.nure.lab3.ivanov.data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class WinMatrix extends Matrix {

	private List<Double> mathematicalExpectations;

	public WinMatrix(Packet... packets) {
		super(packets);
		
		for (Packet packet : packets) {
			this.packets.add(packet);
		}
		computeMathematicalExpectation();
	}
	
	public List<Double> getMathematicalExpectations() {
		return mathematicalExpectations;
	}

	private void computeMathematicalExpectation() {
		mathematicalExpectations = new ArrayList<Double>(scenariosCount);
		for (Packet packet : packets) {
			mathematicalExpectations.add(packet.getValues().stream()
					.mapToDouble(value -> value)
					.summaryStatistics()
					.getAverage());
		}
	}

	public void print() {
		super.print();
		System.out.println("Mathematical Expectations: " + mathematicalExpectations);
	}

}
