package myClasses;

import lt.vtvpmc.Article;

public class ArticleImpl implements Article {
    private String heading;
    private String briefing;

    public ArticleImpl(String heading, String briefing) {
        this.heading = heading;
        this.briefing = briefing;
    }

    @Override
    public String getHeading() {
        return heading;
    }

    @Override
    public String getBrief() {
        return briefing;
    }
}
