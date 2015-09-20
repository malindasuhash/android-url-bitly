package uk.co.blogspot.mycodingnotebook.theshortenurl.models;

import android.app.Activity;
import android.net.Uri;
import android.util.Log;

import uk.co.blogspot.mycodingnotebook.theshortenurl.Constants;
import uk.co.blogspot.mycodingnotebook.theshortenurl.framework.AuthTask;
import uk.co.blogspot.mycodingnotebook.theshortenurl.framework.L;
import uk.co.blogspot.mycodingnotebook.theshortenurl.framework.Operation;

public class UrlInfo implements Operation {

    private String urlToShorten;

    public void handleUri(String uri)
    {
        L.i("Received string " + uri);
        urlToShorten = uri;

        Uri toShorten = Uri.parse(uri);

        if (toShorten == null ||
                toShorten.getAuthority() == null ||
                !toShorten.getAuthority().contains(Constants.HTTP)) {
            // Cannot be parsed, then show dialog
            L.i("Sorry, the uri cannot be parsed");
            //return;
        }

        AuthTask task = new AuthTask();
        task.execute();
    }

    @Override
    public void onconfiguration(Activity activity, boolean firstTime) {

        Log.i(Constants.TAG, "Configuration changing '" + firstTime + "'");
    }
}
