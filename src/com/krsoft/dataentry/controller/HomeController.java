package com.krsoft.dataentry.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.krsoft.dataentry.model.Constants;
import com.krsoft.dataentry.model.Person;
import com.krsoft.dataentry.service.XML;

public class HomeController {

	public static void main(String[] args) {

		// Create new ArrayList to store all potential user input
		XML handleXML =  new XML(getUserInputList());
		handleXML.createXML();
	}

	private static List<Person> getUserInputList() {
		List<Person> userInputList = new ArrayList<Person>();
		boolean isExit = false;
		while (!(isExit)) {
			userInputList.add(getUserInput());
			System.out.println(Constants.EXIT_MESSAGE);
			if (Constants.EXIT_CONFIRM.equals(getUserInputText())) {
				isExit = true;
				System.out.println(Constants.EXIT_SUCCESS);
			}
		}
		return userInputList;
	}

	private static Person getUserInput() {
		System.out.println(Constants.DATA_ENTRY_BEGIN);
		Person userInput = new Person(getUserName(), getUserSSN(),
				getUserAddress(), getUserTelephone());
		System.out.println(Constants.NAME_SAVED + userInput.getName());
		System.out.println(Constants.SSN_SAVED
				+ userInput.getSocialSecurityNumber());
		System.out.println(Constants.ADDRESS_SAVED + userInput.getAddress());
		System.out
				.println(Constants.TELEPHONE_SAVED + userInput.getTelephone());
		return userInput;
	}

	private static String getUserTelephone() {
		System.out.println(Constants.PLEASE_ENTER_TELEPHONE);
		String userInputText = getUserInputText();
		Boolean userTelephoneValidation = validateUserTelephone(userInputText);
		if (userTelephoneValidation) {
			return userInputText;
		} else {
			return getUserTelephone();
		}
	}

	private static String getUserAddress() {
		System.out.println(Constants.PLEASE_ENTER_ADDRESS);
		String userInputText = getUserInputText();
		Boolean userAddressValidation = validateUserAddress(userInputText);
		if (userAddressValidation) {
			return userInputText;
		} else {
			return getUserAddress();
		}
	}

	private static String getUserName() {
		System.out.println(Constants.PLEASE_ENTER_NAME);
		String userInputText = getUserInputText();
		Boolean userNameValidation = validateUserInputName(userInputText);
		if (userNameValidation) {
			return userInputText;
		} else {
			return getUserName();
		}
	}

	private static String getUserSSN() {
		System.out.println(Constants.PLEASE_ENTER_SSN);
		String userInputText = getUserInputText();
		Boolean userSSNValidation = validateUserSSN(userInputText);
		if (userSSNValidation) {
			return userInputText;
		} else {
			return getUserSSN();
		}
	}

	private static String getUserInputText() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String userInputText = br.readLine();
			return userInputText;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	/*
	 * Will accept anything that starts with an uppercase letter, followed by
	 * zero or more of any letter, space, hyphen, ampersand or apostrophes, and
	 * ending with a letter.
	 */
	private static boolean validateUserInputName(String userInputText) {
		String patternText = Constants.REGEX_PATTERN_NAME_CHECK;
		Pattern pattern = Pattern.compile(patternText);
		Matcher matcher = pattern.matcher(userInputText);
		while (matcher.find()) {
			System.out.println(Constants.NAME_OK);
			return true;
		}
		System.out.println(Constants.NAME_NOT_OK);
		return false;
	}

	/*
	 * SSN must be 11 characters long and must only consist of numbers.
	 */
	private static boolean validateUserSSN(String userInputText) {
		String patternText = Constants.REGEX_PATTERN_SSN_CHECK;
		Pattern pattern = Pattern.compile(patternText);
		Matcher matcher = pattern.matcher(userInputText);
		while (matcher.find()) {
			System.out.println(Constants.SSN_OK);
			return true;
		}
		System.out.println(Constants.SSN_NOT_OK);
		return false;
	}

	/*
	 * Address must start with an uppercase letter and be at least 3 characters
	 * long.
	 */
	private static boolean validateUserAddress(String userInputText) {
		String patternText = Constants.REGEX_PATTERN_ADDRESS_CHECK;
		Pattern pattern = Pattern.compile(patternText);
		Matcher matcher = pattern.matcher(userInputText);
		while (matcher.find()) {
			System.out.println(Constants.ADDRESS_OK);
			return true;
		}
		System.out.println(Constants.ADDRESS_NOT_OK);
		return false;
	}

	private static Boolean validateUserTelephone(String userInputText) {
		String patternText = Constants.REGEX_PATTERN_TELEPHONE_CHECK;
		Pattern pattern = Pattern.compile(patternText);
		Matcher matcher = pattern.matcher(userInputText);
		while (matcher.find()) {
			System.out.println(Constants.TELEPHONE_OK);
			return true;
		}
		System.out.println(Constants.TELEPHONE_NOT_OK);
		return false;
	}

}
