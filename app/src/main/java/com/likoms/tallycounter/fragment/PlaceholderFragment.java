package com.likoms.tallycounter.fragment;

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
        this.resetButton = (Button) rootView.findViewById(R.id.reset);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODo show dialog to user if he is sure
                counter.setText("0");
            }
        });
        return rootView;
    }


}