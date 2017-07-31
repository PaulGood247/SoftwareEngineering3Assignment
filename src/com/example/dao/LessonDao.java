package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.business.Lesson;
import com.example.exceptions.DaoException;


public class LessonDao extends Dao {

    public Lesson findLessonById(int _id) throws DaoException {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Lesson l = null;
        try {
            con = this.getConnection();
            
            String query = "SELECT * FROM LESSON WHERE _ID = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1,_id);
            
            rs = ps.executeQuery();
            if(rs.next()) {
            	
            	int lessonId = rs.getInt("_ID");
                String lessonName = rs.getString("LESSONNAME");
                String lessonLocation = rs.getString("LESSONLOCATION");
                String lessonStartTime = rs.getString("LESSONSTATTIME");
                String lessonEndTime = rs.getString("LESSONENDTIME");
                String lessonType = rs.getString("LESSONTYPE");
                String lessonTutor = rs.getString("LESSONTUTOR");
                String lessonDayOfWeek = rs.getString("LESSONDAYOFWEEK");
                l = new Lesson(lessonId, lessonName, lessonLocation, lessonStartTime, lessonEndTime, lessonType, lessonTutor, lessonDayOfWeek);
            }
        } catch (SQLException e) {
            throw new DaoException("findLessonById " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                throw new DaoException("findLessonById" + e.getMessage());
            }
        }
        return l;     // l may be null 
    }
   
}