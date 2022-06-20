package ch6;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 결과 출력
 * c:\java-study\.idea\.gitignore
 * c:\java-study\.idea\misc.xml
 * c:\java-study\.idea\modules.xml
 * c:\java-study\.idea\uiDesigner.xml
 * c:\java-study\.idea\workspace.xml
 * c:\java-study\java-study.iml
 * c:\java-study\out\production\java-study\ch6\Exercise6_4.class
 * c:\java-study\out\production\java-study\ch6\RecursiveScanExample.class
 * c:\java-study\out\production\java-study\ch6\Student.class
 * c:\java-study\out\production\java-study\ch6\VarArgsEx.class
 * c:\java-study\src\ch6\Exercise6_4.java
 * c:\java-study\src\ch6\RecursiveScanExample.java
 * c:\java-study\src\ch6\VarArgsEx.java
 */

public class RecursiveScanExample {
    public static void main(String[] args) {
        List<String> fileLst = new ArrayList<>();
        scanDir("c:/java-study", fileLst);

        for (String fullPath : fileLst)
            System.out.println(fullPath);
    }

    static void scanDir(String folderPath, List<String> fileLst) {
        File[] files = new File(folderPath).listFiles();

        for (File f : files) {
            if (f.isDirectory()) {
                // 재귀호출
                scanDir(f.getAbsolutePath(), fileLst);
            } else {
                fileLst.add(f.getAbsolutePath());
            }
        }
    }
}

// Ref: https://needneo.tistory.com/68
