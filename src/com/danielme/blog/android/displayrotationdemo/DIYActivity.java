/*
* Copyright (C) 2012 Daniel Medina <http://danielme.com>
*
* This file is part of "Android Display Rotation Demo".
*
* "Android Display Rotation Demo" is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, version 3.
*
* "Android Display Rotation Demo" is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License version 3
* along with this program. If not, see <http://www.gnu.org/licenses/gpl-3.0.html/>
*/
package com.danielme.blog.android.displayrotationdemo;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import android.app.ListActivity;
import android.content.res.Configuration;
   
public class DIYActivity extends ListActivity  
{
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      
        String[] array = new String[10];
        for (int i = 0; i < 10;i++)
        {
        	array[i] = System.currentTimeMillis() + "";
        }
   
        super.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, array));        
    }     

    //http://developer.android.com/guide/topics/resources/runtime-changes.html#HandlingTheChange
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
        }
    }
    
}