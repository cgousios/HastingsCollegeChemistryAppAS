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
public class Boyles_Law extends Activity {
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.boyles_law);

    ((TextView) findViewById(R.id.lblPressure1)).setText(Html.fromHtml("P<sub><small>1</small></sub>"));
    ((TextView) findViewById(R.id.lblVolume1)).setText(Html.fromHtml("V<sub><small>1</small></sub>"));
    ((TextView)findViewById(R.id.lblPressure2)).setText(Html.fromHtml("P<sub><small21</small></sub>"));
    ((TextView)findViewById(R.id.lblVolume2)).setText(Html.fromHtml("V<sub><small>2</small></sub>"));

    final EditText txtPressure1;
    final EditText txtPressure2;
    final EditText txtVolume1;
    final EditText txtVolume2;
    final TextView txtFunctionBox;

    txtPressure1 = (EditText) findViewById(R.id.txtPressure1);
    txtPressure2 = (EditText) findViewById(R.id.txtPressure2);
    txtVolume1 = (EditText) findViewById(R.id.txtVolume1);
    txtVolume2 = (EditText) findViewById(R.id.txtVolume2);
    txtFunctionBox = (TextView) findViewById(R.id.FunctionBox);

    txtFunctionBox.setText(Html.fromHtml(getString(R.string.strBoylesFunction)));

    final Button btnCompute = (Button) findViewById(R.id.btnCompute);
    btnCompute.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // P1V1 = P2V2
            String getP1 = txtPressure1.getText().toString();
            String getP2 = txtPressure2.getText().toString();
            String getVol1 = txtVolume1.getText().toString();
            String getVol2 = txtVolume2.getText().toString();

            Double dblP1;
            Double dblP2;
            Double dblVol1;
            Double dblVol2;

            txtPressure1.setTextColor(Color.WHITE);
            txtPressure2.setTextColor(Color.WHITE);
            txtVolume1.setTextColor(Color.WHITE);
            txtVolume2.setTextColor(Color.WHITE);

            // p1v1 = p2v2

            if(getP1.equals("") && !getP2.equals("") && !getVol1.equals("") && !getVol2.equals("")){
                dblP2 = Double.parseDouble(getP2);
                dblVol1 = Double.parseDouble(getVol1);
                dblVol2 = Double.parseDouble(getVol2);

                dblP1 = (dblP2*dblVol2)/dblVol1;
                String strPressure1 = dblP1.toString();
                txtPressure1.setText(strPressure1);
                txtPressure1.setTextColor(Color.RED);
                txtFunctionBox.setText(Html.fromHtml(getString(R.string.strBoylesP1)));
            }
            else if(!getP1.equals("") && getP2.equals("") && !getVol1.equals("") && !getVol2.equals("")){
                dblP1 = Double.parseDouble(getP1);
                dblVol1 = Double.parseDouble(getVol1);
                dblVol2 = Double.parseDouble(getVol2);

                dblP2 = (dblP1 * dblVol1)/dblVol2;
                String strPressure2 = dblP2.toString();
                txtPressure2.setText(strPressure2);
                txtPressure2.setTextColor(Color.RED);
                txtFunctionBox.setText(Html.fromHtml(getString(R.string.strBoylesP2)));
            }
            else if(!getP1.equals("") && !getP2.equals("") && getVol1.equals("") && !getVol2.equals("")){
                dblP1 = Double.parseDouble(getP1);
                dblP2 = Double.parseDouble(getP2);
                dblVol2 = Double.parseDouble(getVol2);

                dblVol1 = (dblP2*dblVol2)/dblP1;
                String strVolume1 = dblVol1.toString();
                txtVolume1.setText(strVolume1);
                txtVolume1.setTextColor(Color.RED);
                txtFunctionBox.setText(Html.fromHtml(getString(R.string.strBoylesV1)));
            }
            else if(!getP1.equals("") && !getP2.equals("") && !getVol1.equals("") && getVol2.equals("")){
                dblP1 = Double.parseDouble(getP1);
                dblP2 = Double.parseDouble(getP2);
                dblVol1 = Double.parseDouble(getVol1);

                dblVol2 = (dblP1*dblVol1)/dblP2;
                String strVol2 = dblVol2.toString();
                txtVolume2.setText(strVol2);
                txtVolume2.setTextColor(Color.RED);
                txtFunctionBox.setText(Html.fromHtml(getString(R.string.strBoylesV2)));
            }
            else if(!getP1.equals("") && !getP2.equals("") && !getVol1.equals("") && !getVol2.equals("")){
                // all 3 have some value
                Toast.makeText(getApplicationContext(), "All four boxes contain values.  Please only give three values to compute.", Toast.LENGTH_LONG).show();
            }
            else if(getP1.equals("") && getP2.equals("") && getVol1.equals("") && getVol2.equals("")){
                Toast.makeText(getApplicationContext(), "Please enter three values to compute.", Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(getApplicationContext(), "I'm impressed, you broke the code.", Toast.LENGTH_LONG).show();
            }

        }


    });
}
}

