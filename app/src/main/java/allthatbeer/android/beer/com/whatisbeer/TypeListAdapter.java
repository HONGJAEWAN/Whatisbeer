package allthatbeer.android.beer.com.whatisbeer;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by T on 2015-12-02.
 */
public class TypeListAdapter extends RecyclerView.Adapter<TypeListAdapter.ViewHolder> {

    Context context;
    List<RecylerItem> items;
    int item_layout;

    public TypeListAdapter(Context context, List<RecylerItem> items, int item_layout) {
        this.context=context;
        this.items=items;
        this.item_layout=item_layout;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_typelist,null);

        return new ViewHolder(v);
    }


    public void onBindViewHolder(final ViewHolder holder, int position) {
        final RecylerItem item = items.get(position);

        holder.image.setImageResource(item.getImage());
        holder.bName.setText(item.getbName());
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView bName;
        CardView itemCard;
        CardView labelCard;

        public ViewHolder(View itemView) {
            super(itemView);
            image=(ImageView)itemView.findViewById(R.id.type_label);
            bName=(TextView)itemView.findViewById(R.id.type_bname);
            itemCard=(CardView)itemView.findViewById(R.id.item_card_type);
            labelCard=(CardView)itemView.findViewById(R.id.label_card_type);

        }
    }


}
