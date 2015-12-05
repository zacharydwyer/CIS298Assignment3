package edu.kvcc.cis298.cis298assignment3;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.util.List;

/**
 * Created by Zak Dwyer on 12/5/2015.
 */
public class BeverageFragment extends Fragment {

    private Beverage mBeverage;                 // Each BeverageFragment has an associated Beverage

    private EditText mNameField;                // Widgets
    private EditText mIDField;
    private EditText mPackField;
    private EditText mPriceField;
    private CheckBox mActiveCheckBox;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBeverage = new Beverage();             // Create new associated Beverage

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_beverage, container, false);        // Create view from associated layout. "container" is your view's parent.

        /* WIRE UP WIDGETS */
        mNameField = (EditText)v.findViewById(R.id.beverage_name_field);                // Get beverage name EditText from view we just created by inflating a layout
        mIDField = (EditText)v.findViewById(R.id.beverage_id_field);
        mPackField = (EditText)v.findViewById(R.id.beverage_pack_field);
        mPriceField = (EditText)v.findViewById(R.id.beverage_price_field);
        mActiveCheckBox = (CheckBox)v.findViewById(R.id.beverage_active_checkBox);

        /* ASSIGN WIDGET LISTENERS */

        // On Name field text change...
        mNameField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Leave blank
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mBeverage.setName(s.toString());                                            // Updates the Data object's Name property
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Leave blank
            }
        });

        // On ID field text change...
        mIDField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // BLANK
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // WARNING - IT MUST be made sure that the inputted ID is unique, or else it will probably screw something up.

                int inputtedNumber = Integer.parseInt(s.toString());    // What the user just inputted. Will always resolve to a number considering the widget data input restriction

                // If there is not already a beverage with this ID...
                if (Beverages.get().getBeverageById(inputtedNumber) != null) {
                    mBeverage.setID(inputtedNumber);
                }
                else {
                    mIDField.setError("ID already in use");
                }
                
                mBeverage.setID(Integer.parseInt(s.toString()));                            // "s" will always evaluate to a valid integer - the widget has android:inputType="number"
            }

            @Override
            public void afterTextChanged(Editable s) {
                // BLANK
            }
        });

        // On Pack field text change...
        mPackField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // BLANK
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mBeverage.setPack(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // BLANK
            }
        });

        // On Price field text change...
        mIDField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // BLANK
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //TODO: Should it be checking to make sure every ID is unique?
                mBeverage.setPrice(Double.parseDouble(s.toString()));                            // "s" will always evaluate to a valid double - the widget has android:inputType="numberDecimal"
            }

            @Override
            public void afterTextChanged(Editable s) {
                // BLANK
            }
        });

        // On Active text box checked change...
        mActiveCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mBeverage.setIsActive(mActiveCheckBox.isChecked());                         // If "Active" check box is checked, change "IsActive" property accordingly of data object
            }
        });

        return v;                                                                       // Return view we just created
    }
}
