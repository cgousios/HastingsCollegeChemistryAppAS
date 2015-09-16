package edu.hastings.HastingsCollegeChemistry.GenChemFunctions;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import edu.hastings.HastingsCollegeChemistry.R;

/**
 * Created by Christopher on 11/11/2014.
 */
public class pH_Scale extends Activity {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.ph_scale);

    final EditText txtConcentration;
    final EditText txtpH;
    final TextView txtFunctionBox;
    final EditText txtConcentration2;
    final EditText txtpOH;

    txtConcentration = (EditText) findViewById(R.id.pH_scale_concentration);
    txtpH = (EditText) findViewById(R.id.pH_scale_pH);
    txtFunctionBox = (TextView) findViewById(R.id.FunctionBox);
    txtConcentration2 = (EditText) findViewById(R.id.pH_scale_concentration2);
    txtpOH = (EditText) findViewById(R.id.pH_scale_pOH);

    final Button btnCompute = (Button) findViewById(R.id.btnCompute);
    btnCompute.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String getConcentration = txtConcentration.getText().toString();
            String getpH = txtpH.getText().toString();

            Double dblConcentration;
            Double dblpH;

            txtConcentration.setTextColor(Color.WHITE);
            txtpH.setTextColor(Color.WHITE);

            // pH = -log(M)

            if (getpH.equals("") && !getConcentration.equals("")) {
                dblConcentration = Double.parseDouble(getConcentration);
                txtFunctionBox.setText("-log(M)");

                dblpH = -Math.log10(dblConcentration);
                String strpH = dblpH.toString();
                txtpH.setText(strpH);
                txtpH.setTextColor(Color.RED);
            }
            else if (!getpH.equals("") && getConcentration.equals("")) {
                dblpH = Double.parseDouble(getpH);
                txtFunctionBox.setText(Html.fromHtml("10<sup><small>-pH</small></sup>"));

                dblConcentration = Math.pow(10, -dblpH);
                String strConcentration = dblConcentration.toString();
                txtConcentration.setText(strConcentration);
                txtConcentration.setTextColor(Color.RED);
            }
            else if (!getpH.equals("") && !getConcentration.equals("")) {
                Toast.makeText(getApplicationContext(), "All boxes contain values.  Please only give one value to compute.", Toast.LENGTH_LONG).show();
            }
            else if(getpH.equals("") && getConcentration.equals("")) {
                Toast.makeText(getApplicationContext(), "Please enter one value to compute.", Toast.LENGTH_LONG).show();
            }
            else {
                Toast.makeText(getApplicationContext(), "Error: Unknown bounds.", Toast.LENGTH_LONG).show();
            }
        }
    });

    final Button btnCompute2 = (Button) findViewById(R.id.btnCompute2);
    btnCompute2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String getConcentration2 = txtConcentration2.getText().toString();
            String getpOH = txtpOH.getText().toString();

            Double dblConcentration2;
            Double dblpOH;

            txtConcentration2.setTextColor(Color.WHITE);
            txtpOH.setTextColor(Color.WHITE);

            // pH = -log(M)

            if (getpOH.equals("") && !getConcentration2.equals("")) {
                dblConcentration2 = Double.parseDouble(getConcentration2);
                txtFunctionBox.setText("-log(OH)");

                dblpOH = -Math.log10(dblConcentration2);
                String strpOH = dblpOH.toString();
                txtpOH.setText(strpOH);
                txtpOH.setTextColor(Color.RED);
            }
            else if (!getpOH.equals("") && getConcentration2.equals("")) {
                dblpOH = Double.parseDouble(getpOH);
                txtFunctionBox.setText(Html.fromHtml("10<sup><small>-pOH</small></sup>"));

                dblConcentration2 = Math.pow(10, -dblpOH);
                String strConcentration2 = dblConcentration2.toString();
                txtConcentration2.setText(strConcentration2);
                txtConcentration2.setTextColor(Color.RED);
            }
            else if (!getpOH.equals("") && !getConcentration2.equals("")) {
                Toast.makeText(getApplicationContext(), "All boxes contain values.  Please only give one value to compute.", Toast.LENGTH_LONG).show();
            }
            else if(getpOH.equals("") && getConcentration2.equals("")) {
                Toast.makeText(getApplicationContext(), "Please enter one value to compute.", Toast.LENGTH_LONG).show();
            }
            else {
                Toast.makeText(getApplicationContext(), "Error: Unknown bounds.", Toast.LENGTH_LONG).show();
            }
        }
    });
}
}
