package drupal.article;

import drupal.entity.Article;
import drupal.requests.CreatedResponse;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public interface ArticleService {

  List<Article> getArticles();
  CreatedResponse SaveArticle(Article article);

  Article getArticle();

  boolean deleteArticle(long id);

  boolean updateArticle(long id, Article updatArticle);




}
