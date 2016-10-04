package jp.co.pockeps.rsssmaple.repository;

import retrofit2.Response;

public interface NetworkListener<T> {

    void OnSuccess(Response<T> response);

    void onFailure();
}
