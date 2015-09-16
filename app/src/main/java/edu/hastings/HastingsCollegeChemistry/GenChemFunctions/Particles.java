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

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by cgousios on 5/7/2015.
 */
public class Particles extends Activity {
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.particles);

    final EditText txtMoles;
    final EditText txtAtoms;
    final TextView txtFunctionBox;

    txtMoles = (EditText) findViewById(R.id.moles);
    txtAtoms = (EditText) findViewById(R.id.atoms);
    txtFunctionBox = (TextView) findViewById(R.id.FunctionBox);

    txtFunctionBox.setText(Html.fromHtml("1 mole = 6.02x10<small><sup>23</sup></small> atoms"));

    final NumberFormat formatter = new DecimalFormat("0.####E0");

    final Button btnCompute = (Button) findViewById(R.id.btnCompute);
    btnCompute.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String getMoles = txtMoles.getText().toString();
            String getAtoms = txtAtoms.getText().toString();

            Double dblMoles;
            Double dblAtoms;

            txtMoles.setTextColor(Color.WHITE);
            txtAtoms.setTextColor(Color.WHITE);

            // 1 mole = 6.02*10^23 atoms
            if(getMoles.equals("") && getAtoms.equals("")){
                Toast.makeText(getApplicationContext(), "Please enter a value.", Toast.LENGTH_LONG).show();
            }
            else if(!getMoles.equals("") && !getAtoms.equals("")){
                Toast.makeText(getApplicationContext(), "Please enter only one value.", Toast.LENGTH_LONG).show();
            }
            else if(!getMoles.equals("") && getAtoms.equals("")){
                dblMoles = Double.parseDouble(getMoles);

                dblAtoms = dblMoles*6.0221415*Math.pow(10,23);
                //System.out.println(formatter.format(dblAtoms));
                String strAtoms = dblAtoms.toString();
                txtAtoms.setTextColor(Color.RED);
                txtAtoms.setText(strAtoms);
            }
            else if(getMoles.equals("") && !getAtoms.equals("")){
                dblAtoms = Double.parseDouble(getAtoms);

                dblMoles = dblAtoms/(6.0221415*Math.pow(10,23));
                //System.out.println(formatter.format(dblMoles));
                String strMoles = dblMoles.toString();
                txtMoles.setTextColor(Color.RED);
                txtMoles.setText(strMoles);
            }

        }
    });
}
}
