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
public class CateSearchFragment extends Fragment {

    TabLayout tabLayout;
    ViewPager viewPager;

    public static CateSearchFragment newInstance() {
        CateSearchFragment fragment = new CateSearchFragment();
        return fragment;
    }

    public CateSearchFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root=inflater.inflate(R.layout.cate_search_main,container,false);

        viewPager = (ViewPager)root.findViewById(R.id.cate_pager);


        tabLayout = (TabLayout)root.findViewById(R.id.cate_tab);
        tabLayout.addTab(tabLayout.newTab().setText("국가별"));
        tabLayout.addTab(tabLayout.newTab().setText("타입별"));
        tabLayout.addTab(tabLayout.newTab().setText("도수별"));
        tabLayout.addTab(tabLayout.newTab().setText("맛별"));
        setupTabIcons();

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

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(R.drawable.country);

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
                    NationFragment nf = new NationFragment();
                    return nf;
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
