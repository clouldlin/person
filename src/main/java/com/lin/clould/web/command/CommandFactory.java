package com.lin.clould.web.command;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class CommandFactory {
	
	private static Logger logger = Logger.getLogger(CommandFactory.class);
	
	private Map<String, Map<String, Object>> cmdMap;
	
	private String configXML = "context/context.xml";
	
	/**
	 * 
	 * 설정 파일을 읽어서 Map의 형태로 객체들을 보관하는 작업
	 * @throws Exception
	 * 
	 */
	
	public void init() throws Exception {
		cmdMap = new HashMap<String, Map<String, Object>>();
		readConfig(configXML);
	}
	
	private void readConfig(String fileName) throws Exception {
		
		ClassLoader loader = this.getClass().getClassLoader();
		URL pathURL = loader.getResource(fileName);
		
		DocumentBuilderFactory bulidFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = bulidFactory.newDocumentBuilder();
		
		Document document = builder.parse(pathURL.openStream());
		
		NodeList commandNode = document.getElementsByTagName(CommandConstant.TAG_COMMAND);
	
		logger.info("NodeList Length : " + commandNode.getLength());
		
		for (int i = 0; i < commandNode.getLength(); i++) {
			
			Map<String, Object> context = new HashMap<String, Object>();
			
			// Node == Element
			Element element = (Element)commandNode.item(i);
			context.put(CommandConstant.ATTR_CLASS, (Command)Class.forName(element.getAttribute(CommandConstant.ATTR_CLASS)).newInstance());
			
			NodeList childNodeList = element.getChildNodes();
			
			for (int j = 0; j < childNodeList.getLength(); j++) {
				
				Node childNode = childNodeList.item(j);

				if (CommandConstant.TAG_DEFAULT_METHOD.equals(childNode.getNodeName())) {
					context.put(CommandConstant.TAG_DEFAULT_METHOD, (childNode.getChildNodes().item(0).getNodeValue()));
				} 
			}
			
			cmdMap.put(element.getAttribute(CommandConstant.ATTR_ID), context);
		}
		
		Map<String, Object> defaultVeiePath = new HashMap<String, Object>();
		
		NodeList defaultViewPathNodeList = document.getElementsByTagName(CommandConstant.TAG_DEFAULT_VIEW_PATH);
		Element defaultViewPathElement = (Element) defaultViewPathNodeList.item(0);
		Node defaultViewPathNode = defaultViewPathElement.getFirstChild();
		defaultVeiePath.put(CommandConstant.TAG_DEFAULT_VIEW_PATH, defaultViewPathNode.getNodeValue());
		
		cmdMap.put(CommandConstant.TAG_DEFAULT_VIEW_PATH, defaultVeiePath);
		
		
	}
	
	
	public Map<String, Object> lookup(String callPath) throws Exception {
		Map<String, Object> target = null;
		
		// callPath에 해당하는 Command 타입의 객체를 target에 할당
		target = (Map<String, Object>) cmdMap.get(callPath);
		logger.info(target);
		return target;
	}
	
	public String getDefaultViewPath() throws Exception {
		String defaultViewPath = null;
		defaultViewPath = (String) cmdMap.get(CommandConstant.TAG_DEFAULT_VIEW_PATH).get(CommandConstant.TAG_DEFAULT_VIEW_PATH);
		logger.info("DefaultViewPath : " + defaultViewPath);
		return defaultViewPath;
	}
}
