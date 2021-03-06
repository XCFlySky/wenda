package com.nowcoder.dao;

import com.nowcoder.model.Question;
import com.nowcoder.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface QuestionDAO {
    String TABLE_NAME = "question";
    String INSERT_FIELDS ="title,content,created_date,user_id,comment_count";
    String SELECT_FIELDS ="id,"+INSERT_FIELDS;

    @Insert({"insert into ",TABLE_NAME,"(",INSERT_FIELDS,") values(#{title},#{content},#{createdDate},#{userId},#{commentCount})"})
    int addQuestion(Question question);

    List<Question> selectLatestQuestions(@Param("userId")int userId,
                                        @Param("offset")int offset,
                                        @Param("limit")int limit);

    @Update({"update",TABLE_NAME,"set password=#{password} where id =#{id}"})
    void updatePassword(User user);

    @Delete({"delete from",TABLE_NAME,"where id =#{id}"})
    void deleteById(int id);

    @Select({"select",SELECT_FIELDS,"from",TABLE_NAME,"where id= #{id}"})
    Question selectById(int id);
}
