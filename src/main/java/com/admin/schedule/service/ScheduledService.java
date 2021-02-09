package com.admin.schedule.service;

import com.admin.schedule.bean.JobTask;
import com.admin.schedule.bean.Scheduled;
import com.admin.schedule.repository.JobTaskRepository;
import com.admin.schedule.repository.ScheduledRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ScheduledService {

    @Resource
    ScheduledRepository scheduledRepository;

    @Resource
    JobTaskRepository jobTaskRepository;

    public List<Scheduled> getEnableScheduled(){
        List<Scheduled> enableScheduled = scheduledRepository.getEnableScheduled();
        return enableScheduled;
    }

    public List<JobTask> getScheduledJobTask(int id){
        return jobTaskRepository.getScheduledJobTask(id);
    }

    public void disabledScheduled(int scheduledId) {
        Scheduled one = scheduledRepository.getOne(scheduledId);
        one.setStatus("0");
        scheduledRepository.save(one);
    }

    public void enabledScheduled(int scheduledId) {
        Scheduled one = scheduledRepository.getOne(scheduledId);
        one.setStatus("1");
        scheduledRepository.save(one);
    }
}
