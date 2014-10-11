package com.lin.clould.web.command;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.net.URL;
import java.sql.SQLException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class CommandFactoryTest {
	
	
	private String configXML = "context/context.xml";
	private Document document; 
	
	
	@Before 
	public void setUp() throws Exception {
		ClassLoader loader = this.getClass().getClassLoader();
		URL pathURL = loader.getResource(configXML);
		DocumentBuilderFactory bulidFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = bulidFactory.newDocumentBuilder();
		
		document = builder.parse(pathURL.openStream());
	}

	@Test
	public void documentCreate() {
		assertThat(document == null, is(false));
	}
	
	@Test // 단일 노드 값 가져오기
	public void defaultViewPath() throws SQLException, ClassNotFoundException {
		NodeList defaultViewPathNodeList = document.getElementsByTagName(CommandConstant.TAG_DEFAULT_VIEW_PATH);
		Element defaultViewPathElement = (Element) defaultViewPathNodeList.item(0);
		Node defaultViewPathNode = defaultViewPathElement.getFirstChild();
		
		assertThat(defaultViewPathNode.getNodeValue(), is("/WEB-INF/jsp/"));
		
	}
	
}
