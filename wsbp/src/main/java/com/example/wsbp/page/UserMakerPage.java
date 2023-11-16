package com.example.wsbp.page;

import com.example.wsbp.service.IUserService;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.wicketstuff.annotation.mount.MountPath;

@MountPath("UserMaker")
public class UserMakerPage extends WebPage {

    // IUserService を IoC/DI する
    @SpringBean
    private IUserService userService;

    public UserMakerPage() {

        var userNameModel = Model.of("");
        var userPassModel = Model.of("");

        var toHomeLink = new BookmarkablePageLink<>("toHome", HomePage.class);
        add(toHomeLink);

        //配置したFormコンポーネントを匿名クラス化して処理を上書きする
        var userInfoForm = new Form<>("userInfo") {
            @Override
            protected void onSubmit() {
                var userName = userNameModel.getObject();
                var userPass = userPassModel.getObject();
                var msg = "送信データ："
                        + userName
                        + ","
                        + userPass;
                System.out.println(msg);
                // IoC/DI した userService のメソッドを呼び出す
                userService.registerUser(userName, userPass);
                setResponsePage(new UserMakerCompPage(userNameModel));
            }
        };
        add(userInfoForm);

        var userNameField = new TextField<>("userName", userNameModel);
        userInfoForm.add(userNameField);

        var userPassField = new PasswordTextField("userPass", userPassModel);
        userInfoForm.add(userPassField);
    }

}