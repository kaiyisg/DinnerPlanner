package se.kth.csc.iprog.dinnerplanner.android.view;


import android.graphics.Color;
import android.text.Layout;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;

public class RecipesView {

    View view;
    DinnerModel dinnerModel;
    int dishType;

    public RecipesView(View view, DinnerModel model, int type){

        this.view = view;
        this.dinnerModel = model;
        this.dishType = type;

        TextView title = (TextView)view.findViewById(R.id.textView17);
        TextView dishName = (TextView)view.findViewById(R.id.textView18);
        TextView dishInstructions = (TextView)view.findViewById(R.id.textView19);

        Dish dishToDisplay = model.getSelectedDish(type);

        if(dishToDisplay!=null){

            if(dishType == Dish.STARTER){

                title.setText("Starter");
                title.setTextColor(Color.BLACK);

            }else if(dishType == Dish.MAIN){

                title.setText("Main Course");
                title.setTextColor(Color.BLACK);

            }else{

                title.setText("Dessert");
                title.setTextColor(Color.BLACK);

            }

            dishName.setText(dishToDisplay.getName());
            dishName.setTextColor(Color.BLACK);

            dishInstructions.setText(dishToDisplay.getDescription());
            dishInstructions.setTextColor(Color.BLACK);

        }

    }

}
