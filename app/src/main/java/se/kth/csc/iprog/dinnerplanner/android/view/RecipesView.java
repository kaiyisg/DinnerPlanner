package se.kth.csc.iprog.dinnerplanner.android.view;


import android.text.Layout;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;

public class RecipesView {

    View view;
    DinnerModel dinnerModel;

    public RecipesView(View view, DinnerModel model){

        this.view = view;
        this.dinnerModel = model;

    }

}
