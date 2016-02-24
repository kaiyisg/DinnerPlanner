package se.kth.csc.iprog.dinnerplanner.android;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

import java.util.Observable;
import java.util.Observer;

import se.kth.csc.iprog.dinnerplanner.android.view.ChooseMenuBgView;
import se.kth.csc.iprog.dinnerplanner.android.view.ChoosingDishesView;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;

public class ChooseMenuActivity extends Activity implements Observer {

    Button createDinnerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_menu);
        this.getActionBar().setTitle("DinnerPlanner");

        createDinnerButton = (Button)findViewById(R.id.button2);

        DinnerModel model = ((DinnerPlannerApplication) this.getApplication()).getModel();

        //initializing all the views
        ChooseMenuBgView chooseMenuBgView = new ChooseMenuBgView(findViewById(R.id.choose_menu_bg_view_id), model);
        ChoosingDishesView choosingStartersView =
                new ChoosingDishesView(findViewById(R.id.starter_choosing_dishes_id), Dish.STARTER, model);
        ChoosingDishesView choosingMainsView =
                new ChoosingDishesView(findViewById(R.id.main_choosing_dishes_id), Dish.MAIN, model);
        ChoosingDishesView choosingDessertsView =
                new ChoosingDishesView(findViewById(R.id.dessert_choosing_dishes_id), Dish.DESERT, model);

        createDinnerButton.setOnClickListener(

                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(v.getContext(), ViewRecipeActivity.class);
                        startActivity(intent);
                    }
                }
        );


    }

    @Override
    public void update(Observable observable, Object data) {

    }
}
