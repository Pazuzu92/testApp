package com.example.testapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.io.IOException;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.testapp.R;
import com.example.testapp.ui.rss.RSSHandler;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import java.net.URL;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class RssFragment extends Fragment {

    String rssResult = "";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        TextView rss;
        View root = inflater.inflate(R.layout.fragment_rss, container, false);

        rss = root.findViewById(R.id.rss);

        try {
            URL rssUrl = new URL("https://appbrowser.ru");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            XMLReader xmlReader = saxParser.getXMLReader();
            RSSHandler rssHandler = new RSSHandler();
            xmlReader.setContentHandler(rssHandler);
            InputSource inputSource = new InputSource(rssUrl.openStream());
            xmlReader.parse(inputSource);
            rss.setText(rssResult);
        } catch (IOException e) {rss.setText(e.getMessage());
        } catch (SAXException e) {rss.setText(e.getMessage());
        } catch (ParserConfigurationException e) {rss.setText(e.getMessage());
        }
        return root;
    }


}
