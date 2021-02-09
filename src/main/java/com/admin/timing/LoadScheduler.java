package com.admin.timing;

import com.admin.schedule.bean.Scheduled;
import com.admin.schedule.service.ScheduledService;
import com.admin.util.ScheduledUtil;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;

import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Component
public class LoadScheduler {

    @Resource
    ScheduledUtil scheduledUtil;

    @Resource
    ScheduledService scheduledService;

    public void load(){
        List<Scheduled> enableScheduled = scheduledService.getEnableScheduled();

        for (final Scheduled scheduled : enableScheduled) {
            scheduledUtil.addJob(scheduled);
        }
    }
}
