package allthatbeer.android.beer.com.whatisbeer;


import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by T on 2015-11-27.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    Context context;
    List<RecylerItem> items;
    int item_layout;

    public RecyclerAdapter(Context context, List<RecylerItem> items, int item_layout) {
        this.context=context;
        this.items=items;
        this.item_layout=item_layout;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,null);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final RecylerItem item=items.get(position);

        holder.image.setImageResource(item.getImage());
        holder.bName.setText(item.getbName());
        holder.id.setText(item.getId());
        holder.content.setText(item.getContent());
        holder.labelCard.setOnTouchListener(new View.OnTouchListener() {


            @Override
            public boolean onTouch(View v, MotionEvent event) {

                CardView dd=(CardView)holder.labelCard;

                int action = event.getAction();

                if(action==MotionEvent.ACTION_DOWN){

                    dd.setCardElevation(0.0f);
                    Toast.makeText(context, item.getbName(), Toast.LENGTH_SHORT).show();
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
        TextView bName;
        TextView id;
        TextView content;
        CardView itemCard;
        CardView labelCard;

        public ViewHolder(View itemView) {
            super(itemView);
            image=(ImageView)itemView.findViewById(R.id.reply_label);
            bName=(TextView)itemView.findViewById(R.id.reply_bname);
            id=(TextView)itemView.findViewById(R.id.reply_id);
            content=(TextView)itemView.findViewById(R.id.reply_content);
            itemCard=(CardView)itemView.findViewById(R.id.item_card);
            labelCard=(CardView)itemView.findViewById(R.id.label_card);

        }
    }

}
