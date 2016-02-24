package se.kth.csc.iprog.dinnerplanner.android.view;


import android.widget.TextView;
import android.view.View;
import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.Dish;

public class ChoosingDishesView {

    View view;

    public ChoosingDishesView(View view, int dishType){

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

        }else if(dishType == Dish.MAIN){

            dishCategory.setText("Main Course");

        }else if(dishType == Dish.DESERT){

            dishCategory.setText("Dessert");

        }
    }

}
