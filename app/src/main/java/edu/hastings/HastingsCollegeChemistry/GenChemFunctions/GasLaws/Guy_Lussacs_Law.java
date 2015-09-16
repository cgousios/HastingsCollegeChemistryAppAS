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
public class Guy_Lussacs_Law extends Activity {
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.guy_lussacs_law);

    ((TextView) findViewById(R.id.lblGuyLussacP1)).setText(Html.fromHtml("P<sub><small>1</small></sub>"));
    ((TextView) findViewById(R.id.lblGuyLussacP2)).setText(Html.fromHtml("P<sub><small>2</small></sub>"));
    ((TextView) findViewById(R.id.lblGuyLussacT1)).setText(Html.fromHtml("T<sub><small>1</small></sub>"));
    ((TextView) findViewById(R.id.lblGuyLussacT2)).setText(Html.fromHtml("T<sub><small>2</small></sub>"));

    final EditText txtPressure1;
    final EditText txtPressure2;
    final EditText txtTemp1;
    final EditText txtTemp2;
    final TextView txtFunctionBox;

    txtPressure1 = (EditText) findViewById(R.id.txtGuyLussacP1);
    txtPressure2 = (EditText) findViewById(R.id.txtGuyLussacP2);
    txtTemp1 = (EditText) findViewById(R.id.txtGuyLussacT1);
    txtTemp2 = (EditText) findViewById(R.id.txtGuyLussacT2);
    txtFunctionBox = (TextView) findViewById(R.id.FunctionBox);

    final Button btnCompute = (Button) findViewById(R.id.btnCompute);
    btnCompute.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String getP1 = txtPressure1.getText().toString();
            String getP2 = txtPressure2.getText().toString();
            String getT1 = txtTemp1.getText().toString();
            String getT2 = txtTemp2.getText().toString();

            Double dblP1;
            Double dblP2;
            Double dblTemp1;
            Double dblTemp2;

            txtPressure1.setTextColor(Color.WHITE);
            txtPressure2.setTextColor(Color.WHITE);
            txtTemp1.setTextColor(Color.WHITE);
            txtTemp2.setTextColor(Color.WHITE);
            txtFunctionBox.setText(Html.fromHtml(getString(R.string.strGuyLussacsFunction)));

            // p1/t1 = p2/t2

            if (getP1.equals("") && !getP2.equals("") && !getT1.equals("") && !getT2.equals("")) {
                dblP2 = Double.parseDouble(getP2);
                dblTemp1 = Double.parseDouble(getT1);
                dblTemp2 = Double.parseDouble(getT2);

                dblP1 = (dblP2 / dblTemp2) * dblTemp1;
                String strP1 = dblP1.toString();
                txtPressure1.setText(strP1);
                txtPressure1.setTextColor(Color.RED);
                txtFunctionBox.setText(Html.fromHtml(getString(R.string.strGuyLussacsP1)));
            }
            else if (!getP1.equals("") && getP2.equals("") && !getT1.equals("") && !getT2.equals("")) {
                dblP1 = Double.parseDouble(getP1);
                dblTemp1 = Double.parseDouble(getT1);
                dblTemp2 = Double.parseDouble(getT2);

                dblP2 = (dblP1 / dblTemp1) * dblTemp2;
                String strP2 = dblP2.toString();
                txtPressure2.setText(strP2);
                txtPressure1.setTextColor(Color.RED);
                txtFunctionBox.setText(Html.fromHtml(getString(R.string.strGuyLussacsP2)));
            }
            else if (!getP1.equals("") && !getP2.equals("") && getT1.equals("") && !getT2.equals("")) {
                dblP1 = Double.parseDouble(getP1);
                dblP2 = Double.parseDouble(getP2);
                dblTemp2 = Double.parseDouble(getT2);

                dblTemp1 = (dblP1 * dblTemp2) / dblP2;
                String strTemp1 = dblTemp1.toString();
                txtTemp1.setText(strTemp1);
                txtTemp1.setTextColor(Color.RED);
                txtFunctionBox.setText(Html.fromHtml(getString(R.string.strGuyLussacsT1)));
            }
            else if (!getP1.equals("") && !getP2.equals("") && !getT1.equals("") && getT2.equals("")) {
                dblP1 = Double.parseDouble(getP1);
                dblP2 = Double.parseDouble(getP2);
                dblTemp1 = Double.parseDouble(getT1);

                dblTemp2 = (dblP2 * dblTemp1) / dblP1;
                String strTemp2 = dblTemp2.toString();
                txtTemp2.setText(strTemp2);
                txtTemp2.setTextColor(Color.RED);
                txtFunctionBox.setText(Html.fromHtml(getString(R.string.strGuyLussacsT2)));
            }
            else if (!getP1.equals("") && !getP2.equals("") && !getT1.equals("") && !getT2.equals("")) {
                // all 3 have some value
                Toast.makeText(getApplicationContext(), "All four boxes contain values.  Please only give three values to compute.", Toast.LENGTH_LONG).show();
            }
            else if (getP1.equals("") && getP2.equals("") && getT1.equals("") && getT2.equals("")) {
                Toast.makeText(getApplicationContext(), "Please enter three values to compute.", Toast.LENGTH_LONG).show();
            }
            else {
                Toast.makeText(getApplicationContext(), "I'm impressed, you broke the code.", Toast.LENGTH_LONG).show();
            }

        }


    });

}

}