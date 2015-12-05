package allthatbeer.android.beer.com.whatisbeer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by T on 2015-12-04.
 */
public class WheatRankFragment extends Fragment {

    public static WheatRankFragment newInstance() {
        WheatRankFragment fragment = new WheatRankFragment();
        return fragment;
    }

    public WheatRankFragment(){

    }


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.item_rank, container, false);

        return v;
    }
}
