package se.kth.csc.iprog.dinnerplanner.android;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

import java.util.Observable;
import java.util.Observer;

import se.kth.csc.iprog.dinnerplanner.android.view.ChooseMenuBgView;
import se.kth.csc.iprog.dinnerplanner.android.view.ChoosingDishesView;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;

public class ChooseMenuActivity extends Activity {

    Button createDinnerButton;
    DinnerModel dinnerModel;
    Spinner dropdown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_menu);
        this.getActionBar().setTitle("DinnerPlanner");

        createDinnerButton = (Button)findViewById(R.id.button2);

        dinnerModel = ((DinnerPlannerApplication) this.getApplication()).getModel();

        //initializing all the views
        ChooseMenuBgView chooseMenuBgView = new ChooseMenuBgView(findViewById(R.id.choose_menu_bg_view_id), dinnerModel);
        ChoosingDishesView choosingStartersView =
                new ChoosingDishesView(findViewById(R.id.starter_choosing_dishes_id), Dish.STARTER, dinnerModel);
        ChoosingDishesView choosingMainsView =
                new ChoosingDishesView(findViewById(R.id.main_choosing_dishes_id), Dish.MAIN, dinnerModel);
        ChoosingDishesView choosingDessertsView =
                new ChoosingDishesView(findViewById(R.id.dessert_choosing_dishes_id), Dish.DESERT, dinnerModel);

        Spinner dropdown = (Spinner)findViewById(R.id.spinner);
        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                dinnerModel.setNumberOfGuests(position+1);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        createDinnerButton.setOnClickListener(

                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if(dinnerModel.getFullMenu().size()==0){

                            new AlertDialog.Builder(v.getContext())
                                    .setTitle("Select a Dish")
                                    .setMessage("Please minimally select a dish to proceed!")
                                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int which) {
                                        }
                                    }).show();
                        }else{
                            Intent intent = new Intent(v.getContext(), ViewRecipeActivity.class);
                            startActivity(intent);
                        }
                    }
                }
        );


    }
}
