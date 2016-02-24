package se.kth.csc.iprog.dinnerplanner.android.view;

import android.text.Layout;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import se.kth.csc.iprog.dinnerplanner.android.R;


public class IngredientsView {

    View view;
    TextView numberOfPeople;
    View ingredientList;

    public IngredientsView (View view){

        numberOfPeople = (TextView)view.findViewById(R.id.textView16);
        ingredientList = view.findViewById(R.id.ingredient_list_id);

    }
}
