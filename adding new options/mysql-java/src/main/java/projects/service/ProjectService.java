package projects.service;

import projects.dao.ProjectDao;
import projects.entity.Project;
import java.util.List;
import java.util.NoSuchElementException;

public class ProjectService {

	private ProjectDao projectDao = new ProjectDao();

	// method calls the DAO class to insert a project row
	public Project addProject(Project project) {
		return projectDao.insertProject(project);
	}

	//created two new methods 
	// retrieving only the id and the name of the projects
	public List<Project> fetchAllProjects() {
		return projectDao.fetchAllProjects();
	}
     //It returns a Project object and takes an Integer projectId as a parameter.
	// It throws an exception if the project ID input by the user doesn't exist in the database.
	public Project fetchProjectById(Integer projectId) {
		return projectDao.fetchProjectById(projectId).orElseThrow(
				() -> new NoSuchElementException("Project with project ID=" + projectId + " does not exist."));
	}

}