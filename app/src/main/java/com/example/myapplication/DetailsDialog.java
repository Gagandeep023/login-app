package com.example.myapplication;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DetailsDialog extends DialogFragment {

    private static final String ARG_DETAILS = "details";

    public static DetailsDialog newInstance(String details) {
        DetailsDialog detailsDialog = new DetailsDialog();
        Bundle args = new Bundle();
        args.putString(ARG_DETAILS, details);
        detailsDialog.setArguments(args);
        return detailsDialog;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_details, container, false);

        String details = getArguments().getString(ARG_DETAILS);
        TextView textView = (TextView) view.findViewById(R.id.textViewDetails);
        textView.setText(details);

        return view;
    }
}