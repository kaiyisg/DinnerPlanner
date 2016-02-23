package se.kth.csc.iprog.dinnerplanner.android.view;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import se.kth.csc.iprog.dinnerplanner.android.ChooseMenuActivity;
import se.kth.csc.iprog.dinnerplanner.android.R;

public class WelcomeView {

    View view;
    Button startButton;


    public WelcomeView (View view){

        this.view = view;


        startButton = (Button)view.findViewById(R.id.button);

        startButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ChooseMenuActivity.class);
                view.getContext().startActivity(intent);
            }
        });


    }


}
