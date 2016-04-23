package com.medicaljournalsystem.config;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.medicaljournalsystem.dao.MedicalJournalDAOImpl;
import com.medicaljournalsystem.dao.UserDAO;
import com.medicaljournalsystem.dao.UserDAOImpl;
import com.medicaljournalsystem.pojo.MedicalJournal;
import com.medicaljournalsystem.pojo.Users;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.medicaljournalsystem")
@EnableTransactionManagement
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SpringMvcConfig extends WebMvcConfigurerAdapter {

	@Bean
	public ViewResolver getViewResolver() {

		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/jsp/");
		resolver.setSuffix(".jsp");

		return resolver;

	}

	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver createMultipartResolver() {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		resolver.setDefaultEncoding("utf-8");
		return resolver;
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Bean(name = "dataSource")
	public DataSource getDataSource() {

		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/medical_journal");
		dataSource.setUsername("root");
		dataSource.setPassword("");

		return dataSource;
	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {

		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addAnnotatedClasses(Users.class);
		sessionBuilder.addAnnotatedClasses(MedicalJournal.class);
		sessionBuilder.setProperty("hibernate.show_sql", "true");
		sessionBuilder.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		sessionBuilder.setProperty("hibernate.hbm2ddl.auto", "update");

		return sessionBuilder.buildSessionFactory();
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);

		return transactionManager;
	}

	@Autowired
	@Bean(name = "userDao")
	public UserDAO getUserDao(SessionFactory sessionFactory) {
		return new UserDAOImpl(sessionFactory);
	}

	@Autowired
	@Bean(name = "medicalJournalDao")
	public MedicalJournalDAOImpl getMedicalJournalDao(SessionFactory sessionFactory) {
		return new MedicalJournalDAOImpl(sessionFactory);
	}

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}

}
