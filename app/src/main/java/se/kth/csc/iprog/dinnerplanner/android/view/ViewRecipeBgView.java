package se.kth.csc.iprog.dinnerplanner.android.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Set;

import se.kth.csc.iprog.dinnerplanner.android.ChooseMenuActivity;
import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;

public class ViewRecipeBgView {

    public static final String drawable = "@drawable/";

    View view;
    DinnerModel dinnerModel;

    TextView foodItemsCost;
    ImageButton ingredientsImage;
    ImageButton starterImage;
    ImageButton mainsImage;
    ImageButton dessertImage;
    TextView starterName;
    TextView mainsName;
    TextView dessertName;

    public ViewRecipeBgView(View view, DinnerModel model){

        this.view = view;
        this.dinnerModel = model;

        foodItemsCost = (TextView)view.findViewById(R.id.textView7);
        ingredientsImage = (ImageButton)view.findViewById(R.id.imageButton);
        starterImage = (ImageButton)view.findViewById(R.id.imageButton2);
        mainsImage = (ImageButton)view.findViewById(R.id.imageButton3);
        dessertImage = (ImageButton)view.findViewById(R.id.imageButton4);
        starterName = (TextView)view.findViewById(R.id.textView11);
        mainsName = (TextView)view.findViewById(R.id.textView13);
        dessertName = (TextView)view.findViewById(R.id.textView12);

        Set<Dish> currentMenu = dinnerModel.getFullMenu();

        LayoutInflater inflater = (LayoutInflater) view.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View recipeBgView = inflater.inflate(R.layout.view_recipe_bg_view, null);

        //setting total price
        double totalPrice = dinnerModel.getTotalMenuPrice();
        foodItemsCost.setText(String.valueOf(totalPrice)+"kr");

        //setting images of chosen dishes
        for(Dish d: currentMenu){
            if(d.getType()==Dish.STARTER){
                starterImage.setImageDrawable(setUpImageView(d));
                starterName.setText(d.getName());
            }else if(d.getType()==Dish.MAIN){
                mainsImage.setImageDrawable(setUpImageView(d));
                mainsName.setText(d.getName());
            }else{
                dessertImage.setImageDrawable(setUpImageView(d));
                dessertName.setText(d.getName());
            }
        }

        //initializing ingredients button
        ingredientsImage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v1) {


                //not sure why i cannot put border
                /*
                FrameLayout background = (FrameLayout)recipeBgView.findViewById(R.id.ingredients_image);
                int bg = recipeBgView.getResources().getIdentifier(
                        "@drawable/border_thin", null, recipeBgView.getContext().getPackageName());
                Drawable bgRes = recipeBgView.getContext().getResources().getDrawable(bg);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    background.setBackground(bgRes);
                }*/

            }

        });


    }

    private Drawable setUpImageView(Dish d){
        String dishImageUri = drawable+d.getImage();
        dishImageUri = dishImageUri.replace(".jpg", "");
        int imageResource = view.getResources().getIdentifier(
                dishImageUri, null, view.getContext().getPackageName());
        Drawable res = view.getContext().getResources().getDrawable(imageResource);
        return res;
    }
}
