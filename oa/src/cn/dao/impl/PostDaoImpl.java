package cn.dao.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import cn.dao.PostDao;
import cn.dao.base.impl.BaseDaoImpl;
import cn.domain.Post;

@Repository("postDao")
public class PostDaoImpl extends BaseDaoImpl<Post> implements PostDao{

	public Set<Post> getPostsByIds(Long[] pids) {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("from Post");
		stringBuffer.append(" where pid in(");
		for(int i=0;i<pids.length;i++){
			if(i<pids.length-1){
				stringBuffer.append(pids[i]+",");
			}else{
				stringBuffer.append(pids[i]);
			}
		}
		stringBuffer.append(")");
		
		List<Post> postList = this.hibernateTemplate.find(stringBuffer.toString());
		return new HashSet<Post>(postList);
	}
	
}
