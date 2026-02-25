package model;

import java.util.Date;

public class Transaction {
	private String accountNumber;
    private double transactionAmount; // +deposit, -withdrawal
    private Date transactionDate;
    
    public Transaction(String accountNumber, double transactionAmount, Date transactionDate) {
		super();
		this.accountNumber = accountNumber;
		this.transactionAmount = transactionAmount;
		this.transactionDate = transactionDate;
		
    }

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
    
	
	public String toString() {
	    return accountNumber + ", " + transactionAmount + ", " + transactionDate;
	}
    
}
