package model;

import java.util.Calendar;

public class CreditCard implements Facade{
	String creditCard, isInvalidCC, isInvalidExp;
	int year, month;
	
	
	public CreditCard(String creditCard, int year, int month) {
		super();
		this.creditCard = creditCard;
		this.year = year;
		this.month = month;
	}

	public String getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}
	
	public String getIsInvalidCC() {
		return isInvalidCC;
	}

	public void setIsInvalidCC(String isInvalidCC) {
		this.isInvalidCC = isInvalidCC;
	}

	public String getIsInvalidExp() {
		return isInvalidExp;
	}

	public void setIsInvalidExp(String isInvalidExp) {
		this.isInvalidExp = isInvalidExp;
	}

	public boolean checkExpirationDate() {
		boolean check = true;
		int tYear, tMonth;
		
		tYear = Calendar.getInstance().get(Calendar.YEAR);
		tYear -= 2000;
		tMonth = Calendar.getInstance().get(Calendar.MONTH);
		
		if (year <= tYear) {
			check = false;
			if(month > tMonth) {
				check = true;
			}
		}
		return check;
	}
	public boolean confirmCreditCard(String creditCard)
	{
	    int nDigits = creditCard.length();
	 
	    int nSum = 0;
	    boolean isSecond = false;
	    for (int i = nDigits - 1; i >= 0; i--) 
	    {
	 
	        int d = creditCard.charAt(i) - '0';
	 
	        if (isSecond == true)
	            d = d * 2;
	        
	        nSum += d / 10;
	        nSum += d % 10;
	 
	        isSecond = !isSecond;
	    }
	    return (nSum % 10 == 0);
	}
	
	@Override
	public void process() {
		if (!confirmCreditCard(creditCard)) {
			isInvalidCC = "is-invalid";
		}
		if (!checkExpirationDate()) {
			isInvalidExp = "is-invalid";
		}
	}
}
