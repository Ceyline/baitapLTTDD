package com.example.myapplication;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication.Fragment.fragment_account;
import com.example.myapplication.Fragment.fragment_call_log;
import com.example.myapplication.Fragment.fragment_contacts;
import com.example.myapplication.Fragment.fragment_messages;
import com.example.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    private static final int REQUEST_CONTACTS_ASK_PERMISSION = 1001;
    private static final int REQUEST_SMS_ASK_PERMISSION = 1002;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        ReplaceFragment(new fragment_contacts());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.contact) {
                if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_CONTACTS)
                        != PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(new String[]{android.Manifest.permission.READ_CONTACTS}, REQUEST_CONTACTS_ASK_PERMISSION);
                } else
                    ReplaceFragment(new fragment_contacts());
            } else if (item.getItemId() == R.id.message) {
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_SMS)
                        != PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(new String[]{android.Manifest.permission.READ_SMS}, REQUEST_SMS_ASK_PERMISSION);
                } else
                    ReplaceFragment(new fragment_messages());
            } else if (item.getItemId() == R.id.call_log) {
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CALL_LOG)
                        != PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(new String[]{Manifest.permission.READ_CALL_LOG}, REQUEST_SMS_ASK_PERMISSION);
                }
                else
                    ReplaceFragment(new fragment_call_log());
            } else if (item.getItemId() == R.id.account) {
                ReplaceFragment(new fragment_account());
            }
            return true;
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void ReplaceFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame_main, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }
}