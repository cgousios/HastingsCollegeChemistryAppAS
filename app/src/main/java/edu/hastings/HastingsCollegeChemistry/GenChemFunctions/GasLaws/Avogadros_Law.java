package edu.hastings.HastingsCollegeChemistry.GenChemFunctions.GasLaws;

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
 * Created by Christopher on 3/10/2015.
 */
public class Avogadros_Law extends Activity {
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.avogadros_law);

    ((TextView) findViewById(R.id.lblAvogadrosV1)).setText(Html.fromHtml("V<sub><small>1</small></sub>"));
    ((TextView) findViewById(R.id.lblAvogadrosV2)).setText(Html.fromHtml("V<sub><small>2</small></sub>"));
    ((TextView)findViewById(R.id.lblAvogadrosN1)).setText(Html.fromHtml("n<sub><small>1</small></sub>"));
    ((TextView)findViewById(R.id.lblAvogadrosN2)).setText(Html.fromHtml("n<sub><small>2</small></sub>"));

    final EditText txtVolume1;
    final EditText txtVolume2;
    final EditText txtMole1;
    final EditText txtMole2;
    final TextView txtFunctionBox;

    txtVolume1 = (EditText) findViewById(R.id.txtAvogadrossV1);
    txtVolume2 = (EditText) findViewById(R.id.txtAvogadrosV2);
    txtMole1 = (EditText) findViewById(R.id.txtAvogadrosN1);
    txtMole2 = (EditText) findViewById(R.id.txtAvogadrosN2);
    txtFunctionBox = (TextView) findViewById(R.id.FunctionBox);

    final Button btnCompute = (Button) findViewById(R.id.btnCompute);
    btnCompute.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String getVol1 = txtVolume1.getText().toString();
            String getVol2 = txtVolume2.getText().toString();
            String getCon1 = txtMole1.getText().toString();
            String getCon2 = txtMole2.getText().toString();

            Double dblVol1;
            Double dblVol2;
            Double dblCon1;
            Double dblCon2;

            txtVolume1.setTextColor(Color.WHITE);
            txtVolume2.setTextColor(Color.WHITE);
            txtMole1.setTextColor(Color.WHITE);
            txtMole2.setTextColor(Color.WHITE);
            txtFunctionBox.setText(Html.fromHtml(getString(R.string.strAvogadrosFunction)));

            // v1/n1 = v2/n2

            if (getVol1.equals("") && !getVol2.equals("") && !getCon1.equals("") && !getCon2.equals("")) {
                dblVol2 = Double.parseDouble(getVol2);
                dblCon1 = Double.parseDouble(getCon1);
                dblCon2 = Double.parseDouble(getCon2);

                dblVol1 = (dblVol2/dblCon2)*dblCon1;
                String strVol1 = dblVol1.toString();
                txtVolume1.setText(strVol1);
                txtVolume1.setTextColor(Color.RED);
                txtFunctionBox.setText(Html.fromHtml(getString(R.string.strAvogadrosV1)));
            }
            else if (!getVol1.equals("") && getVol2.equals("") && !getCon1.equals("") && !getCon2.equals("")) {
                dblVol1 = Double.parseDouble(getVol1);
                dblCon1 = Double.parseDouble(getCon1);
                dblCon2 = Double.parseDouble(getCon2);

                dblVol2 = (dblVol1/dblCon1)*dblCon2;
                String strVol2 = dblVol2.toString();
                txtVolume2.setText(strVol2);
                txtVolume1.setTextColor(Color.RED);
                txtFunctionBox.setText(Html.fromHtml(getString(R.string.strAvogadrosV2)));
            }
            else if (!getVol1.equals("") && !getVol2.equals("") && getCon1.equals("") && !getCon2.equals("")) {
                dblVol1 = Double.parseDouble(getVol1);
                dblVol2 = Double.parseDouble(getVol2);
                dblCon2 = Double.parseDouble(getCon2);

                dblCon1 = (dblVol1*dblCon2)/dblVol2;
                String strCon1 = dblCon1.toString();
                txtMole1.setText(strCon1);
                txtMole1.setTextColor(Color.RED);
                txtFunctionBox.setText(Html.fromHtml(getString(R.string.strAvogadrosCon1)));
            }
            else if (!getVol1.equals("") && !getVol2.equals("") && !getCon1.equals("") && getCon2.equals("")) {
                dblVol1 = Double.parseDouble(getVol1);
                dblVol2 = Double.parseDouble(getVol2);
                dblCon1 = Double.parseDouble(getCon1);

                dblCon2 = (dblVol2*dblCon1)/dblVol1;
                String strCon2 = dblVol2.toString();
                txtMole2.setText(strCon2);
                txtMole2.setTextColor(Color.RED);
                txtFunctionBox.setText(Html.fromHtml(getString(R.string.strAvogadrosCon2)));
            }
            else if (!getVol1.equals("") && !getVol2.equals("") && !getCon1.equals("") && !getCon2.equals("")) {
                // all 3 have some value
                Toast.makeText(getApplicationContext(), "All four boxes contain values.  Please only give three values to compute.", Toast.LENGTH_LONG).show();
            }
            else if (getVol1.equals("") && getVol2.equals("") && getCon1.equals("") && getCon2.equals("")) {
                Toast.makeText(getApplicationContext(), "Please enter three values to compute.", Toast.LENGTH_LONG).show();
            }
            else {
                Toast.makeText(getApplicationContext(), "I'm impressed, you broke the code.", Toast.LENGTH_LONG).show();
            }

        }


    });

}

}