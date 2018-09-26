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

package org.jsoup.select;

import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

import org.jsoup.ElementNotFoundException;
import org.jsoup.nodes.CustomElement;

import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.Accessors;

/**
 * Custom {@link Elements}
 */
@SuppressWarnings("serial")
public class CustomElements extends ArrayList<CustomElement> {
	
	/**
	 * Delegate
	 */
	@Getter
	@Accessors(fluent = true)
	@NonNull
	private final Elements delegate;
	
	/**
	 * Constructor
	 * 
	 * @param delegate {@link #delegate}
	 */
	public CustomElements(Elements delegate) {
		
		super(Objects.requireNonNull(delegate).stream().map(CustomElement::new).collect(Collectors.toList()));
		
		this.delegate = delegate;
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @return {@link CustomElement}
	 * @throws ElementNotFoundException if not found
	 */
	@Override
	public CustomElement get(int index) throws ElementNotFoundException {
		
		try {
			
			return super.get(index);
		}
		catch (IndexOutOfBoundsException e) {
			
			throw new ElementNotFoundException(index);
		}
	}
	
	/**
	 * {@link Elements#first()}
	 * 
	 * @return {@link CustomElement}
	 * @throws ElementNotFoundException if not found
	 */
	public CustomElement first() throws ElementNotFoundException {
		
		return this.get(0);
	}
	
	/**
	 * {@link Elements#last()}
	 * 
	 * @return {@link CustomElement}
	 * @throws ElementNotFoundException if not found
	 */
	public CustomElement last() throws ElementNotFoundException {
		
		return this.get(this.size() - 1);
	}
}
