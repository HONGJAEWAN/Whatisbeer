package allthatbeer.android.beer.com.whatisbeer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by T on 2015-11-10.
 */
public class CountryExpandableListAdapter extends BaseExpandableListAdapter  {

    Context mContext;
    private ArrayList<String> mArrayGroup;
    private HashMap<String,ArrayList<String>> mArrayChild;




    final int GROUP_ITEM_RESOURCE = R.layout.country_group;
    final int CHILD_ITEM_RESOURCE = R.layout.country_item;


    public CountryExpandableListAdapter(Context context, ArrayList<String> arrayGroup, HashMap<String,ArrayList<String>> arrayChild) {
        super();
        this.mContext = context;
        this.mArrayGroup=arrayGroup;
        this.mArrayChild=arrayChild;

    }


    public Object getChild(int groupPosition, int childPosition) {
        return mArrayChild.get(mArrayGroup.get(groupPosition)).get(childPosition);
    }

    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    public int getChildrenCount(int groupPosition) {
        return mArrayChild.get(mArrayGroup.get(groupPosition)).size();
    }

    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        View v = convertView;
        String child = mArrayChild.get(mArrayGroup.get(groupPosition)).get(childPosition);

       if(v==null){
           LayoutInflater lf = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
           v=(LinearLayout)lf.inflate(R.layout.country_item,null);
       }
        TextView elistBname=(TextView)v.findViewById(R.id.elist_bName);
        elistBname.setText(child);

        return v;
    }


    public Object getGroup(int groupPosition) {
        return mArrayGroup.get(groupPosition);
    }
    public int getGroupCount() {
        return mArrayGroup.size();
    }
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        View v = convertView;
        String group = mArrayGroup.get(groupPosition);



        if(v==null){
            LayoutInflater lf=(LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v=(LinearLayout)lf.inflate(R.layout.country_group,null);
        }

        TextView flagName=(TextView)v.findViewById(R.id.flag_name);
        flagName.setText(group);


        return v;
    }
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
    public boolean hasStableIds() {
        return true;
    }


}
