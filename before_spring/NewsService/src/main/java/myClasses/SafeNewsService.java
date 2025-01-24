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
    private final List<String> forbiddenWords = List.of("rupūs miltai",
            "velniai rautų",
            "velnias",
            "velniais");

    public SafeNewsService(NewsServiceImpl newsService) {
        this.newsService = newsService;
    }

    @Override
    public List<Article> getArticles() {
        return newsService.getArticles().stream().filter(article-> {
                    for (String word : forbiddenWords) {
                        if (article.getHeading().toLowerCase().contains(word)) {
                            return false;
                        }
                    }
                    return true;
                }).map(article ->
                        {
                            for (String word : forbiddenWords) {
                                String lowerCaseBrief = article.getBrief();
                                String lowerCasedWord = word.toLowerCase();

                                if (lowerCaseBrief.contains(lowerCasedWord)) {
                                    String formattedBrief = lowerCaseBrief.replaceAll(lowerCasedWord, "***");
                                    return new ArticleImpl(article.getHeading(), formattedBrief);
                                }
                            }
                            return article;
                        })
                .collect(Collectors.toList());
    }
}
