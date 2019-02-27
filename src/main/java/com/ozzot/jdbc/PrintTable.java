//package com.danilov.jdbc;
//
//import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;
//import java.sql.SQLException;
//
//public class PrintTable {
//
//
//
////            for (int i = 1; i <= columnCount; i++) {
////                System.out.print("| " + metadata.getColumnName(i) + " |");
////            }
////            System.out.println("\n=======================");
//
//
//
//    private static void printTable(ResultSet resultSet, ResultSetMetaData metadata, int columnCount, boolean header) throws SQLException {
//        int rowWidth = 0;
//
//
//
//
//        for (int i = 1; i <= columnCount; i++) {
////            rowWidth += metadata.getColumnDisplaySize(i) + 1;
//            StringBuilder currColumnSpace = new StringBuilder();
//            System.out.println(metadata.getScale(i));
//
//            for (int j = 0; j < metadata.getColumnDisplaySize(i) / 2; j++) {
//                currColumnSpace.append("_");
//            }
//            if (header) {
////                rowWidth+= metadata.getColumnName(i).length();
//                System.out.print("|" + currColumnSpace + metadata.getColumnName(i) + currColumnSpace);
//            } else {
//                System.out.print("|" + currColumnSpace + resultSet.getString(i) + currColumnSpace);
//            }
//        }
//
////
////        for (int i = 1; i <= columnCount; i++) {
////            rowWidth += metadata.getColumnDisplaySize(i) + 1;
////            StringBuilder currColumnSpace = new StringBuilder();
////
////            for (int j = 0; j < metadata.getColumnDisplaySize(i) / 2; j++) {
////                currColumnSpace.append("_");
////            }
////            if (header) {
//////                rowWidth+= metadata.getColumnName(i).length();
////                System.out.print("|" + currColumnSpace + metadata.getColumnName(i) + currColumnSpace);
////            } else {
////                System.out.print("|" + currColumnSpace + resultSet.getString(i) + currColumnSpace);
////            }
////        }
//
//        System.out.print("|\n");
////        System.out.print(rowWidth);
//
//
////        for (int i = 0; i <= rowWidth+1; i++) {
////            if (header) {
////                System.out.print("=");
////            } else {
////                System.out.print("-");
////            }
////        }
//
//        System.out.println();
//    }
//
//}
//
