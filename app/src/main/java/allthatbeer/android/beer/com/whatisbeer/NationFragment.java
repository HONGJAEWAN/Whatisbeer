package allthatbeer.android.beer.com.whatisbeer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by T on 2015-12-01.
 */
public class NationFragment extends Fragment {

    ExpandableListView el;
    private ArrayList<String> arrayGroup = new ArrayList<String>();
    private HashMap<String,ArrayList<String>> arrayChild = new HashMap<String,ArrayList<String>>();


    public static NationFragment newInstance() {
        NationFragment fragment = new NationFragment();
        return fragment;
    }

    public NationFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root=inflater.inflate(R.layout.nation_search,container,false);
        el=(ExpandableListView)root.findViewById(R.id.nation_el);
        setArrayData();
        el.setAdapter(new CountryExpandableListAdapter(this.getContext(), arrayGroup,arrayChild));

        return root;
    }

    private void setArrayData(){
        arrayGroup.add("벨기에");
        arrayGroup.add("체코");
        arrayGroup.add("중국");

        ArrayList<String> arrayBel = new ArrayList<String>();
        arrayBel.add("레페");
        arrayBel.add("호가든");

        ArrayList<String> arrayChz = new ArrayList<String>();
        arrayChz.add("코젤");

        ArrayList<String> arrayChina = new ArrayList<String>();
        arrayChina.add("칭다오");


        arrayChild.put(arrayGroup.get(0),arrayBel);
        arrayChild.put(arrayGroup.get(1),arrayChz);
        arrayChild.put(arrayGroup.get(2),arrayChina);



    }

}
