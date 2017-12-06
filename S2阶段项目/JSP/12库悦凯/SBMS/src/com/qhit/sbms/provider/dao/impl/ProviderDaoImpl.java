package com.qhit.sbms.provider.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.qhit.sbms.common.bean.PageBean;
import com.qhit.sbms.provider.bean.Provider;
import com.qhit.sbms.provider.dao.ProviderDao;
import com.qhit.sbms.utils.DBManager;

public class ProviderDaoImpl implements ProviderDao {
	private Connection con;
	private PreparedStatement ps;

	@Override
	public PageBean getPageBeanS(PageBean pageBean) {
		Provider provider = null;
		con = DBManager.getConnection();
		String sql =" select top "
					+ pageBean.getPagesize()
					+" p.providerId,p.providerName,p.providerDetail,"
					+" p.contact,p.telephone,p.address"
					+" from tb_provider p"
					+" where p.providerId"
					+" not in ( "
					+" select top "
					+ pageBean.getPagesize() * (pageBean.getP() - 1)
					+" p.providerId "
					+" from tb_provider p ) ; ";
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				provider = new Provider(
						rs.getInt("providerId"), 
						rs.getString("providerName"), 
						rs.getString("providerDetail"), 
						rs.getString("contact"), 
						rs.getString("telephone"), 
						rs.getString("address"));
				pageBean.addData(provider);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pageBean;
	}

	@Override
	public int addProvider(Provider provider) {
		con = DBManager.getConnection();
		String sql = "insert into tb_provider values(?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, provider.getProviderId());
			ps.setString(2, provider.getProviderName());
			ps.setString(3, provider.getProviderDetail());
			ps.setString(4, provider.getContact());
			ps.setString(5, provider.getTelephone());
			ps.setString(6, provider.getAddress());
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteProviderById(int providerId) {
		con = DBManager.getConnection();
		String sql = "delete from tb_provider where providerId = ? ";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, providerId);
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
