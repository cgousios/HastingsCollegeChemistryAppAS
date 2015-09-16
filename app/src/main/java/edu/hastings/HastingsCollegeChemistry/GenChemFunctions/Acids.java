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
public class Acids extends Activity {
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.acids);

//    ((TextView) findViewById(R.id.lblKa)).setText(R.string.strKa);
//    ((TextView) findViewById(R.id.lblHplus)).setText(R.string.strHplus);
//    ((TextView) findViewById(R.id.lblAminus)).setText(R.string.strAminus);
//    ((TextView) findViewById(R.id.lblHA)).setText(R.string.strHA);


    final EditText txtKa;
    final EditText txtHplus;
    final EditText txtAminus;
    final EditText txtHA;

    final TextView txtFunctionBox;
    final TextView lblKa;
    final TextView lblHplus;
    final TextView lblAminus;
    final TextView lblHA;

    txtKa = (EditText) findViewById(R.id.Ka);
    txtHplus = (EditText) findViewById(R.id.Hplus);
    txtAminus = (EditText) findViewById(R.id.Aminus);
    txtHA = (EditText) findViewById(R.id.HA);
    txtFunctionBox = (TextView) findViewById(R.id.FunctionBox);

    lblKa = (TextView) findViewById(R.id.lblKa);
    lblHplus = (TextView) findViewById(R.id.lblHplus);
    lblAminus = (TextView) findViewById(R.id.lblAminus);
    lblHA = (TextView) findViewById(R.id.lblHA);

    lblKa.setText(Html.fromHtml("K<small><sub>a</sub></small>"));
    lblHplus.setText(Html.fromHtml("H<small><sup>+</sup></small>"));
    lblAminus.setText(Html.fromHtml("A<small><sup>-</sup></small>"));
    lblHA.setText(Html.fromHtml("HA"));

    final Button btnCompute = (Button) findViewById(R.id.btnCompute);
    btnCompute.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String getKa = txtKa.getText().toString();
            String getHplus = txtHplus.getText().toString();
            String getAminus = txtAminus.getText().toString();
            String getHA = txtHA.getText().toString();

            Double dblKA; Double dblH; Double dblA; Double dblHA;

            txtKa.setTextColor(Color.WHITE);
            txtHplus.setTextColor(Color.WHITE);
            txtAminus.setTextColor(Color.WHITE);
            txtHA.setTextColor(Color.WHITE);

            if(getKa.equals("") && getHplus.equals("") && getAminus.equals("") && getHA.equals("")) {
                Toast.makeText(getApplicationContext(), "Please enter three values.", Toast.LENGTH_LONG).show();
            }else if(!getKa.equals("") && getHplus.equals("") && getAminus.equals("") && getHA.equals("")) {
                Toast.makeText(getApplicationContext(), "Please enter three values.", Toast.LENGTH_LONG).show();
            }else if(getKa.equals("") && !getHplus.equals("") && getAminus.equals("") && getHA.equals("")) {
                Toast.makeText(getApplicationContext(), "Please enter three values.", Toast.LENGTH_LONG).show();
            }else if(getKa.equals("") && getHplus.equals("") && !getAminus.equals("") && getHA.equals("")) {
                Toast.makeText(getApplicationContext(), "Please enter three values.", Toast.LENGTH_LONG).show();
            }else if(getKa.equals("") && getHplus.equals("") && getAminus.equals("") && !getHA.equals("")) {
                Toast.makeText(getApplicationContext(), "Please enter three values.", Toast.LENGTH_LONG).show();
            }else if(!getKa.equals("") && !getHplus.equals("") && getAminus.equals("") && getHA.equals("")) {
                Toast.makeText(getApplicationContext(), "Please enter three values.", Toast.LENGTH_LONG).show();
            }else if(!getKa.equals("") && getHplus.equals("") && !getAminus.equals("") && getHA.equals("")) {
                Toast.makeText(getApplicationContext(), "Please enter three values.", Toast.LENGTH_LONG).show();
            }else if(!getKa.equals("") && getHplus.equals("") && getAminus.equals("") && !getHA.equals("")) {
                Toast.makeText(getApplicationContext(), "Please enter three values.", Toast.LENGTH_LONG).show();
            }else if(getKa.equals("") && !getHplus.equals("") && !getAminus.equals("") && getHA.equals("")) {
                Toast.makeText(getApplicationContext(), "Please enter three values.", Toast.LENGTH_LONG).show();
            }else if(getKa.equals("") && !getHplus.equals("") && getAminus.equals("") && !getHA.equals("")) {
                Toast.makeText(getApplicationContext(), "Please enter three values.", Toast.LENGTH_LONG).show();
            }else if(getKa.equals("") && getHplus.equals("") && !getAminus.equals("") && !getHA.equals("")) {
                Toast.makeText(getApplicationContext(), "Please enter three values.", Toast.LENGTH_LONG).show();
            }
            else if(getKa.equals("") && !getHplus.equals("") && !getAminus.equals("") && !getHA.equals("")) {
                dblH = Double.parseDouble(getHplus);
                dblA = Double.parseDouble(getAminus);
                dblHA = Double.parseDouble(getHA);

                dblKA = (dblH*dblA)/dblHA;
                String strSolution = dblKA.toString();
                txtKa.setTextColor(Color.RED);
                txtKa.setText(strSolution);
            }
            else if(!getKa.equals("") && getHplus.equals("") && !getAminus.equals("") && !getHA.equals("")) {
                dblKA = Double.parseDouble(getKa);
                dblA = Double.parseDouble(getAminus);
                dblHA = Double.parseDouble(getHA);

                dblH = (dblKA*dblHA)/dblA;
                String strSolution = dblH.toString();
                txtHplus.setTextColor(Color.RED);
                txtHplus.setText(strSolution);
            }
            else if(!getKa.equals("") && !getHplus.equals("") && getAminus.equals("") && !getHA.equals("")) {
                dblH = Double.parseDouble(getHplus);
                dblKA = Double.parseDouble(getKa);
                dblHA = Double.parseDouble(getHA);

                dblA = (dblKA*dblHA)/dblH;
                String strSolution = dblA.toString();
                txtAminus.setTextColor(Color.RED);
                txtAminus.setText(strSolution);
            }
            else if(!getKa.equals("") && !getHplus.equals("") && !getAminus.equals("") && getHA.equals("")) {
                dblH = Double.parseDouble(getHplus);
                dblA = Double.parseDouble(getAminus);
                dblKA = Double.parseDouble(getKa);

                dblHA = (dblH*dblA)/dblKA;
                String strSolution = dblHA.toString();
                txtHA.setTextColor(Color.RED);
                txtHA.setText(strSolution);
            }
            else{
                Toast.makeText(getApplicationContext(), "Unknown error.", Toast.LENGTH_LONG).show();
            }

        }
    });


}
}
