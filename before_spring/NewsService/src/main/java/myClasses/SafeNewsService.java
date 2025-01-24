package myClasses;

import lt.vtvpmc.Article;
import lt.vtvpmc.NewsService;
import lt.vtvpmc.NewsServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SafeNewsService implements NewsService {

    NewsService newsService;
    private List<String> forbiddenWords = List.of("rupūs miltai",
            "velniai rautų",
            "velnias",
            "velniais");

    public SafeNewsService(NewsServiceImpl newsService) {
        this.newsService = newsService;
    }

    @Override
    public List<Article> getArticles() {
        List<Article> baseList = newsService.getArticles();

        List<Article> res = newsService.getArticles().stream().filter(article-> {
                    for (String word : forbiddenWords) {
                        if (article.getHeading().toLowerCase().contains(word)) {
                            return true;
                        }
                    }
                    return false;
                }).collect(Collectors.toList());


        return res;

    }
}
