package uk.co.blogspot.mycodingnotebook.theshortenurl.framework;

import android.app.FragmentManager;

/*
    Creates a new RetainedFragment and adds to the fragment manager.
 */
public class RetainedFragmentManager {

    private String fragmentName;
    private FragmentManager fragmentManager;
    private RetainedFragment retainedFragment;

    public RetainedFragmentManager(FragmentManager fragmentManager, String fragmentName)
    {
        this.fragmentName = fragmentName;
        this.fragmentManager = fragmentManager;
    }

    public boolean firstTime() {
        retainedFragment = (RetainedFragment) fragmentManager.findFragmentByTag(fragmentName);

        if (retainedFragment != null) {
            return false;
        }

        retainedFragment = new RetainedFragment();
        fragmentManager.beginTransaction()
                .add(retainedFragment, fragmentName)
                .commit();

        return true;
    }

    public void put(Object instance) {
        retainedFragment.put(instance);
    }

    public Object get() {
        return retainedFragment.get();
    }
}
