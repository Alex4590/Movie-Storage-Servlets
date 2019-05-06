package app;

import java.util.*;

public class Data {

    private Map<String,String> users;
    private ArrayList<Film> films;

    public Data() {
        this.users = this.addUsers();
        this.films = this.addFilms();
    }

    private Map<String,String> addUsers() {
        Map<String,String> usersMap = new HashMap<String,String>();

        usersMap.put("Alex","12345");
        usersMap.put("Anton","1234");

        return usersMap;
    }


    private ArrayList<Film> addFilms() {

        ArrayList<Film>  filmsArray = new ArrayList<Film>(){
            {
                add(new Film("1","фильм","Джанго","драма","2008","Эксцентричный охотник за головами, также известный как «Дантист» промышляет отстрелом самых опасных преступников", 7.1, "tt0119008"));
                add(new Film("2","фильм","Донни Браско","драма","1998","Нью-Йорк, 1978 год. Агент ФБР Джо Пистоне получает новое задание: внедриться в одну из преступных группировок Бруклина.", 7.9,"tt0149008"));
                add(new Film("3","фильм","Жестокий романс","мелодрама","1987","Действие разворачивается на берегу Волги в вымышленном провинциальном городке Бряхимове в 1877-1878 годах.", 8.1,"tt0112005"));
            }
        };

        return filmsArray;
    }

    public  ArrayList<Film> getFilms() {
        return films;
    }

    public Map<String,String> getUsers() {
        return this.users;
    }

}
