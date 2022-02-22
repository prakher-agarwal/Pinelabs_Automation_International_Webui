//package com.pinelabs.RnD.CommonUtils;
//
//public class DatabaseUtil {
//
//        private static utils.DatabaseUtil dbConnectionUtil;
//        private static java.util.concurrent.ConcurrentMap<java.lang.String,java.sql.Connection> connectionMap;
//        private java.sql.Connection connection;
//        private java.sql.Statement statement;
//
//        private DatabaseUtil() { /* compiled code */ }
//
//        public static synchronized utils.DatabaseUtil getInstance() { /* compiled code */ }
//
//        public synchronized java.sql.Connection getConnection(java.lang.String dbConnectionURL) { /* compiled code */ }
//
//        public synchronized void closeConnection(java.lang.String dbConnectionURL) { /* compiled code */ }
//
//        public synchronized void closeAllConnections() { /* compiled code */ }
//
//        public synchronized java.util.List<java.util.Map<java.lang.String,java.lang.Object>> executeSelectQuery(java.lang.String dbConnectionURL, java.lang.String sqlQuery) { /* compiled code */ }
//
//        public synchronized void executeUpdateQuery(java.lang.String dbConnectionURL, java.lang.String sqlQuery) { /* compiled code */ }
//
//        public java.util.List<java.lang.String> getMatches(java.lang.String stringToSearch) { /* compiled code */ }
//    }
//}
