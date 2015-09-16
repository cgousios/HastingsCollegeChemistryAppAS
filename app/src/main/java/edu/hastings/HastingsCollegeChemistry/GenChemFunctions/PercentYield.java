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
 * Created by cgousios on 5/7/2015.
 */
public class PercentYield extends Activity {
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.percent_yield);

    final EditText txtPercentYield;
    final EditText txtActualYield;
    final EditText txtTheoreticalYield;
    final TextView txtFunctionBox;

    txtPercentYield = (EditText) findViewById(R.id.PercentYield);
    txtActualYield = (EditText) findViewById(R.id.ActualYield);
    txtTheoreticalYield = (EditText) findViewById(R.id.TheoreticalYield);
    txtFunctionBox = (TextView) findViewById(R.id.FunctionBox);
    txtFunctionBox.setText("Percent Yield = (Actual/Theoretical) x 100");

    final Button btnCompute = (Button) findViewById(R.id.btnCompute);
    btnCompute.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String getPercentYield = txtPercentYield.getText().toString();
            String getActualYield = txtActualYield.getText().toString();
            String getTheoreticalYield = txtTheoreticalYield.getText().toString();

            Double dblPerYield;
            Double dblActYield;
            Double dblTheoYield;

            txtPercentYield.setTextColor(Color.WHITE);
            txtActualYield.setTextColor(Color.WHITE);
            txtTheoreticalYield.setTextColor(Color.WHITE);

            // Percent yield  = (Actual/Theortical)*100

            if (getPercentYield.equals("") && getActualYield.equals("") && getTheoreticalYield.equals("")) {
                Toast.makeText(getApplicationContext(), "Please enter two values.", Toast.LENGTH_LONG).show();
                return;
            }
            else if (!getPercentYield.equals("") && getActualYield.equals("") && getTheoreticalYield.equals("")) {
                Toast.makeText(getApplicationContext(), "Please enter two values.", Toast.LENGTH_LONG).show();
                return;
            }
            else if (getPercentYield.equals("") && !getActualYield.equals("") && getTheoreticalYield.equals("")) {
                Toast.makeText(getApplicationContext(), "Please enter two values.", Toast.LENGTH_LONG).show();
                return;
            }
            else if (getPercentYield.equals("") && getActualYield.equals("") && !getTheoreticalYield.equals("")) {
                Toast.makeText(getApplicationContext(), "Please enter two values.", Toast.LENGTH_LONG).show();
                return;
            }
            else if (!getPercentYield.equals("") && !getActualYield.equals("") && !getTheoreticalYield.equals("")) {
                Toast.makeText(getApplicationContext(), "Please enter only two values.", Toast.LENGTH_LONG).show();
                return;
            }
            else if (getPercentYield.equals("") && !getActualYield.equals("") && !getTheoreticalYield.equals("")) {
                dblActYield = Double.parseDouble(getActualYield);
                dblTheoYield = Double.parseDouble(getTheoreticalYield);
                txtFunctionBox.setText("Percent Yield = (Actual/Theoretical) x 100");

                dblPerYield = (dblActYield / dblTheoYield) * 100;
                String strSolution = dblPerYield.toString();
                txtPercentYield.setText(strSolution);
                txtPercentYield.setTextColor(Color.RED);
            }
            else if (!getPercentYield.equals("") && getActualYield.equals("") && !getTheoreticalYield.equals("")) {
                dblPerYield = Double.parseDouble(getPercentYield);
                dblTheoYield = Double.parseDouble(getTheoreticalYield);
                txtFunctionBox.setText("Actual = (Percent Yield x Theoretical) /100");

                dblActYield = (dblPerYield * dblTheoYield) / 100;
                String strSolution = dblActYield.toString();
                txtActualYield.setText(strSolution);
                txtActualYield.setTextColor(Color.RED);
            }
            else if (!getPercentYield.equals("") && !getActualYield.equals("") && getTheoreticalYield.equals("")) {
                dblActYield = Double.parseDouble(getActualYield);
                dblPerYield = Double.parseDouble(getPercentYield);
                txtFunctionBox.setText("Theoretical = (Actual x 100)/Percent Yield");

                dblTheoYield = (dblActYield * 100) / dblPerYield;
                String strSolution = dblTheoYield.toString();
                txtTheoreticalYield.setText(strSolution);
                txtTheoreticalYield.setTextColor(Color.RED);
            }
            else{
                Toast.makeText(getApplicationContext(), "Unknown error", Toast.LENGTH_LONG).show();
            }
        }

    });
}
}
