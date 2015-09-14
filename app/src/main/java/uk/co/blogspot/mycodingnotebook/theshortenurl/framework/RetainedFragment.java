package uk.co.blogspot.mycodingnotebook.theshortenurl.framework;

import android.app.Fragment;
import android.os.Bundle;

/**
 * http://developer.android.com/guide/topics/resources/runtime-changes.html#RetainingAnObject
 */
public class RetainedFragment extends Fragment {

    private Object instanceToRetain;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    public void put(Object instance)
    {
        this.instanceToRetain = instance;
    }

    public Object get()
    {
        return this.instanceToRetain;
    }
}
