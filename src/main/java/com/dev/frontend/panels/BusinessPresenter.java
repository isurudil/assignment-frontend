package com.dev.frontend.panels;

import java.io.IOException;

public interface BusinessPresenter
{
	boolean bindToGUI(Object o);
	void clear();
	void onInit() throws IOException;
	Object guiToObject();

}
