package com.ozzot.jdbc;

class TestClass {


    public static void main(String[] args) {
        for (int c=32; c<128; c++) {
            System.out.println(c + ": " + (char)c);
        }
    }

//    95: _
//    124: |
//    45: -


//
//    private static final String SELECT = "SELECT";
//    private static final String FROM = "FROM";
//    private static final String WHERE = "WHERE";
//    private static final String ALL = "*";
//
//
//    static void executeQueryApp(Statement statement, String query) throws SQLException {
//
//        String queryHeader = query.substring(0, query.indexOf(" ")).toUpperCase();
//
//
//
//
////
////        if (isColumnNamesConsist(query) == -1){
////            getListOfColunmNames(query, queryHeader);
////        };
//
//
//        String columnNames = query.substring(queryHeader.length() - 1, query.indexOf(FROM));
//
//        if (!queryHeader.equals(SELECT)) {
//            System.out.println(statement.executeUpdate(query));
//        } else {
//            ResultSet resultSet = statement.executeQuery(query);
//
//            while (resultSet.next()) {
//
////            String id = resultSet.getString(1);
////            String name = resultSet.getString(2);
////            String age = resultSet.getString(3);
////            String email = resultSet.getString(4);
////
////            System.out.println("| "+id+" | " + name+" | " + age+" | " + email+" |");
//
//                System.out.println(resultSet);
//            }
//            resultSet.close();
//        }
//
//    }
//
////    private static String getListOfColunmNames(String query, String header) {
////       return query.substring(query.indexOf(header),query.indexOf(FROM));
////    }
////
////    private static int isColumnNamesConsist(String query) {
////        if(!query.contains(ALL)){
////            return query.indexOf(ALL);
////        }
////        return -1;
////    }
////
//
////
////    select  `* || columnNames` from `tableName` were `value`=`valName`

}
