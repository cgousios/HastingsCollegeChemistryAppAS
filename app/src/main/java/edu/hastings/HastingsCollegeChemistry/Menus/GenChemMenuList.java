package edu.hastings.HastingsCollegeChemistry.Menus;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import edu.hastings.HastingsCollegeChemistry.GenChemFunctions.GasLaws.GasLawsMenuList;
import edu.hastings.HastingsCollegeChemistry.GenChemFunctions.*;

/**
 * Created by Christopher on 10/14/2014.
 */
public class GenChemMenuList extends ListActivity {
// Array of values for general chemistry functions
String[] astrGenChemFunctions = new String[]{"Mole Converter", "Density", "Dilution of Solution", "Molarity", "Ideal Gas", "pH Scale", "Gas Laws","Percent Yield", "Particles",
                                                "Acids", "Bases"};

@Override
protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);

    final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, astrGenChemFunctions);
    setListAdapter(adapter);
}

@Override
protected void onListItemClick(ListView listView, View view, int position, long id){
    Intent intent;
    if(position == 0){
        intent = new Intent(GenChemMenuList.this, Stoichiometry.class);
        GenChemMenuList.this.startActivity(intent);
    }
    else if (position == 1){
        intent = new Intent(GenChemMenuList.this, Density.class);
        GenChemMenuList.this.startActivity(intent);
    }
    else if (position == 2){
        intent = new Intent(GenChemMenuList.this, DilutionOfSolution.class);
        GenChemMenuList.this.startActivity(intent);
    }
    else if (position == 3){
        intent = new Intent(GenChemMenuList.this, Molarity.class);
        GenChemMenuList.this.startActivity(intent);
    }
    else if(position == 4){
        intent = new Intent(GenChemMenuList.this, Ideal_Gas.class);
        GenChemMenuList.this.startActivity(intent);
    }
    else if (position == 5){
        intent = new Intent(GenChemMenuList.this, pH_Scale.class);
        GenChemMenuList.this.startActivity(intent);
    }
    else if (position == 6){
        intent = new Intent(GenChemMenuList.this, GasLawsMenuList.class);
        GenChemMenuList.this.startActivity(intent);
    }
    else if (position == 7){
        intent = new Intent(GenChemMenuList.this, PercentYield.class);
        GenChemMenuList.this.startActivity(intent);
    }
    else if (position == 8){
        intent = new Intent(GenChemMenuList.this, Particles.class);
        GenChemMenuList.this.startActivity(intent);
    }
    else if (position == 9){
        intent = new Intent(GenChemMenuList.this, Acids.class);
        GenChemMenuList.this.startActivity(intent);
    }
    else if (position == 10){
        intent = new Intent(GenChemMenuList.this, Bases.class);
        GenChemMenuList.this.startActivity(intent);
    }
    else{
        Toast.makeText(getApplicationContext(), "Not a class yet", Toast.LENGTH_LONG).show();
    }
}
}
