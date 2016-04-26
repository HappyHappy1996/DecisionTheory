package ua.nure.lab3.ivanov;

import java.util.Comparator;

import ua.nure.lab3.ivanov.data.RiskMatrix;
import ua.nure.lab3.ivanov.data.WinMatrix;

public class OptimalSolveService {

	public static double findOptimalSolveByLaplace(WinMatrix winMatrix) {
		return winMatrix.getMathematicalExpectations().stream()
				.max(Comparator.comparingDouble(value -> value))
				.get();
	}
	
	public static double findOptimalSolveByWald(WinMatrix winMatrix) {
		return winMatrix.getPackets().stream()
				.map(packet -> packet.min())
				.max(Comparator.comparingDouble(value -> value))
				.get();
	}
	
	public static double findOptimalSolveByGurwits(WinMatrix winMatrix, double pessimismCoef) {
		return winMatrix.getPackets().stream()
				.map(packet -> pessimismCoef * packet.min() + pessimismCoef * packet.max())
				.max(Comparator.comparingDouble(value -> value))
				.get();
	}
	
	public static double findOptimalSolveBySewidge(RiskMatrix riskMatrix) {
		return riskMatrix.getPackets().stream()
				.map(packet -> packet.max())
				.min(Comparator.comparingDouble(value -> value))
				.get();
	}
	
}
