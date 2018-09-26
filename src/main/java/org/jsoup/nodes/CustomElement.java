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

package org.jsoup.nodes;

import java.util.Optional;

import org.jsoup.AttributeNotFoundException;
import org.jsoup.ElementNotFoundException;
import org.jsoup.select.CustomElements;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Custom {@link Element}
 */
@RequiredArgsConstructor
public class CustomElement {
	
	/**
	 * Delegate
	 */
	@Getter
	@Accessors(fluent = true)
	@NonNull
	private final Element delegate;
	
	/**
	 * {@link Element#select(String)}
	 * 
	 * @param query query
	 * @return {@link CustomElements}
	 */
	public CustomElements select(String query) {
		
		return new CustomElements(this.delegate.select(query));
	}
	
	/**
	 * {@link Element#selectFirst(String)}
	 * 
	 * @param query query
	 * @return {@link CustomElement}
	 * @throws ElementNotFoundException if not found
	 */
	public CustomElement selectFirst(String query) throws ElementNotFoundException {
		
		return Optional.ofNullable(this.delegate.selectFirst(query))
		/* @formatter:off */
			.map(CustomElement::new)
			.orElseThrow(() -> new ElementNotFoundException(query));
			/* @formatter:on */
	}
	
	/**
	 * {@link Element#hasAttr(String)}
	 * 
	 * @param key key
	 * @return {@code true} if has
	 */
	public boolean hasAttr(String key) {
		
		return this.delegate.hasAttr(key);
	}
	
	/**
	 * {@link Element#attr(String)}
	 * 
	 * @param key key
	 * @return value
	 * @throws AttributeNotFoundException if not found
	 */
	public String attr(String key) throws AttributeNotFoundException {
		
		if (this.hasAttr(key)) {
			
			return this.delegate.attr(key);
		}
		
		throw new AttributeNotFoundException(key);
	}
	
	/**
	 * {@link Element#text()}
	 * 
	 * @return text
	 */
	public String text() {
		
		return this.delegate.text();
	}
	
	/**
	 * {@link Element#ownText()}
	 * 
	 * @return own text
	 */
	public String ownText() {
		
		return this.delegate.ownText();
	}
}
