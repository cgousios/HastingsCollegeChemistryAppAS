package edu.hastings.HastingsCollegeChemistry.Menus;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Christopher on 10/14/2014.
 */
public class MainMenuList extends ListActivity{
// Array of strings to show in ListView
String[] astrMainMenu = new String[]{"Converter", "General Chemistry", "Analytical Chemistry", "Physical Chemistry", "Biochemistry", "Organic Chemistry"};


@Override
protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);

    final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, astrMainMenu);
    setListAdapter(adapter);
}

@Override
protected void onListItemClick(ListView listView, View view, int position, long id){
    String itemValue = (String) listView.getItemAtPosition(position);
    Intent intent;

    if(position == 0){
        intent = new Intent(this, ConverterMenuList.class);
        MainMenuList.this.startActivity(intent);
    }
    else if(position == 1){
        intent = new Intent(this, GenChemMenuList.class);
        MainMenuList.this.startActivity(intent);
        //Toast.makeText(getApplicationContext(), itemValue,Toast.LENGTH_LONG).show();
    }
    else if(position == 2){
        // Intent intent = new Intent(this, analytical class);
        // MainMenuList.this.startActivity(intent)
        Toast.makeText(getApplicationContext(), itemValue,Toast.LENGTH_LONG).show();
    }
    else if(position == 3){
        // intent = new Intent(this, physical class)
        // MainMenuList.this.startActivity(intent);
        Toast.makeText(getApplicationContext(), itemValue,Toast.LENGTH_LONG).show();
    }
    else if(position == 4){
        intent = new Intent(this, BioChemMenuList.class);
        MainMenuList.this.startActivity(intent);
    }
    else if(position == 5){
        intent = new Intent(this, OrganicChemMenuList.class);
        MainMenuList.this.startActivity(intent);
    }
    else{
        Toast.makeText(getApplicationContext(), "How did you manage to get this message.", Toast.LENGTH_LONG).show();
    }
}

}
