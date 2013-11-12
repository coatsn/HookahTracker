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

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {	
		//	entries[8] = getString(R.string.test);
		entries = getResources().getStringArray(R.array.entries);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(inflater.getContext(), android.R.layout.simple_list_item_1, entries);
		setListAdapter(adapter);



		return super.onCreateView(inflater, container, savedInstanceState);		
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);

		//        Toast.makeText(getActivity(), "selected item :" + entries[position],
		//                Toast.LENGTH_LONG).show();

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
		default: 
			Toast.makeText(getActivity(), "selected item :" + entries[position],
					Toast.LENGTH_LONG).show();
		}
	}



}
