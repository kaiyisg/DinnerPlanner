package se.kth.csc.iprog.dinnerplanner.android.view;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Observable;
import java.util.Observer;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;

public class ChooseMenuBgView implements Observer {

    View view;
    DinnerModel dinnerModel;
    TextView costOfSelections;

    public ChooseMenuBgView (View view, DinnerModel model){

        this.view = view;
        this.dinnerModel = model;

        //intializing the spinner to hold different numbers
        Spinner dropdown = (Spinner)view.findViewById(R.id.spinner);
        String[] items = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(view.getContext(),
                android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

        //changing dropdown selection based on the model number of guests
        if(dinnerModel.getNumberOfGuests()<=12){
            dropdown.setSelection(dinnerModel.getNumberOfGuests()-1);
        }else{
            //throw exception
        }

        //initializing the textview so i can change the cost inn the future
        costOfSelections = (TextView)view.findViewById(R.id.textView7);

        dinnerModel.addObserver(this);
    }


    @Override
    public void update(Observable observable, Object data) {

        DinnerModel updatedModel = (DinnerModel) observable;

        //updating total cost of food items for everyone
        costOfSelections.setText(String.valueOf(updatedModel.totalCostOfMenu()*
                updatedModel.getNumberOfGuests())+"kr");

    }
}