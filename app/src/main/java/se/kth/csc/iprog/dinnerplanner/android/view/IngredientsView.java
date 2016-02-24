package se.kth.csc.iprog.dinnerplanner.android.view;

import android.graphics.Color;
import android.text.Layout;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import se.kth.csc.iprog.dinnerplanner.android.R;


public class IngredientsView {

    View view;
    TextView numberOfPeople;
    TextView ingredients;
    View ingredientList;

    public IngredientsView (View view){

        this.view = view;

        numberOfPeople = (TextView)view.findViewById(R.id.textView16);
        ingredients = (TextView)view.findViewById(R.id.textView15);
        numberOfPeople.setTextColor(Color.BLACK);
        ingredients.setTextColor(Color.BLACK);
        ingredientList = view.findViewById(R.id.ingredient_list_id);

    }
}
