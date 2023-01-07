package dp;

import java.util.Arrays;

public class MinSideWaysJump {
    public int minSideJumps(int[] obstacles) {
        int currentPosition = 0;
        int currentLane = 2;
        return getMinSideJumpsReccursive(obstacles, currentPosition, currentLane);
    }

    private int getMinSideJumpsReccursive(int[] obstacles, int currentPosition, int currentLane) {
        if(currentPosition == obstacles.length - 1)
            return 0;

        if(currentLane != obstacles[currentPosition + 1]) {
            return getMinSideJumpsReccursive(obstacles, currentPosition + 1, currentLane);
        } else {
            int min = Integer.MAX_VALUE;
            for(int i = 1; i <= 3; i++) {
                if(i != currentLane && obstacles[currentPosition] != i) {
                    min = Integer.min(min, 1 + getMinSideJumpsReccursive(obstacles, currentPosition, i));
                }
            }
            return min;
        }
    }

    private int getMinSideJumpsMemo(int[] obstacles, int currentPosition, int currentLane, int[][] dp) {
        if(currentPosition == obstacles.length - 1)
            return 0;

        if(dp[currentPosition][currentLane] != -1)
            return dp[currentPosition][currentLane];

        if(currentLane != obstacles[currentPosition + 1]) {
            dp[currentPosition][currentLane] = getMinSideJumpsMemo(obstacles, currentPosition + 1, currentLane, dp);
            return dp[currentPosition][currentLane];
        } else {
            int min = Integer.MAX_VALUE;
            for(int i = 1; i <= 3; i++) {
                if(i != currentLane && obstacles[currentPosition] != i) {
                    min = Integer.min(min, 1 + getMinSideJumpsMemo(obstacles, currentPosition, i, dp));
                }
            }
            dp[currentPosition][currentLane] = min;
            return dp[currentPosition][currentLane];
        }
    }

    private int getMinSideJumpsTab(int[] obstacles) {
        int[][] dp = new int[4][obstacles.length];
        Arrays.stream(dp).forEach(e -> Arrays.fill(e, Integer.MAX_VALUE));
        int n = obstacles.length - 1;

        dp[1][n] = 0;
        dp[2][n] = 0;
        dp[3][n] = 0;

        for(int currentPosition = n - 1; currentPosition >= 0; currentPosition--) {
            for(int currentLane = 1; currentLane <= 3; currentLane++) {
                if(currentLane != obstacles[currentPosition + 1]) {
                    dp[currentLane][currentPosition] = dp[currentLane][currentPosition + 1];
                } else {
                    int min = Integer.MAX_VALUE;
                    for(int i = 1; i <= 3; i++) {
                        if(i != currentLane && obstacles[currentPosition] != i) {
                            min = Integer.min(min, 1 + dp[i][currentPosition + 1]);
                        }
                    }
                    dp[currentLane][currentPosition] = min;
                }
            }
        }

        return Integer.min(dp[2][0], Integer.min(1 + dp[1][0], 1 + dp[3][0]));

    }

    private int getMinSideJumpsTab2(int[] obstacles) {
        int n = obstacles.length - 1;

        int[] next = new int[4];
        next[1] = 0;
        next[2] = 0;
        next[3] = 0;

        for(int currentPosition = n - 1; currentPosition >= 0; currentPosition--) {
            int[] current = new int[4];
            for(int currentLane = 1; currentLane <= 3; currentLane++) {
                if(currentLane != obstacles[currentPosition + 1]) {
                    current[currentLane] = next[currentLane];
                } else {
                    int min = Integer.MAX_VALUE;
                    for(int i = 1; i <= 3; i++) {
                        if(i != currentLane && obstacles[currentPosition] != i) {
                            min = Integer.min(min, 1 + next[i]);
                        }
                    }
                    current[currentLane] = min;
                }
            }
            next = current;
        }

        return Integer.min(next[2], Integer.min(1 + next[1], 1 + next[3]));

    }
}
