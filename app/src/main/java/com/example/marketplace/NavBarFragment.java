package com.example.marketplace;


import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


public class NavBarFragment extends Fragment {

    ImageButton btnProfile;
    ImageButton btnChat;
    EditText txtSearch;
    ImageButton btnSearch;
    Button btnFeed;

    private static final String TAG = "NAVBAR";

    public NavBarFragment() {
        //Required empty public constructor
    }

    public interface NavBarFragmentListener {

        public void openProfile();

        public void openChats();

        public void search(String keyword);

        public void openFeed();
        // add methods that we would need the activity to implement
    }

    NavBarFragmentListener NBFL;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        NBFL = (NavBarFragmentListener) context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_nav_bar, container, false);

        btnProfile = view.findViewById(R.id.btnProfile);
        btnChat = view.findViewById(R.id.btnChat);
        txtSearch = view.findViewById(R.id.txtSearch);
        btnSearch = view.findViewById(R.id.btnSort);
        btnFeed = view.findViewById(R.id.btnFeed);

        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NBFL.openProfile();
            }
        });

        btnChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NBFL.openChats();
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String keyword = txtSearch.getText().toString();
                Log.w(TAG, "The keyword is " + keyword);
                NBFL.search(keyword);
            }
        });

        btnFeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NBFL.openFeed();
            }
        });

        return view;
    }
}
