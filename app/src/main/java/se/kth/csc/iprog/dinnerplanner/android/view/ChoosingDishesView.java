package se.kth.csc.iprog.dinnerplanner.android.view;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
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
                final int imageResource = dishView.getResources().getIdentifier(
                        dishImageUri, null, dishView.getContext().getPackageName());
                final Drawable res = dishView.getContext().getResources().getDrawable(imageResource);
                imageButton.setImageDrawable(res);

                //configuring button to generate alertdialog

                imageButton.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v1) {

                        String costString = "Cost: ";
                        costString = costString + String.valueOf(dishCost) + "kr";

                        final Dialog dialog = new Dialog(v1.getContext());
                        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                        dialog.setContentView(R.layout.food_choosing_dialog);

                        dialog.setCancelable(true);

                        //set up title
                        TextView dialogTitle = (TextView)dialog.findViewById(R.id.textView21);
                        dialogTitle.setText(dishName);

                        //set up image view
                        FrameLayout foodImageView = (FrameLayout)dialog.findViewById(R.id.foodpicture);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            foodImageView.setBackground(res);
                        }

                        //set up total cost
                        TextView totalCostView = (TextView)dialog.findViewById(R.id.textView22);

                        //set up individual cost
                        TextView indivCostView = (TextView)dialog.findViewById(R.id.textView23);
                        indivCostView.setText(costString);

                        //set up choose button
                        Button chooseButton = (Button)dialog.findViewById(R.id.button3);
                        chooseButton.setOnClickListener(new View.OnClickListener() {

                            @Override
                            public void onClick(View v2) {
                                dialog.dismiss();
                            }
                        });

                        //set up cancel button
                        Button cancelButton = (Button)dialog.findViewById(R.id.button4);
                        cancelButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v2) {
                                dialog.dismiss();
                            }
                        });

                        dialog.show();

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
