package allthatbeer.android.beer.com.whatisbeer;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by T on 2015-12-02.
 */
public class TypeSearchFragment extends Fragment {

    TabLayout tabLayout;
    ViewPager viewPager;

    public static TypeSearchFragment newInstance() {
        TypeSearchFragment fragment = new TypeSearchFragment();
        return fragment;
    }

    public TypeSearchFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root=inflater.inflate(R.layout.type_search,container,false);

        viewPager = (ViewPager)root.findViewById(R.id.type_pager);

        tabLayout = (TabLayout)root.findViewById(R.id.type_tab);

        tabLayout.addTab(tabLayout.newTab().setText("밀맥주"));
        tabLayout.addTab(tabLayout.newTab().setText("흑맥주"));
        tabLayout.addTab(tabLayout.newTab().setText("애일"));
        tabLayout.addTab(tabLayout.newTab().setText("라거"));
        tabLayout.addTab(tabLayout.newTab().setText("필스너"));
        tabLayout.addTab(tabLayout.newTab().setText("IPA"));

        ViewPagerAdapter adapter = new ViewPagerAdapter
                (getFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return root;
    }




    class ViewPagerAdapter extends FragmentStatePagerAdapter {
        int mNumOfTabs;

        public ViewPagerAdapter(FragmentManager manager,int NumOfTabs) {
            super(manager);
            this.mNumOfTabs=NumOfTabs;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    WheatFragment wf = new WheatFragment();
                    return wf;
                case 1:
                    TypeSearchFragment tsf = new TypeSearchFragment();
                    return tsf;
                case 2:
                    AbvSearchFragment asf = new AbvSearchFragment();
                    return asf;
                case 3:
                    TasteSearchFragment tsf1 = new TasteSearchFragment();
                    return tsf1;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return mNumOfTabs;
        }


    }
}
