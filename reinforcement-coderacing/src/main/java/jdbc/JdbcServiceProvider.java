package jdbc;

import javax.sql.DataSource;

public class JdbcServiceProvider {

    public JdbcService get()
    {
        DataSource dataSource = new ApacheDataSourceProvider("jdbc:mysql://localhost:3306/reinforcement?user=root&password=neuser50&allowMultiQueries=true", 1).get();

        return new JdbcService(dataSource);
    }

}
