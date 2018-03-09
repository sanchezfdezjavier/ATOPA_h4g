package es.upm.h4g.atopa;

        import org.apache.poi.hssf.usermodel.HSSFSheet;
        import org.apache.poi.hssf.usermodel.HSSFWorkbook;
        import org.apache.poi.ss.usermodel.Cell;
        import org.apache.poi.ss.usermodel.FormulaEvaluator;
        import org.apache.poi.ss.usermodel.Row;

        import java.io.*;

public class Read {
    public static void main(String[] args) throws IOException {
        //ejecucion de la lectura del excel

        FileInputStream file = new FileInputStream(new File("testExcel.xls"));
        HSSFWorkbook wb = new HSSFWorkbook(file);
        HSSFSheet sheet = wb.getSheet("file");

        FormulaEvaluator formulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();

        for (Row row : sheet) {
            for (Cell cell : row) {
                switch (formulaEvaluator.evaluateInCell(cell).getCellType()) {
                    case Cell.CELL_TYPE_NUMERIC:
                        System.out.print(cell.getNumericCellValue() + "\t\t");
                        break;
                    case Cell.CELL_TYPE_STRING:
                        System.out.print(cell.getStringCellValue() + "\t\t");
                        break;
                }
            }
        }
    }
}
