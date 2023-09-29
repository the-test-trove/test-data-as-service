package drupal.article;


import drupal.entity.Article;
import drupal.requests.CreatedResponse;
import drupal.utlities.Helper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@ApplicationScoped
public class ArticleServiceImpl implements ArticleService {


    @Inject
    Helper helper;

    @Override
    public List<Article> getArticles() {
        return Article.findAll().list();
    }

    @Override
    public CreatedResponse SaveArticle(Article article) {
        CreatedResponse response = new CreatedResponse();
        if (!(article == null)) {
            Article.persist(article);
        }
        if (article.isPersistent()) {
            response.setId(article.id);
            response.setMessage("Article is created successfully");
        }
        return response;
    }

    @Override
    public Article getArticle() {
        List<Article> articleList = Article.findAll().list();
        int record = helper.getRandomNumber(1, articleList.size());
        return articleList.get(record);
    }

    @Override
    @Transactional
    public boolean deleteArticle(long id) {
        return Article.deleteById(id);
    }

    @Override
    public boolean updateArticle(long id, Article updatArticle) {
        Optional<Article> optionalArticle = Article.findByIdOptional(id);
        if (optionalArticle.isPresent()) {
            Article dbArticle = optionalArticle.get();
            if (Objects.nonNull(updatArticle.getTitle())) {
                dbArticle.setTitle(updatArticle.getTitle());
            }
            if(Objects.nonNull(updatArticle.getArticleType()))
            {
                dbArticle.setArticleType(updatArticle.getArticleType());
            }
            if(Objects.nonNull(updatArticle.getCategory()))
            {
                dbArticle.setCategory(updatArticle.getCategory());
            }
            if(Objects.nonNull(updatArticle.getDescription()))
            {
                dbArticle.setDescription(updatArticle.getDescription());
            }
            if(Objects.nonNull(updatArticle.getPrivateNotes()))
            {
                dbArticle.setPrivateNotes(updatArticle.getPrivateNotes());
            }
            if(Objects.nonNull(updatArticle.getDetails()))
            {
                dbArticle.setDetails(updatArticle.getDetails());
            }
            dbArticle.persist();
            if (dbArticle.isPersistent()) {
                return true;
            }
            else
            {
                return false;
            }
        }
        else {
                return false;
        }
    }
}
