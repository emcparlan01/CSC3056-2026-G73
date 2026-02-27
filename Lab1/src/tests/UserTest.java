package tests;

import model.User;
import utils.TestUtils;

public class UserTest {

	public static void main(String[] args) {
		testUserConstructor();
	}

	public static void testUserConstructor() {

		// 1- Setup
		String test_username = "mike";
		String test_password = "my_passwd";
		String test_first_name = "Mike";
		String test_last_name = "Smith";
		String test_mobile_number = "07771234567";

		// 2- Exercise
		User testUser = new User(test_username, test_password, test_first_name,
								 test_last_name, test_mobile_number);

		System.out.println("Starting the assertions of the test method: testUserConstructor");

		String test_case_name;

		// TC1
		test_case_name = "TC1-getUsername";
		if (testUser.getUsername().equals(test_username))
			TestUtils.printTestPassed(test_case_name);
		else
			TestUtils.printTestFailed(test_case_name);

		// TC2
		test_case_name = "TC2-getPassword";
		if (testUser.getPassword().equals(test_password))
			TestUtils.printTestPassed(test_case_name);
		else
			TestUtils.printTestFailed(test_case_name);

		// TC3
		test_case_name = "TC3-getFirstName";
		if (testUser.getFirstName().equals(test_first_name))
			TestUtils.printTestPassed(test_case_name);
		else
			TestUtils.printTestFailed(test_case_name);

		// TC4
		test_case_name = "TC4-getLastName";
		if (testUser.getLastName().equals(test_last_name))
			TestUtils.printTestPassed(test_case_name);
		else
			TestUtils.printTestFailed(test_case_name);

		// TC5
		test_case_name = "TC5-getMobileNumber";
		if (testUser.getMobileNumber().equals(test_mobile_number))
			TestUtils.printTestPassed(test_case_name);
		else
			TestUtils.printTestFailed(test_case_name);
	
	// TODO5 - using Java assertions
	assert testUser.getUsername().equals(test_username);
	assert testUser.getPassword().equals(test_password);
	assert testUser.getFirstName().equals(test_first_name);
	assert testUser.getLastName().equals(test_last_name);
	assert testUser.getMobileNumber().equals(test_mobile_number);

	System.out.println("All Java assertions in the test suite passed (none failed).");
	}
}
