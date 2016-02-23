package se.kth.csc.iprog.dinnerplanner.android;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

import se.kth.csc.iprog.dinnerplanner.android.view.ChooseMenuBgView;
import se.kth.csc.iprog.dinnerplanner.android.view.ChoosingDishesView;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;

public class ChooseMenuActivity extends Activity {

    Button createDinnerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_menu);
        this.getActionBar().setTitle("DinnerPlanner");

        ChooseMenuBgView chooseMenuBgView = new ChooseMenuBgView(findViewById(R.id.choose_menu_bg_view_id));

        DinnerModel model = ((DinnerPlannerApplication) this.getApplication()).getModel();


        ChoosingDishesView choosingStartersView = new ChoosingDishesView(findViewById(R.id.starter_choosing_dishes_id));
        ChoosingDishesView choosingMainsView = new ChoosingDishesView(findViewById(R.id.main_choosing_dishes_id));
        ChoosingDishesView choosingDessertsView = new ChoosingDishesView(findViewById(R.id.dessert_choosing_dishes_id));

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

}
