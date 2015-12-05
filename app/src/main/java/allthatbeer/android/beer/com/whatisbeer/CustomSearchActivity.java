package allthatbeer.android.beer.com.whatisbeer;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

/**
 * Created by T on 2015-12-03.
 */
public class CustomSearchActivity extends AppCompatActivity {
        CardView peopleCard;
    int mSelect=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_search);


        Toolbar toolbar = (Toolbar) findViewById(R.id.search_toolbar);
        setSupportActionBar(toolbar);
        setTitle(null);

        peopleCard = (CardView)findViewById(R.id.peopleCard);


        peopleCard.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                CardView pCard=(CardView)peopleCard;

                int action = event.getAction();

                if(action==MotionEvent.ACTION_DOWN){

                    pCard.setCardElevation(0.0f);


                }else if(action==MotionEvent.ACTION_UP){

                    pCard.setCardElevation(5.0f);
                    DialogSelectOption();

                }

                return true;

            }
        });



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search_menu, menu);
        return true;
    }

    private void DialogSelectOption() {
        final String items[] = { "1명", "2명", "3명","4명이상" };
        AlertDialog.Builder ab = new AlertDialog.Builder(CustomSearchActivity.this);
        ab.setTitle("인원");
        ab.setSingleChoiceItems(items, mSelect,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        // 각 리스트를 선택했을때
        mSelect=whichButton;
                    }
                }).setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        // OK 버튼 클릭시 , 여기서 선택한 값을 메인 Activity 로 넘기면 된다.
                        TextView peopleCount = (TextView)findViewById(R.id.peopleCount);
                        peopleCount.setText(items[mSelect]);


                    }
                }).setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        dialog.cancel();
                    }
                });
        ab.show();
    }
}
