package by.itclass.model.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    //Шаблон вывода даты в формате: день, месяц, год
    //dd - день
    //MM - месяц (обязательно большими)
    //yyyy - год
    public static final String DD_MM_YYYY= "dd.MM.yyyy";
    //HH - обозначают часы в 24 формате
    //mm - минуты с лидирующими нулями
    public static final String DD_MM_YYYY_HH_MM = "dd.MM.yyyy HH:mm";
    private static SimpleDateFormat dateFormat = new SimpleDateFormat();

    public static String format(Date date, String pattern){
        //Метод applyPattern применяет формат для представления даты к строке
        dateFormat.applyPattern(pattern);
        //Метод format представляет дату в строку согласно формату
        return dateFormat.format(date);
    }

}
