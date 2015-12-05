package allthatbeer.android.beer.com.whatisbeer;

import android.app.Application;
import android.content.Context;

/**
 * Created by T on 2015-11-04.
 */
public class MyBeerApplication extends Application {
    private static Context myContext;

    @Override
    public void onCreate() {
        super.onCreate();
        myContext = this;
    }
    public static Context getContext(){
        return myContext;
    }
}
