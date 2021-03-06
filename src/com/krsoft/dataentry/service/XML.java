package com.krsoft.dataentry.service;

import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.krsoft.dataentry.model.Constants;
import com.krsoft.dataentry.model.Person;

public class XML {
	private List<Person> userInputList;

	public XML(List<Person> userInputList) {
		super();
		this.userInputList = userInputList;
	}

	public List<Person> getUserInputList() {
		return userInputList;
	}

	public void setUserInputList(List<Person> userInputList) {
		this.userInputList = userInputList;
	}

	/**
	 * Creates an XML file from userInputList.
	 */
	public void createXML() {
		try {
			int id = 1;
			DocumentBuilderFactory docFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// Root
			Document doc = docBuilder.newDocument();
			Element rootElement = doc
					.createElement(Constants.XML_ROOT_ELEMENT_NAME);
			doc.appendChild(rootElement);

			for (Person userInput : userInputList) {

				// Person
				Element people = doc
						.createElement(Constants.XML_PEOPLE_ELEMENT_NAME);
				rootElement.appendChild(people);

				// ID
				Attr attr = doc
						.createAttribute(Constants.XML_PEOPLE_ATTRIBUTE_NAME);
				attr.setValue(String.valueOf(id));
				people.setAttributeNode(attr);

				// Name
				Element name = doc
						.createElement(Constants.XML_PERSON_ELEMENT_NAME);
				name.appendChild(doc.createTextNode(userInput.getName()));
				people.appendChild(name);

				// SSN
				Element socialSecurityNumber = doc
						.createElement(Constants.XML_SSN_ELEMENT_NAME);
				socialSecurityNumber.appendChild(doc.createTextNode(userInput
						.getSocialSecurityNumber()));
				people.appendChild(socialSecurityNumber);

				// Address
				Element address = doc
						.createElement(Constants.XML_ADDRESS_ELEMENT_NAME);
				address.appendChild(doc.createTextNode(userInput.getAddress()));
				people.appendChild(address);

				// Telephone
				Element telephone = doc
						.createElement(Constants.XML_TELEPHONE_ELEMENT_NAME);
				telephone.appendChild(doc.createTextNode(userInput
						.getTelephone()));
				people.appendChild(telephone);

				id++;
			}
			// Write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(
					Constants.XML_FILE_LOCATION));

			transformer.transform(source, result);

			System.out.println(Constants.XML_FILE_SAVED);

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}
	}
}
