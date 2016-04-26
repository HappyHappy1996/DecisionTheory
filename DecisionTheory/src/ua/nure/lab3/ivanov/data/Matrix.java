package ua.nure.lab3.ivanov.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Matrix {

	protected int packetsCount;
	protected int scenariosCount;
	protected List<Packet> packets;

	public Matrix(Packet... packets) {
		packetsCount = packets.length;
		this.packets = new ArrayList<Packet>(packetsCount);
		scenariosCount = Objects.requireNonNull(packets[0]).getSize();
	}
	
	public void print() {
		System.out.println("Packets count : " + packetsCount);
		System.out.println("Scenarios count : " + scenariosCount);
		System.out.println(packets);
	}

	public int getPacketsCount() {
		return packetsCount;
	}

	public int getScenariosCount() {
		return scenariosCount;
	}

	public List<Packet> getPackets() {
		return packets;
	}
	
}