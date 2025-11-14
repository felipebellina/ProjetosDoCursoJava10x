package br.com.movieflix.movieflix.exeption;

public class UsernameOrPasswordInvalidException extends RuntimeException{

    public UsernameOrPasswordInvalidException(String massage) {
        super(massage);
    }
}
