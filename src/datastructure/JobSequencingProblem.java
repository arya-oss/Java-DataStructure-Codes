package datastructure;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <h3>Job Sequencing Problem with deadline </h3>
 * <p>An array of jobs where every job has a deadline and associated profit
 * if the job is finished before the deadline. It is also given that every job 
 * takes single unit of time, so the minimum possible deadline for any job is 
 * 1. How to maximize total profit if only one job can be scheduled at a time.</p>
 * @author Rajmani Arya
 */
public class JobSequencingProblem {
    final static Comparator sortByprofit = new Comparator() {
        @Override
        public int compare(Object obj1, Object obj2) {
            Job i1 = (Job) obj1; Job i2 = (Job) obj2;
            return i2.profit-i1.profit;
        }
    };
    
    public static void main(String[] args) {
        Job[] jobs = { new Job("A", 7, 15),new Job("B", 2, 20),new Job("C", 5, 30),new Job("D", 3, 18),
        new Job("E", 4, 18),new Job("F", 5, 10),new Job("G", 2, 23),new Job("H", 7, 16),new Job("I", 3, 25)};
        int maxDeadline = 7;
        int[] result = new int[maxDeadline];
        boolean[] slot = new boolean[maxDeadline];
        Arrays.sort(jobs, sortByprofit);
        for (int i=0; i<jobs.length; i++) {
            for (int j = Math.min(maxDeadline, jobs[i].deadline) - 1; j>=0; j--) {
                if (!slot[j]) {
                    result[j] = i;
                    slot[j] = true;
                    break;
                }
            }
        }
        int totProfit=0;
        for(int i=0; i<result.length; i++) {
            totProfit += jobs[result[i]].profit;
            System.out.println(jobs[result[i]]);
        }
        System.out.printf("Total Profit : %s.\n",totProfit );
                
    }
    
    static class Job {
        String name;
        int deadline;
        int profit;
        public Job(String name, int deadline, int profit) {
            this.name = name;
            this.deadline = deadline;
            this.profit = profit;
        }
        @Override
        public String toString() {
            return name+" "+deadline+" "+profit;
        }
    }
}
