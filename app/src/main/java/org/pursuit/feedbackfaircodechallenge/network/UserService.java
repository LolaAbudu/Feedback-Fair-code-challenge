package org.pursuit.feedbackfaircodechallenge.network;

import org.pursuit.feedbackfaircodechallenge.model.Users;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UserService {
    String END_POINT = "users";

    @GET(END_POINT)
    Call<List<Users>> getAllUsers();
}
