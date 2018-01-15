package com.brainfeaster.sanneo.simpletools.helper;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by sanja on 9/13/2017.
 */

public interface testDelegate {
    public void parse(InputStream inputStream, int processID) throws XmlPullParserException, IOException;
}
