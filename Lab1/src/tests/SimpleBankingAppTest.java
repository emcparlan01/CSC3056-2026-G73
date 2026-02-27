package tests;

import app.SimpleBankingApp;
import utils.TestUtils;

// Required for Feature 3
import java.util.Vector;
import model.Transaction;

public class SimpleBankingAppTest {

	// this test method (test case) verifies if the data load feature works properly
	public static void testLoadData() {

		SimpleBankingApp.users.clear();
		SimpleBankingApp.accounts.clear();
		SimpleBankingApp.transactions.clear();

		SimpleBankingApp.loadUserData();

		if (SimpleBankingApp.users.size() == 3)
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "testLoadData: loadUserData: TC1 passed" + TestUtils.TEXT_COLOR_RESET);
		else
			System.out.println(TestUtils.TEXT_COLOR_RED + "testLoadData: loadUserData: TC1 FAILED" + TestUtils.TEXT_COLOR_RESET);

		try {
			SimpleBankingApp.loadAccountData();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (SimpleBankingApp.accounts.size() == 4)
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "testLoadData: loadAccountData: TC1 passed" + TestUtils.TEXT_COLOR_RESET);
		else
			System.out.println(TestUtils.TEXT_COLOR_RED + "testLoadData: loadAccountData: TC1 FAILED" + TestUtils.TEXT_COLOR_RESET);
	}

	public static void testDeposits() {

		double balanceBefore = SimpleBankingApp.getBalance("5495-1234");
		double depositAmount = 50.21;

		SimpleBankingApp.addTransaction("5495-1234", depositAmount);
		double balanceAfter = SimpleBankingApp.getBalance("5495-1234");

		if (balanceBefore + depositAmount == balanceAfter)
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "testDeposits: TC1 passed" + TestUtils.TEXT_COLOR_RESET);
		else
			System.out.println(TestUtils.TEXT_COLOR_RED + "testDeposits: TC1 FAILED" + TestUtils.TEXT_COLOR_RESET);

		SimpleBankingApp.addTransaction("5495-1234", -depositAmount);
	}

	public static void testWithdrawals() {

		double balanceBefore = SimpleBankingApp.getBalance("5495-1234");
		double withdrawAmount = 20.00;

		SimpleBankingApp.addTransaction("5495-1234", -withdrawAmount);
		double balanceAfter = SimpleBankingApp.getBalance("5495-1234");

		if (balanceBefore - withdrawAmount == balanceAfter)
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "testWithdrawals: TC1 passed" + TestUtils.TEXT_COLOR_RESET);
		else
			System.out.println(TestUtils.TEXT_COLOR_RED + "testWithdrawals: TC1 FAILED" + TestUtils.TEXT_COLOR_RESET);

		SimpleBankingApp.addTransaction("5495-1234", withdrawAmount);
	}

	public static void main(String[] args) {
		testLoadData();
		testDeposits();
		testWithdrawals();
		testAccountExists();
		testAddTransactionSafe();
		testGetTransactionsForAccount();
	}

	// FEATURE 1
	public static void testAccountExists() {

		if (SimpleBankingApp.accounts.size() == 0) {
			testLoadData();
		}

		String test_case_name;

		test_case_name = "testAccountExists: TC1 valid account";
		if (SimpleBankingApp.accountExists("5495-1234"))
			System.out.println(TestUtils.TEXT_COLOR_GREEN + test_case_name + " passed" + TestUtils.TEXT_COLOR_RESET);
		else
			System.out.println(TestUtils.TEXT_COLOR_RED + test_case_name + " FAILED" + TestUtils.TEXT_COLOR_RESET);

		test_case_name = "testAccountExists: TC2 invalid account";
		if (!SimpleBankingApp.accountExists("0000-0000"))
			System.out.println(TestUtils.TEXT_COLOR_GREEN + test_case_name + " passed" + TestUtils.TEXT_COLOR_RESET);
		else
			System.out.println(TestUtils.TEXT_COLOR_RED + test_case_name + " FAILED" + TestUtils.TEXT_COLOR_RESET);
	}

	// FEATURE 2
	public static void testAddTransactionSafe() {

		if (SimpleBankingApp.accounts.size() == 0) {
			testLoadData();
		}

		String test_case_name;
		int sizeBefore = SimpleBankingApp.transactions.size();

		test_case_name = "testAddTransactionSafe: TC1 valid account adds";
		boolean result1 = SimpleBankingApp.addTransactionSafe("5495-1234", 10.0);

		if (result1 && SimpleBankingApp.transactions.size() == sizeBefore + 1)
			System.out.println(TestUtils.TEXT_COLOR_GREEN + test_case_name + " passed" + TestUtils.TEXT_COLOR_RESET);
		else
			System.out.println(TestUtils.TEXT_COLOR_RED + test_case_name + " FAILED" + TestUtils.TEXT_COLOR_RESET);

		if (SimpleBankingApp.transactions.size() > sizeBefore) {
			SimpleBankingApp.transactions.remove(SimpleBankingApp.transactions.size() - 1);
		}

		test_case_name = "testAddTransactionSafe: TC2 invalid account rejected";
		int sizeBefore2 = SimpleBankingApp.transactions.size();
		boolean result2 = SimpleBankingApp.addTransactionSafe("0000-0000", 10.0);

		if (!result2 && SimpleBankingApp.transactions.size() == sizeBefore2)
			System.out.println(TestUtils.TEXT_COLOR_GREEN + test_case_name + " passed" + TestUtils.TEXT_COLOR_RESET);
		else
			System.out.println(TestUtils.TEXT_COLOR_RED + test_case_name + " FAILED" + TestUtils.TEXT_COLOR_RESET);
	}

	// FEATURE 3
		public static void testGetTransactionsForAccount() {

		    SimpleBankingApp.users.clear();
		    SimpleBankingApp.accounts.clear();
		    SimpleBankingApp.transactions.clear();

		    SimpleBankingApp.loadUserData();
		    SimpleBankingApp.loadAccountData();

		    SimpleBankingApp.addTransaction("5495-1234", 10.00);
		    SimpleBankingApp.addTransaction("5495-1234", -5.00);
		    SimpleBankingApp.addTransaction("5495-1239", 99.00);

		    String test_case_name;
		    int txSizeBefore = SimpleBankingApp.transactions.size();

		    test_case_name = "testGetTransactionsForAccount: TC1 valid account";
		    Vector<Transaction> results = SimpleBankingApp.getTransactionsForAccount("5495-1234");

		    if (results.size() == 2)
		        System.out.println(TestUtils.TEXT_COLOR_GREEN + test_case_name + " passed" + TestUtils.TEXT_COLOR_RESET);
		    else
		        System.out.println(TestUtils.TEXT_COLOR_RED + test_case_name + " FAILED" + TestUtils.TEXT_COLOR_RESET);

		    test_case_name = "testGetTransactionsForAccount: TC2 invalid account";
		    Vector<Transaction> invalidResults = SimpleBankingApp.getTransactionsForAccount("0000-0000");

		    if (invalidResults.size() == 0)
		        System.out.println(TestUtils.TEXT_COLOR_GREEN + test_case_name + " passed" + TestUtils.TEXT_COLOR_RESET);
		    else
		        System.out.println(TestUtils.TEXT_COLOR_RED + test_case_name + " FAILED" + TestUtils.TEXT_COLOR_RESET);

		    test_case_name = "testGetTransactionsForAccount: TC3 null account";
		    Vector<Transaction> nullResults = SimpleBankingApp.getTransactionsForAccount(null);

		    if (nullResults.size() == 0)
		        System.out.println(TestUtils.TEXT_COLOR_GREEN + test_case_name + " passed" + TestUtils.TEXT_COLOR_RESET);
		    else
		        System.out.println(TestUtils.TEXT_COLOR_RED + test_case_name + " FAILED" + TestUtils.TEXT_COLOR_RESET);

		    test_case_name = "testGetTransactionsForAccount: TC4 does not modify transactions";
		    int txSizeAfter = SimpleBankingApp.transactions.size();

		    if (txSizeBefore == txSizeAfter)
		        System.out.println(TestUtils.TEXT_COLOR_GREEN + test_case_name + " passed" + TestUtils.TEXT_COLOR_RESET);
		    else
		        System.out.println(TestUtils.TEXT_COLOR_RED + test_case_name + " FAILED" + TestUtils.TEXT_COLOR_RESET);
		}
}
