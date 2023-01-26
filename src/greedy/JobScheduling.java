package greedy;

import java.util.Arrays;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}
public class JobScheduling {
    int[] jobScheduling(Job[] arr, int n)
    {
        Arrays.sort(arr, (j1, j2) -> -Integer.compare(j1.profit, j2.profit));
        int maxDeadline = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            maxDeadline = Math.max(maxDeadline, arr[i].deadline);
        }
        int[] jobDone = new int[maxDeadline + 1];
        Arrays.fill(jobDone, -1);

        int jobCount = 0;
        int maxProfit = 0;
        for(int i = 0; i < n; i++) {
            int currentJobId = arr[i].id;
            int currentDeadline = arr[i].deadline;
            int currentProfit = arr[i].profit;

            for(int j = currentDeadline; j > 0; j--) {
                if(jobDone[j] == -1) {
                    jobCount++;
                    maxProfit += currentProfit;
                    jobDone[j] = currentJobId;
                    break;
                }
            }
        }

        return new int[]{jobCount, maxProfit};
    }
}
