package com.ds.algo;

public class RopeCutting {

	int step;

	public int divide(int remainingLength, int cut) {
		if (remainingLength - cut < 0)
			return 0;
		remainingLength = remainingLength - cut;
		divide(remainingLength, cut);
		step = step + 1;
		return step;

	}

	public static void main(String[] args) {
		RopeCutting obj = new RopeCutting();
		int[] cuts = { 7, 16, 19, 24 };
		int ropeLength = 21;

		for (int i = 0; i < cuts.length; i++) {
			obj.step = 0;
			obj.divide(ropeLength, cuts[i]);
			System.out.println("no of cuts possible for:" + cuts[i] + " is " + obj.step);
		}

	}

}
