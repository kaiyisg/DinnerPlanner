package se.kth.csc.iprog.dinnerplanner.android;

import android.app.Activity;
import android.os.Bundle;

public class ViewRecipeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_recipe);
        this.getActionBar().setTitle("DinnerPlanner");


    }
}
