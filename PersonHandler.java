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
	//文档开始
	@Override
	public void startDocument() throws SAXException {
		System.out.println("文档开始");
		people = new ArrayList<Person>();
	}
   //第一个元素开始
	@Override
	public void startElement(String url, String localName, String qName,
			Attributes arg3) throws SAXException {
		System.out.println("第一个元素开始");
		if(qName != null)
			tag = qName;
		if(qName != null && qName.equals("server"))
			person = new Person();
	}
	
   //元素处理模块
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		System.out.println("元素处理模块");
		String str = new String(ch,start,length);
		if(tag != null && tag.equals("name"))
			person.setName(str);
		if(tag != null && tag.equals("age"))
			person.setAge(Integer.valueOf(str));
	}
	//最后一个元素结束
	@Override
	public void endElement(String url, String localName, String qName)
			throws SAXException {
		System.out.println("最后一个元素结束");
		if(qName != null){
			if(qName.equals("server"))
				people.add(person);
		}
		tag = null;
	}
	//文档结束
	@Override
	public void endDocument() throws SAXException {
		System.out.println("文档结束");
	}
}
