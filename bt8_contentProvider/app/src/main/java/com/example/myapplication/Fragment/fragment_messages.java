package com.example.myapplication.Fragment;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.myapplication.Adapter.lv_messages_adapter;
import com.example.myapplication.Model.Message;
import com.example.myapplication.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment_messages#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_messages extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ListView lv_messages;
    private ArrayList<Message> listMessages = new ArrayList<>();

    public fragment_messages() {
        // Required empty public constructor
    }

    public static fragment_messages newInstance(String param1, String param2) {
        fragment_messages fragment = new fragment_messages();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_messages, container, false);
        Mapping(view);
        SettingAdapter(view);
        ShowMessages();
        return view;
    }

    private void ShowMessages() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy HH:mm");
        Uri uri = Uri.parse("content://sms/inbox");
        Cursor cursor = getContext().getContentResolver().query(uri, null, null, null);
        listMessages.clear();
        while (cursor.moveToNext()){
            int iPhone = cursor.getColumnIndex("address");
            int iTime = cursor.getColumnIndex("date");
            int iContent = cursor.getColumnIndex("body");

            String phone = cursor.getString(iPhone);
            String time = cursor.getString(iTime);
            String content = cursor.getString(iContent);

            Message message = new Message(phone, content, R.drawable.baseline_account_circle_24, dateFormat.format(Long.parseLong(time)));
            listMessages.add(message);
        }
    }

    private void SettingAdapter(View view) {
        lv_messages_adapter listAdapter = new lv_messages_adapter(getContext(), listMessages);
        lv_messages.setAdapter(listAdapter);

    }

    private void Mapping(View view) {
        lv_messages = (ListView) view.findViewById(R.id.lv_messages);
    }
}