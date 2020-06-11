package com.example.testapp.ui.rss;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class RSSHandler extends DefaultHandler {

    String rssResult = "";
    boolean item = false;

    public void startElement(String uri, String localName, String qName,
                             Attributes attrs) throws SAXException {
        if (localName.equals("item"))
            item = true;

        if (!localName.equals("item") && item == true)
            rssResult = rssResult + localName + ": ";

    }

    public void endElement(String namespaceURI, String localName,
                           String qName) throws SAXException {

    }

    public void characters(char[] ch, int start, int length)
            throws SAXException {
        String cdata = new String(ch, start, length);
        if (item == true)
            rssResult = rssResult +(cdata.trim()).replaceAll("\\s+", " ")+"\t";

    }

}
