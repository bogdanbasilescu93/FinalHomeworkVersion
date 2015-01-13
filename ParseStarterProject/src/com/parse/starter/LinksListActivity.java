package com.parse.starter;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class LinksListActivity extends ListActivity{


        String links[] = { "facebook", "youtube" , "yahoo" , "developer.android",
                "google" , "stackoverflow" , "java" } ;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            // TODO Auto-generated method stub
            super.onCreate(savedInstanceState);

            setListAdapter(new ArrayAdapter<String>(LinksListActivity.this, android.R.layout.simple_list_item_1, links){

            });
        }

        @Override
        protected void onListItemClick(ListView l, View v, int position, long id) {
            // TODO Auto-generated method stub

            super.onListItemClick(l, v, position, id);


            String ourLink = links[position];
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + ourLink + ".com"));
            startActivity(browserIntent);



        }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(
                LinksListActivity.this,
                Welcome.class);
        startActivity(intent);
        finish();

    }
    }