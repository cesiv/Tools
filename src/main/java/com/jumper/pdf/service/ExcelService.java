package com.jumper.pdf.service;

import java.util.List;
import java.util.Map;

public interface ExcelService {
    void generateExcel(List<List<Map<Object,Object>>> collections);
}
