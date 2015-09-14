package uk.co.blogspot.mycodingnotebook.theshortenurl.models;

import android.util.Log;

import uk.co.blogspot.mycodingnotebook.theshortenurl.Constants;
import uk.co.blogspot.mycodingnotebook.theshortenurl.framework.Operation;

public class UrlInfo implements Operation {

    @Override
    public void onconfiguration(boolean firstTime) {

        Log.i(Constants.TAG, "Configuration changing '" + firstTime + "'");
    }
}
