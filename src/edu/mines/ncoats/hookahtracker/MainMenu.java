package edu.mines.ncoats.hookahtracker;


import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class MainMenu extends ListFragment {

	String[] entries;

	/**
	* Calls the xml file for creation
	* 
	* @param savedInstanceState, Retrieves app data
	*        container, tells the app where to inflate the layout
	*        inflater, allows the app to inflate the fragment
	*/
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {	
		entries = getResources().getStringArray(R.array.entries);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(inflater.getContext(), android.R.layout.simple_list_item_1, entries);
		setListAdapter(adapter);



		return super.onCreateView(inflater, container, savedInstanceState);		
	}

	/**
	* Overrides the onListItemClick function of a ListFragment
	* 
	* @param l, the LsistView that is being clicked
	*        v, the view that the ListView is in
	*        position, which item in the list is being clicked
	*        id, the id of the item that is being clicked
	*/
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);

		switch(position) {
		case 0:
			Intent intent = new Intent(getActivity().getApplicationContext(), HookahActivity.class);
			startActivity(intent);
			break;
		case 1:
			intent = new Intent(getActivity().getApplicationContext(), ShishaActivity.class);
			startActivity(intent);
			break;
		case 2:
			intent = new Intent(getActivity().getApplicationContext(), BowlActivity.class);
			startActivity(intent);
			break;
		case 3:
			intent = new Intent(getActivity().getApplicationContext(), CoalsActivity.class);
			startActivity(intent);
			break;
		case 5:
			intent = new Intent(getActivity().getApplicationContext(), SessionActivity.class);
			startActivity(intent);
			break;
		default: 
			Toast.makeText(getActivity(), "selected item :" + entries[position],
					Toast.LENGTH_LONG).show();
		}
	}



}
