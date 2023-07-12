package projects.dao;

import projects.entity.Project;
import provided.util.DaoBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import projects.exception.DbException;
import java.math.BigDecimal;

//This class will read and write to the MySQL database and performs CRUD (Create, Read, Update and Delete)
@SuppressWarnings("unused")
public class ProjectDao extends DaoBase {
	private static final String CATEGORY_TABLE = "category";
	private static final String MATERIAL_TABLE = "material";
	private static final String PROJECT_TABLE = "project";
	private static final String PROJECT_CATEGORY_TABLE = "project_category";
	private static final String STEP_TABLE = "step";

	// Inserts a row into the project table
	public Project insertProject(Project project) {

		// @formatter:off
		
		String sql = ""
			+ "INSERT INTO " + PROJECT_TABLE + " "
			+ "(project_name, estimated_hours, actual_hours, difficulty, notes)"
			+ "VALUES "
			+ "(?, ?, ?, ?, ?)";
		//formatter:on
		
		
		try (Connection conn = DbConnection.getConnection()) {	
			startTransaction(conn);
			
			
			try (PreparedStatement statement = conn.prepareStatement(sql)) {	
				setParameter(statement, 1, project.getProjectName(), String.class);
				setParameter(statement, 2, project.getEstimatedHours(), BigDecimal.class);
				setParameter(statement, 3, project.getActualHours(), BigDecimal.class);
				setParameter(statement, 4, project.getDifficulty(), Integer.class);
				setParameter(statement, 5, project.getNotes(), String.class);
				
				statement.executeUpdate();			
				Integer projectId = getLastInsertId(conn, PROJECT_TABLE);
				
				commitTransaction(conn);
				
				project.setProjectId(projectId);
				
				return project;
			} catch (Exception e) {
				rollbackTransaction(conn);
				throw new DbException(e);
			}
			
		} catch (SQLException e) {
			throw new DbException(e);
		}
	}

}