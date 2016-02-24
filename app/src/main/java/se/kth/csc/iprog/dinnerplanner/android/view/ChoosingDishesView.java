package se.kth.csc.iprog.dinnerplanner.android.view;


import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.View;

import java.util.Set;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;

public class ChoosingDishesView {

    public static final String drawable = "@drawable/";

    View view;

    public ChoosingDishesView(View view, int dishType, DinnerModel model){

        this.view = view;



        TextView dishCategory = (TextView)view.findViewById(R.id.textView9);

        if(dishType == Dish.STARTER){

            dishCategory.setText("Starter");
            Set<Dish> starterDishes =  model.getDishesOfType(Dish.STARTER);

            for(Dish d : starterDishes){

                String dishImageUri = drawable+d.getImage();
                dishImageUri = dishImageUri.replace(".jpg", "");
                String dishName = d.getName();
                double dishCost = d.getPrice();

                LinearLayout dishesView = (LinearLayout)view.findViewById(R.id.starter_choosing_dishes_id);


                /*
                //method of defining a new xml layout and resizing from there
                LinearLayout dishView = (LinearLayout)view.findViewById(R.id.food_icon_id);

                ImageButton imageButton = (ImageButton)view.findViewById(R.id.imageButton5);
                int imageResource = view.getResources().getIdentifier(dishImageUri, null, view.getContext().getPackageName());
                Drawable res = view.getContext().getResources().getDrawable(imageResource);
                imageButton.setImageDrawable(res);

                TextView dishText = (TextView)view.findViewById(R.id.textView20);
                dishText.setText(dishName);

                dishesView.addView(dishView);
                */



                //method of defining everything dynamically

                LinearLayout container = new LinearLayout(view.getContext());
                container.setOrientation(LinearLayout.HORIZONTAL);

                FrameLayout imageholder = new FrameLayout(view.getContext());
                container.addView(imageholder);
                //imageholder.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                 //       ViewGroup.LayoutParams.MATCH_PARENT));
                       // 30, 30));

                ImageButton imageButton = new ImageButton(view.getContext());
                imageholder.addView(imageButton);
                int imageResource = view.getResources().getIdentifier(dishImageUri, null, view.getContext().getPackageName());
                Drawable res = view.getContext().getResources().getDrawable(imageResource);
                imageButton.setImageDrawable(res);
                //imageButton.setLayoutParams(new ViewGroup.LayoutParams(
                //        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                //imageButton.requestLayout();

                TextView dishText = new TextView(view.getContext());
                dishText.setText(dishName);
                container.addView(dishText);

                dishesView.addView(container);


                //another method for not sure what
                /*
                int imageResource = view.getResources().getIdentifier(dishImageUri, null, view.getContext().getPackageName());
                ImageButton imageButton= (ImageButton)view.findViewById(R.id.imageButton5);
                Drawable res = view.getContext().getResources().getDrawable(imageResource);
                imageButton.setImageDrawable(res);
                */

            }

        }else if(dishType == Dish.MAIN){

            dishCategory.setText("Main Course");

        }else if(dishType == Dish.DESERT){

            dishCategory.setText("Dessert");

        }
    }

}
