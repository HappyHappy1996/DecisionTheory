package ua.nure.lab3.ivanov.data;

import java.util.ArrayList;
import java.util.Objects;

public class RiskMatrix extends Matrix {

	public RiskMatrix(Packet... packets) {
		super(packets);
		
		for (Packet packet : packets) {
			this.packets.add(packet);
		}
	}
	
//	public RiskMatrix(WinMatrix winMatrix) {
//		packetsCount = winMatrix.getPacketsCount();
//		this.packets = new ArrayList<Packet>(packetsCount);
//		scenariosCount = Objects.requireNonNull(winMatrix.getScenariosCount());
//		this.packets = winMatrix.getPackets().stream()
//		double maxScenarioValue = winMatrix.getPackets().stream().
//	}
}
