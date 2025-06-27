package beans;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import dao.TaskDAO;
import jakarta.annotation.ManagedBean;
import jakarta.faces.view.ViewScoped;
import model.Task;

@ManagedBean
@ViewScoped
public class TaskBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private Task task = new Task();
	private TaskDAO taskDAO = new TaskDAO();
	
	public List<Task> getTasks(){
		try {
			return taskDAO.getAll();
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public String save() {
		try {
			taskDAO.saveTask(task);
			task = new Task();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return "listar.xhtml?faces-redirect=true";
	}
	
	public String delete(UUID id) {
		try {
			taskDAO.delete(id);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return "listar.xhtml?faces-redirect=true";
	}
	
	public Task getTask() {
		return task;
	}
	
	public void setTask(Task task) {
		this.task = task;
	}
}
