package edu.hastings.HastingsCollegeChemistry.BioChemFunctions;

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
public class HendersonHasselbalch extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.henderson_hallelbalch);

        ((TextView)findViewById(R.id.logA)).setText(Html.fromHtml("[A<sup><small<-</small></sup>] (M)"));
        ((TextView)findViewById(R.id.FunctionBox)).setText(Html.fromHtml("pH = pKa + log[A<sup><small>-</small></sup>] / [HA])"));

        final EditText txtph;
        final EditText txtpKa;
        final EditText txtHA;
        final EditText txtA;
        final TextView txtFunctionBox;

        txtph = (EditText) findViewById(R.id.pH);
        txtpKa = (EditText)findViewById(R.id.pKa);
        txtA = (EditText)findViewById(R.id.A);
        txtHA = (EditText)findViewById(R.id.HA);
        txtFunctionBox = (TextView) findViewById(R.id.FunctionBox);

        final Button btnCompute = (Button) findViewById(R.id.btnCompute);
        btnCompute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String getPH = txtph.getText().toString();
                String getPKA = txtpKa.getText().toString();
                String getA = txtA.getText().toString();
                String getHA = txtHA.getText().toString();

                Double dblpH;
                Double dblpKa;
                Double dblA;
                Double dblHA;

                txtph.setTextColor(Color.WHITE);
                txtpKa.setTextColor(Color.WHITE);
                txtA.setTextColor(Color.WHITE);
                txtHA.setTextColor(Color.WHITE);

                // pH = pKa + log10([A]/[HA])

                if(getPH.equals("") && !getPKA.equals("") && !getA.equals("") && !getHA.equals("")){
                    dblpKa = Double.parseDouble(getPKA);
                    dblA = Double.parseDouble(getA);
                    dblHA = Double.parseDouble(getHA);

                    dblpH = dblpKa + Math.log10((dblA/dblHA));
                    String strpH = dblpH.toString();
                    txtph.setText(strpH);
                    txtph.setTextColor(Color.RED);
                    txtFunctionBox.setText(Html.fromHtml("pH = pKa + log[A<sup><small>-</small></sup>] / [HA])"));
                }
                else if(!getPH.equals("") && getPKA.equals("") && !getA.equals("") && !getHA.equals("")){
                    dblpH = Double.parseDouble(getPH);
                    dblA = Double.parseDouble(getA);
                    dblHA = Double.parseDouble(getHA);

                    dblpKa = dblpH - Math.log10((dblA/dblHA));
                    String strpKa = dblpKa.toString();
                    txtpKa.setText(strpKa);
                    txtpKa.setTextColor(Color.RED);
                    txtFunctionBox.setText(Html.fromHtml("pKa = pH - log[A<sup><small>-</small></sup>] / [HA])"));

                }
                else if(!getPH.equals("") && !getPKA.equals("") && getA.equals("") && !getHA.equals("")){
                    dblpH = Double.parseDouble(getPH);
                    dblpKa = Double.parseDouble(getPKA);
                    dblHA = Double.parseDouble(getHA);

                    dblA = Math.pow(10, (dblHA * (dblpH - dblpKa)));
                    String strA = dblA.toString();
                    txtA.setText(strA);
                    txtA.setTextColor(Color.RED);
                    txtFunctionBox.setText(Html.fromHtml("[A<sup><small>-</small></sup> = 10<sup><small>[HA] * (ph - pKa)</small></sup>"));
                }
                else if(!getPH.equals("") && !getPKA.equals("") && !getA.equals("") && getHA.equals("")){
                    dblpH = Double.parseDouble(getPH);
                    dblpKa = Double.parseDouble(getPKA);
                    dblA = Double.parseDouble(getA);

                    dblHA = dblpKa - dblpH + Math.log10(dblA);
                    String strHA = dblHA.toString();
                    txtHA.setText(strHA);
                    txtHA.setTextColor(Color.RED);
                    txtFunctionBox.setText(Html.fromHtml("[HA] = pKa + log[A<sup><small>-</small></sup>] / pH"));
                }
                else if(!getPH.equals("") && !getPKA.equals("") && !getA.equals("") && !getHA.equals("")){
                    // all 3 have some value
                    Toast.makeText(getApplicationContext(), "All four boxes contain values.  Please only give three values to compute.", Toast.LENGTH_LONG).show();
                }
                else if(getPH.equals("") && getPKA.equals("") && getA.equals("") && getHA.equals("")){
                    Toast.makeText(getApplicationContext(), "Please enter three values to compute.", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "I'm impressed, you broke the code.", Toast.LENGTH_LONG).show();
                }

            }


        });
    }
}
