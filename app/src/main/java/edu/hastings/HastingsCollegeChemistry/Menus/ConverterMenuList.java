package edu.hastings.HastingsCollegeChemistry.Menus;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import edu.hastings.HastingsCollegeChemistry.Converters.Converter_Pressure;
import edu.hastings.HastingsCollegeChemistry.Converters.Converter_Temperature;
import edu.hastings.HastingsCollegeChemistry.Converters.Converter_Volume;

/**
 * Created by Christopher on 2/8/2015.
 */
public class ConverterMenuList extends ListActivity {
String[] astrConverterFunctions = new String[]{"Volume","Temperature", "Pressure"};

@Override
protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);

    final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, astrConverterFunctions);
    setListAdapter(adapter);
}

@Override
protected void onListItemClick(ListView listView, View view, int position, long id){
    Intent intent;
    if(position == 0){
        intent = new Intent(ConverterMenuList.this, Converter_Volume.class);
        ConverterMenuList.this.startActivity(intent);
    }
    else if (position == 1){
        intent = new Intent(ConverterMenuList.this, Converter_Temperature.class);
        ConverterMenuList.this.startActivity(intent);
    }
    else if (position == 2){
        intent = new Intent(ConverterMenuList.this, Converter_Pressure.class);
        ConverterMenuList.this.startActivity(intent);
    }
    else{
        Toast.makeText(getApplicationContext(), "Not a class yet", Toast.LENGTH_LONG).show();
    }
}
}
