package se.kth.csc.iprog.dinnerplanner.android.view;

import android.view.View;
import android.widget.TextView;

import se.kth.csc.iprog.dinnerplanner.android.R;

public class ExampleView {

	View view;

	public ExampleView(View view) {

		// store in the class the reference to the Android View
		this.view = view;

		TextView example = (TextView) view.findViewById(R.id.example_text);
		example.setText("Hello world");

		// Setup the rest of the view layout

		//example code if you have a component (etc image view) that you want to pass the image over,
		//the know how to load images dynamically
		/*
		ImageView img = //You either create new or find from layout
		int drawableResId = DinnerPlannerApplication.getDrawable(view.getContext(),"drawable_name_without_extension");
		img.setImageResource(drawableResId);
		 */

		//Note: be sure to not have extension in the drawable name. If you are using the getImage() from the DinnerModel
		// this will give you the image name with .jpg extension. So either modify the model, or be sure to remove the
		// extension before you pass it to the getDrawable() method.

	}

}
