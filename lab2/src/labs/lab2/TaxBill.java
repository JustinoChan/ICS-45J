package labs.lab2;

/*
 * A tax bill defined by one's marital status  and taxable income
 */
public class TaxBill {
	// ADD YOUR INSTANCE VARIABLES HERE
	private boolean Married;
	private double amount;
	/**
	 * Constructor
	 * 
	 * @param married	whether married or not
	 * @param income	taxable yearly income
	 */
	public TaxBill(boolean married, double income) {
		this.Married = married;
		this.amount = income;
	}
	
	
	/**
	 * Calculates amount of tax due
	 * 
	 * @return	amount of tax due
	 */
	public double getAmountDue() {
		if (Married){
			double tax = 0;
			if(amount >= 0 && amount <= 16000) {
				tax = (amount * 10) / 100;
			}
			else if(amount > 16000 && amount <= 64000){
				tax = 1600 + ((amount - 16000) * 15) / 100;
			}
			else if(amount > 64000){
				tax = 8800 + ((amount - 64000) * 25) / 100;
			}
			return tax;
		}
		else{
			double tax = 0;
			if(amount >= 0 && amount <= 8000) {
				tax = (amount * 10) / 100;
			}
			else if(amount > 8000 && amount <= 32000){
				tax = 800 + ((amount - 8000) * 15) / 100;
			}
			else if(amount > 32000){
				tax = 4400 + ((amount - 32000) * 25) / 100;
			}
			return tax;
		}
	}
}