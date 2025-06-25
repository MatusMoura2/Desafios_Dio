package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import model.Task;
import util.ConnectionFactory;

public class TaskDAO {

	public void saveTask(Task task) throws SQLException{
		
		String sql = "INSERT INTO task(id, title, description, status) VALUES (?, ?, ?, ?)";
		
		try(Connection connection = ConnectionFactory.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)){
					preparedStatement.setString(1, task.getId().toString());
					preparedStatement.setString(2, task.getTitle());
					preparedStatement.setString(3, task.getDescription());
					preparedStatement.setString(4, task.getStatus());
					
					preparedStatement.executeUpdate();
				}
	}
	public List<Task> getAll() throws SQLException{
		List<Task> tasks = new ArrayList<>();
		String sql = "SELECT * FROM tarefas";
		try(Connection connection = ConnectionFactory.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(sql)){
			while(resultSet.next()) {
				Task task = new Task();
				task.setId(UUID.fromString(resultSet.getString("id")));
				task.setTitle(resultSet.getString("titulo"));
				task.setDescription(resultSet.getString("descricao"));
				task.setStatus(resultSet.getString("status"));
				tasks.add(task);
			}
		}
		
		return tasks;
	}
	
	
}
