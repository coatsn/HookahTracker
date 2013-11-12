package edu.mines.ncoats.hookahtracker;

import android.app.ListFragment;
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

public class HookahList extends ListFragment {
//	String[] hookahEntries = new String[] {
//			"",
//	};
	String[] hookahEntries;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {	
		//	entries[8] = getString(R.string.test);
		hookahEntries = getResources().getStringArray(R.array.entries);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(inflater.getContext(), android.R.layout.simple_list_item_1, hookahEntries);
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
		case 1:

			break;
		case 2:

			break;
		default: 
			Toast.makeText(getActivity(), "selected item :" + hookahEntries[position],
					Toast.LENGTH_LONG).show();
		}
	}



}
