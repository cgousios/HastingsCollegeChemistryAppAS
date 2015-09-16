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
import edu.hastings.HastingsCollegeChemistry.R.layout;

/**
 * Created by Christopher on 10/15/2014.
 */
public class Density extends Activity {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(layout.density);

    final EditText txtDensity;
    final EditText txtMass;
    final EditText txtVolume;
    final TextView txtFunctionBox;

    txtDensity = (EditText) findViewById(R.id.Density);
    txtMass = (EditText) findViewById(R.id.Mass);
    txtVolume = (EditText) findViewById(R.id.Volume);
    txtFunctionBox = (TextView) findViewById(R.id.FunctionBox);

    final Button btnCompute = (Button) findViewById(R.id.btnCompute);
    btnCompute.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String getDensity = txtDensity.getText().toString();
            String getMass = txtMass.getText().toString();
            String getVolume = txtVolume.getText().toString();

            Double dblDensity;
            Double dblMass;
            Double dblVolume;

            txtDensity.setTextColor(Color.WHITE);
            txtMass.setTextColor(Color.WHITE);
            txtVolume.setTextColor(Color.WHITE);

            // Density = mass/volume

            if (getDensity.equals("") && !getMass.equals("") && !getVolume.equals("")) {
                dblMass = Double.parseDouble(getMass);
                dblVolume = Double.parseDouble(getVolume);

                dblDensity = dblMass / dblVolume;
                String strDensity = dblDensity.toString();
                txtDensity.setText(strDensity);
                txtDensity.setTextColor(Color.RED);
                txtFunctionBox.setText("Density = Mass / Volume");
            }
            else if (getMass.equals("") && !getDensity.equals("") && !getVolume.equals(")")) {
                dblDensity = Double.parseDouble(getDensity);
                dblVolume = Double.parseDouble(getVolume);

                dblMass = dblDensity * dblVolume;
                String strMass = dblMass.toString();
                txtMass.setText(strMass);
                txtMass.setTextColor(Color.RED);
                txtFunctionBox.setText("Mass = Density * Volume");
            }
            else if (getVolume.equals("") && !getDensity.equals("") && !getMass.equals("")) {
                dblDensity = Double.parseDouble(getDensity);
                dblMass = Double.parseDouble(getMass);

                dblVolume = dblMass / dblDensity;
                String strVolume = dblVolume.toString();
                txtVolume.setText(strVolume);
                txtVolume.setTextColor(Color.RED);
                txtFunctionBox.setText("Volume = Mass / Density");
            }
            else if (!getDensity.equals("") && !getMass.equals("") && !getVolume.equals("")) {
                Toast.makeText(getApplicationContext(), "All boxes contain values.  Please only give two values to compute.", Toast.LENGTH_LONG).show();
            }
            else if(getDensity.equals("") && getMass.equals("") && getVolume.equals("")) {
                Toast.makeText(getApplicationContext(), "Please enter two values to compute.", Toast.LENGTH_LONG).show();
            }
            else {
                Toast.makeText(getApplicationContext(), "How did you even manage to get this.", Toast.LENGTH_LONG).show();
            }
        }
    });
}
}
