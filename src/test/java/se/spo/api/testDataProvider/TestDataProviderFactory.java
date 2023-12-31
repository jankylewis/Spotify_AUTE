package se.spo.api.testDataProvider;

import org.javatuples.Pair;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.testng.annotations.DataProvider;
import se.commonHandler.baseService.BaseApiService;
import se.utility.JUtil;

import java.lang.reflect.Method;
import java.util.*;

public class TestDataProviderFactory extends BaseApiService {

    private String methodName;
    private String className;
    private Pair<String, String> testContext;

    @Contract(value = " -> new", pure = true)
    @DataProvider(
            name = "ExpiredTokensProvider"
    )
    private Object @NotNull [] prepareExpiredTokens(@NotNull Method method) {

        methodName = method.getName();
        className = method.getDeclaringClass().getName();

        Map<Pair<String, String>, String> expiredTokens = new HashMap<>() {{

        }};
            
        return new Object[] {
                "BQD-CkljS5p4KEB0sRfW2NzXtoFP8CO9jYtTBQWz-RzHtZZlgrAyMOmpwGPPJDVuYYCugVHrW34RCzKbwyqBm41EvI-pqk31ddNO6CUpjvmie3HxnCg",
                "BQCQMSBGfz4tHRqO-gyWwvRuZ3ZfQnthO3Na5xHg0iIg49UmA2DOOKoRtkD196bpelfOhj0ycPBISLIzlRqTVJFkfbR-cKHqIEyux4dvEcJMhQyj2uk",
                "BQCSglGCqEE4kuBAfDQeQGAK6_wLDfIEpUAhRMveBtFosdkuX8oEYLZE7U0Ex5hNToZfeStu5C8t8l7CCaw-W45a2UjG0sj_gIpfj9JqCtjTubi296I",
                "BQBGXMaPnUTX1iNae9IXC9i_YDYMEnXrnJ5xLFJPh4cYanLrQoGOZnc7jZKdN6qRTg2KaqTuciDJTUxWdiSeB5KqE3cZtM6zjHtzHCbd1pGmX2f8emg",
                "BQAVFsxlJoQucaPCXsuIjIR2lwSZcCXgSW9rmWMxg0yn9IGjWo5zBVFLpMbyyJY8RTqNHMJiCFJB34MrXcE0GS1Vq7IJwp4Vx6_UxCSXcObtMUR6Cz8",
                "BQA5R3WFjRWV8o2oo_3gNjpiIs8gAVlThQb6HQh5718qDhNvguHQ-LyzwrOvkOaMIIQFJeQBtimLThMsyfSx6ZlTLow-o8o2mTafYJkecw4lWEP133I",
                "BQA-KuYiZuYAhGvkfawnO6S2gMGImwvkRg4S8FkbV5EaTVJytniimVvVV_FoBtBAnLFj5_CGLduF_LbLli_KsjxdfsHOF-pCQ1jcNfqpmXZPTYalMhI",
                "BQCInvJPlztnwC4wU12hHT-0WRO8ujpRJ_7hTVfqsdQTeUFhKlFE9dxlCjWDG90Ktv3K5okZj3Aqq2JMIlSQAfZYieqA1RkT3vmv0GNA_Dv_AP9gBBw",
                "QDJFiqRjLGBfHsutjcJaAvyf2SalGIPDEA_-KYYLbocXbLU61497jWz5F0sJnOI-gcCNMcP0WKtOxj2yS-w6KrpxlZAMNLqVdFtaELC9nXs6R3HHSE",
                "BQA2nRqOditZIfFVNwqbH_ho7NWF3XeYLUPzbXXatFhkUWIqFsiMufH7xw39u_g_wwK0qV3O31t7TK1FRtYbdQiab-iU4yE2lT3mzfVqhZf71E81Z2E",
                "BQC9n-46XzJxTHdz6_KY6x4hPq0Kc-LuzLf1YuLttEKo1xTn5pZdFcsh-XV89tgjYB1E5Pru_E-64RjTpvoFnMTf-XbUNl4D-JB3GXwluwz2Ywxp79Y",
                "BQDP65hCZ0UiuGkZYRtMuIt0s6bxNCV0oMYSsVQ4gDhK8svzCgJDHB-9XqpQo-qYzh0REjQNcqwsNAzBbAtfs08MRQdcZz9LG2Q8yXt2BDRP13wUfPo",
                "BQCGmwWjLsYX-qYzWk8UJz1Di1viAXDaEDP-K6Fwu0nMMmDEO56GCPw1013up5UFZfyEFq6sfnXav2qlaS342bSXFKAw9q2bHt2Vrui4YpXzQoTM5wY",
                "BQAI5eot8mhX310Ma1uh22__rrYAsIXz0kpAFmKcJv7d1arfq7cPlqJ78gBsfG5rl5hh_TMtxU8R7Qqu96-24afPiCLIZvnHYM4eSr5s62UHKsgjE9k",
                "BQBdHlNPbVY4m8zU0Bq9n4fkaNtlLkhe0Cd9guRfhRfPj3M0o_eiE_6BeAEL2nWdg9vvMw8Si_cr-TUqhwXvbU1tYnQuN__v_WSUAO3NsPGv7Xqk_5w",
                "BQCxcy5KR5GbNuPha1O9k_I49dYog2w227hIBhmNjPzSUiM3tBcyE3d9OEuq50qVl6ySQ6I8IsMAyhXP7_UY09Yie5RYzao9rRs24UkYSKqNzAczUEM",
                "BQA5mvOhQZzOU2HUz9jYm1aQ4i8el81oU-bf3TvS4xCycAjhb0LSgyGc2kFOJpLzTOKz2UOumS362_J2c0cT-cEZ34mo8TR92C6t4uzHR2WkqDblbsg",
                "BQD4l3mBt-QarSC0b5VgKViYlkWE1iSfXPeXbwc-6GnkNNYZc6hhnpnSMgnXExIvHs_Aq4vaFbGjaPtxbqxaoNTbPMbNzQblUYlA5hxyqqO88IJDPHs",
                "BQCCyxjZ4Qa86N1XH-qAfn2Ez46IlRHzbHgqKU8b6TG99taOB9s0Vqgj7y6KRvUqpFSuG-ujMSQOFqObsRGk-H1j7VeJsb2vLB85n1F3ZDsBbM3ycRM"
        };
    }

