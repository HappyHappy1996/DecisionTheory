package ua.nure.lab3.ivanov.data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Packet {

	private int size;
	private List<Double> values;
	
	public Packet(double... values) {
		size = values.length;
		this.values = new ArrayList<Double>(size);
		
		for (int i = 0; i < values.length; i++) {
			this.values.add(values[i]);
		}
	}

	public int getSize() {
		return size;
	}

	public List<Double> getValues() {
		return values;
	}
	
	public Double min() {
		return values.stream()
				.min(Comparator.comparingDouble(value -> value))
				.get();
	}
	
	public Double max() {
		return values.stream()
				.max(Comparator.comparingDouble(value -> value))
				.get();
	}

	public String toString() {
		return "\n" + values.toString();
	}
	
	
}
