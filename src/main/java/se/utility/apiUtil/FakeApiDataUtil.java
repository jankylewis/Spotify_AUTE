package se.utility.apiUtil;

import java.security.SecureRandom;
import java.util.Random;
import java.util.UUID;

public class FakeApiDataUtil {

    public FakeApiDataUtil() {}

    private SecureRandom secureRandom;
    private Random random;

    public Random getRandomInstance() {
        return random = random == null ? new Random() : random;
    }

    public Random getSecureRandomInstance() {
        return secureRandom = secureRandom == null ? new SecureRandom() : secureRandom;
    }

    //region Generating dummy Spotify tokens service

    public String generateSpotifyDummyTokens(Random random) {

        //First two characters of Spotify token always began with BQ
        final String firstTwoCharacters = "BQ";
        final String[] thirdCharacter = new String[]{"A", "B", "C", "D"};

        final String uncapitalizedCharacters = "abcdefghijklmnopqrstuvwxyz";
        final String capitalizedCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String numericCharacters = "0123456789";
        final String specialCharacters= "-_";

        final String alphanumericCharacters =
                uncapitalizedCharacters + capitalizedCharacters + numericCharacters + specialCharacters;

        final int length = 112;
        final char[] token = new char[length];

        //Performing randomizations
        for (int i = 0; i < token.length; ++i) {

            //Parsing alphanumericCharacters to be char[] type
            char[] _alphanumericCharacters = alphanumericCharacters.toCharArray();

            token[i] = _alphanumericCharacters[random.nextInt(alphanumericCharacters.length())];
        }

        String tokenPrefix = firstTwoCharacters + thirdCharacter[random.nextInt(thirdCharacter.length)];

        return tokenPrefix + new String(token);
    }

    //endregion

    public UUID produceFakeUuid() {
        return UUID.randomUUID();
    }
}
