package allthatbeer.android.beer.com.whatisbeer;


import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by T on 2015-11-27.
 */
public class EstimateAdapter extends RecyclerView.Adapter<EstimateAdapter.ViewHolder> {
    Context context;
    List<EstimateItem> items;
    int item_layout;

    public EstimateAdapter(Context context, List<EstimateItem> items, int item_layout) {
        this.context=context;
        this.items=items;
        this.item_layout=item_layout;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_estimate,null);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final EstimateItem item=items.get(position);

        holder.image.setImageResource(item.getImage());
        holder.kName.setText(item.getkName());
        holder.eName.setText(item.geteName());
        holder.mRating.setRating(item.getPoint());
        holder.labelCard.setOnTouchListener(new View.OnTouchListener() {


            @Override
            public boolean onTouch(View v, MotionEvent event) {

                CardView dd=(CardView)holder.labelCard;

                int action = event.getAction();

                if(action==MotionEvent.ACTION_DOWN){

                    dd.setCardElevation(0.0f);
                    Toast.makeText(context, item.getkName(), Toast.LENGTH_SHORT).show();
                }else if(action==MotionEvent.ACTION_UP){

                    dd.setCardElevation(5.0f);

                }

                return true;
            }
        });
    }
    @Override
    public int getItemCount() {
        return this.items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView kName;
        TextView eName;
       RatingBar mRating;
        CardView itemCard;
        CardView labelCard;

        public ViewHolder(View itemView) {
            super(itemView);
            image=(ImageView)itemView.findViewById(R.id.est_Img);
            kName=(TextView)itemView.findViewById(R.id.est_kname);
            eName=(TextView)itemView.findViewById(R.id.est_eName);
            mRating=(RatingBar)itemView.findViewById(R.id.est_Rating);
            itemCard=(CardView)itemView.findViewById(R.id.item_estimate);
            labelCard=(CardView)itemView.findViewById(R.id.est_label);

        }
    }


}
