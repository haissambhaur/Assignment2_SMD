package com.example.assignment_1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class screen5HomeFragment extends Fragment {
    BottomNavigationView bottomNavigationView;
    screen5 screen5HomeFragment = new screen5();    //homeFragment
    screen6 screen6Fragment = new screen6(); //searchFragment
    screen8 screen8Fragment = new screen8();    //chatFragment
    screen10 screen10Fragment = new screen10();  //profileFragment
    screen12 screen12Fragment = new screen12();     //addFragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_screen5_home, container, false);
    }
}