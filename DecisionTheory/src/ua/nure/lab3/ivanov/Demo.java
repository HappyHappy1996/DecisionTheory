package ua.nure.lab3.ivanov;

import ua.nure.lab3.ivanov.data.Packet;
import ua.nure.lab3.ivanov.data.WinMatrix;

public class Demo {

	public static void main(String[] args) {

		WinMatrix matrix = new WinMatrix(new Packet(42, -72, 60, -72), 
				new Packet(25, 56, 25, 25),
				new Packet(-25, 21, -25, 54), 
				new Packet(50, -40, 54, -40));

		System.out.println("===================");
		matrix.print();
		System.out.println("===================");

		double solution = matrix.findOptimalSolveByLaplace();
		
		/*
		 * Laplace
		 */
		System.out.println("======================================");
		System.out.println("== Laplace " + solution + " ==");
		System.out.println("======================================");
		
		/*
		 * Wald
		 */
		solution = matrix.findOptimalSolveByWald();
		System.out.println("======================================");
		System.out.println("== Wald " + solution + " ==");
		System.out.println("======================================");
		
		/*
		 * Gurwits
		 */
		solution = matrix.findOptimalSolveByGurwits(0.6);
		System.out.println("======================================");
		System.out.println("== Gurwits " + solution + " ==");
		System.out.println("======================================");
		
	}

}
