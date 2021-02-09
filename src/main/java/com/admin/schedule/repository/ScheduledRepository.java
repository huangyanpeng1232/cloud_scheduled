package com.admin.schedule.repository;


import com.admin.schedule.bean.JobTask;
import com.admin.schedule.bean.Scheduled;
import io.lettuce.core.dynamic.annotation.Param;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduledRepository  extends JpaRepository<Scheduled, Integer> {

    @Query(value = "select * from scheduled where status = '1'",nativeQuery = true)
    List<Scheduled> getEnableScheduled();
}
