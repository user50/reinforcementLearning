package jdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class BatchUpdateByIterator<T> implements BatchUpdate  {

    private Iterator<T> iterator;
    private Supplier<String> sqlSupplier;
    private BiConsumer<T, PreparedStatement> preparator;

    public BatchUpdateByIterator(Iterator<T> iterator, Supplier<String> sqlSupplier, BiConsumer<T, PreparedStatement> preparator) {
        this.iterator = iterator;
        this.sqlSupplier = sqlSupplier;
        this.preparator = preparator;
    }

    @Override
    public String getRawSql() {
        return sqlSupplier.get();
    }

    @Override
    public void prepare(PreparedStatement statement) throws SQLException {
        preparator.accept(iterator.next(), statement);
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public int executeBatchEvery() {
        return 1000;
    }
}
