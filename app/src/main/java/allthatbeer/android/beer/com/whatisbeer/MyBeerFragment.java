package allthatbeer.android.beer.com.whatisbeer;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by T on 2015-12-04.
 */
public class MyBeerFragment extends Fragment {

    GridView mybeerGrid;
    List<EstimateItem> items=new ArrayList<>();
    EstimateItem[] item=new EstimateItem[5];

    public static MyBeerFragment newInstance() {
        MyBeerFragment fragment = new MyBeerFragment();
        return fragment;
    }


    public MyBeerFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root=inflater.inflate(R.layout.mybeers_grid,container,false);

        mybeerGrid = (GridView) root.findViewById(R.id.mybeer_grid);

        ((GridView)mybeerGrid).setAdapter(new GridAdapter(getActivity()));


        item[0]=new EstimateItem(R.drawable.label_hei,"하이네켄","Heineken",0);
        item[1]=new EstimateItem(R.drawable.label_hoga,"호가든","Hogarden",1);
        item[2]=new EstimateItem(R.drawable.label_ching,"칭다오","Thingdado",2);
        item[3]=new EstimateItem(R.drawable.label_ko,"코젤","Kozel",3);
        item[4]=new EstimateItem(R.drawable.label_leffe,"레페","Leffe",4);

        for(int i=0;i<5;i++) items.add(item[i]);



        return root;
    }


    class GridAdapter extends BaseAdapter {





        LayoutInflater inflater;





        public GridAdapter(Context c) {

            inflater = LayoutInflater.from(c);

        }


        @Override

        public int getCount() {

            return items.size();    //그리드뷰에 출력할 목록 수

        }



        @Override

        public Object getItem(int position) {



            return items.get(position);    //아이템을 호출할 때 사용하는 메소드

        }



        @Override

        public long getItemId(int position) {

// TODO Auto-generated method stub

            return position;    //아이템의 아이디를 구할 때 사용하는 메소드

        }



        @Override

        public View getView(int position, View convertView, ViewGroup parent) {

// TODO Auto-generated method stub

            if(convertView == null) {

                convertView = inflater.inflate(R.layout.item_mybeers, parent, false);

            }

            CardView mybeerCard=(CardView)convertView.findViewById(R.id.mybeer_item);
            ImageView mybeerImg = (ImageView) convertView.findViewById(R.id.mybeer_img);

            TextView mybeerKname = (TextView) convertView.findViewById(R.id.mybeer_kname);
            TextView mybeerPoint=(TextView) convertView.findViewById(R.id.mybeer_point);

            mybeerImg.setImageResource(items.get(position).getImage());

            mybeerKname.setText(items.get(position).getkName());
            mybeerPoint.setText(String.valueOf(items.get(position).getPoint()));

            mybeerCard.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    return false;
                }
            });

            return convertView;

        }
    }

}
