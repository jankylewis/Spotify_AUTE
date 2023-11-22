package se.utility;

import com.github.javafaker.Faker;

public class FakeDataUtil {

    private Faker faker = new Faker();

    //region Producing fake credentials

    public String produceFakeName() {
        return faker.name().fullName();
    }

    public String produceFakeFirstName() {
        return faker.name().firstName();
    }

    public String produceFakeLastName() {
        return faker.name().lastName();
    }

    public String produceUsername() {
        return faker.name().username();
    }

    public String produceFakeEmail() {
        return faker.internet().emailAddress();
    }

    public String producePassword() {
        return faker.internet().password();
    }

    public String producePassword(int minLength, int maxLength) {
        return faker.internet().password(minLength, maxLength);
    }

    public String producePassword(int minthLength,
                                  int maxLength,
                                  Boolean isDigitsIncluded,
                                  Boolean isUppercaseIncluded,
                                  Boolean isSpecialCharsIncluded) {

        return faker.internet().password(
                minthLength, maxLength, isUppercaseIncluded, isSpecialCharsIncluded, isDigitsIncluded);
    }

    //endregion

    //region Producing fictional characters

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

    //endregion
}
