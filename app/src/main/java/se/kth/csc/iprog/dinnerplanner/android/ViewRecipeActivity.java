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

import se.kth.csc.iprog.dinnerplanner.android.view.IngredientsView;
import se.kth.csc.iprog.dinnerplanner.android.view.RecipesView;
import se.kth.csc.iprog.dinnerplanner.android.view.ViewRecipeBgView;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;

public class ViewRecipeActivity extends Activity {

    DinnerModel dinnerModel;
    ViewGroup insertPoint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_recipe);
        this.getActionBar().setTitle("DinnerPlanner");

        ImageButton ingredientsImage = (ImageButton)findViewById(R.id.imageButton);
        ImageButton starterImage = (ImageButton)findViewById(R.id.imageButton2);
        ImageButton mainsImage = (ImageButton)findViewById(R.id.imageButton3);
        ImageButton dessertImage = (ImageButton)findViewById(R.id.imageButton4);

        insertPoint = (ViewGroup) findViewById(R.id.display_stuff_id);

        dinnerModel = ((DinnerPlannerApplication) this.getApplication()).getModel();

        ViewRecipeBgView viewRecipeBgView = new ViewRecipeBgView(findViewById(R.id.view_recipe_bg_view_id), dinnerModel);


        ingredientsImage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                insertPoint.removeAllViews();
                LayoutInflater vi = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View v = vi.inflate(R.layout.ingredients_view, null);
                insertPoint.addView(v, 0, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT,
                        ViewGroup.LayoutParams.FILL_PARENT));
                IngredientsView ingredientsView = new IngredientsView(findViewById(R.id.ingredients_layout_id), dinnerModel);

            }
        });

        starterImage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                insertPoint.removeAllViews();
                LayoutInflater vi = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View v = vi.inflate(R.layout.recipes_view, null);
                insertPoint.addView(v, 0, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT,
                        ViewGroup.LayoutParams.FILL_PARENT));
                RecipesView recipesView = new RecipesView(findViewById(R.id.recipes_view_id), dinnerModel, Dish.STARTER);

            }
        });

        mainsImage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                insertPoint.removeAllViews();
                LayoutInflater vi = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View v = vi.inflate(R.layout.recipes_view, null);
                insertPoint.addView(v, 0, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT,
                        ViewGroup.LayoutParams.FILL_PARENT));
                RecipesView recipesView = new RecipesView(findViewById(R.id.recipes_view_id), dinnerModel, Dish.MAIN);

            }
        });

        dessertImage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                insertPoint.removeAllViews();
                LayoutInflater vi = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View v = vi.inflate(R.layout.recipes_view, null);
                insertPoint.addView(v, 0, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT,
                        ViewGroup.LayoutParams.FILL_PARENT));
                RecipesView recipesView = new RecipesView(findViewById(R.id.recipes_view_id), dinnerModel, Dish.DESERT);

            }
        });

    }
}
