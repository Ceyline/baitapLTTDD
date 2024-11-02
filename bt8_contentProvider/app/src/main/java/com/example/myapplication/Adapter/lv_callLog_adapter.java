package com.example.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.Model.Call;
import com.example.myapplication.Model.Contact;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class lv_callLog_adapter extends ArrayAdapter<Call> {


    public lv_callLog_adapter(@NonNull Context context, @NonNull List<Call> listCall) {
        super(context, R.layout.item_call_log, listCall);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        Call call = getItem(position);
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.item_call_log, parent, false);
        }
        TextView tv_time = view.findViewById(R.id.tv_time);
        TextView tv_phone = view.findViewById(R.id.tv_phone);
        TextView tv_duration = view.findViewById(R.id.tv_duration);
        if (call != null) {
            tv_time.setText(call.getTime());
            tv_phone.setText(call.getPhone());
            tv_duration.setText(call.getDuration());
        }
        return view;
    }


    }
