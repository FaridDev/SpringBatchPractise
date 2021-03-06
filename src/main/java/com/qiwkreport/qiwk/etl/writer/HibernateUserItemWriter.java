package com.qiwkreport.qiwk.etl.writer;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.HibernateItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.qiwkreport.qiwk.etl.domain.NewUser;

public class HibernateUserItemWriter implements ItemWriter<NewUser> {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void write(List<? extends NewUser> items) throws Exception {
		HibernateItemWriter<NewUser> hibernateItemWriter=new HibernateItemWriter<>();
		hibernateItemWriter.setSessionFactory(sessionFactory);
		hibernateItemWriter.write(items);
		hibernateItemWriter.afterPropertiesSet();
	}

}
