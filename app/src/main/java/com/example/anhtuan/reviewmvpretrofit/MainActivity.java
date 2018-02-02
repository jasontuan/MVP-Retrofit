package com.example.anhtuan.reviewmvpretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.anhtuan.reviewmvpretrofit.adapter.RecyclerViewAdapter;
import com.example.anhtuan.reviewmvpretrofit.api.IUser;
import com.example.anhtuan.reviewmvpretrofit.presenter.PresenterBase;
import com.example.anhtuan.reviewmvpretrofit.view.ViewUsers;

import butterknife.BindView;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements ViewUsers {

    private PresenterBase presenterBase;
    private RecyclerViewAdapter recyclerViewAdapter;
    @BindView(R.id.rcv)
    RecyclerView rcvUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(IUser.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        presenterBase = new PresenterBase(this);

        recyclerViewAdapter = new RecyclerViewAdapter(this, presenterBase.getUsersList());
        rcvUsers.setLayoutManager(new LinearLayoutManager(this));
        rcvUsers.setAdapter(recyclerViewAdapter);
        IUser iUser = retrofit.create(IUser.class);
        presenterBase.getDataUsers(iUser);
    }

    @Override
    public void showSuccess() {
        recyclerViewAdapter.notifyDataSetChanged();
    }

    @Override
    public void showFail() {
        Toast.makeText(this, "Fail", Toast.LENGTH_SHORT).show();
    }
}
