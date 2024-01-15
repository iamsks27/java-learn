package com.shivam.learn.reflection.proxy.external;

import java.io.IOException;

/**
 * @author sksingh created on 15/01/24
 */
public interface DatabaseReader {

    int countRowsInTable(String table) throws InterruptedException, IOException;

    String[] readRows(String query) throws InterruptedException;
}
