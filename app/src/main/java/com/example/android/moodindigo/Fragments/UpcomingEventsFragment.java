package com.example.android.moodindigo.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.moodindigo.DownloadImage;
import com.example.android.moodindigo.EventsAdapter;
import com.example.android.moodindigo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by owais on 05/07/17.
 */

public class UpcomingEventsFragment extends Fragment {

    CircleImageView profimage;
    RecyclerView events;
    EventsAdapter eventsAdapter;
    public UpcomingEventsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        container.removeAllViews();
//        return inflater.inflate(R.layout.fragment_upcoming_events, container, false);
//    }
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    //container.removeAllViews();

    // Inflate the layout for this fragment
    View rootView = inflater.inflate(R.layout.fragment_upcoming_events, container, false);
    profimage=(CircleImageView) rootView.findViewById(R.id.imageView);
    Bundle bundle=getArguments();
    String name = bundle.get("name").toString();
    String imageUrl = bundle.get("imageUrl").toString();
    String mi_number=bundle.get("mi number").toString();

    new DownloadImage(profimage,getContext()).execute(imageUrl);
    TextView profname=(TextView) rootView.findViewById(R.id.name);
    profname.setText(name);

    TextView mi_no=(TextView) rootView.findViewById(R.id.mi_number);
    mi_no.setText(mi_number);

    eventsAdapter=new EventsAdapter();
    events=(RecyclerView) rootView.findViewById(R.id.events);
    events.setAdapter(eventsAdapter);
    events.setLayoutManager(new LinearLayoutManager(getContext()));
    return rootView;

}

}
