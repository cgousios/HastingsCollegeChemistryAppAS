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
 * Created by Christopher on 11/11/2014.
 */
public class Ideal_Gas extends Activity {
@Override
protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.ideal_gas);


    final EditText txtPressure;
    final EditText txtVolume;
    final EditText txtMole;
    final EditText txtTemperature;
    final TextView txtFunction;

    txtPressure = (EditText) findViewById(R.id.ideal_gas_pressure);
    txtVolume = (EditText)findViewById(R.id.ideal_gas_volume);
    txtMole = (EditText)findViewById(R.id.ideal_gas_mole);
    txtTemperature = (EditText)findViewById(R.id.ideal_gas_temperature);
    txtFunction = (TextView)findViewById(R.id.FunctionBox);
    txtFunction.setText("PV = nRT");


    final Button btnCompute = (Button) findViewById(R.id.btnCompute);
    btnCompute.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String getPressure = txtPressure.getText().toString();
            String getVolume = txtVolume.getText().toString();
            String getMole = txtMole.getText().toString();
            String getTemp = txtTemperature.getText().toString();

            Double dblPressure;
            Double dblVolume;
            Double dblMole;
            Double dblTemp;
            Double dblR = 0.08206;

            txtPressure.setTextColor(Color.WHITE);
            txtVolume.setTextColor(Color.WHITE);
            txtMole.setTextColor(Color.WHITE);
            txtTemperature.setTextColor(Color.WHITE);

            // PV = nRT

            if(getPressure.equals("") && !getVolume.equals("") && !getMole.equals("") && !getTemp.equals("")){
                dblVolume = Double.parseDouble(getVolume);
                dblMole = Double.parseDouble(getMole);
                dblTemp = Double.parseDouble(getTemp);
                txtFunction.setText("nRT / V");

                dblPressure = (dblMole * dblR * dblTemp) / dblVolume;
                String strPressure = dblPressure.toString();
                txtPressure.setText(strPressure);
                txtPressure.setTextColor(Color.RED);
            }
            else if(!getPressure.equals("") && getVolume.equals("") && !getMole.equals("") && !getTemp.equals("")){
                dblPressure = Double.parseDouble(getPressure);
                dblMole = Double.parseDouble(getMole);
                dblTemp = Double.parseDouble(getTemp);
                txtFunction.setText("nRT / P");

                dblVolume = (dblMole * dblR * dblTemp) / dblPressure;
                String strVolume = dblVolume.toString();
                txtVolume.setText(strVolume);
                txtVolume.setTextColor(Color.RED);
            }
            else if(!getPressure.equals("") && !getVolume.equals("") && getMole.equals("") && !getTemp.equals("")){
                dblPressure = Double.parseDouble(getPressure);
                dblVolume = Double.parseDouble(getVolume);
                dblTemp = Double.parseDouble(getTemp);
                txtFunction.setText("PV / RT");

                dblMole = (dblPressure * dblVolume) / (dblR * dblTemp);
                String strMole = dblMole.toString();
                txtMole.setText(strMole);
                txtMole.setTextColor(Color.RED);
            }
            else if(!getPressure.equals("") && !getVolume.equals("") && !getMole.equals("") && getTemp.equals("")){
                dblPressure = Double.parseDouble(getPressure);
                dblVolume = Double.parseDouble(getVolume);
                dblMole = Double.parseDouble(getMole);
                txtFunction.setText("PV / nR");

                dblTemp = (dblPressure * dblVolume) / (dblMole * dblR);
                String strTemp = dblTemp.toString();
                txtTemperature.setText(strTemp);
                txtTemperature.setTextColor(Color.RED);
            }
            else if(!getPressure.equals("") && !getVolume.equals("") && !getMole.equals("") && !getTemp.equals("")){
                // all 4 have some value
                Toast.makeText(getApplicationContext(), "All four boxes contain values.  Please only give three values to compute.", Toast.LENGTH_LONG).show();
            }
            else if(getPressure.equals("") && getVolume.equals("") && getMole.equals("") && getTemp.equals("")){
                Toast.makeText(getApplicationContext(), "Please enter three values to compute.", Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(getApplicationContext(), "Unknown Error", Toast.LENGTH_LONG).show();
            }

        }


    });
}
}

