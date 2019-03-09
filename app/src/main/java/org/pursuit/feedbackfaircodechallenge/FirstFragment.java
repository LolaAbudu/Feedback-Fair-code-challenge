package org.pursuit.feedbackfaircodechallenge;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.pursuit.feedbackfaircodechallenge.model.Users;
import org.pursuit.feedbackfaircodechallenge.network.RetrofitSingleton;
import org.pursuit.feedbackfaircodechallenge.network.UserService;
import org.pursuit.feedbackfaircodechallenge.recyclerview.UserAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class FirstFragment extends Fragment {

    private static final String FIRST_LAST_NAME = "name";

    private String name;

    public FirstFragment() {
        // Required empty public constructor
    }

    public static FirstFragment newInstance() {
        return new FirstFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            name = getArguments().getString(FIRST_LAST_NAME);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final RecyclerView recyclerView = view.findViewById(R.id.recycler_view);

        Retrofit retrofit = RetrofitSingleton.getOneInstance();
        UserService userService = retrofit.create(UserService.class);
        Call<List<Users>> usersCall = userService.getAllUsers();
        usersCall.enqueue(new Callback<List<Users>>() {
            @Override
            public void onResponse(Call<List<Users>> call, Response<List<Users>> response) {
                List<Users> usersList = new ArrayList<>();
                usersList.addAll(response.body());
                Log.d("TAG", "onResponse: " + response.body().get(0).getName());

                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                UserAdapter userAdapter = new UserAdapter(usersList);
                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.setAdapter(userAdapter);
            }

            @Override
            public void onFailure(Call<List<Users>> call, Throwable t) {
                Log.d("TAG", "onFailure " + t.toString());
            }
        });
    }
}
