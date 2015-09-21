package uk.co.blogspot.mycodingnotebook.theshortenurl.framework;

import android.os.AsyncTask;

import retrofit.RestAdapter;
import uk.co.blogspot.mycodingnotebook.theshortenurl.Remote.SecuredRestBuilder;

/**
 * Created by malindasuhash on 20/09/15.
 */
public class AuthTask extends AsyncTask<Void, Void, Void> {
    @Override
    protected Void doInBackground(Void... voids) {
        SecuredRestBuilder builder = new SecuredRestBuilder();
        BitlySvc all = builder.setEndpoint("https://api-ssl.bitly.com")
                .setLoginEndpoint("https://api-ssl.bitly.com/oauth/access_token")
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build().create(BitlySvc.class);

        all.shorten();

        return null;
    }

}
