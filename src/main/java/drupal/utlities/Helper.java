package drupal.utlities;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.Random;

@ApplicationScoped
public class Helper {

    public int getRandomNumber(int min , int max)
    {
        return (int) ((Math.random() * (max - min)) + min);
    }

}
