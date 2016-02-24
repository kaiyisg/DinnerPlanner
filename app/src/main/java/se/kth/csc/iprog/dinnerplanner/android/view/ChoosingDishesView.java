package se.kth.csc.iprog.dinnerplanner.android.view;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.View;

import java.util.Set;

import se.kth.csc.iprog.dinnerplanner.android.ChooseMenuActivity;
import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;

public class ChoosingDishesView {

    public static final String drawable = "@drawable/";
    HorizontalScrollView horizontalScrollView;
    TextView dishCategory;
    View view;

    public ChoosingDishesView(View view, int dishType, DinnerModel model){

        this.view = view;

        horizontalScrollView = (HorizontalScrollView)view.findViewById(R.id.horizontalScrollView);
        dishCategory = (TextView)view.findViewById(R.id.textView9);

        if(dishType == Dish.STARTER){

            dishCategory.setText("Starter");
            Set<Dish> starterDishes =  model.getDishesOfType(Dish.STARTER);

            //creating container to put into my scroll view
            LinearLayout topLinearLayout = new LinearLayout(view.getContext());
            topLinearLayout.setOrientation(LinearLayout.HORIZONTAL);

            for(Dish d : starterDishes){

                String dishImageUri = drawable+d.getImage();
                dishImageUri = dishImageUri.replace(".jpg", "");
                final String dishName = d.getName();
                final double dishCost = d.getPrice();

                //getting layout of food_icon template to fill up
                LayoutInflater inflater = (LayoutInflater) view.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View dishView = inflater.inflate(R.layout.food_icon, null);

                //initializing button
                ImageButton imageButton = (ImageButton)dishView.findViewById(R.id.imageButton5);
                int imageResource = dishView.getResources().getIdentifier(dishImageUri, null, dishView.getContext().getPackageName());
                Drawable res = dishView.getContext().getResources().getDrawable(imageResource);
                imageButton.setImageDrawable(res);

                //configuring button to generate alertdialog

                imageButton.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v1) {

                        String costString = "Cost: ";
                        costString = costString + String.valueOf(dishCost) + "kr";

                        new AlertDialog.Builder(v1.getContext())
                                .setTitle(dishName)
                                .setMessage("costString")
                                .setPositiveButton("Choose", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                    }
                                })
                                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        // do nothing
                                    }
                                })
                                .setIcon(android.R.drawable.ic_dialog_alert)
                                .show();
                    }
                });



                TextView dishText = (TextView)dishView.findViewById(R.id.textView20);
                dishText.setText(dishName);

                topLinearLayout.addView(dishView);

            }

            horizontalScrollView.addView(topLinearLayout);

        }else if(dishType == Dish.MAIN){

            dishCategory.setText("Main Course");

        }else if(dishType == Dish.DESERT){

            dishCategory.setText("Dessert");

        }
    }

}
