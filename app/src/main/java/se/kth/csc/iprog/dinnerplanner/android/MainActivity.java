package se.kth.csc.iprog.dinnerplanner.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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

        Button startButton = (Button)findViewById(R.id.button);

        startButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ChooseMenuActivity.class);
                view.getContext().startActivity(intent);
            }
        });

    }

    // TODO: 17-Feb-16 changing the title bar and styling it, must introduce new functions, etc, if have time

}
