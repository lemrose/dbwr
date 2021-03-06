/*******************************************************************************
 * Copyright (c) 2019 Oak Ridge National Laboratory.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the LICENSE
 * which accompanies this distribution
 ******************************************************************************/
package dbwr;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.fasterxml.jackson.core.JsonFactory;

@WebListener
public class WebDisplayRepresentation implements ServletContextListener
{
    /** Common logger */
	public static final Logger logger = Logger.getLogger(WebDisplayRepresentation.class.getPackage().getName());

	/** Common JSON factory */
	public static final JsonFactory json_factory = new JsonFactory();

	public static final List<String> display_options = new ArrayList<>();

	static
	{
	    // Load display links for the start page from environment variables "DBWR1", "DBWR2", ...
	    int i=1;
	    String display = System.getenv("DBWR" + i);
	    while (display != null)
	    {
	        display_options.add(display);
	        display = System.getenv("DBWR" + (++i));
	    }

	    // If none are provided, add some defaults
	    if (display_options.isEmpty())
	    {
	        display_options.add("https://raw.githubusercontent.com/shroffk/phoebus/master/app/display/model/src/main/resources/examples/01_main.bob");
	        display_options.add("file:/some/local/display.bob");
	    }
	}

	@Override
	public void contextInitialized(final ServletContextEvent ev)
    {
        final ServletContext context = ev.getServletContext();

        logger.log(Level.INFO, "===========================================");
        logger.log(Level.INFO, context.getContextPath() + " started");
        logger.log(Level.INFO, "===========================================");
    }

    @Override
    public void contextDestroyed(final ServletContextEvent ev)
    {
        final ServletContext context = ev.getServletContext();

        logger.log(Level.INFO, "===========================================");
        logger.log(Level.INFO, context.getContextPath() + " shut down");
        logger.log(Level.INFO, "===========================================");
    }
}
