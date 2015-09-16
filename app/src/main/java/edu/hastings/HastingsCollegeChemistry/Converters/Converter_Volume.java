package edu.hastings.HastingsCollegeChemistry.Converters;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import edu.hastings.HastingsCollegeChemistry.R;

/**
 * Created by Christopher on 10/14/2014.
 */
public class Converter_Volume extends Activity {

// Array of values to populate spinners
String[] astrConverterValues = new String[]{"µL", "mL", "L"};
@Override
protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.converter_volume);

    final EditText txtConvertFrom;
    final TextView txtConvertedNumber;

    txtConvertFrom = (EditText)findViewById(R.id.convert_from);
    txtConvertedNumber = (TextView)findViewById(R.id.convert_convertedNum);

    txtConvertedNumber.setTextColor(Color.RED);

    final Spinner spinFromUnits = (Spinner)findViewById(R.id.convert_FromSpinner);
    final Spinner spinToUnits = (Spinner)findViewById(R.id.convert_ToSpinner);
    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.VolumeConverterSpinner));
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    spinFromUnits.setAdapter(adapter);
    spinToUnits.setAdapter(adapter);



    // button compute
    final Button btnCompute = (Button) findViewById(R.id.btnCompute);
    btnCompute.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String getFromValue = txtConvertFrom.getText().toString();
            Double dblFromValue = Double.parseDouble(getFromValue);
//            String strSpinFromValue = spinFromUnits.getSelectedItem().toString();
//            String strSpinToValue = spinToUnits.getSelectedItem().toString();

            Integer iSpinnerValue = spinFromUnits.getSelectedItemPosition();
            String strSpinFromValue = astrConverterValues[iSpinnerValue];
            Integer iSpinToValue = spinToUnits.getSelectedItemPosition();
            String strSpinToValue = astrConverterValues[iSpinToValue];



            Double dblFromInLiters = dblToLiters(dblFromValue, strSpinFromValue);
//            Toast.makeText(getApplicationContext(), "liters " + dblFromInLiters + " from val " + strSpinFromValue, Toast.LENGTH_LONG).show();
            Double dblConvertedValue = dblFromLitersToSolution(dblFromInLiters, strSpinToValue);
//            Toast.makeText(getApplicationContext(), "liters " + dblFromInLiters, Toast.LENGTH_LONG).show();

            if(getFromValue.equals("")){
                Toast.makeText(getApplicationContext(), "Please enter a value to be converted.", Toast.LENGTH_LONG).show();
                return;
            }

//            NumberFormat numberFormat = new DecimalFormat("0.#####");
//            String strConvertedNumber = numberFormat.format(dblConvertedValue);
            String strConvertedNumber = dblConvertedValue.toString();

//            String strConvertedValue = dblConvertedValue.toString();
            txtConvertedNumber.setText(strConvertedNumber);

        }
    });

}

protected Double dblToLiters(Double dblCurVal, String strSpinFromVal){
    String strFromVal = strSpinFromVal;
    Double dblValEntered = dblCurVal;

    // Check position, convert to Liters by respective nth power of ten
    if(strFromVal == "µL"){
        // µL * 10^6
        Double dblLiters = dblValEntered / Math.pow(10,6);
        return dblLiters;
    }
    else if(strFromVal == "mL"){
        // mL * 10^3
        Double dblLiters = dblValEntered / Math.pow(10, 3);
        return dblLiters;
    }
    else if(strFromVal == "L"){
        // already in L
        Double dblLiters = dblValEntered;
        return dblLiters;
    }
    else{
        // Do nothing
        Toast.makeText(getApplicationContext(), "From units error", Toast.LENGTH_LONG).show();
        return null;
    }
}
protected Double dblFromLitersToSolution(Double dblInLiters, String strSpinToVal){
    // Check position, convert from liters to respective value
    Double dblLiters = dblInLiters;
    Double dblConvertedVal = null;
    String strToVal = strSpinToVal;

    if(strToVal == "µL"){
        // L / 10^6
        dblConvertedVal = dblLiters * Math.pow(10,6);
    }
    else if(strToVal == "mL"){
        // mL / 10^3
        dblConvertedVal = dblLiters * Math.pow(10,3);
    }
    else if(strToVal == "L"){
        // Already in L
        dblConvertedVal = dblLiters;
    }
    else{
        // Do nothing
        Toast.makeText(getApplicationContext(), "To units error", Toast.LENGTH_LONG).show();

    }
    return dblConvertedVal;
}
}
