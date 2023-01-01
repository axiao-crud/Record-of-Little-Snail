import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author lltt9
 * @date 2022-12-22 23:44
 */
public class Workbook {
    public static void main(String[] args) throws IOException, URISyntaxException {
        org.apache.poi.ss.usermodel.Workbook ws = new XSSFWorkbook();
        Sheet sheet1 = ws.createSheet("sheet1");
        sheet1.createRow(0).createCell(0).setCellValue(1);
        CreationHelper creationHelper = ws.getCreationHelper();

        org.apache.poi.ss.usermodel.Workbook ws2 = new XSSFWorkbook();
        Sheet sheet2 = ws.createSheet("sheet2");
        sheet2.createRow(0).createCell(0).setCellValue(1);
        //workbook->File
        String s = LocalDate.now().toString();
        LocalDateTime now = LocalDateTime.now();
        String formatTime = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss"));
        File file1 = convertWorkBookToFile(ws, "文档1" + "_" + formatTime + ".xlsx");
        File file2 = convertWorkBookToFile(ws2, "文档2.xlsx");
        File[] srcFile = {file1, file2};
        File zipFile = new File("压缩包.zip");
        ZipFiles(srcFile, zipFile);
        byte[] bytesByFile = getBytesByFile(zipFile);
        file1.delete();
        file2.delete();
        zipFile.delete();


    }

    private static File convertWorkBookToFile(org.apache.poi.ss.usermodel.Workbook ws, String name) throws IOException, URISyntaxException {
        File file = new File(name);
        OutputStream out = new FileOutputStream(file);
        ws.write(out);
        out.close();
        return file;
    }

    //压缩文件  
    public static void ZipFiles(File[] srcfile, File zipfile) {
        byte[] buf = new byte[1024];
        try {
            ZipOutputStream out = new ZipOutputStream(new FileOutputStream(
                    zipfile));
            for (int i = 0; i < srcfile.length; i++) {
                FileInputStream in = new FileInputStream(srcfile[i]);
                out.putNextEntry(new ZipEntry(srcfile[i].getName()));
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
                out.closeEntry();
                in.close();
            }
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static byte[] getBytesByFile(File file) {
        try {
            //获取输入流
            FileInputStream fis = new FileInputStream(file);

            //新的 byte 数组输出流，缓冲区容量1024byte
            ByteArrayOutputStream bos = new ByteArrayOutputStream(1024);
            //缓存
            byte[] b = new byte[1024];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fis.close();
            //改变为byte[]
            byte[] data = bos.toByteArray();
            //
            bos.close();
            return data;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
