package edu.mines.ncoats.hookahtracker;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

public class AboutDialog extends DialogFragment{

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        alertDialogBuilder.setTitle(getString(R.string.about_title));
        alertDialogBuilder.setMessage(R.string.about_message);

        alertDialogBuilder.setPositiveButton("OK", null);



        return alertDialogBuilder.create();
    }
}