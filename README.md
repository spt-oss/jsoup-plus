# jsoup Plus

[![circleci](https://img.shields.io/badge/circleci-jsoup--plus-brightgreen.svg)](https://circleci.com/gh/spt-oss/jsoup-plus)
[![maven central](https://img.shields.io/badge/maven_central-jsoup--plus-blue.svg)](https://mvnrepository.com/artifact/com.github.spt-oss/jsoup-plus)
[![javadoc](https://img.shields.io/badge/javadoc-jsoup--plus-blue.svg)](https://www.javadoc.io/doc/com.github.spt-oss/jsoup-plus)

* Custom implementation for [jsoup](https://github.com/jhy/jsoup)

## Usage

1. Add a dependency in your project.

	```xml
	<dependency>
	    <groupId>com.github.spt-oss</groupId>
	    <artifactId>jsoup</artifactId>
	    <version>1.11.3.0</version>
	</dependency>
	```

1. Parse your HTML or XML as same as jsoup.

	```java
	import org.jsoup.CustomJsoup;
	import org.jsoup.AttributeNotFoundException;
	import org.jsoup.ElementNotFoundException;
	import org.jsoup.nodes.CustomDocument;
	
	CustomDocument doc = CustomJsoup.parseHtml("<html>......");
	
	// You can catch runtime exception when element or attribute not found
	try {
	    
	    String url = doc.selectFirst("#foo a").attr("href");
	    ......
	}
	catch (ElementNotFoundException | AttributeNotFoundException e) {
	    
	    ......
	}
	```
	```java
	import org.jsoup.CustomJsoup;
	import org.jsoup.nodes.CustomDocument;
	
	CustomDocument doc = CustomJsoup.parseXml("<?xml version=\"1.0\"?>......");
	
	String url = doc.selectFirst("link").text();
	......
	```

## License

* This software is released under the Apache License 2.0.
