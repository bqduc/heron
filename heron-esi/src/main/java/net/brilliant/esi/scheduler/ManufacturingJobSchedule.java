/**
 * 
 */
package net.brilliant.esi.scheduler;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import net.brilliant.esi.base.JobSchedulerBase;

/**
 * @author ducbq
 *
 */
public class ManufacturingJobSchedule extends JobSchedulerBase {
  protected void executing(JobExecutionContext jobExecutionContext) throws JobExecutionException {
    super.reportScheduleStatus(this.getClass().getSimpleName());
  }
}
