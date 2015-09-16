package edu.hastings.HastingsCollegeChemistry.GenChemFunctions.GasLaws;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import edu.hastings.HastingsCollegeChemistry.GenChemFunctions.Ideal_Gas;

/**
 * Created by Christopher on 3/10/2015.
 */
public class GasLawsMenuList extends ListActivity {
// Array of values for the different gas law functions
String[] astrGasLaws = new String[]{"Boyle's Law","Charles' Law","Guy-Lussac's Law","Avogadro's Law","Combined Gas Law","Ideal Gas Law"};

@Override
protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);

    final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, astrGasLaws);
    setListAdapter(adapter);
}

@Override
protected void onListItemClick(ListView listView, View view, int position, long id){
    Intent intent;
    if(position == 0){
        intent = new Intent(GasLawsMenuList.this, Boyles_Law.class);
        GasLawsMenuList.this.startActivity(intent);
    }
    else if (position == 1){
        intent = new Intent(GasLawsMenuList.this, Charles_Law.class);
        GasLawsMenuList.this.startActivity(intent);
    }
    else if (position == 2){
        intent = new Intent(GasLawsMenuList.this, Guy_Lussacs_Law.class);
        GasLawsMenuList.this.startActivity(intent);
    }
    else if (position == 3){
        intent = new Intent(GasLawsMenuList.this, Avogadros_Law.class);
        GasLawsMenuList.this.startActivity(intent);
    }
    else if(position == 4) {
        intent = new Intent(GasLawsMenuList.this, Combined_Gas_Law.class);
        Toast.makeText(getApplicationContext(), "Intent " + intent, Toast.LENGTH_LONG).show();
        GasLawsMenuList.this.startActivity(intent);
    }
    else if(position == 5) {
        intent = new Intent(GasLawsMenuList.this, Ideal_Gas.class);
        GasLawsMenuList.this.startActivity(intent);
    }
    else{
        Toast.makeText(getApplicationContext(), "Not a gas law", Toast.LENGTH_LONG).show();
    }
}
}

