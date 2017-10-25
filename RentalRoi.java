package util.rental

public class RentalRoi {
	static double principal = 2600000;
	static double rent = 18000d;

	public static void main(String[] args) {
		double interest = 10d / 100d;
		double years;
		// System.out.println(calc(rent, interest) / 12);
		System.out.println(recursionCalcRefined(principal, 0d, rent, interest, 0d) / 12d);
		System.out.println(recursionCalc(principal, 0d, rent, interest, 0d) / 12d);

	}

	static double calc(double rent, double interest) {
		double months = 12, amount = rent * 12;
		while (amount <= principal) {
			if (months % 12 == 0) {
				rent = rent + (rent * interest);
			}
			amount = amount + (rent + rent * interest);
			months++;
		}
		return months;
	}

  /** 
  * Recursive function
  */
	static double recursionCalc(double principal, double amount, double rent, double interest, double months) {
		if (amount >= principal) {
			return months;
		}
		if (months != 0 && months % 12 == 0) {
			rent = rent + (rent * interest);
		}
		amount = amount + rent;
		months++;
		return recursionCalc(principal, amount, rent, interest, months);
	}

  /** 
  *  Refined Recursive function with less number of Recursive Calls
  */
	static double recursionCalcRefined(double principal, double amount, double rent, double interest, double months) {
		if (amount >= principal) {
			double diff = (amount - principal) / rent;
			return diff > 1.0 ? months - diff : months;
		}
		if (months != 0) {
			rent = rent + (rent * interest);
		}
		return recursionCalcRefined(principal, amount + rent * 12d, rent, interest, months + 12);
	}
}
