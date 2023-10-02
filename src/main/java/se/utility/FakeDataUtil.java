package se.utility;

import com.github.javafaker.Faker;

public class FakeDataUtil {

    private Faker faker = new Faker();

    //region Producing fake names

    public String produceFakeName() {
        return faker.name().fullName();
    }

    public String produceFakeFirstName() {
        return faker.name().firstName();
    }

    public String produceFakeLastName() {
        return faker.name().lastName();
    }

    //endregion

    public String produceUsername() {
        return faker.name().username();
    }

    public String produceCharacterOfGameOfThrones() {
        return faker.gameOfThrones().character();
    }

    public String produceQuoteOfGameOfThrones() {
        return faker.gameOfThrones().quote();
    }

    public String produceCharacterOfLordOfTheRings() {
        return faker.lordOfTheRings().character();
    }

    public String produceSpellOfHarryPotter() {
        return faker.harryPotter().spell();
    }

    public String produceCatchPhraseOfHowIMetYourMother() {
        return faker.howIMetYourMother().catchPhrase();
    }

    public String produceCharacterOfDragonBall() {
        return faker.dragonBall().character();
    }

    public String produceMarvinQuoteOfHitchHikersGuideToTheGalaxy() {
        return faker.hitchhikersGuideToTheGalaxy().marvinQuote();
    }
}
