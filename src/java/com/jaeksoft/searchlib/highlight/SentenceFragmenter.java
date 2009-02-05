/**   
 * License Agreement for Jaeksoft SearchLib Community
 *
 * Copyright (C) 2008 Emmanuel Keller / Jaeksoft
 * 
 * http://www.jaeksoft.com
 * 
 * This file is part of Jaeksoft SearchLib Community.
 *
 * Jaeksoft SearchLib Community is free software: you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 * Jaeksoft SearchLib Community is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with Jaeksoft SearchLib Community. 
 *  If not, see <http://www.gnu.org/licenses/>.
 **/

package com.jaeksoft.searchlib.highlight;

import org.w3c.dom.NamedNodeMap;

public class SentenceFragmenter extends FragmenterAbstract {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4962131354275204301L;

	public FragmenterAbstract newInstance() {
		return new SentenceFragmenter();
	}

	public void setAttributes(NamedNodeMap attr) {
	}

	public void check(String originalText) {
		int pos = 0;
		char[] chars = originalText.toCharArray();
		for (char ch : chars) {
			switch (ch) {
			case '.':
			case '?':
			case '!':
				addSplit(pos + 1);
				break;
			}
			pos++;
		}
	}
}
