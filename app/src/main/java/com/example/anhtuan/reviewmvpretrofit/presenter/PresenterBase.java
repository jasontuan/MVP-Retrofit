package com.example.anhtuan.reviewmvpretrofit.presenter;

import android.util.Log;

import com.example.anhtuan.reviewmvpretrofit.api.IUser;
import com.example.anhtuan.reviewmvpretrofit.model.Users;
import com.example.anhtuan.reviewmvpretrofit.presenter.PresenterUsers;
import com.example.anhtuan.reviewmvpretrofit.view.ViewUsers;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ANH TUAN on 2/1/2018.
 */

public class PresenterBase implements PresenterUsers {

    private ViewUsers viewUsers;
    private List<Users> usersList;

    public PresenterBase(ViewUsers viewUsers) {
        this.viewUsers = viewUsers;
        usersList = new ArrayList<>();
    }

    public List<Users> getUsersList() {
        return usersList;
    }

    @Override
    public void getDataUsers(IUser iUser) {
        Call<List<Users>> call = iUser.getAllUsers();
        call.enqueue(new Callback<List<Users>>() {
            @Override
            public void onResponse(Call<List<Users>> call, Response<List<Users>> response) {
                usersList.addAll(response.body());
                viewUsers.showSuccess();
            }

            @Override
            public void onFailure(Call<List<Users>> call, Throwable t) {
                Log.d("TAG", t.getMessage());
                viewUsers.showFail();
            }
        });
    }

}
