package cn.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import cn.utils.DataSourceUtils;

public class TxFilter implements Filter{

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		Connection conn = null;
		
		try{
			conn = DataSourceUtils.getConn();
			//��ʼ����
			conn.setAutoCommit(false);
			chain.doFilter(request, response);
			//���û�г���
			conn.commit();
		}catch (Exception e) {
			System.err.println("������");
			try {
				if(e instanceof SQLException)
					conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new RuntimeException(e);
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

}
