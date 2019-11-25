package com.tekclan.demo.Utils;



	import java.io.File;
	import java.io.IOException;

	import jxl.Sheet;
	import jxl.Workbook;

	public class ReadFromExcel {

	    /**
	     * This method will fetch the data from excel sheet on 2nd Row based on Column name
	     * 1st row will contain the row header
	     * 
	     * @param strSheetName
	     *              Sheet Name in the DataSheet workbook
	     * @param strColumnIdentifier
	     *              Column Name in the sheet
	     * @return String cell data
	     */
	    public static String getData(String strSheetName, String strColumnIdentifier)  {
	        Workbook objWorkBook;
	        Sheet objCurrentSheet;
	        String strAbsFilePath = getAbsolutePath("testdata" + File.separator + "DataSheet.xls");
	        String strContent;
	        try {
	            objWorkBook = Workbook.getWorkbook(new File(strAbsFilePath));
	            objCurrentSheet = objWorkBook.getSheet(strSheetName);
	            int columnNum = getColumnNumber(objCurrentSheet, strColumnIdentifier);
	            strContent = objCurrentSheet.getCell(columnNum, 1).getContents();
	            objWorkBook.close();
	            return strContent;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	            
	        }
	    }
	    
	    /**
	     * This method will be used get the column number based on column Identifier
	     * 
	     * @param strSheetName
	     *              Sheet Name in the workbook
	     * @param strColIdentifier
	     *              Column Name in the sheet
	     * @return int column number
	     * @throws IOException
	     */
	    private static int getColumnNumber(Sheet objCurrentSheet, String strColIdentifier) throws IOException {
	        int col;
	        try {
	            col = objCurrentSheet.findCell(strColIdentifier).getColumn();
	            return col;
	        } catch (Exception e) {
	            return -1;
	        }
	    }
	    
	    /**
	     * This method will be used get the row number based on row Identifier
	     * 
	     * @param strSheetName
	     *              Sheet Name in the workbook
	     * @param strRowIdentifier
	     *              Row Name in the sheet
	     * @return int row number
	     * @throws IOException
	     */
	    @SuppressWarnings("unused")
	    private static int getRowNumber(Sheet objCurrentSheet, String strRowIdentifier) throws IOException {
	        int row;
	        try {
	            row = objCurrentSheet.findCell(strRowIdentifier).getRow();
	            return row;
	        } catch (Exception e) {
	            return -1;
	        }
	    }

	    /**
	     * This method will be used get the column number based on column Identifier
	     * 
	     * @param strSheetName
	     *              Sheet Name in the workbook
	     * @param strColIdentifier
	     *              Column Name in the sheet
	     * @return int column number
	     * @throws IOException
	     */
	/*  public static int getColumnNumber(String strFileName,String strSheetName, String strColIdentifier) throws IOException {
	        Workbook objWorkBook;
	        Sheet objCurrentSheet;
	        String strAbsFilePath = getAbsolutePath(strFileName);
	        int col;
	        try {
	            objWorkBook = Workbook.getWorkbook(new File(strAbsFilePath));
	            objCurrentSheet = objWorkBook.getSheet(strSheetName);
	            col = objCurrentSheet.findCell(strColIdentifier).getColumn();
	            objWorkBook.close();
	            return col;
	        } catch (Exception e) {
	            return -1;
	        }
	    }
	*/
	    /**
	     * This method is used to fetch the absolute path of the given excel sheet
	     * 
	     * @param strFilePath
	     * @return String full path of the file
	     */
	    private static String getAbsolutePath(String strFilePath) {
	        try {
	            if (strFilePath.contains("https")) {
	                return strFilePath;
	            }
	            else {
	                return new File(strFilePath).getAbsolutePath();
	            }
	        } catch (Exception objException) {
	            return "";
	        }
	    }
	    private static String getAbsolutePath1(String strFilePath) {
	        try {
	            if (strFilePath.contains("https")) {
	                return strFilePath;
	            }
	            else {
	                return new File(strFilePath).getAbsolutePath();
	            }
	        } catch (Exception objException) {
	            return "";
	        }
	    }
	}



