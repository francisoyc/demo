package com.oyc.sqlprovider;

import com.alibaba.druid.util.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

/**
 * 主要用途：根据复杂的业务需求来动态生成SQL.
 * <p>
 * 目标：使用Java工具类来替代传统的XML文件.(例如：StudentSqlProvider.java <-- StudentMapper.xml)
 */
public class StudentSqlProvider {

    /*public String getStudentByName(String name) {
        return "select * from t_user where name =#{name}";
    }*/

    /**
     * 根据学生姓名查询学生信息，动态编写sql
     * @param name
     * @return
     */
    public String getListByName(@Param("name") String name) {
        return new SQL() {{
            SELECT("*");
            FROM("student");
            if (name != null) {
                WHERE("name like CONCAT('%',#{name},'%')");
            } else {
                WHERE("1=1");
            }
        }}.toString();
    }

}