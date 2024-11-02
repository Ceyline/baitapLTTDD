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

import com.example.myapplication.Model.Contact;
import com.example.myapplication.R;

import java.util.ArrayList;

public class lv_contacts_adapter extends ArrayAdapter<Contact> {

    public lv_contacts_adapter(@NonNull Context context, ArrayList<Contact> listContacts) {
        super(context, R.layout.item_contacts, listContacts);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        Contact contact = getItem(position);
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.item_contacts, parent, false);
        }
        ImageView iv_avatar = view.findViewById(R.id.iv_avatar);
        TextView tv_name = view.findViewById(R.id.tv_name);
        TextView tv_phone = view.findViewById(R.id.tv_phone);
        if (contact != null) {
            iv_avatar.setImageResource(contact.getAvatar());
            tv_name.setText(contact.getName());
            tv_phone.setText(contact.getPhone());
        }
        return view;
    }
}
