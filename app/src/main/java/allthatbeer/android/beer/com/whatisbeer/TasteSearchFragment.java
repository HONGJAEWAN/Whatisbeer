package allthatbeer.android.beer.com.whatisbeer;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by T on 2015-12-02.
 */
public class TasteSearchFragment extends Fragment {

    TabLayout tabLayout;
    ViewPager viewPager;

    public static TasteSearchFragment newInstance() {
        TasteSearchFragment fragment = new TasteSearchFragment();
        return fragment;
    }

    public TasteSearchFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root=inflater.inflate(R.layout.type_search,container,false);

        viewPager = (ViewPager)root.findViewById(R.id.type_pager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout)root.findViewById(R.id.type_tab);
        tabLayout.setupWithViewPager(viewPager);


        return root;
    }


    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getFragmentManager());
        adapter.addFragment(new WheatFragment(), "단맛");
        adapter.addFragment(new NationFragment(), "쌉살한맛");
        adapter.addFragment(new NationFragment(), "과일맛");
        adapter.addFragment(new NationFragment(), "톡쏘는맛");
        adapter.addFragment(new NationFragment(), "구수한맛");


        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
