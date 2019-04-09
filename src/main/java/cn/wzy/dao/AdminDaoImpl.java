package cn.wzy.dao;

import cn.wzy.dao.entity.Admin;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDaoImpl extends SqlSessionDaoSupport implements AdminDao {
	private String getNamespace() {
		return "cn.wzy.dao.AdminDao";
	}
	@Override
	public int count(Admin admin) {
		return this.getSqlSession().selectOne(getNamespace() + ".count", admin);
	}
}
