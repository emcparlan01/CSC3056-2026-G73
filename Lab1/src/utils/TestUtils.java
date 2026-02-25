package utils;

public class TestUtils {

	public static final String TEXT_COLOR_GREEN = "\u001B[32m";
	public static final String TEXT_COLOR_RED = "\u001B[31m";
	public static final String TEXT_COLOR_RESET = "\u001B[0m";

	public static void printTestPassed(String test_case_name) {
		System.out.println(TEXT_COLOR_GREEN + test_case_name + "-Passed" + TEXT_COLOR_RESET);
	}

	public static void printTestFailed(String test_case_name) {
		System.out.println(TEXT_COLOR_RED + test_case_name + "-FAILED" + TEXT_COLOR_RESET);
	}
}
