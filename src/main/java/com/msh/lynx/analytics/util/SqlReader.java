package com.msh.lynx.analytics.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Slf4j
public class SqlReader 
{
  public static String getStatement(final String myFile) 
  {

    try {
      return FileUtils.readFileToString(new ClassPathResource(myFile).getFile(), StandardCharsets.UTF_8);
    } 
    catch (IOException exception) {
      log.error("IOException reading file [" + myFile + "].", exception);
      throw new IllegalStateException("Error reading file [" + myFile + "]", exception);
    }
  }
}