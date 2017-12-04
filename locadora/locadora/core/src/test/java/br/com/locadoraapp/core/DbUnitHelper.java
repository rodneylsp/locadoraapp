package br.com.locadoraapp.core;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;

import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.postgresql.PostgresqlDataTypeFactory;
import org.dbunit.operation.DatabaseOperation;
import org.hibernate.SessionFactory;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;

public class DbUnitHelper {

	private Connection conexao;
	private DatabaseConnection conexaoDBUnit;
	private String xmlFolder;

	public DbUnitHelper(String xmlFolder) {
		this.xmlFolder = xmlFolder;

		try {
			
			SessionFactory factory = HibernateUtilTest.newSessionFactory("src/main/test/resource/hibernate.cfg.xml");
			conexao = factory.getSessionFactoryOptions()
					.getServiceRegistry().getService(ConnectionProvider.class).getConnection();
			conexaoDBUnit = new DatabaseConnection(conexao);
			DatabaseConfig config = conexaoDBUnit.getConfig();
			config.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new PostgresqlDataTypeFactory());
		} catch (Exception e) {
			throw new RuntimeException("Erro inicializando DBUnit", e);
		}
	}

	public void execute(DatabaseOperation operation, String xml) {
		try {
			IDataSet dataSet  = new FlatXmlDataSetBuilder().build(new FileInputStream("src/test/resources/dataset.xml"));

			operation.execute(conexaoDBUnit, dataSet);
		} catch (Exception e) {
			throw new RuntimeException("Erro executando DbUnit", e);
		}
	}

	public void close() {
		try {
			conexaoDBUnit.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
