package testScheduleRun;


import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class TestScheduler {

    public static void main(String[] args) throws SchedulerException {
        // Create a scheduler factory
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();

        // Get a scheduler instance
        Scheduler scheduler = schedulerFactory.getScheduler();

        // Define a job to be executed
        JobDetail job = JobBuilder.newJob(SeleniumTestJob.class)
            .withIdentity("seleniumTestJob", "group1")
            .build();

     // Define multiple triggers for scheduling the job at different times of the da
      
        Trigger trigger1 = TriggerBuilder.newTrigger()
            .withIdentity("testTrigger1", "group1")
            .withSchedule(CronScheduleBuilder.dailyAtHourAndMinute(0, 00))
            .build();


        // Start the scheduler
 
         scheduler.scheduleJob(job, trigger1);
   
        scheduler.start();

        // Output a message indicating the execution times
        System.out.println("Execution times are set to 06:00 AM, 9:00 PM, and 12:00 AM daily.");
    }
}