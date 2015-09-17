package uk.co.blogspot.mycodingnotebook.theshortenurl.framework;

import android.app.Activity;

public class GenericActivity<T extends Operation> extends Activity {

    public T Operations;

    private RetainedFragmentManager retainedFragmentManager = new RetainedFragmentManager(getFragmentManager(), "Retained");

    public void onCreate(Class<T> ops)  {
        if (retainedFragmentManager.firstTime()) {
            try {
                initialise(ops);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
        else {
            Operations = (T) retainedFragmentManager.get();
            Operations.onconfiguration(this, false);
        }
    }

    private void initialise(Class<T> ops) throws IllegalAccessException, InstantiationException {
        T instance = ops.newInstance();
        retainedFragmentManager.put(instance);
        Operations = instance;
        Operations.onconfiguration(this, true);
    }
}
