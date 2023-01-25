package greedy;

public class SurviveOnIland {
    static int minimumDays(int S, int N, int M){
        /*
         days to survive = S;
         max food buy = N
         food require per day = M

         for one day survival -> N >= M
         for N day survival -> d * N >= d * M

         constraint = in a week only 6 days buy is allowed

         if day == 7
         buy day = 6


         if day = 15
         buy day = 13

         buyDay = day - day / 7

         if day = 8
         buy day = 7

         8 - 1
         = 7

         15 - 15 / 7
         15 - 2;

         if day 24
         buy day 21

         24 - 25 % 7
         = 24 - 3

         if day = 6
         buy day = 6 - 6/7;
         6

         day 20
         bd = 20 - 20/7;
         bd = 18;

         10 * 2 = 20
         16 + 1 = 17;
         2 d
         */

        if(N < M)
            return -1;

        int buyDay = getBuyDay(S);
        if(buyDay * N >= S * M)
            return getNumberOfBuyDays(buyDay, N, S*M);
        else
            return -1;

    }

    private static int getBuyDay(int days) {
        return days - Math.abs(days / 7);
    }

    private static int getNumberOfBuyDays(int buyDay, int unitBuy, int totalToSurvive) {
        int days = 0;
        int bd = 0;
        while(totalToSurvive > 0 && bd <= buyDay) {
            totalToSurvive = totalToSurvive - unitBuy;
            bd++;
            days++;
        }
        return days;
    }
}
