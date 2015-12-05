package allthatbeer.android.beer.com.whatisbeer;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    HomeFragment hf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hf=new HomeFragment();

        final android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame, hf);
        ft.commit();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CustomSearchActivity.class);
                startActivity(intent);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



    }

    public static class HomeFragment extends  Fragment{

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            View root=inflater.inflate(R.layout.content_main,container,false);


            RecyclerView recyclerView = (RecyclerView) root.findViewById(R.id.recyclerView);
            LinearLayoutManager layoutManager = new LinearLayoutManager(root.getContext());

            recyclerView.setLayoutManager(layoutManager);
            List<RecylerItem> items=new ArrayList<>();
            RecylerItem[] item=new RecylerItem[5];
            item[0]=new RecylerItem(R.drawable.label_hei,"하이네켄","rlovenara","챔스 좋아,하이네켄 좋아!");
            item[1]=new RecylerItem(R.drawable.label_hoga,"호가든","오가든이싫어요","분홍색 소시지 맛이 나네요");
            item[2]=new RecylerItem(R.drawable.label_ching,"칭다오","워스중구오른","혜자 맥주!! 흥해라!");
            item[3]=new RecylerItem(R.drawable.label_ko,"코젤","할머니가한국인","체코본토에서 먹어봤는데 정말 잊을수가 없습니다");
            item[4]=new RecylerItem(R.drawable.label_leffe,"레페","호우호우","분위기 있는 맥주");

            for(int i=0;i<5;i++) items.add(item[i]);

            recyclerView.setAdapter(new RecyclerAdapter(root.getContext(), items, R.layout.activity_main));

            return root;
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

       FragmentManager fm=getSupportFragmentManager();
        Fragment fragment =fm.findFragmentById(R.id.frame);


        int id = item.getItemId();

        if (id == R.id.nav_home) {
            android.support.v4.app.FragmentTransaction tr = fm.beginTransaction();
            HomeFragment hf=new HomeFragment();

            tr.replace(R.id.frame,hf);
            tr.addToBackStack(null);
            tr.commit();

        } else if (id == R.id.nav_cateSearch) {
            android.support.v4.app.FragmentTransaction tr = fm.beginTransaction();
            CateSearchFragment csf=new CateSearchFragment();
            tr.replace(R.id.frame,csf);
            tr.addToBackStack(null);
            tr.commit();
        } else if (id == R.id.nav_estimate) {
            android.support.v4.app.FragmentTransaction tr = fm.beginTransaction();
            EstimateFragment ef=new EstimateFragment();
            tr.replace(R.id.frame,ef);
            tr.addToBackStack(null);
            tr.commit();
        } else if (id == R.id.nav_mypage) {

            android.support.v4.app.FragmentTransaction tr = fm.beginTransaction();
            MypageFragment mf=new MypageFragment();
            tr.replace(R.id.frame,mf);
            tr.addToBackStack(null);
            tr.commit();

        } else if(id == R.id.nav_static){
            android.support.v4.app.FragmentTransaction tr = fm.beginTransaction();
            RankFragment rf=new RankFragment();
            tr.replace(R.id.frame,rf);
            tr.addToBackStack(null);
            tr.commit();
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
