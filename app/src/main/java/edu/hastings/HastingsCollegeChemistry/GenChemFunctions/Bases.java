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
 * Created by cgousios on 5/8/2015.
 */
public class Bases extends Activity {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.bases);

//    ((TextView) findViewById(R.id.lblKb)).setText(R.string.strKb);
//    ((TextView) findViewById(R.id.lblBHplus)).setText(R.string.strBHplus);
//    ((TextView) findViewById(R.id.lblOHminus)).setText(R.string.strOHminus);
//    ((TextView) findViewById(R.id.lblB)).setText(R.string.strB);

    final EditText txtKb;
    final EditText txtBHplus;
    final EditText txtOHminus;
    final EditText txtB;

    final TextView txtFunctionBox;
    final TextView lblKb;
    final TextView lblBHplus;
    final TextView lblOHminus;
    final TextView lblB;

    txtKb = (EditText) findViewById(R.id.Kb);
    txtBHplus = (EditText) findViewById(R.id.BHplus);
    txtOHminus = (EditText) findViewById(R.id.OHminus);
    txtB = (EditText) findViewById(R.id.B);
    txtFunctionBox = (TextView) findViewById(R.id.FunctionBox);

    lblKb = (TextView) findViewById(R.id.lblKb);
    lblBHplus = (TextView) findViewById(R.id.lblBHplus);
    lblOHminus = (TextView) findViewById(R.id.lblOHminus);
    lblB = (TextView) findViewById(R.id.lblB);

    lblKb.setText(Html.fromHtml("K<small><sub>b</sub></small>"));
    lblBHplus.setText(Html.fromHtml("BH<small><sup>+</sup></small>"));
    lblOHminus.setText(Html.fromHtml("OH<small><sup>-</sup></small>"));
    lblB.setText(Html.fromHtml("B"));

    final Button btnCompute = (Button) findViewById(R.id.btnCompute);
    btnCompute.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String getKb = txtKb.getText().toString();
            String getBHplus = txtBHplus.getText().toString();
            String getOHminus = txtOHminus.getText().toString();
            String getB = txtB.getText().toString();

            Double dblKA; Double dblH; Double dblA; Double dblHA;

            txtKb.setTextColor(Color.WHITE);
            txtBHplus.setTextColor(Color.WHITE);
            txtOHminus.setTextColor(Color.WHITE);
            txtB.setTextColor(Color.WHITE);

            if(getKb.equals("") && getBHplus.equals("") && getOHminus.equals("") && getB.equals("")) {
                Toast.makeText(getApplicationContext(), "Please enter three values.", Toast.LENGTH_LONG).show();
            }else if(!getKb.equals("") && getBHplus.equals("") && getOHminus.equals("") && getB.equals("")) {
                Toast.makeText(getApplicationContext(), "Please enter three values.", Toast.LENGTH_LONG).show();
            }else if(getKb.equals("") && !getBHplus.equals("") && getOHminus.equals("") && getB.equals("")) {
                Toast.makeText(getApplicationContext(), "Please enter three values.", Toast.LENGTH_LONG).show();
            }else if(getKb.equals("") && getBHplus.equals("") && !getOHminus.equals("") && getB.equals("")) {
                Toast.makeText(getApplicationContext(), "Please enter three values.", Toast.LENGTH_LONG).show();
            }else if(getKb.equals("") && getBHplus.equals("") && getOHminus.equals("") && !getB.equals("")) {
                Toast.makeText(getApplicationContext(), "Please enter three values.", Toast.LENGTH_LONG).show();
            }else if(!getKb.equals("") && !getBHplus.equals("") && getOHminus.equals("") && getB.equals("")) {
                Toast.makeText(getApplicationContext(), "Please enter three values.", Toast.LENGTH_LONG).show();
            }else if(!getKb.equals("") && getBHplus.equals("") && !getOHminus.equals("") && getB.equals("")) {
                Toast.makeText(getApplicationContext(), "Please enter three values.", Toast.LENGTH_LONG).show();
            }else if(!getKb.equals("") && getBHplus.equals("") && getOHminus.equals("") && !getB.equals("")) {
                Toast.makeText(getApplicationContext(), "Please enter three values.", Toast.LENGTH_LONG).show();
            }else if(getKb.equals("") && !getBHplus.equals("") && !getOHminus.equals("") && getB.equals("")) {
                Toast.makeText(getApplicationContext(), "Please enter three values.", Toast.LENGTH_LONG).show();
            }else if(getKb.equals("") && !getBHplus.equals("") && getOHminus.equals("") && !getB.equals("")) {
                Toast.makeText(getApplicationContext(), "Please enter three values.", Toast.LENGTH_LONG).show();
            }else if(getKb.equals("") && getBHplus.equals("") && !getOHminus.equals("") && !getB.equals("")) {
                Toast.makeText(getApplicationContext(), "Please enter three values.", Toast.LENGTH_LONG).show();
            }
            else if(getKb.equals("") && !getBHplus.equals("") && !getOHminus.equals("") && !getB.equals("")) {
                dblH = Double.parseDouble(getBHplus);
                dblA = Double.parseDouble(getOHminus);
                dblHA = Double.parseDouble(getB);

                dblKA = (dblH*dblA)/dblHA;
                String strSolution = dblKA.toString();
                txtKb.setTextColor(Color.RED);
                txtKb.setText(strSolution);
            }
            else if(!getKb.equals("") && getBHplus.equals("") && !getOHminus.equals("") && !getB.equals("")) {
                dblKA = Double.parseDouble(getKb);
                dblA = Double.parseDouble(getOHminus);
                dblHA = Double.parseDouble(getB);

                dblH = (dblKA*dblHA)/dblA;
                String strSolution = dblH.toString();
                txtBHplus.setTextColor(Color.RED);
                txtBHplus.setText(strSolution);
            }
            else if(!getKb.equals("") && !getBHplus.equals("") && getOHminus.equals("") && !getB.equals("")) {
                dblH = Double.parseDouble(getBHplus);
                dblKA = Double.parseDouble(getKb);
                dblHA = Double.parseDouble(getB);

                dblA = (dblKA*dblHA)/dblH;
                String strSolution = dblA.toString();
                txtOHminus.setTextColor(Color.RED);
                txtOHminus.setText(strSolution);
            }
            else if(!getKb.equals("") && !getBHplus.equals("") && !getOHminus.equals("") && getB.equals("")) {
                dblH = Double.parseDouble(getBHplus);
                dblA = Double.parseDouble(getOHminus);
                dblKA = Double.parseDouble(getKb);

                dblHA = (dblH*dblA)/dblKA;
                String strSolution = dblHA.toString();
                txtB.setTextColor(Color.RED);
                txtB.setText(strSolution);
            }
            else{
                Toast.makeText(getApplicationContext(), "Unknown error.", Toast.LENGTH_LONG).show();
            }

        }
    });


}
}

