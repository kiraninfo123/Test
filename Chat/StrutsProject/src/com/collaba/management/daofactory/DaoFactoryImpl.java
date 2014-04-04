package com.collaba.management.daofactory;

import com.collaba.management.dao.*;
import com.collaba.management.daoimpl.*;


public final class DaoFactoryImpl {
	
	 private static DaoFactoryImpl instance = null;
	
	public static DaoFactoryImpl getInstance() {


			if  (instance == null ) {

				instance =  new  DaoFactoryImpl();

			}

				return instance;

			}
	
	public loginDao getloginDao(){return new logindaoimpl();}
	public RegistrationDao RegistrationDao(){return new RegistrationDaoImpl();}
	public PropertyDao PropertyDao(){return new Propertydaoimpl();}
	public PropertytypeDao PropertytypeDao(){return new PropertytypeDaoImpl();}
	public projectDao projectDao(){return new Projectdaoimpl();}
	public ProjecttypeDao ProjecttypeDao(){return new Projecttypedaoimpl();}
	public AlliedservicesDao AlliedservicesDao(){return new Alliedservicesdaoimpl();}
	public AlliedpersDao AlliedpersonDao(){return new Alliedpersondaoimpl();}
	public OwnerDao OwnerDao(){return new Ownerdaoimpl();}
	public loanDao loanDao(){return new loandaoimpl();}
	public AlliedDao architectdao(){return new AlliedDaoImpl();}
	
	
}	

