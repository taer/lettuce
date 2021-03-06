package com.lambdaworks.redis.commands;

import com.lambdaworks.redis.api.sync.RedisCommands;
import org.junit.Test;

import com.lambdaworks.redis.RedisConnection;
import com.lambdaworks.redis.RedisConnectionPool;

/**
 * @author Mark Paluch
 */
public class ServerCommandPoolTest extends ServerCommandTest {

    RedisConnectionPool<RedisCommands<String, String>> pool;

    @Override
    protected RedisCommands<String, String> connect() {
        pool = client.pool();
        return pool.allocateConnection();
    }

    @Override
    public void closeConnection() throws Exception {
        pool.freeConnection(redis);
        pool.close();
    }
}
