package ru.job4j.search;

import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    enum en {
        getName(),
        getSurname(),
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (Person pers :this.persons) {
            String[] array = {
                    pers.getName(),
                    pers.getSurname(),
                    pers.getAddress(),
                    pers.getPhone()
            };
            for (String getter : array) {
                if (getter.contains(key)) {
                    result.add(pers);
                    break;
                }
            }

        }
        return result;
    }
}
