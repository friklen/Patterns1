package ru.netology.web.data;

import com.github.javafaker.Faker;
import lombok.Value;
import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateCity() {
        var cities = new String[]{
                "Магас", "Йошкар-Ола", "Иваново", "Челябинск", "Майкоп", "Горно-Алтайск", "Уфа", "Улан-Удэ", "Махачкала",
                "Нальчик", "Элиста", "Черкесск", "Петрозаводск", "Сыктывкар", "Саранск", "Якутск", "Владикавказ", "Казань",
                "Кызыл", "Ижевск", "Абакан", "Грозный", "Чебоксары", "Барнаул", "Чита", "Петропавловск-Камчатский", "Краснодар",
                "Красноярск", "Пермь", "Владивосток", "Ставрополь", "Хабаровск", "Благовещенск", "Архангельск", "Астрахань", "Белгород", "Брянск",
                "Владимир", "Волгоград", "Вологда", "Воронеж", "Иркутск", "Калининград", "Калуга", "Кемерово", "Киров", "Кострома", "Курган",
                "Курск", "Санкт-Петербург", "Гатчина", "Липецк", "Магадан", "Москва", "Красногорск", "Мурманск"};
        return cities[new Random().nextInt(cities.length)];
    }

    public static String generateName(String locale) {
        Faker faker = new Faker(new Locale(locale));
        return faker.name().lastName() + " " + faker.name().firstName();
    }

    public static String generatePhone(String locale) {
        Faker faker = new Faker(new Locale(locale));
        return faker.phoneNumber().phoneNumber();
    }


    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            return new UserInfo(generateCity(), generateName(locale), generatePhone(locale));
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }


}
