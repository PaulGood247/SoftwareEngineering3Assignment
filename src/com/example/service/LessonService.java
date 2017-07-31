package com.example.service;

import com.example.business.Lesson;
import com.example.dao.LessonDao;
import com.example.exceptions.DaoException;

public class LessonService {

	LessonDao dao = new LessonDao();
	
	public Lesson getLesson(int _id){
		
		Lesson l = null;
		try {			
			l = dao.findLessonById(_id);
		} 
		catch (DaoException e) {
			e.printStackTrace();
		}
		
		return l;	
	}
	
	
}