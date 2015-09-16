package edu.hastings.HastingsCollegeChemistry.Menus;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import edu.hastings.HastingsCollegeChemistry.BioChemFunctions.HendersonHasselbalch;

/**
 * Created by Christopher on 10/26/2014.
 */
public class BioChemMenuList extends ListActivity {

// Array of values for bio chemistry functions
String[] astrBioChemFunctions = new String[]{"Henderson Hasselbalch"};

@Override
protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);

    final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, astrBioChemFunctions);
    setListAdapter(adapter);
}

@Override
protected void onListItemClick(ListView listView, View view, int position, long id){
    Intent intent;
    if(position == 0){
        intent = new Intent(BioChemMenuList.this, HendersonHasselbalch.class);
        BioChemMenuList.this.startActivity(intent);
    }
    else if (position == 1){
//        intent = new Intent(GenChemMenuList.this, Density.class);
//        GenChemMenuList.this.startActivity(intent);
    }
    else if (position == 2){
        //intent = new Intent(GenChemMenuList.this, Converter.class);
        //GenChemMenuList.this.startActivity(intent);
    }
    else{
        Toast.makeText(getApplicationContext(), "Not a class yet", Toast.LENGTH_LONG).show();
    }
}
}
