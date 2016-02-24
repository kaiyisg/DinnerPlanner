package se.kth.csc.iprog.dinnerplanner.android.view;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;

public class ChooseMenuBgView {

    View view;

    public ChooseMenuBgView (View view, DinnerModel model){

        this.view = view;

        //intializing the spinner to hold different numbers
        Spinner dropdown = (Spinner)view.findViewById(R.id.spinner);
        String[] items = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(view.getContext(),
                android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

        //changing dropdown selection based on the model number of guests
        if(model.getNumberOfGuests()<=12){
            dropdown.setSelection(model.getNumberOfGuests()-1);
        }else{
            //throw exception
        }


        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //initializing the textview so i can change the cost inn the future
        TextView costOfSelections = (TextView)view.findViewById(R.id.textView7);

    }


}