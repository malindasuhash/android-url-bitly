package uk.co.blogspot.mycodingnotebook.theshortenurl.activities;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import uk.co.blogspot.mycodingnotebook.theshortenurl.R;
import uk.co.blogspot.mycodingnotebook.theshortenurl.framework.L;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private OnShorten onShortenCallbacks;

    public MainActivityFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View inflatedView = inflater.inflate(R.layout.fragment_main, container, false);
        attachListeners(inflatedView);

        return  inflatedView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try
        {
            onShortenCallbacks = (OnShorten)activity;
        }
        catch (Exception e) {
            L.i("Looks like the Activity does not implement OnShare contract.");
        }
    }

    /**
     * Invoked when the user attempts to share a url.
     */
    public void shorten(View view) {
        TextView uriToShare = (TextView) getActivity().findViewById(R.id.uriToShare);
        onShortenCallbacks.shorten(uriToShare.getText().toString());
    }

    /**
     * Attach click handlers to the buttons.
     */
    private void attachListeners(View inflatedView)
    {
       (inflatedView.findViewById(R.id.shortenbtn))
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        shorten(view);
                    }
                });
    }

    public interface OnShorten
    {
        void shorten(String uri);
    }
}
