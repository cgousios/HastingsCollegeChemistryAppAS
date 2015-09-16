package edu.hastings.HastingsCollegeChemistry.Converters;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import edu.hastings.HastingsCollegeChemistry.R;

/**
 * Created by Christopher on 2/8/2015.
 */
public class Converter_Temperature extends Activity {
// Array of values to populate spinners
String[] astrTempUnits = new String[]{"F", "C", "K"};

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.converter_temperature);

    final EditText txtConvertFrom;
    final TextView txtConvertedNumber;

    txtConvertFrom = (EditText) findViewById(R.id.convert_from);
    txtConvertedNumber = (TextView) findViewById(R.id.convert_convertedNum);

    txtConvertedNumber.setTextColor(Color.RED);

    final Spinner spinFromUnits = (Spinner) findViewById(R.id.convert_FromSpinner);
    final Spinner spinToUnits = (Spinner) findViewById(R.id.convert_ToSpinner);
    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.TemperatureConverterSpinner));
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
            String strSpinFromValue = astrTempUnits[iSpinnerValue];
            Integer iSpinToValue = spinToUnits.getSelectedItemPosition();
            String strSpinToValue = astrTempUnits[iSpinToValue];

            Double dblConvertedSolution;

            if (getFromValue.equals("")) {
                Toast.makeText(getApplicationContext(), "Please enter a value to be converted.", Toast.LENGTH_LONG).show();
                return;
            }

            if (strSpinFromValue == "F") {
                dblConvertedSolution = dblFromFahrenheit(dblFromValue, strSpinToValue);
            }
            else if (strSpinFromValue == "C") {
                dblConvertedSolution = dblFromCelcius(dblFromValue, strSpinToValue);
            }
            else if (strSpinFromValue == "K") {
                dblConvertedSolution = dblFromKelvin(dblFromValue, strSpinToValue);
            }
            else {
                Toast.makeText(getApplicationContext(), "Unit Error.", Toast.LENGTH_LONG).show();
                return;
            }


            String strConvertedNumber = dblConvertedSolution.toString();
            txtConvertedNumber.setText(strConvertedNumber);

        }
    });
}


protected Double dblFromFahrenheit(Double dblFromTemp, String strSpinToUnit) {
    Double dblFahrenheit = dblFromTemp;
    Double dblConvertedVal = null;
    String strToUnit = strSpinToUnit;
    Integer intFive_Nine = 5/9;
    Integer intNine_Five = 9/5;


    if (strToUnit == "C") {
        // (F-32) * 5/9
        Toast.makeText(getApplicationContext(), "F to C", Toast.LENGTH_LONG).show();
        dblConvertedVal = ((dblFahrenheit-32)*5)/9;
        //dblConvertedVal = ((dblFahrenheit - 32)*(intFive_Nine));
        return dblConvertedVal;
    }
    else if (strToUnit == "K") {
        // (F-32) * 5/9 + 273.15
        Toast.makeText(getApplicationContext(), "F to K", Toast.LENGTH_LONG).show();
        dblConvertedVal = ((dblFahrenheit-32)*5)/9 + 273.15;
        //dblConvertedVal = ((dblFahrenheit - 32)*(intFive_Nine))+273.15;
        return dblConvertedVal;
    }
    else if(strToUnit=="F"){
        Toast.makeText(getApplicationContext(), "F to F", Toast.LENGTH_LONG).show();
        dblConvertedVal = dblFahrenheit;
        return dblConvertedVal;
    }
    else {
        // Do nothing
        Toast.makeText(getApplicationContext(), "From units error", Toast.LENGTH_LONG).show();
        return null;
    }
}

protected Double dblFromCelcius(Double dblFromTemp, String strSpinToUnit) {
    Double dblCelcius = dblFromTemp;
    Double dblConvertedVal = null;
    String strToUnit = strSpinToUnit;
    Integer intFive_Nine = 5/9;
    Integer intNine_Five = 9/5;

    if (strToUnit == "F") {
        // (C*9/5) + 32
        dblConvertedVal = ((dblCelcius*9)/5)+32;
        //dblConvertedVal = ((dblCelcius * (intNine_Five)) + 32);
        return dblConvertedVal;
    }
    else if (strToUnit == "K") {
        // C + 273.15
        dblConvertedVal = dblCelcius + 273.15;
        return dblConvertedVal;
    }
    else if(strToUnit=="C"){
        dblConvertedVal = dblCelcius;
        return dblConvertedVal;
    }
    else {
        // Do nothing
        Toast.makeText(getApplicationContext(), "From units error", Toast.LENGTH_LONG).show();
        return null;
    }
}

protected Double dblFromKelvin(Double dblFromTemp, String strSpinToUnit) {
    Double dblKelvin = dblFromTemp;
    Double dblConvertedVal = null;
    String strToUnit = strSpinToUnit;
    Integer intFive_Nine = 5/9;
    Integer intNine_Five = 9/5;

    if (strToUnit == "F") {
        // (K-273.15) *9/5 + 32
        dblConvertedVal = ((dblKelvin-273.15)*9)/5 + 32;
        //dblConvertedVal = (((dblKelvin - 273.15)) * intNine_Five) + 32;
        return dblConvertedVal;
    }
    else if (strToUnit == "C") {
        // K-273.15
        dblConvertedVal = dblKelvin - 273.15;
        return dblConvertedVal;
    }
    else if(strToUnit=="K"){
        dblConvertedVal = dblKelvin;
        return dblConvertedVal;
    }
    else {
        // Do nothing
        Toast.makeText(getApplicationContext(), "From units error", Toast.LENGTH_LONG).show();
        return null;
    }
}
}
