package com.example.wsbp.page;

import com.example.wsbp.service.ISampleService;
import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.wicketstuff.annotation.mount.MountPath;

@WicketHomePage
@MountPath("Home")
public class HomePage extends WebPage {

    @SpringBean
    private ISampleService service;

    public HomePage() {
        addLabel("you", "Wicket-Spring-Boot");
        addLabel("gakuseki", "B2210840");
        addLabel("name", "清川佑真");
        addLabel("time", service.makeCurrentHMS());
        addLabel("rand", intToString(service.makeRandInt()));

        var toUserMakerLink = new BookmarkablePageLink<>("toUserMaker", UserMakerPage.class);
        add(toUserMakerLink);
        var toUserDeleteLink = new BookmarkablePageLink<>("toUserDelete", UserDeletePage.class);
        add(toUserDeleteLink);
    }

    private void addLabel(String id, String object) {
        var model = Model.of(object);
        var label = new Label(id, model);
        add(label);
    }

    private String intToString(int x) {
        return Integer.valueOf(x).toString();
    }
}