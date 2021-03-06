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
import android.app.ListActivity;
   

public class DefaultRetainDataActivity extends ListActivity  
{

    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] array = null;
        Object restore = getLastNonConfigurationInstance();
        
        if (restore != null)
        {
        	array = (String[]) restore;
        }
        else
        {
        	array = new String[10];
        	for (int i = 0; i < 10;i++)
        	{
        		array[i] = System.currentTimeMillis() + "";
        	}
        }
        super.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, array));        
    }   
  

    @Override
    public Object onRetainNonConfigurationInstance()
    {
    	String[] array = new String[getListAdapter().getCount()];
    	for (int i=0;i < getListAdapter().getCount();i++)
    	{
    		array[i] = (String) getListAdapter().getItem(i);
    	}
    	return array;
    }    
  
}
