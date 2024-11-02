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

import com.example.myapplication.Model.Message;
import com.example.myapplication.R;

import java.util.ArrayList;

public class lv_messages_adapter extends ArrayAdapter<Message> {
    public lv_messages_adapter(@NonNull Context context, ArrayList<Message> listMessages) {
        super(context, R.layout.item_messages, listMessages);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        Message message = getItem(position);
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.item_messages, parent, false);
        }
        ImageView iv_avatar = view.findViewById(R.id.iv_avatar);
        TextView tv_time = view.findViewById(R.id.tv_time);
        TextView tv_phone = view.findViewById(R.id.tv_phone);
        TextView tv_content = view.findViewById(R.id.tv_content);
        if (message != null) {
            iv_avatar.setImageResource(message.getAvatar());
            tv_time.setText(message.getTime());
            tv_phone.setText(message.getPhone());
            tv_content.setText(message.getContent());
        }
        return view;
    }
}
