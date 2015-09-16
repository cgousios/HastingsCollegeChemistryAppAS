package edu.hastings.HastingsCollegeChemistry.GenChemFunctions;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import edu.hastings.HastingsCollegeChemistry.R;

/**
 * Created by Christopher on 11/9/2014.
 */
public class Molarity extends Activity {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.molarity);

    final EditText txtMole;
    final EditText txtVolume;
    final EditText txtConcentration;
    final TextView txtFunctionBox;

    txtMole = (EditText) findViewById(R.id.MolarityMoles);
    txtVolume = (EditText) findViewById(R.id.MolarityVolume);
    txtConcentration = (EditText) findViewById(R.id.MolarityConcentration);
    txtFunctionBox = (TextView) findViewById(R.id.FunctionBox);

    final Button btnCompute = (Button) findViewById(R.id.btnCompute);
    btnCompute.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String getMole = txtMole.getText().toString();
            String getVolume = txtVolume.getText().toString();
            String getConcentration = txtConcentration.getText().toString();

            Double dblMole;
            Double dblVolume;
            Double dblConcentration;

            txtMole.setTextColor(Color.WHITE);
            txtVolume.setTextColor(Color.WHITE);
            txtConcentration.setTextColor(Color.WHITE);

            // Concentration = mol / L

            if (getMole.equals("") && !getVolume.equals("") && !getConcentration.equals("")) {
                dblVolume = Double.parseDouble(getVolume);
                dblConcentration = Double.parseDouble(getConcentration);
                txtFunctionBox.setText("mol = M x L");

                dblMole = dblConcentration * dblVolume;
                String strMole = dblMole.toString();
                txtMole.setText(strMole);
                txtMole.setTextColor(Color.RED);
            }
            else if (!getMole.equals("") && getVolume.equals("") && !getConcentration.equals("")) {
                dblConcentration = Double.parseDouble(getConcentration);
                dblMole = Double.parseDouble(getMole);
                txtFunctionBox.setText("L = mol / M");

                dblVolume = dblMole / dblConcentration;
                String strVolume = dblVolume.toString();
                txtVolume.setText(strVolume);
                txtVolume.setTextColor(Color.RED);
            }
            else if (!getMole.equals("") && !getVolume.equals("") && getConcentration.equals("")) {
                dblMole = Double.parseDouble(getMole);
                dblVolume = Double.parseDouble(getVolume);
                txtFunctionBox.setText("M = mol / L");

                dblConcentration = dblMole / dblVolume;
                String strConcentration = dblConcentration.toString();
                txtConcentration.setText(strConcentration);
                txtConcentration.setTextColor(Color.RED);
            }
            else if (!getConcentration.equals("") && !getMole.equals("") && !getVolume.equals("")) {
                Toast.makeText(getApplicationContext(), "All boxes contain values.  Please only give two values to compute.", Toast.LENGTH_LONG).show();
            }
            else if(getConcentration.equals("") && getMole.equals("") && getVolume.equals("")) {
                Toast.makeText(getApplicationContext(), "Please enter two values to compute.", Toast.LENGTH_LONG).show();
            }
            else {
                Toast.makeText(getApplicationContext(), "Error: Unknown bounds.", Toast.LENGTH_LONG).show();
            }
        }
    });
}
}
