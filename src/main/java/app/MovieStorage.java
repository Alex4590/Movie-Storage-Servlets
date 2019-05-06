package app;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.lang.String;

public class MovieStorage {

    private static Data data;
    private static String error;
    private static Scanner scan;

    public static void main(String[] args){

        data = new Data();
        scan = new Scanner(System.in);

        login();
    }


    private static void login() {

        System.out.print("Ведите логин: ");
        String inputLogin = scan.next();

        System.out.print("Введите пароль: ");
        String inputPass = scan.next();

        Data data = new Data();
        Map<String,String> users = data.getUsers();


        for (Map.Entry<String,String> user : users.entrySet()) {

            String userName = user.getKey();
            String userPass = user.getValue();

            if (userName.equalsIgnoreCase(inputLogin)) {

                if (userPass.equals(inputPass)) {

                    System.out.println("Вы успешно авторизовались");

                    searchFilm(userName);
                }
            }
        }

        System.out.println("Логин или пароль не верен");
    }

    private static void searchFilm(String autor) {
        System.out.println("Введите название фильма: ");
        String inputFilmName = scan.next();

        ArrayList<Film> films = data.getFilms();

        for(Film film: films) {

            if (film.getName().matches(inputFilmName + "(.*)")) {
                System.out.println(film.getName());
            }
        }

        addComment(autor);

    }

    private static void addComment(String autor) {
        try {

            System.out.print("Введите id фильма: ");
            String inputId = scan.next();

            System.out.print("Введите комментарий к фильму: ");
            String inputText = scan.next();

            System.out.print("Введите рейтинг фильма: ");
            Double inputReiting = scan.nextDouble();

            ArrayList<Film> filmsArray = data.getFilms();

            for(Film film: filmsArray) {

                if(film.getId().equals(inputId)) {

                    film.addComment(autor, inputText, inputReiting);
                    System.out.println("Комментарий успешно добавлен");

                    filmInfo();

                    System.exit(0);

                } else {
                    error = "Фильм с таким id не найцден";
                }
            }

            if (!error.isEmpty()) {
                System.out.println(error);
            }

        } catch (InputMismatchException e) {
            System.out.println(e);
        }
    }


    private static void filmInfo() {
        System.out.print("Введите imdb идентификатор фильма: ");
        String inputImdb = scan.next();

        ArrayList<Film> films = data.getFilms();

        for (Film film: films) {

            if (film.getImdb().equals(inputImdb)) {

                String filmInfo =   "Id: "  + film.getId() + "\n" +
                                    "Название: "  + film.getName() + "\n" +
                                    "Год: "  + film.getDate() + "\n" +
                                    "Жанр: "  + film.getGenre() + "\n" +
                                    "Описание: "  + film.getDesk() + "\n" +
                                    "Рейтинг: "  + film.getRating() + "\n" +
                                    "Imdb: "  + film.getImdb()+ "\n";

                System.out.println(filmInfo);

                ArrayList<Comment> CommentsToFilm = film.getComment();

                if (!CommentsToFilm.isEmpty()) {

                    System.out.println("Комментарии к фильму. ");

                    for(Comment comment: CommentsToFilm) {

                        String commentInfo =   "Дата: "  + comment.getDate() + "\n" +
                                "Автор: "  + comment.getAutor() + "\n" +
                                "комментарий: "  + comment.getText() + "\n" +
                                "Оценка фильму: "  + film.getRating() + "\n";


                        System.out.println(commentInfo);
                    }
                } else {
                    System.out.println("Комментарии к фильму отсутствуют");
                }
            }

        }
    }


}



