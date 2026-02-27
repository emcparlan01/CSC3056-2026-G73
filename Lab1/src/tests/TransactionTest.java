package tests;

import java.util.Date;

import model.Transaction;
import utils.TestUtils;

public class TransactionTest {

	public static void main(String[] args) {

		testTransactionConstructor();

		testGetAccountNumber();
		testSetAccountNumber();

		testGetTransactionAmount();
		testSetTransactionAmount();

		testGetTransactionDate();
		testSetTransactionDate();

		testToString();
	}

	public static Transaction createTestTransaction() {
		return new Transaction("A123", 50.0, new Date(0));
	}

	public static void testTransactionConstructor() {

		System.out.println("Starting the assertions of the test method: testTransactionConstructor");

		String test_accountNumber = "A123";
		double test_transactionAmount = 50.0;
		Date test_transactionDate = new Date(0);

		Transaction testTransaction = new Transaction(test_accountNumber, test_transactionAmount, test_transactionDate);

		String test_case_name;

		test_case_name = "TC1-Constructor-accountNumber";
		if (testTransaction.getAccountNumber().equals(test_accountNumber))
			TestUtils.printTestPassed(test_case_name);
		else
			TestUtils.printTestFailed(test_case_name);

		test_case_name = "TC2-Constructor-transactionAmount";
		if (testTransaction.getTransactionAmount() == test_transactionAmount)
			TestUtils.printTestPassed(test_case_name);
		else
			TestUtils.printTestFailed(test_case_name);

		test_case_name = "TC3-Constructor-transactionDate";
		if (testTransaction.getTransactionDate().equals(test_transactionDate))
			TestUtils.printTestPassed(test_case_name);
		else
			TestUtils.printTestFailed(test_case_name);
	}

	public static void testGetAccountNumber() {

		Transaction testTransaction = createTestTransaction();
		String test_case_name = "TC4-getAccountNumber";

		if (testTransaction.getAccountNumber().equals("A123"))
			TestUtils.printTestPassed(test_case_name);
		else
			TestUtils.printTestFailed(test_case_name);
	}

	public static void testGetTransactionAmount() {

		Transaction testTransaction = createTestTransaction();
		String test_case_name = "TC5-getTransactionAmount";

		if (testTransaction.getTransactionAmount() == 50.0)
			TestUtils.printTestPassed(test_case_name);
		else
			TestUtils.printTestFailed(test_case_name);
	}

	public static void testGetTransactionDate() {

		Transaction testTransaction = createTestTransaction();
		String test_case_name = "TC6-getTransactionDate";

		if (testTransaction.getTransactionDate().equals(new Date(0)))
			TestUtils.printTestPassed(test_case_name);
		else
			TestUtils.printTestFailed(test_case_name);
	}

	public static void testSetAccountNumber() {

		Transaction testTransaction = createTestTransaction();
		String test_case_name = "TC7-setAccountNumber";

		testTransaction.setAccountNumber("B456");

		if (testTransaction.getAccountNumber().equals("B456"))
			TestUtils.printTestPassed(test_case_name);
		else
			TestUtils.printTestFailed(test_case_name);
	}

	public static void testSetTransactionAmount() {

		Transaction testTransaction = createTestTransaction();
		String test_case_name = "TC8-setTransactionAmount";

		testTransaction.setTransactionAmount(99.99);

		if (testTransaction.getTransactionAmount() == 99.99)
			TestUtils.printTestPassed(test_case_name);
		else
			TestUtils.printTestFailed(test_case_name);
	}

	public static void testSetTransactionDate() {

		Transaction testTransaction = createTestTransaction();
		String test_case_name = "TC9-setTransactionDate";

		Date newDate = new Date(1000);
		testTransaction.setTransactionDate(newDate);

		if (testTransaction.getTransactionDate().equals(newDate))
			TestUtils.printTestPassed(test_case_name);
		else
			TestUtils.printTestFailed(test_case_name);
	}

	public static void testToString() {

		Transaction testTransaction = createTestTransaction();
		String test_case_name = "TC10-toString";

		String expected = "A123, " + 50.0 + ", " + new Date(0);

		if (testTransaction.toString().equals(expected))
			TestUtils.printTestPassed(test_case_name);
		else
			TestUtils.printTestFailed(test_case_name);
	}
}
