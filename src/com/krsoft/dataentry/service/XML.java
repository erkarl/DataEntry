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

	public void createXML() {
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			Document doc = docBuilder.newDocument();

			Element rootElement = doc
					.createElement(Constants.XML_ROOT_ELEMENT_NAME);

			Element people = doc
					.createElement(Constants.XML_PEOPLE_ELEMENT_NAME);
			rootElement.appendChild(people);

			Element name = doc.createElement(Constants.XML_PERSON_ELEMENT_NAME);
			people.appendChild(name);
			Element socialSecurityNumber = doc
					.createElement(Constants.XML_SSN_ELEMENT_NAME);
			people.appendChild(socialSecurityNumber);
			Element address = doc
					.createElement(Constants.XML_ADDRESS_ELEMENT_NAME);
			people.appendChild(address);
			Element telephone = doc
					.createElement(Constants.XML_TELEPHONE_ELEMENT_NAME);
			people.appendChild(telephone);
			Attr attribute = doc
					.createAttribute(Constants.XML_PEOPLE_ATTRIBUTE_NAME);

			int idCounter = 1;
			for (Person userInput : userInputList) {

				attribute.setValue(String.valueOf(idCounter));

				name.appendChild(doc.createTextNode(userInput.getName()));

				socialSecurityNumber.appendChild(doc.createTextNode(userInput
						.getSocialSecurityNumber()));

				address.appendChild(doc.createTextNode(userInput.getAddress()));

				telephone.appendChild(doc.createTextNode(userInput
						.getTelephone()));

				System.out.println(userInput.getName() + " "
						+ userInput.getSocialSecurityNumber() + " ID "
						+ idCounter);
				idCounter++;
			}

			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			Transformer transformer = transformerFactory.newTransformer();

			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(
					Constants.XML_FILE_LOCATION));

			transformer.transform(source, result);
			System.out.println("File saved.");

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}
	}
}
