package edu.hastings.HastingsCollegeChemistry.GenChemFunctions;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import edu.hastings.HastingsCollegeChemistry.R;

/**
 * Created by Christopher on 10/14/2014.
 */
public class Stoichiometry extends Activity {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.stoichiometry);

    final EditText txtMass;
    final EditText txtMol;
    final EditText txtMolMass;

    txtMass = (EditText) findViewById(R.id.Mass);
    txtMol = (EditText)findViewById(R.id.Molarity);
    txtMolMass = (EditText)findViewById(R.id.MolarMass);
    final TextView txtFunctionBox = (TextView) findViewById(R.id.FunctionBox);

    final Button btnCompute = (Button) findViewById(R.id.btnCompute);
    btnCompute.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String getMass = txtMass.getText().toString();
            String getMol = txtMol.getText().toString();
            String getMolMass = txtMolMass.getText().toString();

            Double dblMass;
            Double dblMol;
            Double dblMolMass;

            txtMass.setTextColor(Color.WHITE);
            txtMol.setTextColor(Color.WHITE);
            txtMolMass.setTextColor(Color.WHITE);

            // Mass = Mol x MolMass

            if(getMolMass.equals("") && !getMass.equals("") && !getMol.equals("")){ //Moll Mass = Mass/Mol
                //Toast.makeText(getApplicationContext(), "Mol Mass empty", Toast.LENGTH_LONG).show();
                dblMass = Double.parseDouble(getMass);
                dblMol = Double.parseDouble(getMol);

                dblMolMass = dblMass/dblMol;
                String strMolMass = dblMolMass.toString();
                txtMolMass.setText(strMolMass);
                txtMolMass.setTextColor(Color.RED);
                txtFunctionBox.setText("Mass / mol = Molar mass");
                //Toast.makeText(getApplicationContext(), strMolMass , Toast.LENGTH_LONG).show();
            }
            else if(getMass.equals("") && !getMolMass.equals("") && !getMol.equals("")){  //Mass = Mol x MolMass
                //Toast.makeText(getApplicationContext(), "Mass empty - bad if you see", Toast.LENGTH_LONG).show();
                dblMolMass = Double.parseDouble(getMolMass);
                dblMol = Double.parseDouble(getMol);

                dblMass = dblMol * dblMolMass;
                String strMass = dblMass.toString();
                txtMass.setText(strMass);
                txtMass.setTextColor(Color.RED);
                txtFunctionBox.setText("Mass = mol x Molar mass");
            }
            else if(getMol.equals("") && !getMolMass.equals("") && !getMass.equals("")){  // Mol = Mass / MolMass
                //Toast.makeText(getApplicationContext(), "Mol empty - bad if you see", Toast.LENGTH_LONG).show();
                dblMass = Double.parseDouble(getMass);
                dblMolMass = Double.parseDouble(getMolMass);

                dblMol = dblMass/dblMolMass;
                String strMol = dblMol.toString();
                txtMol.setText(strMol);
                txtMol.setTextColor(Color.RED);
                txtFunctionBox.setText("mol = Mass / Molar mass");
            }
            else if(!getMolMass.equals("") && !getMass.equals("") && !getMol.equals("")){
                // all 3 have some value
                Toast.makeText(getApplicationContext(), "All three boxes contain values.  Please only give two values to compute.", Toast.LENGTH_LONG).show();
            }
            else if(getMolMass.equals("") && getMass.equals("") && getMol.equals("")){
                Toast.makeText(getApplicationContext(), "Please enter two values to compute.", Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(getApplicationContext(), "I'm impressed, you broke the code.", Toast.LENGTH_LONG).show();
            }

        }

        private Double dConvertyToMolarMAss(Double dblMass, Double dblMolarity) {
            return (dblMass / dblMolarity);
        }

        private Double dConvertToMolarity(Double dblMass, Double dblMolarMass) {
            return (dblMass / dblMolarMass);
        }

        private Double dConvertToMass(double dblMol, double dblMolMass) {
            return (dblMol * dblMolMass);
        }

    });
}
}
