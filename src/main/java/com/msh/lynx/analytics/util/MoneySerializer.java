package com.msh.lynx.analytics.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class MoneySerializer extends JsonSerializer<BigDecimal>
{
  @Override
  public void serialize(BigDecimal value, JsonGenerator jgen, SerializerProvider provider) throws IOException
  {
    // String num = new DecimalFormat("#,###.00").format(value);
    jgen.writeString(new DecimalFormat("#,###.00").format(value));
  }
}