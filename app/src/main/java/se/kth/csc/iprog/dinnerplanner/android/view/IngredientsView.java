package se.kth.csc.iprog.dinnerplanner.android.view;

import android.graphics.Color;
import android.text.Layout;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Ingredient;


public class IngredientsView {

    View view;
    TextView numberOfPeople;
    TextView ingredients;
    TableLayout ingredientList;
    DinnerModel dinnerModel;

    public IngredientsView (View view, DinnerModel model){

        this.dinnerModel = model;
        this.view = view;

        numberOfPeople = (TextView)view.findViewById(R.id.textView16);
        ingredients = (TextView)view.findViewById(R.id.textView15);
        numberOfPeople.setTextColor(Color.BLACK);
        ingredients.setTextColor(Color.BLACK);
        ingredientList = (TableLayout)view.findViewById(R.id.ingredient_list_id);

        numberOfPeople.setText(model.getNumberOfGuests() + " pers");

        for (Ingredient i : model.getAllIngredients()){

            //creating new table row
            TableRow row = new TableRow(view.getContext());
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            row.setLayoutParams(lp);

            /*
            int leftMargin=5;
            int topMargin=2;
            int rightMargin=5;
            int bottomMargin=2;

            lp.setMargins(leftMargin, topMargin, rightMargin, bottomMargin);
            row.setLayoutParams(lp);*/

            //creating name of ingredient and adding it
            TextView tv = new TextView(view.getContext());
            tv.setText(i.getName());
            tv.setTextColor(Color.BLACK);
            row.addView(tv);

            //creating quantity of ingredient and adding it
            TextView tv2 = new TextView(view.getContext());
            tv2.setText(i.getQuantity() +" "+ i.getUnit());
            tv2.setTextColor(Color.BLACK);
            row.addView(tv2);

            ingredientList.addView(row);

        }

    }
}
