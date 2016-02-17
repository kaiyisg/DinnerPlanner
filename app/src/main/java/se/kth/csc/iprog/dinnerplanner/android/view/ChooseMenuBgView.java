package se.kth.csc.iprog.dinnerplanner.android.view;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import se.kth.csc.iprog.dinnerplanner.android.R;

public class ChooseMenuBgView {

    View view;

    public ChooseMenuBgView (View view){

        this.view = view;

        Spinner dropdown = (Spinner)view.findViewById(R.id.spinner);
        String[] items = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(view.getContext(),
                android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

    }


}