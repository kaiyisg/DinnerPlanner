package se.kth.csc.iprog.dinnerplanner.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import se.kth.csc.iprog.dinnerplanner.android.view.ExampleView;
import se.kth.csc.iprog.dinnerplanner.android.view.WelcomeView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Default call to load previous state
        super.onCreate(savedInstanceState);

        // Set the view for the main activity screen
        // it must come before any call to findViewById method
        setContentView(R.layout.activity_main);

        // Creating the view class instance
        WelcomeView welcomeView = new WelcomeView(findViewById(R.id.welcome_view_id));


        //ExampleView mainView = new ExampleView(findViewById(R.id.this_is_example_view_id));
    }

    // TODO: 17-Feb-16 changing the title bar and styling it, must introduce new functions, etc, if have time

}
