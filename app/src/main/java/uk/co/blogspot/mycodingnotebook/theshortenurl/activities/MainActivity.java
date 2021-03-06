package uk.co.blogspot.mycodingnotebook.theshortenurl.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import uk.co.blogspot.mycodingnotebook.theshortenurl.R;
import uk.co.blogspot.mycodingnotebook.theshortenurl.framework.Configuration;
import uk.co.blogspot.mycodingnotebook.theshortenurl.framework.GenericActivity;
import uk.co.blogspot.mycodingnotebook.theshortenurl.models.UrlInfo;

public class MainActivity extends GenericActivity<UrlInfo>
        implements MainActivityFragment.OnShorten,
        Configuration {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        super.onCreate(UrlInfo.class);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void shorten(String uri) {
        Operations.handleUri(uri);
    }

    @Override
    public void set(String key, String value) {
        SharedPreferences settings = getSharedPreferences(key, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(key, value);
    }

    @Override
    public String get(String key) {
        SharedPreferences settings = getSharedPreferences(key, 0);
        return settings.getString(key, "");
    }
}
