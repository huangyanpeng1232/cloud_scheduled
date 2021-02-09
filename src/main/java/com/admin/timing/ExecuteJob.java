package com.admin.timing;

import com.admin.AdminApplication;
import com.admin.schedule.bean.JobTask;
import com.admin.schedule.service.ScheduledService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@Component
public class ExecuteJob implements Job {

    @Override
    public void execute(JobExecutionContext context) {

        ScheduledService scheduledService = AdminApplication.context.getBean(ScheduledService.class);
        RestTemplate restTemplate = AdminApplication.context.getBean(RestTemplate.class);

        JobDataMap dataMap = context.getJobDetail().getJobDataMap();
        int scheduledId = Integer.parseInt(String.valueOf(dataMap.get("scheduledId")));
        List<JobTask> jobTaskList = scheduledService.getScheduledJobTask(scheduledId);
        for (JobTask jobTask : jobTaskList) {
            log.info("执行任务 {}",jobTask.getName());
            restTemplate.getForObject("http://"+jobTask.getServer()+jobTask.getUrl(), String.class);
        }
    }
}
