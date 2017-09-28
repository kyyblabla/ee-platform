package com.ax.extra.gen.util;

import com.ax.common.util.JaxbMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by kyy on 2017/9/19.
 */
@Slf4j
public class XmlUtil {


    public static <T> T fileToObject(String filePath, Class<T> clazz) {

        Resource resource = new ClassPathResource(filePath);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream(), "UTF-8"))) {
            StringBuilder sb = new StringBuilder();
            while (true) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }
                sb.append(line).append("\r\n");
            }
            return (T) JaxbMapper.fromXml(sb.toString(), clazz);
        } catch (IOException e) {
            log.warn("Error file convert: {}", e.getMessage());
        }
        return null;
    }

    public static <T> T stringToObject(String str, Class<T> clazz) {
        try {
            return (T) JaxbMapper.fromXml(str, clazz);
        } catch (Exception e) {
            e.printStackTrace();
            log.warn("Error file convert: {}", e.getMessage());
        }
        return null;
    }


}
