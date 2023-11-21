package com.example.wsbp.repository;

public interface IAuthUserRepository {

    /**
     * ユーザー名とパスワードをAuthUserテーブルに記録する
     *
     * @param userName ユーザー名
     * @param userPass パスワード
     * @return データベースの更新行数
     */
    public int insert(String userName, String userPass);

    /**
     * ユーザー名を使用してユーザー情報をAuthUserテーブルから削除する
     *
     * @param userName ユーザー名
     * @return データベースの更新行数
     */
    public int delete(String userName);

}