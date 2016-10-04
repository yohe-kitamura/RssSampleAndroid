package jp.co.pockeps.rsssmaple.repository;

import retrofit2.Response;

public interface NetworkListener<T> {

    /**
     * 通信成功
     * @param response レスポンス
     */
    void OnSuccess(Response<T> response);

    /**
     * 通信失敗
     */
    void onFailure();
}
