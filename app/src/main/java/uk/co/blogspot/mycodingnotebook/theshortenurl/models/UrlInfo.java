package uk.co.blogspot.mycodingnotebook.theshortenurl.models;

import android.app.Activity;
import android.util.Log;

import uk.co.blogspot.mycodingnotebook.theshortenurl.Constants;
import uk.co.blogspot.mycodingnotebook.theshortenurl.framework.L;
import uk.co.blogspot.mycodingnotebook.theshortenurl.framework.Operation;

public class UrlInfo implements Operation {

    public void parseUrl()
    {

    }

    public boolean handleUri(String uri)
    {
        L.i("Received string " + uri);
        return false;
    }

    @Override
    public void onconfiguration(Activity activity, boolean firstTime) {

        Log.i(Constants.TAG, "Configuration changing '" + firstTime + "'");
    }
}
