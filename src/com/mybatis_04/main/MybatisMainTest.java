package com.mybatis_04.main;

import com.mybatis_04.mapper.RoleMapper;
import com.mybatis_04.pojo.Role;
import com.mybatis_04.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import java.util.List;

/**
 * @author Nigori
 * @date 2020/5/8
 **/
public class MybatisMainTest {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(MybatisMainTest.class);
        SqlSession sqlSession = null;

        try {
            //实例化SqlSession对象
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            //Mapper接口发送SQL
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);


            //查询单条记录
            /*Role role = roleMapper.getRole(101);
            logger.info(role.getRoleName());*/

            //删除记录
            /*roleMapper.deleteRole(103);*/

            //查询所有记录
            List<Role> roleList = roleMapper.findRole("民");
            for (Role role:roleList) {
                System.out.println(role);
            }

            //更新记录
            /*Role role = new Role();
            role.setId(100);
            role.setName("小月");
            role.setRoleName("工人");
            roleMapper.updateRole(role);*/

            //插入记录
            /*Role role = new Role();
            role.setId(103);
            role.setName("小新");
            role.setRoleName("商人");
            roleMapper.insertRole(role);*/
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.commit();
                sqlSession.close();
            }
        }
    }
}
