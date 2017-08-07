package com.xiaohong.testXML;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
/**
 * ����:�������ķ�ʽ��ȡxml�������ļ�
 * ����:�ڼ����ĵ�ʱ��·���ǰ���/xml�������ļ���ע�����֮���ǡ�/��������"."
 * @author xiaohong
 *
 */
public class Main {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException{
				//1,��ȡ��������
				SAXParserFactory factory = SAXParserFactory.newInstance();
				//2.�ӽ���������ȡ������
				SAXParser parser = factory.newSAXParser();
				//3�������ĵ�Documents ע�ᴦ����
				//4����д������
				 PersonHandler handler =  new PersonHandler();
				parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("com/xiaohong/testXML/person.xml"),handler);
				
				List<Person> peoples = handler.getPeople();
				for(Person p : peoples)
					System.out.println(p.getName() + "--->" + p.getAge());
		
	}

}
