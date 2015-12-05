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
 * Created by T on 2015-12-03.
 */
public class RankFragment extends Fragment {

    TabLayout typeRankTab,genderTab;
    ViewPager genderPager,typePager;

    public static RankFragment newInstance() {
        RankFragment fragment = new RankFragment();
        return fragment;
    }

    public RankFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.rank_layout, container, false);

        genderPager=(ViewPager)root.findViewById(R.id.geder_pager);
        typePager=(ViewPager)root.findViewById(R.id.typeRank_pager);

        genderTab = (TabLayout)root.findViewById(R.id.gender_tab);
        genderTab.addTab(genderTab.newTab().setText("남자"));
        genderTab.addTab(genderTab.newTab().setText("여자"));

        typeRankTab = (TabLayout)root.findViewById(R.id.rank_tab);

        typeRankTab.addTab(typeRankTab.newTab().setText("밀맥주"));
        typeRankTab.addTab(typeRankTab.newTab().setText("흑맥주"));
        typeRankTab.addTab(typeRankTab.newTab().setText("라거"));
        typeRankTab.addTab(typeRankTab.newTab().setText("필스너"));
        typeRankTab.addTab(typeRankTab.newTab().setText("에일"));
        typeRankTab.addTab(typeRankTab.newTab().setText("IPA"));

        GenderPagerAdapter gadapter = new GenderPagerAdapter
                (getFragmentManager(), genderTab.getTabCount());

        TypeRankPagerAdapter trAdapter=new TypeRankPagerAdapter
                (getFragmentManager(), typeRankTab.getTabCount());

        typePager.setAdapter(trAdapter);
        typePager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(typeRankTab));



        genderPager.setAdapter(gadapter);
        genderPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(genderTab));


        genderTab.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                genderPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        typeRankTab.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                typePager.setCurrentItem(tab.getPosition());
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







    class GenderPagerAdapter extends FragmentStatePagerAdapter {
        int mNumOfTabs;

        public GenderPagerAdapter(FragmentManager manager,int NumOfTabs) {
            super(manager);
            this.mNumOfTabs=NumOfTabs;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    ManRankFragment mf = new ManRankFragment();
                    return mf;
                case 1:
                    TypeSearchFragment tsf = new TypeSearchFragment();
                    return tsf;

                case 2:


                case 3:


                case 4:


                case 5:




                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return mNumOfTabs;
        }


    }

    class TypeRankPagerAdapter extends FragmentStatePagerAdapter {
        int mNumOfTabs;

        public TypeRankPagerAdapter(FragmentManager manager, int NumOfTabs) {
            super(manager);
            this.mNumOfTabs = NumOfTabs;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    WheatRankFragment wrf = new WheatRankFragment();
                    return wrf;
                case 1:
                    TypeSearchFragment tsf = new TypeSearchFragment();
                    return tsf;

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
