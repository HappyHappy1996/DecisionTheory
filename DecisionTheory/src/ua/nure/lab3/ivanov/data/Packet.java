package ua.nure.lab3.ivanov.data;

import java.util.ArrayList;
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
	
}
