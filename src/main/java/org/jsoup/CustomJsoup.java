/*
 * Copyright 2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jsoup;

import org.jsoup.nodes.CustomDocument;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

/**
 * Custom {@link Jsoup}
 */
public class CustomJsoup {
	
	/**
	 * Constructor
	 */
	protected CustomJsoup() {
		
		/* NOP */
	}
	
	/**
	 * Parse HTML
	 * 
	 * @param html {@link Document#html()}
	 * @return {@link CustomDocument}
	 */
	public static CustomDocument parseHtml(String html) {
		
		return parseHtml(html, "");
	}
	
	/**
	 * Parse
	 * 
	 * @param html {@link Document#html()}
	 * @param baseUri {@link Document#baseUri()}
	 * @return {@link CustomDocument}
	 */
	public static CustomDocument parseHtml(String html, String baseUri) {
		
		return new CustomDocument(Parser.parse(html, baseUri));
	}
	
	/**
	 * Parse XML
	 * 
	 * @param xml {@link Document#html()}
	 * @return {@link CustomDocument}
	 */
	public static CustomDocument parseXml(String xml) {
		
		return parseXml(xml, "");
	}
	
	/**
	 * Parse XML
	 * 
	 * @param xml {@link Document#html()}
	 * @param baseUri {@link Document#baseUri()}
	 * @return {@link CustomDocument}
	 */
	public static CustomDocument parseXml(String xml, String baseUri) {
		
		return new CustomDocument(Parser.xmlParser().parseInput(xml, baseUri));
	}
}
