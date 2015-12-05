package allthatbeer.android.beer.com.whatisbeer;

import android.widget.RatingBar;

/**
 * Created by T on 2015-11-27.
 */
public class EstimateItem {

    int image;
    String kName;
    String eName;
    RatingBar mRating;
    int point;

    int getImage(){
        return this.image;
    }
    String getkName(){
        return this.kName;
    }
    String geteName(){
        return this.eName;
    }
    RatingBar getmRating(){

        return this.mRating;
    }
    int getPoint(){return this.point;}

    EstimateItem(int image, String kName, String eName,int point){
        this.image=image;
        this.kName=kName;
        this.eName=eName;
        this.point=point;

    }
    EstimateItem(int image, String kName,int point){
        this.image=image;
        this.kName=kName;

        this.point=point;

    }
}