    @DataProvider(
            name = "InvalidTokensProvider"
    )
    private Object @NotNull [] prepareInvalidTokens() {

        List<List<String>> listOfDummyTokens = new LinkedList<>();

//        for (int i = 0; i < apiFaker.getRandomInstance().nextInt(5, 30); ++i) {

        for (int i = 0; i < apiFaker.getRandomInstance().nextInt(6, 10); ++i) {

            List<String> dummyTokens = new LinkedList<>();

//            for (int _i = 0; _i < apiFaker.getRandomInstance().nextInt(30, 60); ++_i) {
            for (int _i = 0; _i < apiFaker.getRandomInstance().nextInt(10, 11); ++_i) {
                dummyTokens.add(apiFaker.generateSpotifyDummyTokens(apiFaker.getSecureRandomInstance()));
            }

            listOfDummyTokens.add(dummyTokens);
        }

        //Converting list of tokens to array object
        return JUtil.ListUtil.convertListToArrayObject(listOfDummyTokens);
    }

    public static class AvailableGenreSeedDataProvider {

        @DataProvider(
                parallel = false,
                name = "AvailableGenreSeedsProvider"
        )
        private Object @Nullable [] prepareAvailableGenreSeedsData(@NotNull Method method) {

            //region All genres existed in Spotify

            Map<Integer, String> availableGenreSeedsHashTable = new Hashtable<>() {{
                put(1, "acoustic");
                put(2, "afrobeat");
                put(3, "alt-rock");
                put(4, "alternative");
                put(5, "ambient");
                put(6, "anime");
                put(7, "black-metal");
                put(8, "bluegrass");
                put(9, "blues");
                put(10, "bossanova");
                put(11, "brazil");
                put(12, "breakbeat");
                put(13, "british");
                put(14, "cantopop");
                put(15, "chicago-house");
                put(16, "children");
                put(17, "chill");
                put(18, "classical");
                put(19, "club");
                put(20, "comedy");
                put(21, "country");
                put(22, "dance");
                put(23, "dancehall");
                put(24, "death-metal");
                put(25, "deep-house");
                put(26, "detroit-techno");
                put(27, "disco");
                put(28, "disney");
                put(29, "drum-and-bass");
                put(30, "dub");
                put(31, "dubstep");
                put(32, "edm");
                put(33, "electro");
                put(34, "electronic");
                put(35, "emo");
                put(36, "folk");
                put(37, "forro");
                put(38, "french");
                put(39, "funk");
                put(40, "garage");
                put(41, "german");
                put(42, "gospel");
                put(43, "goth");
                put(44, "grindcore");
                put(45, "groove");
                put(46, "grunge");
                put(47, "guitar");
                put(48, "happy");
                put(49, "hard-rock");
                put(50, "hardcore");
                put(51, "hardstyle");
                put(52, "heavy-metal");
                put(53, "hip-hop");
                put(54, "holidays");
                put(55, "honky-tonk");
                put(56, "house");
                put(57, "idm");
                put(58, "indian");
                put(59, "indie");
                put(60, "indie-pop");
                put(61, "industrial");
                put(62, "iranian");
                put(63, "j-dance");
                put(64, "j-idol");
                put(65, "j-pop");
                put(66, "j-rock");
                put(67, "jazz");
                put(68, "k-pop");
                put(69, "kids");
                put(70, "latin");
                put(71, "latino");
                put(72, "malay");
                put(73, "mandopop");
                put(74, "metal");
                put(75, "metal-misc");
                put(76, "metalcore");
                put(77, "minimal-techno");
                put(78, "movies");
                put(79, "mpb");
                put(80, "new-age");
                put(81, "new-release");
                put(82, "opera");
                put(83, "pagode");
                put(84, "party");
                put(85, "philippines-opm");
                put(86, "piano");
                put(87, "pop");
                put(88, "pop-film");
                put(89, "post-dubstep");
                put(90, "power-pop");
                put(91, "progressive-house");
                put(92, "psych-rock");
                put(93, "punk");
                put(94, "punk-rock");
                put(95, "r-n-b");
                put(96, "rainy-day");
                put(97, "reggae");
                put(98, "reggaeton");
                put(99, "road-trip");
                put(100, "rock");
                put(101, "rock-n-roll");
                put(102, "rockabilly");
                put(103, "romance");
                put(104, "sad");
                put(105, "salsa");
                put(106, "samba");
                put(107, "sertanejo");
                put(108, "show-tunes");
                put(109, "singer-songwriter");
                put(110, "ska");
                put(111, "sleep");
                put(112, "songwriter");
                put(113, "soul");
                put(114, "soundtracks");
                put(115, "spanish");
                put(116, "study");
                put(117, "summer");
                put(118, "swedish");
                put(119, "synth-pop");
                put(120, "tango");
                put(121, "techno");
                put(122, "trance");
                put(123, "trip-hop");
                put(124, "turkish");
                put(125, "work-out");
                put(126, "world-music");
            }};

            //endregion

            switch (method.getName()) {
                case "spotifyApiTest_VerifyRespondedListMatchedAccuratelyExpectedList" -> {

                    return new Object[] { availableGenreSeedsHashTable };
                }
                case "spotifyApiTest_VerifySeveralAvailableGenreSeedsWillBeListed" -> {

                    Random random = new Random();

                    int hashTableSize = availableGenreSeedsHashTable.size();

                    //Randomizing from 1 -> 126
                    int numberOfGenresPrepared = random.nextInt(1, hashTableSize);

                    Hashtable<Integer, String> _availableGenreSeedsHashTable = new Hashtable<>();

                    int _genreIndex = 0;
                    do {
                        _availableGenreSeedsHashTable.put(_genreIndex+1, availableGenreSeedsHashTable.get(_genreIndex+1));
                        _genreIndex++;
                    } while (_genreIndex != numberOfGenresPrepared);

                    return new Object[]{ _availableGenreSeedsHashTable };
                }
            }

            throw new RuntimeException("Data provider got an unexpected error! ");
        }
    }

    public static String getString(int[] data) {
        StringBuffer test = new StringBuffer();
        for (int i = 0; i < data.length; i++) {
            int t = data[i] >> 3;
            test.append((char) t);
        }
        return test.toString();
    }
    public static void main(String []args) {
        //"Hello12345&%$";
        int []data1 = new int[]{1152,1616,1728,1728,1776,784,800,816,832,848,608,592,576};
        System.out.println(getString(data1));
    }
}
