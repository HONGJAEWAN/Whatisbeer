package allthatbeer.android.beer.com.whatisbeer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import io.apptik.widget.MultiSlider;

/**
 * Created by T on 2015-12-02.
 */
public class AbvSearchFragment extends Fragment {

    public static AbvSearchFragment newInstance() {
        AbvSearchFragment fragment = new AbvSearchFragment();
        return fragment;
    }

    public AbvSearchFragment(){

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.abv_search, container, false);
        final TextView min6 = (TextView) v.findViewById(R.id.minValue6);
        final TextView max6 = (TextView) v.findViewById(R.id.maxValue6);
        MultiSlider multiSlider6 = (MultiSlider)v.findViewById(R.id.range_slider6);

        multiSlider6.setOnThumbValueChangeListener(new MultiSlider.SimpleOnThumbValueChangeListener() {
            @Override
            public void onValueChanged(MultiSlider multiSlider, MultiSlider.Thumb thumb, int thumbIndex, int value) {
                if (thumbIndex == 0) {
                    min6.setText(String.valueOf(value));
                } else {
                    max6.setText(String.valueOf(value));
                }
            }
        });
        return v;
    }
}
