package com.admin.schedule.repository;

import com.admin.schedule.bean.JobTask;
import com.admin.schedule.bean.Scheduled;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobTaskRepository extends JpaRepository<JobTask, Integer> {

    @Query(value = "select jt.* from `scheduled_job_task` sjt,`job_task` jt where sjt.job_task_id = jt.id and sjt.scheduled_id = ?1 order by jt.`number`",nativeQuery=true)
    List<JobTask> getScheduledJobTask(@Param("id") Integer id);
}
