package com.nowcoder.service;

import com.nowcoder.dao.QuestionDAO;
import com.nowcoder.dao.UserDAO;
import com.nowcoder.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WendaService {
    @Autowired
    UserDAO userDAO;
    public String getMessage(int userId){
        return "hello message." +String.valueOf(userDAO.selectById(userId));
    }
}
