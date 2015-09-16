package edu.hastings.HastingsCollegeChemistry.Converters;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import edu.hastings.HastingsCollegeChemistry.R;

/**
 * Created by cgousios on 5/7/2015.
 */
public class Converter_Pressure extends Activity {
String[] astrPressureUnits = new String[]{"atm", "mmHg", "bar", "Pa"};

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.converter_pressure);

    final EditText txtConvertFrom;
    final TextView txtConvertedValue;

    txtConvertFrom = (EditText) findViewById(R.id.convert_from);
    txtConvertedValue = (TextView) findViewById(R.id.convert_convertedNum);

    txtConvertedValue.setTextColor(Color.RED);

    final Spinner spinFromUnits = (Spinner) findViewById(R.id.convert_FromSpinner);
    final Spinner spinToUnits = (Spinner) findViewById(R.id.convert_ToSpinner);
    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.PressureConverterSpinner));
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    spinFromUnits.setAdapter(adapter);
    spinToUnits.setAdapter(adapter);

    final Button btnCompute = (Button) findViewById(R.id.btnCompute);
    btnCompute.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String getFromVaue = txtConvertFrom.getText().toString();
            Double dblFromValue = Double.parseDouble(getFromVaue);

            Integer iSpinnerValue = spinFromUnits.getSelectedItemPosition();
            String strSpinFromValue = astrPressureUnits[iSpinnerValue];
            Integer iSpinToValue = spinToUnits.getSelectedItemPosition();
            String strSpinToValue = astrPressureUnits[iSpinToValue];

            Double dblSolution = null;

            if (getFromVaue.equals("")) {
                Toast.makeText(getApplicationContext(), "Unit Error.", Toast.LENGTH_LONG).show();
                return;
            }
            else if (!getFromVaue.equals("")) {
                if (strSpinFromValue == "atm") {
                    dblSolution = dblFromATM(dblFromValue, strSpinToValue);
                }
                else if (strSpinFromValue == "mmHg") {
                    dblSolution = dblFromMMHG(dblFromValue, strSpinToValue);
                }
                else if (strSpinFromValue == "bar") {
                    dblSolution = dblFromBAR(dblFromValue, strSpinToValue);
                }
                else if (strSpinFromValue == "Pa") {
                    dblSolution = dblFromPA(dblFromValue, strSpinToValue);
                }
            }
            else {
                Toast.makeText(getApplicationContext(), "Unknown error.", Toast.LENGTH_LONG).show();
            }

            String strConvertedNum = dblSolution.toString();
            txtConvertedValue.setText(strConvertedNum);
        }
    });

}


protected Double dblFromATM(Double dblFromPressure, String strSpintoUnit) {
    Double dblATM = dblFromPressure;
    Double dblConverted = null;
    String strToUnit = strSpintoUnit;

    if (strToUnit == "atm") {
        // atm*1
        dblConverted = dblATM;
        return dblConverted;
    }
    else if (strToUnit == "mmHg") {
        // atm*760.0
        dblConverted = dblATM * 760.0;
        return dblConverted;
    }
    else if (strToUnit == "bar") {
        // atm*1.01325
        dblConverted = dblATM * 1.01325;
        return dblConverted;
    }
    else if (strToUnit == "Pa") {
        // atm*101325
        dblConverted = dblATM * 101325;
        return dblConverted;
    }
    else {
        // Do nothing
        Toast.makeText(getApplicationContext(), "From units error", Toast.LENGTH_LONG).show();
        return null;
    }
}

protected Double dblFromMMHG(Double dblFromPressure, String strSpintoUnit) {
    Double dblmmHg = dblFromPressure;
    Double dblConverted = null;
    String strToUnit = strSpintoUnit;

    if (strToUnit == "atm") {
        //mmHG*0.001316
        dblConverted = dblmmHg * 0.001316;
        return dblConverted;
    }
    else if (strToUnit == "mmHg") {
        // mmhg*1
        dblConverted = dblmmHg;
        return dblConverted;
    }
    else if (strToUnit == "bar") {
        // mmHg * 0.001333
        dblConverted = dblmmHg * 0.001333;
        return dblConverted;
    }
    else if (strToUnit == "Pa") {
        // mmHg* 133.3
        dblConverted = dblmmHg * 133.3;
        return dblConverted;
    }
    else {
        // Do nothing
        Toast.makeText(getApplicationContext(), "From units error", Toast.LENGTH_LONG).show();
        return null;
    }
}

protected Double dblFromBAR(Double dblFromPressure, String strSpintoUnit) {
    Double dblbar = dblFromPressure;
    Double dblConverted = null;
    String strToUnit = strSpintoUnit;

    if (strToUnit == "atm") {
        // bar*0.987
        dblConverted = dblbar * 0.987;
        return dblConverted;
    }
    else if (strToUnit == "mmHg") {
        // bar*750.1
        dblConverted = dblbar * 750.1;
        return dblConverted;
    }
    else if (strToUnit == "bar") {
        // bar*1
        dblConverted = dblbar;
        return dblConverted;
    }
    else if (strToUnit == "Pa") {
        // bar*100000
        dblConverted = dblbar * 100000;
        return dblConverted;
    }
    else {
        // Do nothing
        Toast.makeText(getApplicationContext(), "From units error", Toast.LENGTH_LONG).show();
        return null;
    }
}

protected Double dblFromPA(Double dblFromPressure, String strSpintoUnit) {
    Double dblPa = dblFromPressure;
    Double dblConverted = null;
    String strToUnit = strSpintoUnit;

    if (strToUnit == "atm") {
        // Pa*0.00001
        dblConverted = dblPa * 0.00001;
        return dblConverted;
    }
    else if (strToUnit == "mmHg") {
        // Pa*0.0075
        dblConverted = dblPa * 0.0075;
        return dblConverted;
    }
    else if (strToUnit == "bar") {
        // Pa*0.00001
        dblConverted = dblPa * 0.00001;
        return dblConverted;
    }
    else if (strToUnit == "Pa") {
        // Pa*1
        dblConverted = dblPa;
        return dblConverted;
    }
    else {
        // Do nothing
        Toast.makeText(getApplicationContext(), "From units error", Toast.LENGTH_LONG).show();
        return null;
    }
}
}