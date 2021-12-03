package com.rafli.si_boss;

import android.view.View;
import android.widget.RadioButton;

public class onRadioButtonClicked {
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_L:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.radio_P:
                if (checked)
                    // Ninjas rule
                    break;
        }
    }
}
