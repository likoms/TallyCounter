package com.likoms.tallycounter.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.likoms.tallycounter.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {

    private TextView counter;
    private Button nextButton;
    private Button resetButton;
    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

    public PlaceholderFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_tally_main, container, false);
        this.counter = (TextView) rootView.findViewById(R.id.counter);
        this.nextButton = (Button) rootView.findViewById(R.id.next);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int index = Integer.parseInt(counter.getText().toString());
                counter.setText((index+1)+"");
            }
        });
        //Dialog
        this.builder.setMessage(R.string.confirm_dialog)
                .setPositiveButton(R.string.yes_option_dialog, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        counter.setText("0");
                        dialog.cancel();
                    }
                })
                .setNegativeButton(R.string.cancel_option_dialog, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        //End of dialog
        this.resetButton = (Button) rootView.findViewById(R.id.reset);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODo show dialog to user if he is sure
                // Create the AlertDialog object and return it
                AlertDialog alert = builder.create();
                alert.show();
                //counter.setText("0");
            }
        });



        return rootView;
    }
  /* public void showMsgDialog() {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.confirm_dialog)
                .setPositiveButton(R.string.yes_option_dialog, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        counter.setText("0");
                    }
                })
                .setNegativeButton(R.string.cancel_option_dialog, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });
        // Create the AlertDialog object and return it
       AlertDialog alert = builder.create();
       alert.show();
    }*/


}