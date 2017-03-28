package swe.sofolab.mytoolbarandsearchview;

import android.app.SearchManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mlistview();
        Toolbar toolbar=(Toolbar)findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.title);
        getSupportActionBar().setSubtitle(R.string.sub_title);
        getSupportActionBar().setIcon(R.drawable.ic_action_name);
        Intent searchIntent=getIntent();
        if(Intent.ACTION_SEARCH.equals(searchIntent.getAction())){
            String query=searchIntent.getStringExtra(SearchManager.QUERY);
            Toast.makeText(MainActivity.this,query,Toast.LENGTH_SHORT).show();

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);

        SearchView searchView=(SearchView)menu.findItem(R.id.menu_search).getActionView();
        SearchManager searchManager=(SearchManager)getSystemService(SEARCH_SERVICE);

        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));



        return super.onCreateOptionsMenu(menu);
    }

    @Override
        public boolean onOptionsItemSelected(MenuItem item) {

            switch (item.getItemId()){
                case R.id.menu1:
                    Toast.makeText(getApplicationContext(),"First position",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.menu2:
                    Toast.makeText(getApplicationContext(),"Second position",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.menu3:
                    Toast.makeText(getApplicationContext(),"Third position",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.menu4:
                    Toast.makeText(getApplicationContext(),"Fourth position",Toast.LENGTH_SHORT).show();
                    break;
            }

            return super.onOptionsItemSelected(item);
        }


    public void mlistview(){


        ListView lst=(ListView)findViewById(R.id.listView_main);
        ArrayAdapter adapter=new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.countries));
        lst.setAdapter(adapter);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){

                    Toast.makeText(getApplicationContext(),"Grear first position",Toast.LENGTH_SHORT).show();
                }

            }
        });




    }



}
