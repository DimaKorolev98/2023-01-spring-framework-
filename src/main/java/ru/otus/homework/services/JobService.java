package ru.otus.homework.services;

/**
 * Интерфейс работы с задачей
 */
public interface JobService {

    /**
     * Запускает задачу
     * @throws Exception ошибка
     */
    void run() throws Exception;

    /**
     * Перезапускает задачу
     * @throws Exception ошибка
     */
    void restart() throws Exception;

    /**
     * Отображает информация по запущенной задаче
     * @throws Exception ошибка
     */
    String showJobInfo() throws Exception;
}