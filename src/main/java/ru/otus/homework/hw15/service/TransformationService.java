package ru.otus.homework.hw15.service;


import ru.otus.homework.hw15.domain.*;

public interface TransformationService {

    /**
     * Превращение в гусеницу
     * @param egg яйцо
     * @return гусеница
     */
    Caterpillar transformToCaterpillar(Egg egg);

    /**
     * Превращение в кокон бабочки
     * @param caterpillar гусеница
     * @return кокон бабочки
     */
    Cocoon transformToCocoon(Caterpillar caterpillar);

    /**
     * Превращение в бабочку
     * @param cocoon кокон бабочки
     * @return бабочка
     */
    Butterfly transformToButterfly(Cocoon cocoon);

    /**
     * Превращению в землю
     * @param butterfly бабочка
     * @return земля
     */
    Ground transformToGround(Butterfly butterfly);

    void transform();
}
