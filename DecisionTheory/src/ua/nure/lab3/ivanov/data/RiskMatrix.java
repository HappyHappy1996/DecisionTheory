package ua.nure.lab3.ivanov.data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RiskMatrix extends Matrix {

	public RiskMatrix(Packet... packets) {
		super(packets);

		if (nonEmpty()) {
			for (Packet packet : packets) {
				this.packets.add(packet);
			}
		}
	}

	public RiskMatrix(String values) {
		super(parseStringForConstructor(values));

		if (nonEmpty()) {
			for (Packet packet : parseStringForConstructor(values)) {
				this.packets.add(packet);
			}
		}
	}

	private static Packet[] parseStringForConstructor(String values) {

		int linesAmount = 0;

		for (char element : values.toCharArray()) {
			if (Character.compare('\n', element) == 0) {
				linesAmount++;
			}
		}

		if (linesAmount < 1) {
			return null;
		}

		Packet[] array = new Packet[linesAmount + 1];
		int i = 0;

		String regexp = "(-?\\d *)+";
		Pattern pattern = Pattern.compile(regexp);
		Matcher matcher = pattern.matcher(values);

		while (matcher.find()) {
			String[] numbersInLine = matcher.group().split(" ");
			double[] numbersArray = new double[numbersInLine.length];
			for (int j = 0; j < numbersArray.length; j++) {
				numbersArray[j] = Double.parseDouble(numbersInLine[j]);
			}
			array[i++] = new Packet(numbersArray);
		}
		return array;
	}

	 /*public RiskMatrix(WinMatrix winMatrix) {
	 packetsCount = winMatrix.getPacketsCount();
	 this.packets = new ArrayList<Packet>(packetsCount);
	 scenariosCount = Objects.requireNonNull(winMatrix.getScenariosCount());
	 this.packets = winMatrix.getPackets().stream()
	 double maxScenarioValue = winMatrix.getPackets().stream().
	 }*/
}
