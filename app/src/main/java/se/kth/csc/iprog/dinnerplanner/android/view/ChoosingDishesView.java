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

import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import se.kth.csc.iprog.dinnerplanner.android.ChooseMenuActivity;
import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;

public class ChoosingDishesView implements Observer {

    public static final String drawable = "@drawable/";
    HorizontalScrollView horizontalScrollView;
    TextView dishCategory;
    View view;
    int numberOfGuests;

    //attributes to hold the chosen dishes
    Dish chosenDish;
    Set<Dish> dishes;
    DinnerModel dinnerModel;
    int dishType;

    public ChoosingDishesView(View view, int dishType, DinnerModel model){

        this.view = view;
        this.dinnerModel = model;
        this.dishType = dishType;

        //number of guests
        numberOfGuests = this.dinnerModel.getNumberOfGuests();

        //currently no dish is chosen
        chosenDish = null;

        //setting up layouts for each image button
        horizontalScrollView = (HorizontalScrollView)view.findViewById(R.id.horizontalScrollView);
        dishCategory = (TextView)view.findViewById(R.id.textView9);

        if(dishType == Dish.STARTER){

            dishCategory.setText("Starter");
            dishes =  this.dinnerModel.getDishesOfType(Dish.STARTER);

        }else if(dishType == Dish.MAIN){

            dishCategory.setText("Main Course");
            dishes =  this.dinnerModel.getDishesOfType(Dish.MAIN);

        }else{

            dishCategory.setText("Dessert");
            dishes =  this.dinnerModel.getDishesOfType(Dish.DESERT);

        }

        initializeRowOfDishes(dishes, chosenDish);

        model.addObserver(this);

    }

    private void initializeRowOfDishes(Set<Dish> dishes, Dish selectedDish){

        //clear all previous views before any calls made here
        horizontalScrollView.removeAllViews();

        //creating container to put into my scroll view
        LinearLayout topLinearLayout = new LinearLayout(view.getContext());
        topLinearLayout.setOrientation(LinearLayout.HORIZONTAL);

        //populating the rest of the dishes into the view

        for(Dish d : dishes){

            if (selectedDish==null){
                topLinearLayout.addView(initializeDishIcon(d, false));
            } else if (selectedDish.equals(d)){
                topLinearLayout.addView(initializeDishIcon(d, true));
            }else{
                topLinearLayout.addView(initializeDishIcon(d, false));
            }

        }
        horizontalScrollView.addView(topLinearLayout);
    }

    private View initializeDishIcon(Dish dish, boolean selected){

        final Dish iterDish = dish;
        String dishImageUri = drawable+dish.getImage();
        dishImageUri = dishImageUri.replace(".jpg", "");
        final String dishName = dish.getName();
        final double dishCost = dish.getPrice();

        //getting layout of food_icon template to fill up
        LayoutInflater inflater = (LayoutInflater) view.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View dishView = inflater.inflate(R.layout.food_icon, null);
        //making margins for better layouting
        LinearLayout.LayoutParams ll = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        ll.setMargins(0,0,20,0);
        dishView.setLayoutParams(ll);

        //initializing imageButton
        ImageButton imageButton = (ImageButton)dishView.findViewById(R.id.imageButton5);
        final int imageResource = dishView.getResources().getIdentifier(
                dishImageUri, null, dishView.getContext().getPackageName());
        final Drawable res = dishView.getContext().getResources().getDrawable(imageResource);
        imageButton.setImageDrawable(res);

        //highlighting imageButton if selected
        if(selected){
            LinearLayout background = (LinearLayout)dishView.findViewById(R.id.food_icon_id);
            int bg = dishView.getResources().getIdentifier(
                    "@drawable/border_thin", null, dishView.getContext().getPackageName());
            Drawable bgRes = dishView.getContext().getResources().getDrawable(bg);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                background.setBackground(bgRes);
            }
        }

        //configuring button to generate alertdialog

        imageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v1) {

                String costPerFoodString = "kr / Person)";
                costPerFoodString = "(" + String.valueOf(dishCost) + costPerFoodString;

                String costTotalString = "Cost: ";
                double totalCost = dinnerModel.getNumberOfGuests() * dishCost;
                costTotalString = costTotalString + String.valueOf(totalCost);

                final Dialog dialog = new Dialog(v1.getContext());
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.food_choosing_dialog);

                dialog.setCancelable(true);

                //set up title
                TextView dialogTitle = (TextView) dialog.findViewById(R.id.textView21);
                dialogTitle.setText(dishName);

                //set up image view
                FrameLayout foodImageView = (FrameLayout) dialog.findViewById(R.id.foodpicture);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    foodImageView.setBackground(res);
                }

                //set up total cost
                TextView totalCostView = (TextView) dialog.findViewById(R.id.textView22);
                totalCostView.setText(costTotalString);

                //set up individual cost
                TextView indivCostView = (TextView) dialog.findViewById(R.id.textView23);
                indivCostView.setText(costPerFoodString);

                //set up choose button
                Button chooseButton = (Button) dialog.findViewById(R.id.button3);
                chooseButton.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v2) {
                        chosenDish = iterDish;
                        //horizontalScrollView.removeAllViews();
                        initializeRowOfDishes(dishes, chosenDish);
                        ChoosingDishesView.this.dinnerModel.addDishToMenu(chosenDish);
                        dialog.dismiss();

                    }
                });

                //set up cancel button
                Button cancelButton = (Button) dialog.findViewById(R.id.button4);
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

        return(dishView);

    }

    @Override
    public void update(Observable observable, Object data) {

        DinnerModel updatedModel = (DinnerModel) observable;
        initializeRowOfDishes(updatedModel.getDishesOfType(dishType),
                updatedModel.getSelectedDish(dishType));

    }

}
