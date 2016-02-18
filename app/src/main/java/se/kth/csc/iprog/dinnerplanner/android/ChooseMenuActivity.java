package se.kth.csc.iprog.dinnerplanner.android;

import android.os.Bundle;
import android.app.Activity;

import se.kth.csc.iprog.dinnerplanner.android.view.ChooseMenuBgView;
import se.kth.csc.iprog.dinnerplanner.android.view.ChoosingDishesView;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;

public class ChooseMenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_menu);

        DinnerModel model = ((DinnerPlannerApplication) this.getApplication()).getModel();

        ChooseMenuBgView chooseMenuBgView = new ChooseMenuBgView(findViewById(R.id.choose_menu_bg_view_id));

        ChoosingDishesView choosingStartersView = new ChoosingDishesView(findViewById(R.id.starter_choosing_dishes_id));
        ChoosingDishesView choosingMainsView = new ChoosingDishesView(findViewById(R.id.main_choosing_dishes_id));
        ChoosingDishesView choosingDessertsView = new ChoosingDishesView(findViewById(R.id.dessert_choosing_dishes_id));


    }

}
