package allthatbeer.android.beer.com.whatisbeer;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by T on 2015-12-04.
 */
public class MypageFragment extends Fragment{
    CardView myBeerCard,myReviewCard;
    FragmentManager fm;


    public static MypageFragment newInstance() {
        MypageFragment fragment = new MypageFragment();
        return fragment;
    }

    public MypageFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         fm=getFragmentManager();
        Fragment mypageFrag =fm.findFragmentById(R.id.myPageframe);
        View root=inflater.inflate(R.layout.mypage_layout,container,false);
        myBeerCard=(CardView)root.findViewById(R.id.mybeer_card);
        myReviewCard=(CardView)root.findViewById(R.id.myreview_card);


        android.support.v4.app.FragmentTransaction tr = fm.beginTransaction();
        MyBeerFragment mbf = new MyBeerFragment();
        tr.replace(R.id.myPageframe, mbf);

        tr.commit();


        myBeerCard.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {


                int action = event.getAction();

                if (action == MotionEvent.ACTION_DOWN) {

                    myBeerCard.setCardElevation(0.0f);
                    android.support.v4.app.FragmentTransaction tr = fm.beginTransaction();
                    MyBeerFragment mbf = new MyBeerFragment();
                    tr.replace(R.id.myPageframe, mbf);

                    tr.commit();

                } else if (action == MotionEvent.ACTION_UP) {

                    myBeerCard.setCardElevation(5.0f);

                }

                return true;
            }
        });

        myReviewCard.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {


                int action = event.getAction();

                if (action == MotionEvent.ACTION_DOWN) {

                    myReviewCard.setCardElevation(0.0f);
                    android.support.v4.app.FragmentTransaction tr = fm.beginTransaction();
                    MyReviewFragment mrf=new MyReviewFragment();
                    tr.replace(R.id.myPageframe, mrf);

                    tr.commit();

                } else if (action == MotionEvent.ACTION_UP) {

                    myReviewCard.setCardElevation(5.0f);

                }

                return true;
            }
        });


        return root;
    }


   public static class MyReviewFragment extends Fragment {


        public MyReviewFragment newInstance() {
            MyReviewFragment fragment = new MyReviewFragment();
            return fragment;
        }

        public MyReviewFragment (){

        }

       @Override
       public void onCreate(Bundle savedInstanceState) {
           super.onCreate(savedInstanceState);

       }
       @Override
       public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

           View root = inflater.inflate(R.layout.myreview_layout, container, false);
           RecyclerView recyclerView = (RecyclerView) root.findViewById(R.id.myreview_list);
           LinearLayoutManager layoutManager = new LinearLayoutManager(root.getContext());
           recyclerView.setLayoutManager(layoutManager);

           List<RecylerItem> items=new ArrayList<>();
           RecylerItem[] item=new RecylerItem[5];
           item[0]=new RecylerItem(R.drawable.label_hei,R.drawable.profile,"하이네켄","챔스 좋아,하이네켄 좋아!",3,3);
           item[1]=new RecylerItem(R.drawable.label_hoga,R.drawable.profile,"호가든","분홍색 소시지 맛이 나네요",5,2);
           item[2]=new RecylerItem(R.drawable.label_ching,R.drawable.profile,"칭다오","혜자 맥주!! 흥해라!",5,5);
           item[3]=new RecylerItem(R.drawable.label_ko,R.drawable.profile,"코젤","체코본토에서 먹어봤는데 정말 잊을수가 없습니다",10,4);
           item[4]=new RecylerItem(R.drawable.label_leffe,R.drawable.profile,"레페","분위기 있는 맥주",1,1);

           for(int i=0;i<5;i++) items.add(item[i]);


           recyclerView.setAdapter(new MyReviewListAdapter(root.getContext(), items, R.layout.activity_main));


           return root;
       }


    }

    private static class MyReviewListAdapter extends RecyclerView.Adapter<MyReviewListAdapter.ViewHolder> {

        Context context;
        List<RecylerItem> items;
        int item_layout;

        public MyReviewListAdapter(Context context, List<RecylerItem> items, int item_layout) {
            this.context = context;
            this.items = items;
            this.item_layout = item_layout;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_myreview, null);

            return new ViewHolder(v);
        }


        public void onBindViewHolder(final ViewHolder holder, int position) {
            final RecylerItem item = items.get(position);

            holder.bImg.setImageResource(item.getImage());
            holder.bName.setText(item.getbName());
            holder.proImg.setImageResource(item.getProfileimg());
            holder.mRating.setRating(item.getPoint());
            holder.likecount.setText(String.valueOf(item.getLikeCount()));
            holder.content.setText(item.getContent());

        }

        @Override
        public int getItemCount() {
            return this.items.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            ImageView bImg;
            CircleImageView proImg;
            TextView bName,likecount,content;
            CardView itemCard;
            RatingBar mRating;


            public ViewHolder(View itemView) {
                super(itemView);
                proImg=(CircleImageView)itemView.findViewById(R.id.profile_image);
                bImg = (ImageView) itemView.findViewById(R.id.myreview_bImg);
                bName = (TextView) itemView.findViewById(R.id.myreview_bname);
                itemCard = (CardView) itemView.findViewById(R.id.item_card_myreview);
                likecount=(TextView)itemView.findViewById(R.id.likecount);
                content=(TextView)itemView.findViewById(R.id.myreview_content);
                mRating=(RatingBar)itemView.findViewById(R.id.myreview_rating);
            }
        }
    }

}
