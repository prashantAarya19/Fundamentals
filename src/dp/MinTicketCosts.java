package dp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinTicketCosts {
    private int minCostUtilRecursive(int[] days, int[] costs, int index) {
        if(index >= days.length)
            return 0;

        int oneDayTicket = costs[0] + minCostUtilRecursive(days, costs, index + 1);

        int day = 0;

        for(day = index; day < days.length && days[index] + 7 > days[day]; day++);
        int sevenDayTicket = costs[1] + minCostUtilRecursive(days, costs, day);

        for(day = index; day < days.length && days[index] + 30 > days[day]; day++);
        int thirtyDayTicket = costs[2] + minCostUtilRecursive(days, costs, day);

        return Integer.min(oneDayTicket, Integer.min(sevenDayTicket, thirtyDayTicket));
    }

    private int minCostUtilMemo(int[] days, int[] costs, int index, int[] dp) {
        if(index >= days.length)
            return 0;

        if(dp[index] != -1)
            return dp[index];

        int oneDayTicket = costs[0] + minCostUtilMemo(days, costs, index + 1, dp);

        int day = 0;

        for(day = index; day < days.length && days[index] + 7 > days[day]; day++);
        int sevenDayTicket = costs[1] + minCostUtilMemo(days, costs, day, dp);

        for(day = index; day < days.length && days[index] + 30 > days[day]; day++);
        int thirtyDayTicket = costs[2] + minCostUtilMemo(days, costs, day, dp);

        dp[index] = Integer.min(oneDayTicket, Integer.min(sevenDayTicket, thirtyDayTicket));

        return dp[index];
    }

    private int minCostUtilTab(int[] days, int[] costs) {
        int[] dp = new int[days.length + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[days.length] = 0;

        for(int i = days.length - 1; i >= 0; i--) {
            int oneDayTicket = costs[0] + dp[i + 1];

            int day = 0;

            for(day = i; day < days.length && days[i] + 7 > days[day]; day++);
            int sevenDayTicket = costs[1] + dp[day];

            for(day = i; day < days.length && days[i] + 30 > days[day]; day++);
            int thirtyDayTicket = costs[2] + dp[day];

            dp[i] = Integer.min(oneDayTicket, Integer.min(sevenDayTicket, thirtyDayTicket));
        }


        return dp[0];
    }

    public static int mincostTickets(int[] days, int[] costs) {
        int minCost = 0;
        Queue<Pair> month = new LinkedList<>();
        Queue<Pair> week = new LinkedList<>();

        for(int day: days) {
            while(!month.isEmpty() && (month.peek().day + 30) <= day)
                month.remove();
            while(!week.isEmpty() && (week.peek().day + 7) <= day)
                week.remove();

            month.add(new Pair(day, minCost+costs[2]));
            week.add(new Pair(day, minCost+costs[1]));
            minCost = Integer.min((minCost + costs[0]), Integer.min(month.peek().cost, week.peek().cost));
        }
        return minCost;
    }

    public static void main(String[] args) {
        int[] days = {1,2,3,4,5,6,7,8,9,10,30,31};
        int[] costs = {2,7,15};
        System.out.println(mincostTickets(days, costs));
    }
}
