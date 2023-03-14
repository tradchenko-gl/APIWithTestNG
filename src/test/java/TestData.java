import org.testng.annotations.DataProvider;
import utils.ExcelUtils;

import java.io.IOException;

public class TestData {
    @DataProvider(name = "idCategoryName")
    public Object[][] idCategoryName() {
        return new Object[][] {
                {"5", "jewelery", "John Hardy Women's Legends Naga Gold & Silver Dragon Station Chain Bracelet"},
                {"7", "jewelery", "John Hardy Women's Legends Naga Gold & Silver Dragon Station Chain Bracelet"}
        };
    }

    @DataProvider(name = "idCategoryNameExcel")
    public Object[][] idCategoryNameExcel() throws IOException {
        return ExcelUtils.getTestData("C:\\Personal\\Education\\IdeaProjects\\APIWithTestNG\\src\\test\\java\\utils\\excelData2.xlsx", "Sheet1");
    }
}
