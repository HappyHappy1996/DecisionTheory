package ua.nure.lab3.ivanov;

import ua.nure.lab3.ivanov.data.Packet;
import ua.nure.lab3.ivanov.data.RiskMatrix;
import ua.nure.lab3.ivanov.data.WinMatrix;

public class Demo {

	public static void main(String[] args) {

		WinMatrix winMatrix = new WinMatrix(new Packet(42, -72, 60, -72), 
				new Packet(25, 56, 25, 25),
				new Packet(-25, 21, -25, 54), 
				new Packet(50, -40, 54, -40));
		
		System.out.println("=========winMatrix==========");
		winMatrix.print();
		System.out.println("=========winMatrix==========");

		double solution = OptimalSolveService.findOptimalSolveByLaplace(winMatrix);
		
		/*
		 * Laplace
		 */
		System.out.println("======================================");
		System.out.println("== Laplace " + solution + " ==");
		System.out.println("======================================");
		
		/*
		 * Wald
		 */
		solution = OptimalSolveService.findOptimalSolveByWald(winMatrix);
		System.out.println("======================================");
		System.out.println("== Wald " + solution + " ==");
		System.out.println("======================================");
		
		/*
		 * Gurwits
		 */
		solution = OptimalSolveService.findOptimalSolveByGurwits(winMatrix, 0.6);
		System.out.println("======================================");
		System.out.println("== Gurwits " + solution + " ==");
		System.out.println("======================================");
		
		RiskMatrix riskMatrix = new RiskMatrix(new Packet(8, 128, 0, 126), 
				new Packet(25, 0, 35, 29),
				new Packet(75, 35, 85, 0), 
				new Packet(0, 96, 6, 94));
		
		System.out.println("=========riskMatrix=========");
		riskMatrix.print();
		System.out.println("=========riskMatrix=========");
		
		/*
		 * Sewidge
		 */
		solution = OptimalSolveService.findOptimalSolveBySavage(riskMatrix);
		System.out.println("======================================");
		System.out.println("== Savage " + solution + " ==");
		System.out.println("======================================");
		
	}

}
