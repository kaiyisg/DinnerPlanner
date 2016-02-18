package se.kth.csc.iprog.dinnerplanner.android.view;


import android.widget.TextView;
import android.view.View;
import se.kth.csc.iprog.dinnerplanner.android.R;

public class ChoosingDishesView {

    View view;

    public ChoosingDishesView(View view){
        this.view = view;

        TextView dishCategory = (TextView)view.findViewById(R.id.textView9);
    }

}
