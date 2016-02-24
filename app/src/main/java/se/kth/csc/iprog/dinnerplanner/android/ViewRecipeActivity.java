package se.kth.csc.iprog.dinnerplanner.android;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import se.kth.csc.iprog.dinnerplanner.android.view.ViewRecipeBgView;

public class ViewRecipeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_recipe);
        this.getActionBar().setTitle("DinnerPlanner");

        ImageButton ingredientsImage = (ImageButton)findViewById(R.id.imageButton);
        ImageButton starterImage = (ImageButton)findViewById(R.id.imageButton2);
        ImageButton mainsImage = (ImageButton)findViewById(R.id.imageButton3);
        ImageButton dessertImage = (ImageButton)findViewById(R.id.imageButton4);

        ViewRecipeBgView viewRecipeBgView = new ViewRecipeBgView(findViewById(R.id.view_recipe_bg_view_id));

        ingredientsImage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                /*
                View ingredientsLayout = findViewById(R.id.ingredients_layout_id);
                LinearLayout viewBgRecipeView = findViewById(R.id.linearLayout2);
                View ingredientsView = getLayoutInflater().inflate(R.layout.ingredients_view, viewBgRecipeView, false);
                if(ingredientsLayout == null){
                    LinearLayout myLayout = (LinearLayout)findViewById(R.id.linearLayout2);
                    View hiddenInfo = getLayoutInflater().inflate(R.layout.hidden, myLayout, false);
                    myLayout.addView(hiddenInfo);
                }*/


                LayoutInflater vi = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View v = vi.inflate(R.layout.ingredients_view, null);
                ViewGroup insertPoint = (ViewGroup) findViewById(R.id.display_stuff_id);
                insertPoint.addView(v, 0, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));
            }
        });

    }
}
