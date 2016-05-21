package ua.nure.lab3.ivanov;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import ua.nure.lab3.ivanov.data.Matrix;
import ua.nure.lab3.ivanov.data.RiskMatrix;
import ua.nure.lab3.ivanov.data.WinMatrix;

public class OptimalSolveService {

	public static double findOptimalSolveByLaplace(WinMatrix winMatrix) {
		return winMatrix.getMathematicalExpectations().stream()
				.max(Comparator.comparingDouble(value -> value))
				.get();
	}
	
	public static String findOptimalSolveByLaplaceString(WinMatrix winMatrix) {
		if (!nonEmptyData(winMatrix)) {
			return "������ ������";
		}
		StringBuilder sb = new StringBuilder();
		sb.append('\n');
		sb.append("�������������� �������� �������� ��� ������ �� �����������, ������������ ��� ���������� ������������ ������� �� �������� �������, ���������:\n");
		sb.append(winMatrix.getMathematicalExpectations().toString());
		sb.append("\n����������� �������� �� ������� ��������: ");
		sb.append(winMatrix.getMathematicalExpectations().stream()
				.max(Comparator.comparingDouble(value -> value))
				.get().toString());
		sb.append('\n');
		return sb.toString();
	}
	
	public static double findOptimalSolveByWald(WinMatrix winMatrix) {
		return winMatrix.getPackets().stream()
				.map(packet -> packet.min())
				.max(Comparator.comparingDouble(value -> value))
				.get();
	}
	
	public static String findOptimalSolveByWaldString(WinMatrix winMatrix) {
		if (!nonEmptyData(winMatrix)) {
			return "������ ������";
		}
		StringBuilder sb = new StringBuilder();
		sb.append('\n');
		sb.append("����������� �������� ��� ������ �� �����������, ������������ ��� ���������� ������������ ������� �� �������� ������, ���������:\n");
		List<Double> minAlternativesList = winMatrix.getPackets().stream()
				.map(packet -> packet.min()).collect(Collectors.toList());
		sb.append(minAlternativesList.toString());
		sb.append("\n����������� �������� �� ������� ��������: ");
		sb.append(minAlternativesList.stream().max(Comparator.comparingDouble(value -> value))
				.get().doubleValue());
		sb.append('\n');
		return sb.toString();
	}
	
	public static double findOptimalSolveByGurwits(WinMatrix winMatrix, double pessimismCoef) {
		return winMatrix.getPackets().stream()
				.map(packet -> pessimismCoef * packet.min() + pessimismCoef * packet.max())
				.max(Comparator.comparingDouble(value -> value))
				.get();
	}
	
	public static String findOptimalSolveByGurwitsString(WinMatrix winMatrix, double pessimismCoef) {
		if (!nonEmptyData(winMatrix)) {
			return "������ ������";
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append('\n');
		sb.append("���������� �������� ��� ������ �� �����������, ������������ ��� ���������� ������������ ������� �� �������� �������, ���������:\n");
		List<Double> tempValues = winMatrix.getPackets().stream()
				.map(packet -> pessimismCoef * packet.min() + pessimismCoef * packet.max()).collect(Collectors.toList());
		sb.append(tempValues.toString());
		sb.append("\n����������� �������� �� ������� ��������: ");
		sb.append(tempValues.stream()
				.max(Comparator.comparingDouble(value -> value))
				.get().doubleValue());
		sb.append('\n');
		return sb.toString();
	}
	
	public static String findOptimalSolveByGurwitsString(WinMatrix winMatrix) {
		return findOptimalSolveByGurwitsString(winMatrix, 0.5);
	}
	
	public static double findOptimalSolveBySavage(RiskMatrix riskMatrix) {
		return riskMatrix.getPackets().stream()
				.map(packet -> packet.max())
				.min(Comparator.comparingDouble(value -> value))
				.get();
	}
	
	public static String findOptimalSolveBySavageString(RiskMatrix riskMatrix) {
		if (!nonEmptyData(riskMatrix)) {
			return "������ ������";
		}
		StringBuilder sb = new StringBuilder();
		sb.append('\n');
		sb.append("������������ ������ �������� ��� ������ �� �����������, ������������ ��� ���������� ������������ ������� �� �������� �������, ���������:\n");
		List<Double> tempValues = riskMatrix.getPackets().stream()
				.map(packet -> packet.max()).collect(Collectors.toList());
		sb.append(tempValues.toString());
		sb.append("\n����������� �������� �� ������� ��������: ");
		sb.append(tempValues.stream()
				.min(Comparator.comparingDouble(value -> value))
				.get().doubleValue());
		sb.append('\n');
		return sb.toString();
	}
	
	private static boolean nonEmptyData(Matrix matrix) {
		return matrix.nonEmpty();
	}
}
