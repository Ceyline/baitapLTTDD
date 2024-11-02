package com.example.myapplication.Fragment;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.CallLog;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.myapplication.Adapter.lv_callLog_adapter;
import com.example.myapplication.Model.Call;
import com.example.myapplication.Model.Message;
import com.example.myapplication.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment_call_log#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_call_log extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ListView lv_call_log;
    private ArrayList<Call> listCall = new ArrayList<>();

    public fragment_call_log() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment_call_log.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment_call_log newInstance(String param1, String param2) {
        fragment_call_log fragment = new fragment_call_log();
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
        View view = inflater.inflate(R.layout.fragment_call_log, container, false);
        Mapping(view);
        SettingAdapter(view);
        ShowCallLogs();
        return view;
    }

    private void ShowCallLogs() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy HH:mm");
        Uri uri = CallLog.Calls.CONTENT_URI;
        Cursor cursor = getContext().getContentResolver().query(uri, null, null, null);
        listCall.clear();
        while (cursor.moveToNext()) {
            int iPhone = cursor.getColumnIndex(CallLog.Calls.NUMBER);
            int iTime = cursor.getColumnIndex(CallLog.Calls.DATE);
            int iDuration = cursor.getColumnIndex(CallLog.Calls.DURATION);

            String phone = cursor.getString(iPhone);

            String time = cursor.getString(iTime);

            int durationInSeconds = cursor.getInt(iDuration);
            int minutes = durationInSeconds / 60;
            int seconds = durationInSeconds % 60;
            String duration = minutes + " ph " + seconds + " s";

            Call call = new Call(phone, dateFormat.format(Long.parseLong(time)), duration);
            listCall.add(call);
        }
    }


    private void SettingAdapter(View view) {
        lv_callLog_adapter listAdapter = new lv_callLog_adapter(getContext(), listCall);
        lv_call_log.setAdapter(listAdapter);
    }

    private void Mapping(View view) {
        lv_call_log = (ListView) view.findViewById(R.id.lv_call_log);
    }
}