package com.krsoft.dataentry.model;

public class Constants {

	public static String XML_PATH;
	public static String DATA_ENTRY_BEGIN = "----------- NEW DATA ENTRY -----------";
	public static String EXIT_MESSAGE = "Please type \"Exit\" to exit. Press enter to continue entering data.";
	public static String EXIT_CONFIRM = "Exit";
	public static String EXIT_SUCCESS = "Exiting data entry, proceeding to build the XML file.";
	
	public static String PLEASE_ENTER_NAME = "Name: ";
	public static String NAME_OK = "Name OK.";
	public static String NAME_NOT_OK = "Name NOT OK. Will accept anything that starts with an uppercase letter, followed by zero or more of any letter, space, hyphen, ampersand or apostrophes, and ending with a letter.";
	public static String NAME_SAVED = "Name saved.";
	// First letter uppercase A-Z, can contain any letter and whitespace ', &, - in the middle. Also has to end with a letter.
	public static String REGEX_PATTERN_NAME_CHECK = "^[A-Z][a-zA-Z '&-]*[A-Za-z]$";
	
	public static String PLEASE_ENTER_SSN = "Social Security Number: ";
	// Only numberic, exactly 11 characters.
	public static String REGEX_PATTERN_SSN_CHECK = "^[0-9]{11}$";
	public static String SSN_OK = "SSN OK.";
	public static String SSN_SAVED = "SSN saved.";
	public static String SSN_NOT_OK = "SSN NOT OK. SSN must be 11 characters long and must only consist of numbers.";
	
	public static String PLEASE_ENTER_ADDRESS = "Address: ";
	// First letter uppercase A-Z, at least 3 characters long and can contain any word character AND whitespace, ', -
	public static String REGEX_PATTERN_ADDRESS_CHECK = "^[A-Z][\\w '-]*{3,}$";
	public static String ADDRESS_OK = "Address OK.";
	public static String ADDRESS_SAVED = "Address saved.";
	public static String ADDRESS_NOT_OK = "Address NOT OK.";
	
	public static String PLEASE_ENTER_TELEPHONE = "Telephone: ";
	// Only numeric and 4-20 characters.
	public static String REGEX_PATTERN_TELEPHONE_CHECK = "^[0-9]{4,20}$";
	public static String TELEPHONE_OK = "Telephone OK.";
	public static String TELEPHONE_SAVED = "Telephone saved.";
	public static String TELEPHONE_NOT_OK = "Telephone NOT OK. Only numeric and 4-20 characters.";
	
	public static String XML_ROOT_ELEMENT_NAME = "DataEntryXML";
	public static String XML_PEOPLE_ELEMENT_NAME = "People";
	public static String XML_PEOPLE_ATTRIBUTE_NAME = "ID";
	public static String XML_FILE_LOCATION = "res/people.xml";
	public static String XML_PERSON_ELEMENT_NAME = "Person";
	public static String XML_SSN_ELEMENT_NAME = "SSN";
	public static String XML_ADDRESS_ELEMENT_NAME = "Address";
	public static String XML_TELEPHONE_ELEMENT_NAME = "Telephone";
	
}
