package se.kth.csc.iprog.dinnerplanner.android.view;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import se.kth.csc.iprog.dinnerplanner.android.ChooseMenuActivity;
import se.kth.csc.iprog.dinnerplanner.android.R;

public class ViewRecipeBgView {

    View view;

    TextView foodItemsCost;
    ImageButton ingredientsImage;
    ImageButton starterImage;
    ImageButton mainsImage;
    ImageButton dessertImage;
    TextView starterName;
    TextView mainsName;
    TextView dessertName;

    public ViewRecipeBgView(View view){

        foodItemsCost = (TextView)view.findViewById(R.id.textView7);
        ingredientsImage = (ImageButton)view.findViewById(R.id.imageButton);
        starterImage = (ImageButton)view.findViewById(R.id.imageButton2);
        mainsImage = (ImageButton)view.findViewById(R.id.imageButton3);
        dessertImage = (ImageButton)view.findViewById(R.id.imageButton4);
        starterName = (TextView)view.findViewById(R.id.textView11);
        mainsName = (TextView)view.findViewById(R.id.textView13);
        dessertName = (TextView)view.findViewById(R.id.textView12);

        /*ingredientsImage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                LayoutInflater vi = (LayoutInflater) view.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            }
        });*/

    }

}
