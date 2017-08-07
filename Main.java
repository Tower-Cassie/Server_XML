package com.xiaohong.testXML;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
/**
 * 功能:按照流的方式读取xml的配置文件
 * 错误:在加载文档时，路径是包名/xml的配置文件，注意包名之间是“/”而不是"."
 * @author xiaohong
 *
 */
public class Main {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException{
				//1,获取解析工厂
				SAXParserFactory factory = SAXParserFactory.newInstance();
				//2.从解析工厂获取解析器
				SAXParser parser = factory.newSAXParser();
				//3，加载文档Documents 注册处理器
				//4，编写处理器
				 PersonHandler handler =  new PersonHandler();
				parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("com/xiaohong/testXML/person.xml"),handler);
				
				List<Person> peoples = handler.getPeople();
				for(Person p : peoples)
					System.out.println(p.getName() + "--->" + p.getAge());
		
	}

}
