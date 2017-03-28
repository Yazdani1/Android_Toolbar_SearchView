package swe.sofolab.mytoolbarandsearchview;

import android.app.SearchManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondsearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondsearch);
        Toolbar toolbar=(Toolbar)findViewById(R.id.search_resulttoolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent searchIntent=getIntent();
        String query=new String();
        if (Intent.ACTION_SEARCH.equals(searchIntent.getAction())) {
            query=searchIntent.getStringExtra(SearchManager.QUERY);
            getSupportActionBar().setTitle(query);
            Toast.makeText(SecondsearchActivity.this,query,Toast.LENGTH_SHORT).show();
        }

        String[] mcountries=getResources().getStringArray(R.array.countries);
        ArrayList<String> mylist=new ArrayList<String>();
        for (int i=0;i<mcountries.length;i++)
            if(mcountries[i].toLowerCase().contains(query.toLowerCase()))
                mylist.add(mcountries[i]);
        ListView lst=(ListView)findViewById(R.id.listView_result);
        ArrayAdapter adapter=new ArrayAdapter(SecondsearchActivity.this,android.R.layout.simple_list_item_1,mylist);
        lst.setAdapter(adapter);





    }
}
