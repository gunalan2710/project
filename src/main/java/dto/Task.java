package dto;


public class Task {
	
	private int taskid;
	private String tasktitle;
	private String taskdescription;
	private String taskpriority;
	private String taskduedate;
	private String taskstatus;
	private int userid;
	public int getTaskid() {
		return taskid;
	}
	public Task(int taskid, String tasktitle, String taskdescription, String taskpriority, String taskduedate,
			String taskstatus, int userid) {
		super();
		this.taskid = taskid;
		this.tasktitle = tasktitle;
		this.taskdescription = taskdescription;
		this.taskpriority = taskpriority;
		this.taskduedate = taskduedate;
		this.taskstatus = taskstatus;
		this.userid = userid;
	}
	
	public String getTasktitle() {
		return tasktitle;
	}
	
	public String getTaskdescription() {
		return taskdescription;
	}
	
	public String getTaskpriority() {
		return taskpriority;
	}
	public String getTaskduedate() {
		return taskduedate;
	}
	
	public String getTaskstatus() {
		return taskstatus;
	}
	
	public int getUserid() {
		return userid;
	}
	
	
	
	
	
}