package se.kth.csc.iprog.dinnerplanner.android.view;


import android.graphics.drawable.Drawable;
import android.widget.ImageButton;
import android.widget.ImageView;
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

        //example code if you have a component (etc image view) that you want to pass the image over,
        //the know how to load images dynamically
		/*
		ImageView img = //You either create new or find from layout
		int drawableResId = DinnerPlannerApplication.getDrawable(view.getContext(),"drawable_name_without_extension");
		img.setImageResource(drawableResId);
		 */

        //Note: be sure to not have extension in the drawable name. If you are using the getImage() from the DinnerModel
        // this will give you the image name with .jpg extension. So either modify the model, or be sure to remove the
        // extension before you pass it to the getDrawable() method.

        if(dishType == Dish.STARTER){

            dishCategory.setText("Starter");
            Set<Dish> starterDishes =  model.getDishesOfType(Dish.STARTER);

            for(Dish d : starterDishes){
                String dishImageUri = drawable+d.getImage();
                dishImageUri = dishImageUri.replace(".jpg", "");
                String dishName = d.getName();
                double dishCost = d.getPrice();

                int imageResource = view.getResources().getIdentifier(dishImageUri, null, view.getContext().getPackageName());
                ImageButton imageButton= (ImageButton)view.findViewById(R.id.imageButton5);
                Drawable res = view.getContext().getResources().getDrawable(imageResource);
                imageButton.setImageDrawable(res);

            }

        }else if(dishType == Dish.MAIN){

            dishCategory.setText("Main Course");

        }else if(dishType == Dish.DESERT){

            dishCategory.setText("Dessert");

        }
    }

}
