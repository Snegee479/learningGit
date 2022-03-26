package basic;

public class ATM {
	int Balance=3000;
	int minBal=1000;
	int withdraw(int amtToiWithdraw) throws LowBalanceException {
		try {
			Balance=Balance-amtToiWithdraw;
		}
		catch(ArithmeticException e)  
        {  
            System.out.println(e);  
        }
		return Balance;  
	}
}
