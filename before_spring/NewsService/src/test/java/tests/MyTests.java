package tests;

import lt.vtvpmc.BaseNewsServiceTest;
import lt.vtvpmc.NewsService;
import lt.vtvpmc.NewsServiceImpl;
import myClasses.SafeNewsService;

public class MyTests extends BaseNewsServiceTest {
    @Override
    protected NewsService getNewsService() {
        return new SafeNewsService(new NewsServiceImpl());
    }
}
