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
public class Combined_Gas_Law extends Activity {
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.combined_gas_law);

    ((TextView) findViewById(R.id.lblCombinedP1)).setText(Html.fromHtml("P<sub><small>1</small></sub>"));
    ((TextView) findViewById(R.id.lblCombinedV1)).setText(Html.fromHtml("V<sub><small>1</small></sub>"));
    ((TextView) findViewById(R.id.lblCombinedT1)).setText(Html.fromHtml("T<sub><small>1</small></sub>"));
    ((TextView) findViewById(R.id.lblCombinedP2)).setText(Html.fromHtml("P<sub><small>1</small></sub>"));
    ((TextView) findViewById(R.id.lblCombinedV2)).setText(Html.fromHtml("V<sub><small>1</small></sub>"));
    ((TextView) findViewById(R.id.lblCombinedT2)).setText(Html.fromHtml("T<sub><small>1</small></sub>"));

    final EditText txtP1;
    final EditText txtV1;
    final EditText txtT1;
    final EditText txtP2;
    final EditText txtV2;
    final EditText txtT2;
    final TextView txtFunctionBox;

    txtP1 = (EditText) findViewById(R.id.txtCombinedP1);
    txtV1 = (EditText) findViewById(R.id.txtCombinedV1);
    txtT1 = (EditText) findViewById(R.id.txtCombinedT1);
    txtP2 = (EditText) findViewById(R.id.txtCombinedP2);
    txtV2 = (EditText) findViewById(R.id.txtCombinedV2);
    txtT2 = (EditText) findViewById(R.id.txtCombinedT2);
    txtFunctionBox = (TextView) findViewById(R.id.FunctionBox);

    final Button btnCompute = (Button) findViewById(R.id.btnCompute);
    btnCompute.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // P1V1/T1 = P2V2/T2
            String getP1 = txtP1.getText().toString();
            String getV1 = txtV1.getText().toString();
            String getT1 = txtT1.getText().toString();
            String getP2 = txtP2.getText().toString();
            String getV2 = txtV2.getText().toString();
            String getT2 = txtT2.getText().toString();

            Double dblP1;
            Double dblV1;
            Double dblT1;
            Double dblP2;
            Double dblV2;
            Double dblT2;

            txtP1.setTextColor(Color.WHITE);
            txtV1.setTextColor(Color.WHITE);
            txtT1.setTextColor(Color.WHITE);
            txtP2.setTextColor(Color.WHITE);
            txtV2.setTextColor(Color.WHITE);
            txtT2.setTextColor(Color.WHITE);
            txtFunctionBox.setText(Html.fromHtml(getString(R.string.strCombinedGasFunction)));

            //P1V1/T1 = P2V2/T2
            if(getP1.equals("") && !getV1.equals("") && !getT1.equals("") && !getP2.equals("") && !getV2.equals("") && !getT2.equals("")){
                // p1 = p2v2t1 / t2v1
                dblV1 = Double.parseDouble(getV1);
                dblT1 = Double.parseDouble(getT1);
                dblP2 = Double.parseDouble(getP2);
                dblV2 = Double.parseDouble(getV2);
                dblT2 = Double.parseDouble(getT2);

                dblP1 = (dblP2*dblV2*dblT1)/(dblT2*dblV1);
                String strSolution = dblP1.toString();
                txtP1.setText(strSolution);
                txtP1.setTextColor(Color.RED);
                txtFunctionBox.setText(Html.fromHtml(getString(R.string.strCombinedP1)));
            }
            else if(!getP1.equals("") && getV1.equals("") && !getT1.equals("") && !getP2.equals("") && !getV2.equals("") && !getT2.equals("")){
                // v1 = p2v2t1 / t2p1
                dblP1 = Double.parseDouble(getP1);
                dblT1 = Double.parseDouble(getT1);
                dblP2 = Double.parseDouble(getP2);
                dblV2 = Double.parseDouble(getV2);
                dblT2 = Double.parseDouble(getT2);

                dblV1 = (dblP2*dblV2*dblT1)/(dblT2*dblP1);
                String strSolution = dblV1.toString();
                txtV1.setText(strSolution);
                txtV1.setTextColor(Color.RED);
                txtFunctionBox.setText(Html.fromHtml(getString(R.string.strCombinedV1)));
            }
            else if(!getP1.equals("") && !getV1.equals("") && getT1.equals("") && !getP2.equals("") && !getV2.equals("") && !getT2.equals("")){
                // t1 = p1v1t2 / p2v2
                dblP1 = Double.parseDouble(getP1);
                dblV1 = Double.parseDouble(getV1);
                dblP2 = Double.parseDouble(getP2);
                dblV2 = Double.parseDouble(getV2);
                dblT2 = Double.parseDouble(getT2);

                dblT1 = (dblP1*dblV1*dblT2)/(dblP2*dblV2);
                String strSolution = dblT1.toString();
                txtT1.setText(strSolution);
                txtT1.setTextColor(Color.RED);
                txtFunctionBox.setText(Html.fromHtml(getString(R.string.strCombinedT1)));
            }
            else if(!getP1.equals("") && !getV1.equals("") && !getT1.equals("") && getP2.equals("") && !getV2.equals("") && !getT2.equals("")){
                // p2 = p1v1t2 / t1v2
                dblP1 = Double.parseDouble(getP1);
                dblV1 = Double.parseDouble(getV1);
                dblT1 = Double.parseDouble(getT1);
                dblV2 = Double.parseDouble(getV2);
                dblT2 = Double.parseDouble(getT2);

                dblP2 = (dblP1*dblV1*dblT2)/(dblT1*dblV2);
                String strSolution = dblP2.toString();
                txtP2.setText(strSolution);
                txtP2.setTextColor(Color.RED);
                txtFunctionBox.setText(Html.fromHtml(getString(R.string.strCombinedP2)));
            }
            else if(!getP1.equals("") && !getV1.equals("") && !getT1.equals("") && !getP2.equals("") && getV2.equals("") && !getT2.equals("")){
                // v2 = p1v1t2 / t1p2
                dblP1 = Double.parseDouble(getP1);
                dblV1 = Double.parseDouble(getV1);
                dblT1 = Double.parseDouble(getT1);
                dblP2 = Double.parseDouble(getP2);
                dblT2 = Double.parseDouble(getT2);

                dblV2 = (dblP1*dblV1*dblT2)/(dblT1*dblP2);
                String strSolution = dblV2.toString();
                txtV2.setText(strSolution);
                txtV2.setTextColor(Color.RED);
                txtFunctionBox.setText(Html.fromHtml(getString(R.string.strCombinedV2)));
            }
            else if(!getP1.equals("") && !getV1.equals("") && !getT1.equals("") && !getP2.equals("") && !getV2.equals("") && getT2.equals("")){
                // t2 = p2v2t1 / p1v1
                dblP1 = Double.parseDouble(getP1);
                dblV1 = Double.parseDouble(getV1);
                dblT1 = Double.parseDouble(getT1);
                dblP2 = Double.parseDouble(getP2);
                dblV2 = Double.parseDouble(getV2);

                dblT2 = (dblP2*dblV2*dblT1)/(dblP1*dblV1);
                String strSolution = dblT2.toString();
                txtT2.setText(strSolution);
                txtT2.setTextColor(Color.RED);
                txtFunctionBox.setText(Html.fromHtml(getString(R.string.strCombinedT2)));
            }
            else if(!getP1.equals("") && !getV1.equals("") && !getT1.equals("") && !getP2.equals("") && !getV2.equals("") && !getT2.equals("")){
                // all 6 have some value
                Toast.makeText(getApplicationContext(), "All six boxes contain values.  Please only give five values to compute.", Toast.LENGTH_LONG).show();
            }
            else if(getP1.equals("") && getV1.equals("") && getT1.equals("") && getP2.equals("") && getV2.equals("") && getT2.equals("")){
                // all 6 have no value
                Toast.makeText(getApplicationContext(), "All six boxes contain no values.  Please give five values to compute.", Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(getApplicationContext(), "Please make sure five values are given.  Otherwise you broke the code.", Toast.LENGTH_LONG).show();
            }
        }
    });

}
}