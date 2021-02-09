package com.admin.schedule.controller;

import com.admin.schedule.bean.JobTask;
import com.admin.schedule.bean.Scheduled;
import com.admin.schedule.repository.JobTaskRepository;
import com.admin.schedule.repository.ScheduledRepository;
import com.admin.schedule.service.ScheduledService;
import com.admin.timing.ExecuteJob;
import com.admin.util.ScheduledUtil;
import org.quartz.*;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("scheduled")
public class ScheduledController {

    @Resource
    ScheduledRepository scheduledRepository;

    @Resource
    ScheduledService scheduledService;

    @Resource
    ScheduledUtil scheduledUtil;

    @RequestMapping("reloadScheduled")
    public String reloadScheduled(int scheduledId){

        Scheduled scheduled = scheduledRepository.getOne(scheduledId);

        scheduledUtil.removeJob(scheduled);

        scheduledUtil.addJob(scheduled);

        return "true";
    }

    @RequestMapping("startScheduled")
    public String startScheduled(int scheduledId) {

        Scheduled scheduled = scheduledRepository.getOne(scheduledId);
        scheduledUtil.addJob(scheduled);

        scheduledService.enabledScheduled(scheduledId);

        return "true";
    }

    @RequestMapping("staopScheduled")
    public String staopScheduled(int scheduledId) {

        Scheduled scheduled = scheduledRepository.getOne(scheduledId);
        scheduledUtil.removeJob(scheduled);

        scheduledService.disabledScheduled(scheduledId);

        return "true";
    }
}
