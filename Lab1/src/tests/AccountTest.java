package tests;

import java.util.Date;

import model.Account;
import utils.TestUtils;

public class AccountTest {

	public static void main(String[] args) {

		testAccountConstructor();
		testGetAccount_number();
		testSetAccount_number();
		testGetUsername_of_account_holder();
		testSetUsername_of_account_holder();
		testGetAccount_type();
		testSetAccount_type();
		testGetAccount_opening_date();
		testSetAccount_opening_date();
		testToString();
	}

	public static Account createTestAccount() {
		return new Account("A123", "mike@email.com", "standard", new Date(0));
	}

	public static void testAccountConstructor() {

		Account testAccount = createTestAccount();
		String test_case_name;

		test_case_name = "TC1-Constructor-account_number";
		if (testAccount.getAccount_number().equals("A123"))
			TestUtils.printTestPassed(test_case_name);
		else
			TestUtils.printTestFailed(test_case_name);
	}

	public static void testGetAccount_number() {
		Account testAccount = createTestAccount();
		String test_case_name = "TC2-getAccount_number";

		if (testAccount.getAccount_number().equals("A123"))
			TestUtils.printTestPassed(test_case_name);
		else
			TestUtils.printTestFailed(test_case_name);
	}

	public static void testSetAccount_number() {
		Account testAccount = createTestAccount();
		String test_case_name = "TC3-setAccount_number";

		testAccount.setAccount_number("B456");

		if (testAccount.getAccount_number().equals("B456"))
			TestUtils.printTestPassed(test_case_name);
		else
			TestUtils.printTestFailed(test_case_name);
	}

	public static void testGetUsername_of_account_holder() {
		Account testAccount = createTestAccount();
		String test_case_name = "TC4-getUsername_of_account_holder";

		if (testAccount.getUsername_of_account_holder().equals("mike@email.com"))
			TestUtils.printTestPassed(test_case_name);
		else
			TestUtils.printTestFailed(test_case_name);
	}

	public static void testSetUsername_of_account_holder() {
		Account testAccount = createTestAccount();
		String test_case_name = "TC5-setUsername_of_account_holder";

		testAccount.setUsername_of_account_holder("anna@email.com");

		if (testAccount.getUsername_of_account_holder().equals("anna@email.com"))
			TestUtils.printTestPassed(test_case_name);
		else
			TestUtils.printTestFailed(test_case_name);
	}

	public static void testGetAccount_type() {
		Account testAccount = createTestAccount();
		String test_case_name = "TC6-getAccount_type";

		if (testAccount.getAccount_type().equals("standard"))
			TestUtils.printTestPassed(test_case_name);
		else
			TestUtils.printTestFailed(test_case_name);
	}

	public static void testSetAccount_type() {
		Account testAccount = createTestAccount();
		String test_case_name = "TC7-setAccount_type";

		testAccount.setAccount_type("saving");

		if (testAccount.getAccount_type().equals("saving"))
			TestUtils.printTestPassed(test_case_name);
		else
			TestUtils.printTestFailed(test_case_name);
	}

	public static void testGetAccount_opening_date() {
		Account testAccount = createTestAccount();
		String test_case_name = "TC8-getAccount_opening_date";

		if (testAccount.getAccount_opening_date().equals(new Date(0)))
			TestUtils.printTestPassed(test_case_name);
		else
			TestUtils.printTestFailed(test_case_name);
	}

	public static void testSetAccount_opening_date() {
		Account testAccount = createTestAccount();
		String test_case_name = "TC9-setAccount_opening_date";

		Date newDate = new Date(1000);
		testAccount.setAccount_opening_date(newDate);

		if (testAccount.getAccount_opening_date().equals(newDate))
			TestUtils.printTestPassed(test_case_name);
		else
			TestUtils.printTestFailed(test_case_name);
	}

	public static void testToString() {
		Account testAccount = createTestAccount();
		String test_case_name = "TC10-toString";

		String expected = "A123, mike@email.com, standard, " + new Date(0);

		if (testAccount.toString().equals(expected))
			TestUtils.printTestPassed(test_case_name);
		else
			TestUtils.printTestFailed(test_case_name);
	}
}
