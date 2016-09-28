package com.moon.vip.service.impl.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.poi.poifs.filesystem.OfficeXmlFileException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.moon.reader.ExcelUtil;
import com.moon.vip.infra.constants.EnumAttendException;
import com.moon.vip.infra.exception.AttendanceException;
import com.moon.vip.service.util.IExcelService;

@Service("excelService")
public class ExcelServiceImpl implements IExcelService {
	private static Logger logger = Logger.getLogger(ExcelServiceImpl.class);
	private static final String FILE_NAME = "uploadpath.properties";

	public List<Map<Integer, String>> getExcel(MultipartFile file, String key) {
		String path = getPath(file, key);
		List<Map<Integer, String>> list = new ArrayList<Map<Integer, String>>();
		try {
			list = new ExcelUtil(path).getSheetOfExcel(0, true); //获取Excel数据
			return list;
		} catch(OfficeXmlFileException e){
			throw new AttendanceException(EnumAttendException.POIERR);
		} catch (IOException e) {
			throw new AttendanceException(EnumAttendException.EXCELSYSERR);
		}
	}

	private String getPath(MultipartFile file, String key) {
		Properties pro = new Properties();
		FileInputStream fs;
		try {
			fs = new FileInputStream(getClass().getResource("/").getPath() + FILE_NAME);
			pro.load(fs);
			fs.close();
		} catch (FileNotFoundException e) {
			throw new AttendanceException(EnumAttendException.IOEXP0001);
		} catch (IOException e) {
			throw new AttendanceException(EnumAttendException.IOEXP0002);
		}
		String path = pro.getProperty("uploadPath");
		if (StringUtils.isEmpty(path)) {
			throw new AttendanceException(EnumAttendException.IOEXP0003);
		}
		String fileName = file.getOriginalFilename();
		File directory = new File(path); // 创建文件
		if (!directory.exists()) {
			directory.mkdirs();
		}
		try {
			file.transferTo(new File(path + "/" + fileName));
		} catch (IllegalStateException e) {
			logger.error(String.format("文件已经被移走,路径[%s]", path + "/" + fileName));
			throw new AttendanceException(EnumAttendException.IOEXP0004);
		} catch (IOException e) {
			logger.error(String.format("文件移动失败,路径[%s]", path + "/" + fileName));
			throw new AttendanceException(EnumAttendException.IOEXP0005);
		}
		return path + "/" + fileName;
	}

}
