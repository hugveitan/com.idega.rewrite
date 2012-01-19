package com.idega.rewrite;

import com.idega.idegaweb.IWBundle;
import com.idega.idegaweb.IWBundleStartable;
import com.idega.idegaweb.IWMainApplication;
import com.idega.rewrite.util.NoForwardRedirectHandler;
import com.idega.servlet.filter.util.PagesRedirectHandler;


public class IWBundleStarter implements IWBundleStartable {

	public static final String APPLICATION_PROPERTY_BUNDLE_INITIALIZED = "com.idega.rewrite.bundle.initialized";
	/* (non-Javadoc)
	 * @see com.idega.idegaweb.IWBundleStartable#start(com.idega.idegaweb.IWBundle)
	 */
	public void start(IWBundle starterBundle) {
		//Disabling the forward mechanism of IWWelcomeFilter by registering a filter that always returns false for forward
		//This enables uninterrupted use of pretty-config.xml documents to declare rewrites and JSF url mapping
		if(starterBundle!=null){
			IWMainApplication iwma = starterBundle.getApplication();
			String handlerClassProperty = iwma.getSettings().getProperty(PagesRedirectHandler.ATTRIBUTE_PAGES_REDIRECT_HANDLER_CLASS);
			if(handlerClassProperty == null){
				String initialized = iwma.getSettings().getProperty(APPLICATION_PROPERTY_BUNDLE_INITIALIZED);
				if(initialized == null || !"true".equalsIgnoreCase(initialized)){
					iwma.getSettings().setProperty(PagesRedirectHandler.ATTRIBUTE_PAGES_REDIRECT_HANDLER_CLASS, NoForwardRedirectHandler.class.getName());
					iwma.getSettings().setProperty(APPLICATION_PROPERTY_BUNDLE_INITIALIZED,"true");
				}
			}
		}
	}

	/* (non-Javadoc)
	 * @see com.idega.idegaweb.IWBundleStartable#stop(com.idega.idegaweb.IWBundle)
	 */
	public void stop(IWBundle starterBundle) {
		// TODO Auto-generated method stub
	}
}
