package edu.hastings.HastingsCollegeChemistry.OrganicChemFunctions;

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
 * Created by Christopher on 10/15/2014.
 */
public class SpecificRotation extends Activity {
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.specific_rotation);

    ((TextView)findViewById(R.id.txtCM)).setText(Html.fromHtml("c (g/cm<sup><small>3</small></sup>)"));
    ((TextView)findViewById(R.id.txtalphaD)).setText(Html.fromHtml("[α]<sub><small>D</small></sub>"));
    ((TextView)findViewById(R.id.FunctionBox)).setText(Html.fromHtml("[α]<sub><small>D</small></sub> = α / l x c"));

    final EditText txtRotation;
    final EditText txtAngle;
    final EditText txtCocentration;
    final EditText txtLength;
    final TextView txtFunctionBox;

    txtRotation = (EditText) findViewById(R.id.rotation);
    txtAngle = (EditText)findViewById(R.id.angle);
    txtCocentration = (EditText)findViewById(R.id.MassConcentration);
    txtLength = (EditText)findViewById(R.id.length);
    txtFunctionBox = (TextView) findViewById(R.id.FunctionBox);

    final Button btnCompute = (Button) findViewById(R.id.btnCompute);
    btnCompute.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String getRotation = txtRotation.getText().toString();
            String getAngle = txtAngle.getText().toString();
            String getConcentration = txtCocentration.getText().toString();
            String getLength = txtLength.getText().toString();

            Double dblRotation;
            Double dblAngle;
            Double dblConcentration;
            Double dblLength;

            txtRotation.setTextColor(Color.WHITE);
            txtAngle.setTextColor(Color.WHITE);
            txtCocentration.setTextColor(Color.WHITE);
            txtLength.setTextColor(Color.WHITE);
            txtFunctionBox.setText(Html.fromHtml("[α]<sub><small>D</</small>sub> = α / l x c"));

            // [a]d = a/ c*l

            if(getRotation.equals("") && !getAngle.equals("") && !getConcentration.equals("") && !getLength.equals("")){
                dblAngle = Double.parseDouble(getAngle);
                dblConcentration = Double.parseDouble(getConcentration);
                dblLength = Double.parseDouble(getLength);

                dblRotation = dblAngle/(dblConcentration*dblLength);
                String strRotation = dblRotation.toString();
                txtRotation.setText(strRotation);
                txtRotation.setTextColor(Color.RED);
                txtFunctionBox.setText(Html.fromHtml("[α]<sub><small>D</small></sub> = α / l x c"));
            }
            else if(!getRotation.equals("") && getAngle.equals("") && !getConcentration.equals("") && !getLength.equals("")){
                dblRotation = Double.parseDouble(getRotation);
                dblConcentration = Double.parseDouble(getConcentration);
                dblLength = Double.parseDouble(getLength);

                dblAngle = dblRotation * dblConcentration * dblLength;
                String strAngle = dblAngle.toString();
                txtAngle.setText(strAngle);
                txtAngle.setTextColor(Color.RED);
                txtFunctionBox.setText(Html.fromHtml("α = [α]<sub><small>D</small></sub> x l x c"));
            }
            else if(!getRotation.equals("") && !getAngle.equals("") && getConcentration.equals("") && !getLength.equals("")){
                dblAngle = Double.parseDouble(getAngle);
                dblRotation = Double.parseDouble(getRotation);
                dblLength = Double.parseDouble(getLength);

                dblConcentration = dblAngle/(dblRotation * dblLength);
                String strConcentration = dblConcentration.toString();
                txtCocentration.setText(strConcentration);
                txtCocentration.setTextColor(Color.RED);
                txtFunctionBox.setText(Html.fromHtml("c = α / [α]<sub><small>D</small></sub> x l"));
            }
            else if(!getRotation.equals("") && !getAngle.equals("") && !getConcentration.equals("") && getLength.equals("")){
                dblAngle = Double.parseDouble(getAngle);
                dblConcentration = Double.parseDouble(getConcentration);
                dblRotation = Double.parseDouble(getRotation);

                dblLength = dblAngle/(dblConcentration * dblRotation);
                String strLength = dblLength.toString();
                txtLength.setText(strLength);
                txtLength.setTextColor(Color.RED);
                txtFunctionBox.setText(Html.fromHtml("l = α / [α]<sub><small>D</small></sub> x c"));
            }
            else if(!getRotation.equals("") && !getAngle.equals("") && !getConcentration.equals("") && !getLength.equals("")){
                // all 3 have some value
                Toast.makeText(getApplicationContext(), "All four boxes contain values.  Please only give three values to compute.", Toast.LENGTH_LONG).show();
            }
            else if(getRotation.equals("") && getAngle.equals("") && getConcentration.equals("") && getLength.equals("")){
                Toast.makeText(getApplicationContext(), "Please enter three values to compute.", Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(getApplicationContext(), "I'm impressed, you broke the code.", Toast.LENGTH_LONG).show();
            }

        }


    });
}
}
