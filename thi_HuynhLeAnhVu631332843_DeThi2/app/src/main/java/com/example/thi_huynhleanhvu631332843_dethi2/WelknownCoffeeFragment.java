package com.example.thi_huynhleanhvu631332843_dethi2;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class WelknownCoffeeFragment extends Fragment {

    private RecyclerView recyclerView;
    private CoffeeAdapter coffeeAdapter;
    private List<Coffee> coffeeList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_welknown_coffee, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        coffeeList = new ArrayList<>();
        coffeeList.add(new Coffee("Quán Cà Phê Mr P", "Địa chỉ: 177-TT6, Trần Nhật Duật", R.drawable.mrp));
        coffeeList.add(new Coffee("Quán Cà Phê Hoàng Tuấn", "Địa chỉ: 1-3 Nguyễn Trãi", R.drawable.cf1));
        coffeeAdapter = new CoffeeAdapter(coffeeList);
        recyclerView.setAdapter(coffeeAdapter);

        return view;
    }
}
