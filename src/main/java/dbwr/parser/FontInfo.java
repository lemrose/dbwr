/*******************************************************************************
 * Copyright (c) 2019 Oak Ridge National Laboratory.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the LICENSE
 * which accompanies this distribution
 ******************************************************************************/
package dbwr.parser;

import java.util.Map;

public class FontInfo
{
	private final int size;
    private final boolean bold;

	public FontInfo(final int size, final boolean bold)
	{
		this.size = size;
		this.bold = bold;
	}

	public int getSize()
	{
		return size;
	}

	public void addToStyles(Map<String, String> styles)
	{
		styles.put("font-size", size + "px");
		if (bold)
	        styles.put("font-weight", "bold");
	}

	@Override
	public String toString()
	{
	    final StringBuilder buf = new StringBuilder();
	    buf.append("font-size: ").append(size).append("px;");
	    if (bold)
	        buf.append("font-weight: bold;");
	    return buf.toString();
	}
}
