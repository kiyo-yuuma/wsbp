package com.example.wsbp.page;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

public class UserDeleteCompPage extends WebPage {

    public UserDeleteCompPage() {
        var toHomeLink = new BookmarkablePageLink<>("toHome", HomePage.class);
        add(toHomeLink);
    }
}
