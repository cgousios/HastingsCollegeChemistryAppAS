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
 * Created by Christopher on 10/26/2014.
 */
public class DilutionOfSolution extends Activity {
@Override
protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.dilution_of_solution);


    final EditText txtCon1;
    final EditText txtCon2;
    final EditText txtVol1;
    final EditText txtVol2;
    final TextView txtFunctionBox;

    txtCon1 = (EditText) findViewById(R.id.DOS_valConcentration1);
    txtCon2 = (EditText)findViewById(R.id.DOS_valConcentration2);
    txtVol1 = (EditText)findViewById(R.id.DOS_valVolume1);
    txtVol2 = (EditText)findViewById(R.id.DOS_valVolume2);
    txtFunctionBox = (TextView) findViewById(R.id.FunctionBox);

    txtFunctionBox.setText(Html.fromHtml(getString(R.string.strMV)));



    final Button btnCompute = (Button) findViewById(R.id.btnCompute);
    btnCompute.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String getCon1 = txtCon1.getText().toString();
            String getCon2 = txtCon2.getText().toString();
            String getVol1 = txtVol1.getText().toString();
            String getVol2 = txtVol2.getText().toString();

            Double dblCon1;
            Double dblCon2;
            Double dblVol1;
            Double dblVol2;

            txtCon1.setTextColor(Color.WHITE);
            txtCon2.setTextColor(Color.WHITE);
            txtVol1.setTextColor(Color.WHITE);
            txtVol2.setTextColor(Color.WHITE);

            // m1v1 = m2v2

            if(getCon1.equals("") && !getCon2.equals("") && !getVol1.equals("") && !getVol2.equals("")){
                dblCon2 = Double.parseDouble(getCon1);
                dblVol1 = Double.parseDouble(getVol1);
                dblVol2 = Double.parseDouble(getVol2);

                dblCon1 = (dblCon2*dblVol2)/dblVol1;
                String strCon1 = dblCon1.toString();
                txtCon1.setText(strCon1);
                txtCon1.setTextColor(Color.RED);
                txtFunctionBox.setText(Html.fromHtml(getString(R.string.strM1)));
            }
            else if(!getCon1.equals("") && getCon2.equals("") && !getVol1.equals("") && !getVol2.equals("")){
                dblCon1 = Double.parseDouble(getCon1);
                dblVol1 = Double.parseDouble(getVol1);
                dblVol2 = Double.parseDouble(getVol2);

                dblCon2 = (dblCon1 * dblVol1)/dblVol2;
                String strCon2 = dblCon2.toString();
                txtCon2.setText(strCon2);
                txtCon2.setTextColor(Color.RED);
                txtFunctionBox.setText(Html.fromHtml(getString(R.string.strM2)));
            }
            else if(!getCon1.equals("") && !getCon2.equals("") && getVol1.equals("") && !getVol2.equals("")){
                dblCon1 = Double.parseDouble(getCon1);
                dblCon2 = Double.parseDouble(getCon2);
                dblVol2 = Double.parseDouble(getVol2);

                dblVol1 = (dblCon2*dblVol2)/dblCon1;
                String strVol1 = dblVol1.toString();
                txtVol1.setText(strVol1);
                txtVol1.setTextColor(Color.RED);
                txtFunctionBox.setText(Html.fromHtml(getString(R.string.strV1)));
            }
            else if(!getCon1.equals("") && !getCon2.equals("") && !getVol1.equals("") && getVol2.equals("")){
                dblCon1 = Double.parseDouble(getCon1);
                dblCon2 = Double.parseDouble(getCon2);
                dblVol1 = Double.parseDouble(getVol1);

                dblVol2 = (dblCon1*dblVol1)/dblCon2;
                String strVol2 = dblVol2.toString();
                txtVol2.setText(strVol2);
                txtVol2.setTextColor(Color.RED);
                txtFunctionBox.setText(Html.fromHtml(getString(R.string.strV2)));
            }
            else if(!getCon1.equals("") && !getCon2.equals("") && !getVol1.equals("") && !getVol2.equals("")){
                // all 3 have some value
                Toast.makeText(getApplicationContext(), "All four boxes contain values.  Please only give three values to compute.", Toast.LENGTH_LONG).show();
            }
            else if(getCon1.equals("") && getCon2.equals("") && getVol1.equals("") && getVol2.equals("")){
                Toast.makeText(getApplicationContext(), "Please enter three values to compute.", Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(getApplicationContext(), "I'm impressed, you broke the code.", Toast.LENGTH_LONG).show();
            }

        }


    });
}
}

