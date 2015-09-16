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
public class Charles_Law extends Activity {
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.charles_law);

    ((TextView) findViewById(R.id.lblCharlesV1)).setText(Html.fromHtml("V<sub><small>1</small></sub>"));
    ((TextView) findViewById(R.id.lblCharlesV2)).setText(Html.fromHtml("V<sub><small>2</small></sub>"));
    ((TextView) findViewById(R.id.lblCharlesT1)).setText(Html.fromHtml("T<sub><small>1</small></sub>"));
    ((TextView) findViewById(R.id.lblCharlesT2)).setText(Html.fromHtml("T<sub><small>2</small></sub>"));

    final EditText txtVolume1;
    final EditText txtVolume2;
    final EditText txtTemp1;
    final EditText txtTemp2;
    final TextView txtFunctionBox;

    txtVolume1 = (EditText) findViewById(R.id.txtCharlesV1);
    txtVolume2 = (EditText) findViewById(R.id.txtCharlesV2);
    txtTemp1 = (EditText) findViewById(R.id.txtCharlesT1);
    txtTemp2 = (EditText) findViewById(R.id.txtCharlesT2);
    txtFunctionBox = (TextView) findViewById(R.id.FunctionBox);

    final Button btnCompute = (Button) findViewById(R.id.btnCompute);
    btnCompute.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String getVol1 = txtVolume1.getText().toString();
            String getVol2 = txtVolume2.getText().toString();
            String getT1 = txtTemp1.getText().toString();
            String getT2 = txtTemp2.getText().toString();

            Double dblVol1;
            Double dblVol2;
            Double dblTemp1;
            Double dblTemp2;

            txtVolume1.setTextColor(Color.WHITE);
            txtVolume2.setTextColor(Color.WHITE);
            txtTemp1.setTextColor(Color.WHITE);
            txtTemp2.setTextColor(Color.WHITE);
            txtFunctionBox.setText(Html.fromHtml(getString(R.string.strCharlesFunction)));

            // v1/t1 = v2/t2

            if (getVol1.equals("") && !getVol2.equals("") && !getT1.equals("") && !getT2.equals("")) {
                dblVol2 = Double.parseDouble(getVol2);
                dblTemp1 = Double.parseDouble(getT1);
                dblTemp2 = Double.parseDouble(getT2);

                dblVol1 = (dblVol2 / dblTemp2) * dblTemp1;
                String strVol1 = dblVol1.toString();
                txtVolume1.setText(strVol1);
                txtVolume1.setTextColor(Color.RED);
                txtFunctionBox.setText(Html.fromHtml(getString(R.string.strCharlesV1)));
            }
            else if (!getVol1.equals("") && getVol2.equals("") && !getT1.equals("") && !getT2.equals("")) {
                dblVol1 = Double.parseDouble(getVol1);
                dblTemp1 = Double.parseDouble(getT1);
                dblTemp2 = Double.parseDouble(getT2);

                dblVol2 = (dblVol1 / dblTemp1) * dblTemp2;
                String strVol2 = dblVol2.toString();
                txtVolume2.setText(strVol2);
                txtVolume1.setTextColor(Color.RED);
                txtFunctionBox.setText(Html.fromHtml(getString(R.string.strCharlesV2)));
            }
            else if (!getVol1.equals("") && !getVol2.equals("") && getT1.equals("") && !getT2.equals("")) {
                dblVol1 = Double.parseDouble(getVol1);
                dblVol2 = Double.parseDouble(getVol2);
                dblTemp2 = Double.parseDouble(getT2);

                dblTemp1 = (dblVol1 * dblTemp2) / dblVol2;
                String strTemp1 = dblTemp1.toString();
                txtTemp1.setText(strTemp1);
                txtTemp1.setTextColor(Color.RED);
                txtFunctionBox.setText(Html.fromHtml(getString(R.string.strCharlesT1)));
            }
            else if (!getVol1.equals("") && !getVol2.equals("") && !getT1.equals("") && getT2.equals("")) {
                dblVol1 = Double.parseDouble(getVol1);
                dblVol2 = Double.parseDouble(getVol2);
                dblTemp1 = Double.parseDouble(getT1);

                dblTemp2 = (dblVol2 * dblTemp1) / dblVol1;
                String strTemp2 = dblTemp2.toString();
                txtTemp2.setText(strTemp2);
                txtTemp2.setTextColor(Color.RED);
                txtFunctionBox.setText(Html.fromHtml(getString(R.string.strCharlesT2)));
            }
            else if (!getVol1.equals("") && !getVol2.equals("") && !getT1.equals("") && !getT2.equals("")) {
                // all 3 have some value
                Toast.makeText(getApplicationContext(), "All four boxes contain values.  Please only give three values to compute.", Toast.LENGTH_LONG).show();
            }
            else if (getVol1.equals("") && getVol2.equals("") && getT1.equals("") && getT2.equals("")) {
                Toast.makeText(getApplicationContext(), "Please enter three values to compute.", Toast.LENGTH_LONG).show();
            }
            else {
                Toast.makeText(getApplicationContext(), "I'm impressed, you broke the code.", Toast.LENGTH_LONG).show();
            }

        }


    });

}

}