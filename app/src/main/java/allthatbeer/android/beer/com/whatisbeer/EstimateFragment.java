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
public class EstimateFragment extends Fragment {

    public static EstimateFragment newInstance() {
        EstimateFragment fragment = new EstimateFragment();
        return fragment;
    }

    public EstimateFragment(){

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root=inflater.inflate(R.layout.content_est,container,false);
        RecyclerView recyclerView = (RecyclerView) root.findViewById(R.id.est_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(root.getContext());

        recyclerView.setLayoutManager(layoutManager);
        List<EstimateItem> items=new ArrayList<>();
        EstimateItem[] item=new EstimateItem[5];
        item[0]=new EstimateItem(R.drawable.label_hei,"하이네켄","Heineken",0);
        item[1]=new EstimateItem(R.drawable.label_hoga,"호가든","Hogarden",1);
        item[2]=new EstimateItem(R.drawable.label_ching,"칭다오","Thingdado",2);
        item[3]=new EstimateItem(R.drawable.label_ko,"코젤","Kozel",3);
        item[4]=new EstimateItem(R.drawable.label_leffe,"레페","Leffe",4);

        for(int i=0;i<5;i++) items.add(item[i]);

        recyclerView.setAdapter(new EstimateAdapter(root.getContext(), items, R.layout.activity_main));

        return root;

    }

}
