package ua.nure.lab3.ivanov.data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class WinMatrix {

	private int packetsCount;
	private int scenariosCount;
	
	private List<Packet> packets;
	private List<Double> mathematicalExpectations;

	public WinMatrix(Packet... packets) {
		packetsCount = packets.length;
		this.packets = new ArrayList<Packet>(packetsCount);
		scenariosCount = Objects.requireNonNull(packets[0]).getSize();
		
		for (Packet packet : packets) {
			this.packets.add(packet);
		}
		
		computeMathematicalExpectation();
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
		System.out.println("Packets count : " + packetsCount);
		System.out.println("Scenarios count : " + scenariosCount);
		System.out.println(packets);
		System.out.println("Mathematical Expectations: " + mathematicalExpectations);
	}

	public double findOptimalSolveByLaplace() {
		return mathematicalExpectations.stream()
				.max(Comparator.comparingDouble(value -> value))
				.get();
	}
	
	public double findOptimalSolveByWald() {
		return packets.stream()
				.map(packet -> packet.min())
				.max(Comparator.comparingDouble(value -> value))
				.get();
	}
	
	public double findOptimalSolveByGurwits(double pessimismCoef) {
		return packets.stream()
				.map(packet -> pessimismCoef * packet.min() + pessimismCoef * packet.max())
				.max(Comparator.comparingDouble(value -> value))
				.get();
	}
}
