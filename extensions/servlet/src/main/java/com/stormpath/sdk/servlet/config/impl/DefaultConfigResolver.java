package com.stormpath.sdk.servlet.config.impl;

import com.stormpath.sdk.lang.Assert;
import com.stormpath.sdk.servlet.config.Config;
import com.stormpath.sdk.servlet.config.ConfigLoader;
import com.stormpath.sdk.servlet.config.ConfigResolver;
import com.stormpath.sdk.servlet.config.DefaultConfigLoaderListener;

import javax.servlet.ServletContext;

public class DefaultConfigResolver implements ConfigResolver {

    private static final String SERVLET_CONTEXT_ATTRIBUTE_NAME = ConfigLoader.CONFIG_ATTRIBUTE_NAME;

    private static final String NULL_ERR_MSG = "There is no Config instance accessible via the ServletContext " +
                                               "attribute key [" + SERVLET_CONTEXT_ATTRIBUTE_NAME + "].  This is an " +
                                               "invalid webapp configuration.  Consider defining " +
                                               DefaultConfigLoaderListener.class.getName() +
                                               " in web.xml or manually adding " +
                                               "a Config instance to the ServletContext under this key.  " +
                                               "For example:\n\n" +
                                               "<listener>\n" +
                                               "     <listener-class>" +
                                               DefaultConfigLoaderListener.class.getName() +
                                               "</listener-class>\n" +
                                               " </listener>";

    private static final String INSTANCE_ERR_MSG = "ServletContext attribute '" + SERVLET_CONTEXT_ATTRIBUTE_NAME +
                                                   "' value must be a " + Config.class.getName() + " instance.";

    public Config getConfig(ServletContext servletContext) {

        Assert.notNull(servletContext, "ServletContext argument cannot be null.");

        Object value = servletContext.getAttribute(SERVLET_CONTEXT_ATTRIBUTE_NAME);

        Assert.notNull(value, NULL_ERR_MSG);

        Assert.isInstanceOf(Config.class, value, INSTANCE_ERR_MSG);

        return (Config) value;
    }
}
