package ru.otus.homework.hw15.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.homework.hw15.domain.*;
import ru.otus.homework.hw15.integration.FirstStep;
import ru.otus.homework.hw15.integration.FourthsStep;
import ru.otus.homework.hw15.integration.SecondStep;
import ru.otus.homework.hw15.integration.ThirdStep;
import ru.otus.homework.hw15.service.TransformationService;

@Service
@RequiredArgsConstructor
public class TransformationServiceImpl implements TransformationService {
    private final FirstStep firstStep;
    private final SecondStep secondStep;
    private final ThirdStep thirdStep;
    private final FourthsStep fourthsStep;

    @Override
     public void transform(){
         firstStep.process(new Egg());
     }
    @Override
    public Caterpillar transformToCaterpillar(Egg egg) {
        System.out.println("transform to Caterpillar");
        return new Caterpillar();
    }

    @Override
    public Cocoon transformToCocoon(Caterpillar caterpillar) {
        System.out.println("transform to Cocoon");
        return new Cocoon();
    }

    @Override
    public Butterfly transformToButterfly(Cocoon cocoon) {
        System.out.println("transform to Butterfly");
        return new Butterfly();
    }

    @Override
    public Ground transformToGround(Butterfly butterfly) {
        System.out.println("transform to Ground");
        return new Ground();
    }
}
