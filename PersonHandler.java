package com.xiaohong.testXML;
import java.util.*;

import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class PersonHandler extends DefaultHandler{
	public List<Person> people ;
	private Person person;
	private String tag;
	
	
	public List<Person> getPeople() {
		return people;
	}
	public void setPeople(List<Person> people) {
		this.people = people;
	}
	//�ĵ���ʼ
	@Override
	public void startDocument() throws SAXException {
		System.out.println("�ĵ���ʼ");
		people = new ArrayList<Person>();
	}
   //��һ��Ԫ�ؿ�ʼ
	@Override
	public void startElement(String url, String localName, String qName,
			Attributes arg3) throws SAXException {
		System.out.println("��һ��Ԫ�ؿ�ʼ");
		if(qName != null)
			tag = qName;
		if(qName != null && qName.equals("server"))
			person = new Person();
	}
	
   //Ԫ�ش���ģ��
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		System.out.println("Ԫ�ش���ģ��");
		String str = new String(ch,start,length);
		if(tag != null && tag.equals("name"))
			person.setName(str);
		if(tag != null && tag.equals("age"))
			person.setAge(Integer.valueOf(str));
	}
	//���һ��Ԫ�ؽ���
	@Override
	public void endElement(String url, String localName, String qName)
			throws SAXException {
		System.out.println("���һ��Ԫ�ؽ���");
		if(qName != null){
			if(qName.equals("server"))
				people.add(person);
		}
		tag = null;
	}
	//�ĵ�����
	@Override
	public void endDocument() throws SAXException {
		System.out.println("�ĵ�����");
	}
}
