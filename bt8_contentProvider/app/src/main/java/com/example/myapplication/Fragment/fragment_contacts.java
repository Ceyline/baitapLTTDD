package com.example.myapplication.Fragment;

import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.myapplication.Adapter.lv_contacts_adapter;
import com.example.myapplication.Model.Contact;
import com.example.myapplication.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment_contacts#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_contacts extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ListView lv_contacts;
    private ArrayList<Contact> listContact = new ArrayList<>();
    private static final int REQUEST_CONTACTS_ASK_PERMISSION = 1001;

    public fragment_contacts() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment_contacts.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment_contacts newInstance(String param1, String param2) {
        fragment_contacts fragment = new fragment_contacts();
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
        View view = inflater.inflate(R.layout.fragment_contacts, container, false);
        Mapping(view);
        SettingAdapter(view);
        ShowContacts();
        return view;
    }

    private void ShowContacts() {
            Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
            Cursor cursor = getContext().getContentResolver().query(uri, null, null, null);
            listContact.clear();
            while (cursor.moveToNext()) {
                String colName = ContactsContract.Contacts.DISPLAY_NAME;
                String colPhone = ContactsContract.CommonDataKinds.Phone.NUMBER;

                int iName = cursor.getColumnIndex(colName);
                int iPhone = cursor.getColumnIndex(colPhone);

                String name = cursor.getString(iName);
                String phone = cursor.getString(iPhone);

                Contact contact = new Contact(name, R.drawable.cat2, phone);
                listContact.add(contact);
            }
            cursor.close();

    }

    private void SettingAdapter(View view) {
        lv_contacts_adapter listAdapter = new lv_contacts_adapter(getContext(), listContact);
        lv_contacts.setAdapter(listAdapter);
    }

    private void Mapping(View view) {
        lv_contacts = (ListView) view.findViewById(R.id.lv_contacts);
    }
}