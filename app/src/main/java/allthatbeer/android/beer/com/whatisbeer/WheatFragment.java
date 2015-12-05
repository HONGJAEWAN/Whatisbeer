package allthatbeer.android.beer.com.whatisbeer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by T on 2015-11-30.
 */
public class WheatFragment extends Fragment {

    public static WheatFragment newInstance() {
        WheatFragment fragment = new WheatFragment();
        return fragment;
    }

    public WheatFragment(){

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root=inflater.inflate(R.layout.type_list,container,false);
        RecyclerView recyclerView = (RecyclerView) root.findViewById(R.id.type_recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(root.getContext());

        recyclerView.setLayoutManager(layoutManager);
        List<RecylerItem> items=new ArrayList<>();
        RecylerItem[] item=new RecylerItem[5];
        item[0]=new RecylerItem(R.drawable.label_hei,"하이네켄");
        item[1]=new RecylerItem(R.drawable.label_hoga,"호가든");
        item[2]=new RecylerItem(R.drawable.label_ching,"칭다오");
        item[3]=new RecylerItem(R.drawable.label_ko,"코젤");
        item[4]=new RecylerItem(R.drawable.label_leffe,"레페");

        for(int i=0;i<5;i++) items.add(item[i]);

        recyclerView.setAdapter(new TypeListAdapter(root.getContext(), items, R.layout.type_list));

        return root;

    }

}
