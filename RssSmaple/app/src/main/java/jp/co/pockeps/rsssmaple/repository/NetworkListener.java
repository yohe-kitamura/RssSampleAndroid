package jp.co.pockeps.rsssmaple.repository;

public interface NetworkListener<T> {

    /**
     * 通信成功
     *
     * @param response レスポンス
     */
    void onSuccess(T response);

    /**
     * 通信失敗
     */
    void onFailure();
}
